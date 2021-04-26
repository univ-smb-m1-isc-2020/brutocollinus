import React, {useEffect, useState} from 'react'
import {Card, Col, ListGroup} from 'react-bootstrap'
import Bruto from './Bruto.js';
import AuthService from "../services/Auth";

export default function MyBrutoList(props) {
    const allBrutoUrl = props.allBrutoUrl;
    const [brutos, setBrutos] = useState([]);

    useEffect(() => {
        AuthService.get(allBrutoUrl).then(response => setBrutos(response._embedded.brutoResponseList));
    }, [allBrutoUrl]);

    return (
        <div>
            <h2>Mes brutos</h2>
            <ListGroup>
                {brutos.map(bruto => {
                    return (
                        <ListGroup.Item><Bruto bruto={bruto}/></ListGroup.Item>
                    )
                })}
            </ListGroup>
            <a href="bruto/create">Créer un bruto</a>
        </div>
    );
}
