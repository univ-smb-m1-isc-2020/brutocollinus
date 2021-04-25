import React, {useState} from 'react'
import Tree from 'react-tree-graph';
import AuthService from '../services/Auth.js';
import useQuery from '../utils/Query.js';

export default function TournamentPage() {
  const urlQuery = useQuery();
  const tournamentUrl = urlQuery.get('tournamentUrl');

  let data = {
    name: 'Parent',
    children: [{
      name: 'Child One'
    }, {
      name: 'Child Two'
    }]
  };

  return (
      <>
      <>{tournamentUrl}</>
      <Tree data={data} height={400} width={400}/>
      </>
    );
}
