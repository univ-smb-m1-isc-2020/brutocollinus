import React from 'react'
import FightStatistics from './FightStatistics.js';

export default function Stuff(props) {
    const stuff = props.stuff;

    return (
        <div>
            {stuff.name}
            <FightStatistics fightStatistics={stuff.fightStatistics}/>
        </div>
    );
}