import React, {useEffect, useState} from 'react'
import {Button, Container, Form, ListGroup} from 'react-bootstrap'
import AuthService from "../services/Auth";
import useQuery from "../utils/Query";
import Stuff from '../components/Stuff.js';

export default function ArmedBrutoReequipPage() {
    const urlQuery = useQuery();
    const armedBrutoUrl = urlQuery.get('armedBrutoUrl');
    const [armedBruto, setArmedBruto] = useState();
    const [selectedStuffs, setSelectedStuffs] = useState([]);

    useEffect(() => {
        AuthService.get(armedBrutoUrl).then(setArmedBruto);
    }, [armedBrutoUrl])

    useEffect(() => {
        if (armedBruto) {
            setSelectedStuffs(armedBruto.equipedStuffs);
        }
    }, [armedBruto])

    function isSelectedStuffValid() {
        return (selectedStuffs.length > 0 && selectedStuffs.length < 4);
    }

    function onSubmit(e) {
        e.preventDefault();
        if (isSelectedStuffValid()) {
            AuthService.post(armedBruto._links.reequip.href, {
                equipedStuffs: selectedStuffs.map(stuff => stuff.uuid)
            }).then(setArmedBruto);
        }
    }

    function isSelectedStuff(stuff) {
        return selectedStuffs.find(selectedStuff => selectedStuff.uuid === stuff.uuid);
    }

    function selectStuff(stuff) {
        if (isSelectedStuff(stuff)) {
            const filteredStuffs = selectedStuffs.filter(selectedStuff => selectedStuff.uuid !== stuff.uuid);
            setSelectedStuffs(filteredStuffs);
        }
        else {
            setSelectedStuffs([...selectedStuffs, stuff])
        }
    }

    if (!armedBruto) {
        return ('Loading');
    }

    return (
        <Container>
            <h2>Ré-équipement de {armedBruto.name}</h2>
            <p>Équipement actuel</p>
            <ListGroup>
                {armedBruto.equipedStuffs.map(stuff =>
                    (<ListGroup.Item><Stuff stuff={stuff}></Stuff></ListGroup.Item>)
                )}
            </ListGroup>
            <Form onSubmit={onSubmit}>
                <Form.Group>
                    <Form.Label>Équipement gagné (1 minimum, 3 maximum)</Form.Label>
                    <ListGroup>
                        {armedBruto.gainedStuffs.map(stuff => (
                            <ListGroup.Item onClick={() => selectStuff(stuff)} active={isSelectedStuff(stuff)}>
                                <Stuff stuff={stuff}></Stuff>
                            </ListGroup.Item>)
                        )}
                    </ListGroup>
                </Form.Group>
                {isSelectedStuffValid() &&
                <Button variant="primary" type="submit">
                    Équiper
                </Button>
                }
            </Form>
        </Container>
    );
}