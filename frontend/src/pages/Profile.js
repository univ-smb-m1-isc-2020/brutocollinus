import React from 'react'
import {useHistory} from "react-router-dom";
import {Button} from 'react-bootstrap';
import AuthService from '../services/Auth.js';

export default function ProfilePage() {
  const history = useHistory();

  function logout() {
    AuthService.logout();
    history.push('/');
  }

  return (
    <Button onClick={logout}>
      Se déconnecter
    </Button>
  );
}
