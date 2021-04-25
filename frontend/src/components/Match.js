import React, {useState, useEffect} from 'react'
import AuthService from '../services/Auth.js';
import { Button, Card, ListGroup } from 'react-bootstrap';
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

                    <div className="container">
                        <div className="row">
                            <ArmedBruto className="col" armedBruto={firstOpponent}/>
                            <ArmedBruto className="col" armedBruto={secondOpponent}/>
                        </div>
                    </div>

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