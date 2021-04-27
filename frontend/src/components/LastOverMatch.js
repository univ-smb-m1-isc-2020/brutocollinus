import React, {useEffect, useState} from 'react'
import {Col, Row} from 'react-bootstrap'
import ArmedBruto from "./ArmedBruto";
import AuthService from "../services/Auth";

export default function LastOverMatch(props) {
    const [match, setMatch] = useState()
    const lastOverMatch = props.lastOverMatch;
    const matchUrl = lastOverMatch.match._links.detail.href;

    useEffect(() => {
        AuthService.get(matchUrl).then(setMatch);
    }, []);

    if (!match) {
        return ('Loading')
    }

    const firstOpponent = match.firstOpponent;
    const secondOpponent = match.secondOpponent;

    return (
      <div>
        <div className="justify-content-center d-flex">
          <h1>{lastOverMatch.hasWon ? "Gagné" : "Perdu"}</h1>
        </div>
        <Row>
          <Col>
              <ArmedBruto armedBruto={firstOpponent}/>
          </Col>
        <Col>
            <ArmedBruto armedBruto={secondOpponent}/>
        </Col>
        </Row>
          <a href={"/tournament?tournamentUrl=" + lastOverMatch.tournament._links.detail.href}>Acceder au tournoi</a>
      </div>
  );
}
