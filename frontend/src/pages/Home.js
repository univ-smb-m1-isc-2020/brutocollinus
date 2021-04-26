import React, {useState, useEffect} from 'react'
import AuthService from '../services/Auth.js';
import Bruto from '../components/MyBrutoList.js';
import {ListGroup, Container, Row, Col, Card} from "react-bootstrap";
import {Redirect, useLocation} from "react-router-dom";
import MyBrutoList from "../components/MyBrutoList.js";
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
