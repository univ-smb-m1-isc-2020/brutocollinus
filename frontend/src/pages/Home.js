import React, {useState, useEffect} from 'react'

import AuthService from '../services/Auth.js';
import BrutoList from '../components/BrutoList.js';

export default function HomePage() {
  const [brutos, setBrutos] = useState([]);
  const user = AuthService.user;

  useEffect(() => {
    //  AuthService.get(user._links.all_bruto.href).then(response => setBrutos(response));
    //}, [user._links.all_bruto.href]);
    AuthService.get(user._links.all_bruto.href).then(setBrutos);
  }, [user._links.all_bruto.href]);

  return (
    <BrutoList brutos={brutos}/>
  );
}
