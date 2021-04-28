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

    return (
        <Container>
            <div className="text-center">
                <h1>{firstOpponent.name + " vs " + secondOpponent.name}</h1>
                    {winner && looser &&
                        "Gagnant : " + winner.name + ", Perdant : " + looser.name
                    }
            </div>
            <Container>
                <Row>
                    <ArmedBruto className="col" armedBruto={firstOpponent}/>
                    <ArmedBruto className="col" armedBruto={secondOpponent}/>
                </Row>
            </Container>

            <hr />
            <h6>Historique de bataille</h6>
            <ListGroup>
                {match.attackRecords.map(record => {
                    return (
                        <ListGroup.Item><AttackRecord record={record} /></ListGroup.Item>
                    );
                })}
            </ListGroup>
        </Container>
    );
}