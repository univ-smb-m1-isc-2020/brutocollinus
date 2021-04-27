import React, {useState, useEffect} from 'react'
import {Form, Container, ListGroup, Col, Button, InputGroup, Modal} from 'react-bootstrap'
import AuthService from "../services/Auth";
import { BsSearch, BsArrowReturnLeft, BsX } from 'react-icons/bs';

export default function CreateTournamentRequestPage() {
    const [name, setName] = useState();
    const [guests, setGuests] = useState([AuthService.user]);
    const [searchResults, setSearchResults] = useState([]);
    const [term, setTerm] = useState('');
    const [display, setDisplay] = useState(false);
    const [show, setShow] = useState(false);

    useEffect(() => {
        if (term.length > 2) {
            AuthService.index().then(response => AuthService.post(response._links.search_player.href, {term}))
                .then(response => {
                    if (response._embedded) {
                        setSearchResults(response._embedded.playerResponseList);
                    }
                    else {
                        setSearchResults([]);
                    }
                });
        }
    }, [term])

    function onFocus() {
        setDisplay(true);
    }

    function onClose() {
        setDisplay(false);
    }

    function onSubmit(e) {
        e.preventDefault();
        if (name) {
            AuthService.index().then(response => AuthService.post(response._links.create_tournament_request.href, {
                name, guests: guests.map(guest => guest.uuid)
            })).then(() => setShow(true));
        }
    }

    function handleClose() {
        setShow(false);
        window.location.href = "/";
    }

    function addGuest(player) {
        if (!guests.find(guest => guest.uuid === player.uuid)) {
            setGuests([...guests, player])
        }
    }

    return (
        <>
        <Container>
            <h2>Création d'un tournoi</h2>
            <Form onSubmit={onSubmit}>
                <Form.Group>
                    <Form.Label>Nom</Form.Label>
                    <Form.Control type="name" placeholder="Entrez le nom de votre tournoi" onChange={(e) => setName(e.target.value) } defaultValue={name}/>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Participants</Form.Label>
                    <InputGroup>
                        <InputGroup.Prepend>
                            <InputGroup.Text>@</InputGroup.Text>
                        </InputGroup.Prepend>
                        <Form.Control placeholder="rechercher un participant" onChange={e => setTerm(e.target.value)} onFocus={onFocus}/>
                        {display &&
                            <InputGroup.Append>
                                <Button variant="outline-secondary" onClick={onClose}><BsX /></Button>
                            </InputGroup.Append>
                        }
                    </InputGroup>

                    {display && searchResults &&
                    <ListGroup>
                        {searchResults.map(player => (
                            <ListGroup.Item key={player.uuid} onClick={() => addGuest(player)}>{player.name}</ListGroup.Item>
                        ))}
                    </ListGroup>
                    }

                    <ListGroup>
                        {guests.map(guest => (
                            <ListGroup.Item key={guest.uuid}>{guest.name}</ListGroup.Item>
                        ))}
                    </ListGroup>
                </Form.Group>
                <Button variant="primary" type="submit">
                    Créer
                </Button>
            </Form>
        </Container>

            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Tournoi crée</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    Une invitation pour accepter le tournoi a été envoyé par email à tous les participants
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Ok
                    </Button>
                </Modal.Footer>
            </Modal>
        </>
    );
}