import React from 'react';

import LoginPage from './pages/Login.js'
import RegisterPage from './pages/Register.js'
import TournamentPage from './pages/Tournament.js'
import MatchPage from './pages/Match.js'

import {BrowserRouter as Router, Route, Switch} from "react-router-dom";

import 'bootstrap/dist/css/bootstrap.css';
import 'react-tree-graph/dist/style.css'
import './App.css';

function App() {
  return (
    <Router>
    <Switch>
      <Route path="/login" exact><LoginPage /></Route>
      <Route path="/register" exact><RegisterPage /></Route>
      <Route path="/tournament" exact><TournamentPage /></Route>
      <Route path="/match" exact><MatchPage /></Route>
    </Switch>
  </Router>
);
}

export default App;
