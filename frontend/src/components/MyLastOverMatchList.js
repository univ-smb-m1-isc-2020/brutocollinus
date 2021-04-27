import React, {useEffect, useState} from 'react'
import {Card, Col, ListGroup} from 'react-bootstrap'
import LastOverMatch from './LastOverMatch.js';
import AuthService from "../services/Auth";

export default function MyLastOverMatchList(props) {
    const allLastOverMatchUrl = props.allLastOverMatchUrl;
    const [lastOverMatches, setLastOverMatches] = useState([]);

    useEffect(() => {
        AuthService.get(allLastOverMatchUrl).then(response => {
            if (response._embedded) {
                setLastOverMatches(response._embedded.lastOverMatchResponseList)
            }
        });
    }, [allLastOverMatchUrl]);

    return (
        <div>
                <h2>Mes dernier matches</h2>
                <ListGroup>
                    {lastOverMatches.map(lastMatchOver => {
                        return (
                            <ListGroup.Item><LastOverMatch lastOverMatch={lastMatchOver}/></ListGroup.Item>
                        )
                    })}
                </ListGroup>
                <a href="tournament/request/create">Créer un tournoi</a>
        </div>
    );
}