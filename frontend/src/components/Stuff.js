import React, {useState, useEffect} from 'react'
import FightStatistics from './FightStatistics.js';

export default function Stuff(props) {
    const stuff = props.stuff;

    return (
        <div>
            {stuff.name}
            <FightStatistics className="float-right" fightStatistics={stuff.fightStatistics}/>
        </div>
    );
}