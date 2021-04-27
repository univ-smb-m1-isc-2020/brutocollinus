import axios from 'axios';

const API_URL = '/api/';

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

  index() {
    return this.get(API_URL);
  }

  login(email, password) {
    return this.index().then(response => this.post(response._links.login.href, {
        email,
        password
      }))
      .then(response => {
        sessionStorage.setItem('user', JSON.stringify(response));

        return response;
      });
  }

  register(email, name, password) {
    return this.index().then(response => this.post(response._links.login.href, {
        email,
        name,
        password
      }))
      .then(response => {
          //sessionStorage.setItem('token', response.token);
          sessionStorage.setItem('user', JSON.stringify(response.user));

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
