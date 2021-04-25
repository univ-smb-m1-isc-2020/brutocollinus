import React from 'react'
import Tournament from '../components/Tournament.js';
import useQuery from '../utils/Query.js';

export default function TournamentPage() {
  const urlQuery = useQuery();
  const tournamentUrl = urlQuery.get('tournamentUrl');

  return (<Tournament url={tournamentUrl}/>);
}
