import React from 'react'
import Match from '../components/Match.js';
import useQuery from '../utils/Query.js';

export default function MatchPage() {
  const urlQuery = useQuery();
  const matchUrl = urlQuery.get('matchUrl');

  return (<Match url={matchUrl}/>);
}
