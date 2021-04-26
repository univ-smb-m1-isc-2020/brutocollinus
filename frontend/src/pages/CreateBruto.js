import React, {useState, useEffect} from 'react'
import {Form, Container, ListGroup, Col, Button} from 'react-bootstrap'
import AuthService from "../services/Auth";

export default function CreateBrutoPage() {
    const [name, setName] = useState();
    const [brutoClass, setBrutoClass] = useState();
    const [brutoClasses, setBrutoClasses] = useState([]);

    useEffect(() => {
        AuthService.index().then(response => AuthService.get(response._links.all_bruto_class.href))
            .then(response => setBrutoClasses(response._embedded.brutoClassResponseList));
    }, [])

    function onSubmit(e) {
        e.preventDefault();
        if (name && brutoClass) {
            AuthService.post(AuthService.user._links.create_bruto.href, {
                name, brutoClass: brutoClass.uuid
            }).then(() => {
                window.location.href = '/'
            });
        }
    }

    return (
        <Container>
            <h2>Création d'un bruto</h2>
            <Form onSubmit={onSubmit}>
                <Form.Group>
                    <Form.Label>Nom</Form.Label>
                    <Form.Control type="name" placeholder="Entrez le nom de votre bruto" onChange={(e) => setName(e.target.value) } defaultValue={name}/>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Classe</Form.Label>
                    <ListGroup>
                        {brutoClasses.map(_brutoClass => (
                            <ListGroup.Item action href={"#" + _brutoClass.name} onClick={() => setBrutoClass(_brutoClass)}>{_brutoClass.name}</ListGroup.Item>
                        ))}
                    </ListGroup>
                </Form.Group>
                <Button variant="primary" type="submit">
                    Créer
                </Button>
            </Form>
        </Container>
    );
}