import React, {useEffect, useState} from 'react'
import AuthService from '../services/Auth.js';
import {Card, Container, ListGroup, Row} from 'react-bootstrap';
import AttackRecord from './AttackRecord.js';
import ArmedBruto from './ArmedBruto.js';

export default function Match(props) {
    const [match, setMatch] = useState();

    useEffect(() => {
        AuthService.get(props.url).then(setMatch);
    }, [props.url]);

    if (!match) {
        return ('Loading');
    }

    const firstOpponent = match.firstOpponent;
    const secondOpponent = match.secondOpponent;
    const winner = match.winner;
    const looser = match.looser;

    console.log(match.attackRecords);

    return (
        <Card>
            <Card.Body>
                <Card.Title>
                    {firstOpponent.name + " vs " + secondOpponent.name}
                </Card.Title>
                <Card.Subtitle>
                    {winner && looser &&
                        "Gagnant :" + winner.name + " Perdant : " + looser.name
                    }
                </Card.Subtitle>
                <Card.Text>

                    <Container>
                        <Row>
                            <ArmedBruto className="col" armedBruto={firstOpponent}/>
                            <ArmedBruto className="col" armedBruto={secondOpponent}/>
                        </Row>
                    </Container>

                    <hr />
                    <ListGroup>
                        {match.attackRecords.map(record => {
                            return (
                                <ListGroup.Item><AttackRecord record={record} /></ListGroup.Item>
                            );
                        })}
                    </ListGroup>
                </Card.Text>
            </Card.Body>
        </Card>
    );
}