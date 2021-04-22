import React from 'react';

import LoginPage from './pages/Login.js'
import RegisterPage from './pages/Register.js'

import {BrowserRouter as Router, Route, Switch} from "react-router-dom";

import 'bootstrap/dist/css/bootstrap.css';
import './App.css';

function App() {
  return (
    <Router>
    <Switch>
      <Route path="/login" exact><LoginPage /></Route>
      <Route path="/register" exact><RegisterPage /></Route>
    </Switch>
  </Router>
);
}

export default App;
