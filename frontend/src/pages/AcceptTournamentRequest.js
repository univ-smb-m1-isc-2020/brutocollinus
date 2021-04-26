import React, {useState, useEffect} from 'react'
import useQuery from '../utils/Query.js';
import AuthService from '../services/Auth.js';
import Boost from '../components/Boost.js';
import { ListGroup, Button, Row, Col, Form } from 'react-bootstrap';
import {Redirect, useLocation} from "react-router-dom";

export default function AcceptTournamentRequestPage() {
  const user = AuthService.user;
  const urlQuery = useQuery();
  const tournamentRequestUrl = urlQuery.get('tournamentRequestUrl');
  const location = useLocation();

  const [tournamentRequest, setTournamentRequest] = useState();
  const [boosts, setBoosts] = useState();
  const [brutos, setBrutos] = useState();

  useEffect(() => {
    AuthService.get(tournamentRequestUrl).then(setTournamentRequest);
  }, [tournamentRequestUrl])

  useEffect(() => {
    AuthService.index().then(response => AuthService.get(response._links.all_boost.href)).then(setBoosts);
  }, []);

  function onClick(e) {
    e.preventDefault();
  }

  if (!user) {
    return (<Redirect to={"/login?redirectUrl=" + location.pathname + location.search}/>);
  }

  if (!tournamentRequest || !boosts) {
    return ('Loading');
  }

  return (
      <div>
        <h1>Accepter l'invitation au tournoi "{tournamentRequest.name}"</h1>

        <Form>
        <Row>
          <Form.Group>
            <Col>
              <h4>Selectionnez votre bruto</h4>
              <ListGroup defaultActiveKey="#billy">
                <ListGroup.Item action href="#billy">Billy</ListGroup.Item>
                <ListGroup.Item action href="#bouboule">Bouboule</ListGroup.Item>
              </ListGroup>
            </Col>
          </Form.Group>
          <Form.Group>
            <Col>
              <h4>Selectionnez un boost</h4>
              <ListGroup>
                {boosts.map(boost => (
                    <ListGroup.Item action href={"#" + boost.name}><Boost boost={boost}/></ListGroup.Item>
                ))}
              </ListGroup>
            </Col>
          </Form.Group>
        </Row>
          <Button onClick={onClick}>
              Accepter
          </Button>
        </Form>
      </div>
  )
}
