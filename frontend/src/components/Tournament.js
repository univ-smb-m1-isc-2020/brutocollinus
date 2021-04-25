import React, {useState, useEffect} from 'react'
import Tree from 'react-tree-graph';
import AuthService from '../services/Auth.js';

export default function Tournament(props) {
    const [tournament, setTournament] = useState();

    useEffect(() => {
        AuthService.get(props.url).then(setTournament);
    }, [props.url]);

    if (!tournament) {
        return ('Loading');
    }

    let data = {
        name: 'Parent',
        children: [{
            name: 'Child One'
        }, {
            name: 'Child Two'
        }]
    };

    console.log(tournament);

    return (
        <>
            <>{props.url}</>
            <Tree data={data} height={400} width={400}/>
        </>
    );
}