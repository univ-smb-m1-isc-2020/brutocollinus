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
    }, [matchUrl]);

    if (!match) {
        return ('Loading')
    }

    const winner = match.winner;
    const looser = match.looser;
    const hasWon = lastOverMatch.hasWon;
    const tournament = lastOverMatch.tournament;

    return (
      <div>
        <div className="text-center">
            <h1><a href={"/tournament?tournamentUrl=" + tournament._links.detail.href}>{tournament.name}</a> : {hasWon ? "Gagné" : "Perdu"}</h1>
            <a href={"/match?matchUrl=" + match._links.detail.href}>Détails du match</a>
        </div>
          <Row>
            <Col>
              <div className="text-center">
                Gagnant
              </div>
              <ArmedBruto armedBruto={winner}/>
                <div className="text-center">
                    {hasWon &&
                    <a href={"/armedbruto/reequip?armedBrutoUrl=" + winner._links.current_state.href}>Ré-équipper</a>
                    }
                </div>
          </Col>
        <Col>
            <div className="text-center">
                Perdant
            </div>
            <ArmedBruto armedBruto={looser}/>
        </Col>
        </Row>
      </div>
  );
}
