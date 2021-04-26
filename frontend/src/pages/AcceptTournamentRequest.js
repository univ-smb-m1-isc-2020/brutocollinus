import React, {useState}from 'react'
import useQuery from '../utils/Query.js';

export default function AcceptTournamentRequestPage() {
  const urlQuery = useQuery();
  const tournamentRequestUrl = urlQuery.get('tournamentRequestUrl');

  const [tournamentRequest, setTournamentRequest] = useState();
  const [boosts, setBoosts] = useState();
  const [brutos, setBrutos] = useState();

  if (tournamentRequest && boosts && brutos) {

  }
}
