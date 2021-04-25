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

    function formatNode(node) {
        const children = node.children ? node.children.map(formatNode) : [];
        const selectedBruto = node.selectedBruto;
        const name = selectedBruto ? selectedBruto.name : "";

        return {name, children};
    }

    const data = formatNode(tournament.tree);

    console.log(data);

    return (
        <>
            <h1>{tournament.name}</h1>
            <Tree data={data} height={400} width={400}/>
        </>
    );
}