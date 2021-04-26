import React, {useState, useEffect} from 'react'
import {Form, Container, ListGroup, Col, Button} from 'react-bootstrap'
import AuthService from "../services/Auth";

export default function CreateTournamentRequestPage() {
    const [name, setName] = useState();
    const [guests, setGuests] = useState([]);

    /*useEffect(() => {
        AuthService.index().then(response => AuthService.get(response._links.all_bruto_class.href))
            .then(response => setBrutoClasses(response._embedded.brutoClassResponseList));
    }, [])*/

    function onSubmit(e) {
        e.preventDefault();
        if (name) {
            AuthService.index().then(response => AuthService.post(response._links.create_tourmanent_request.href, {
                name, guests
            })).then(() => {
                window.location.href = '/'
            });
        }
    }

    return (
        <Container>
            <h2>Création d'un tournoi</h2>
            <Form onSubmit={onSubmit}>
                <Form.Group>
                    <Form.Label>Nom</Form.Label>
                    <Form.Control type="name" placeholder="Entrez le nom de votre tournoi" onChange={(e) => setName(e.target.value) } defaultValue={name}/>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Participants</Form.Label>
                    <ListGroup>
                    </ListGroup>
                </Form.Group>
                <Button variant="primary" type="submit">
                    Créer
                </Button>
            </Form>
        </Container>
    );
}