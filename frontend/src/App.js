import React from 'react';

import HeaderBar from './components/HeaderBar.js'
import LoginPage from './pages/Login.js'
import RegisterPage from './pages/Register.js'
import HomePage from './pages/Home.js'

import {BrowserRouter as Router, Route, Switch} from "react-router-dom";

import 'bootstrap/dist/css/bootstrap.css';
import './App.css';

function App() {
  return (
    <Router>
    <HeaderBar />
    <Switch>
      <Route path="/login" exact><LoginPage /></Route>
      <Route path="/register" exact><RegisterPage /></Route>
      <Route path="/" exact><HomePage /></Route>
    </Switch>
  </Router>
);
}

export default App;
