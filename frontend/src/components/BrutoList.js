import React from 'react'
import { ListGroup } from 'react-bootstrap'

export default function BrutoList(props) {
  const brutos = props.brutos;
  return (
    <ListGroup>
    {brutos.map(bruto => {
      return (
        <ListGroup.Item> {bruto.name} </ListGroup.Item>
    )})}
    </ListGroup>
  );
}
