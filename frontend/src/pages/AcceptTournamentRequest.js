import React, {useState, useEffect} from 'react'
import useQuery from '../utils/Query.js';
import AuthService from '../services/Auth.js';
import Boost from '../components/Boost.js';
import Bruto from '../components/Bruto.js';
import { ListGroup, Button, Row, Col, Form, Container, Modal } from 'react-bootstrap';
import {Redirect, useLocation} from "react-router-dom";

export default function AcceptTournamentRequestPage() {
  const user = AuthService.user;
  const urlQuery = useQuery();
  const tournamentRequestUrl = urlQuery.get('tournamentRequestUrl');
  const location = useLocation();

  const [tournamentRequest, setTournamentRequest] = useState();
  const [boosts, setBoosts] = useState();
  const [brutos, setBrutos] = useState();
  const [selectedBruto, setSelectedBruto] = useState();
  const [selectedBoost, setSelectedBoost] = useState();
  const [show, setShow] = useState(false);

  useEffect(() => {
    AuthService.get(tournamentRequestUrl).then(setTournamentRequest);
  }, [tournamentRequestUrl])

  useEffect(() => {
    AuthService.index().then(response => AuthService.get(response._links.all_boost.href)).then(setBoosts);
  }, []);

  useEffect(() => {
    if (user) {
      AuthService.get(user._links.all_bruto.href).then(setBrutos);
    }
  }, [])

  function onSubmit(e) {
    e.preventDefault();

    if (selectedBruto && selectedBoost) {
      AuthService.post(tournamentRequest._links.accept.href, {
        selectedBruto: selectedBruto.uuid, selectedBoosts: [selectedBoost.uuid]
      }).then(() => setShow(true));
    }
  }

  function handleClose() {
    setShow(false);
    window.location.href = "/";
  }

  if (!user) {
    return (<Redirect to={"/login?redirectUrl=" + location.pathname + location.search}/>);
  }

  if (!tournamentRequest || !boosts) {
    return ('Loading');
  }

  return (
      <>
        <Container>
          <h1>Accepter l'invitation au tournoi "{tournamentRequest.name}"</h1>

          <Form onSubmit={onSubmit}>
            <Form.Group>
                <h4>Selectionnez votre bruto</h4>
                <ListGroup>
                  {brutos.map(bruto => (
                      <ListGroup.Item action href={"#" + bruto.name} onClick={() => setSelectedBruto(bruto)}><Bruto bruto={bruto}/></ListGroup.Item>
                  ))}
                </ListGroup>
            </Form.Group>
            <Form.Group>
                <h4>Selectionnez un boost</h4>
                <ListGroup>
                  {boosts.map(boost => (
                      <ListGroup.Item action href={"#" + boost.name} onClick={() => setSelectedBoost(boost)}><Boost boost={boost}/></ListGroup.Item>
                  ))}
                </ListGroup>
            </Form.Group>
            <Button variant="primary" type="submit">
                Accepter
            </Button>
          </Form>
        </Container>

        <Modal show={show} onHide={handleClose}>
          <Modal.Header closeButton>
            <Modal.Title>Tournoi accepté validée</Modal.Title>
          </Modal.Header>
          <Modal.Body>Le tournoi commencera une fois que tous les participants auront validé</Modal.Body>
          <Modal.Footer>
            <Button variant="secondary" onClick={handleClose}>
              Ok
            </Button>
          </Modal.Footer>
        </Modal>
      </>
  )
}
