import React from 'react'
import AuthService from '../services/Auth.js';
import MyBrutoList from '../components/MyBrutoList.js';
import {Col, Container, Row} from "react-bootstrap";
import {Redirect} from "react-router-dom";
import MyLastOverMatchList from "../components/MyLastOverMatchList.js";

export default function HomePage() {
  const user = AuthService.user;


    if (!user) {
        return (<Redirect to="/login" />);
    }

    return (
        <Container fluid>
            <Row>
                <Col xs={3}>
                    <MyBrutoList allBrutoUrl={user._links.all_bruto.href}/>
                </Col>
                <Col>
                    <MyLastOverMatchList allLastOverMatchUrl={user._links.all_last_over_match.href} />
                </Col>
            </Row>
      </Container>
  );
}
