import React from 'react';

import HeaderBar from './components/HeaderBar.js'
import LoginPage from './pages/Login.js'
import RegisterPage from './pages/Register.js'
import HomePage from './pages/Home.js'
import TournamentPage from './pages/Tournament.js'
import AcceptTournamentRequestPage from './pages/AcceptTournamentRequest.js'
import CreateTournamentRequestPage from './pages/CreateTournamentRequest.js'
import MatchPage from './pages/Match.js'
import ProfilePage from './pages/Profile.js'
import CreateBrutoPage from './pages/CreateBruto.js'
import ArmedBrutoReequipPage from './pages/ArmedBrutoReequip.js'

import {BrowserRouter as Router, Route, Switch} from "react-router-dom";

import 'bootstrap/dist/css/bootstrap.css';
import 'react-tree-graph/dist/style.css'
import './App.css';

function App() {
  return (
    <Router>
    <HeaderBar />
    <Switch>
      <Route path="/login" exact><LoginPage /></Route>
      <Route path="/register" exact><RegisterPage /></Route>
      <Route path="/profile" exact><ProfilePage /></Route>
      <Route path="/" exact><HomePage /></Route>
      <Route path="/tournament" exact><TournamentPage /></Route>
      <Route path="/tournament/request/accept" exact><AcceptTournamentRequestPage /></Route>
      <Route path="/tournament/request/create" exact><CreateTournamentRequestPage /></Route>
      <Route path="/armedbruto/reequip" exact><ArmedBrutoReequipPage /></Route>
      <Route path="/match" exact><MatchPage /></Route>
      <Route path="/bruto/create" exact><CreateBrutoPage /></Route>
    </Switch>
  </Router>
);
}

export default App;
