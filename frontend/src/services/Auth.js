import React from 'react'
import axios from 'axios';

const URL = '/api/player/';

// Service de connexion/deconnexion enregistrant le token et l'utilisateur courant'
class AuthService {
  post(url, params) {
    return axios.post(url, Object.assign({headers: this.headers}, params)).then(response => {
      return response.data;
    })
  }

  postForm(url, formData, params) {
    const headers = Object.assign({'Content-Type': 'multipart/form-data' }, this.headers);
//     console.log({headers, params});
    return axios.post(url, formData, {headers, params}).then(response => {
      return response.data;
    })
  }

  get(url, params) {
    return axios.get(url, {headers: this.headers, params: params}).then(response => {
      return response.data;
    })
  }

  login(email, password) {
    return this.post(URL + 'login', {
        email,
        password
      })
      .then(response => {
        sessionStorage.setItem('user', JSON.stringify(response));

        return response;
      });
  }

  register(email, firstname, lastname, dayofbirth, password, role) {
    console.log(email, dayofbirth, password)
    return this.post(URL + 'register', {
        email,
        firstname,
        lastname,
        dayofbirth,
        password,
        role
      })
      .then(response => {
          //if (response) {
            console.log(response)
            /*console.log('Logged');
            sessionStorage.setItem('token', response.token);
            sessionStorage.setItem('user', JSON.stringify(response.user));
          }*/

          return response;
      });
  }

  logout() {
    sessionStorage.removeItem('user');
    sessionStorage.removeItem('token');
    console.log('Unlogged');
  }

  get user() {
    return JSON.parse(sessionStorage.getItem('user'));
  }

  get token() {
    return sessionStorage.getItem('token')
  }

  get headers() {
    if (this.token) {
      return {'x-access-token': this.token}
    }
    else {
      return {};
    }
  }

  get formHeaders() {
    if (this.token) {
      return {'x-access-token': this.token}
    }
    else {
      return {};
    }
  }
}

export default new AuthService();
