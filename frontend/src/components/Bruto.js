import React from 'react'
import { ListGroup } from 'react-bootstrap'
import BrutoClass from './BrutoClass.js';

export default function Bruto(props) {
  const bruto = props.bruto;
  return (
    <span>
      <h4>{bruto.name}</h4>
      <BrutoClass brutoClass={bruto.brutoClass}/>
    </span>
  );
}
