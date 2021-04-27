import React from 'react'
import FightStatistics from './FightStatistics.js';

export default function Boost(props) {
    const boost = props.boost;

    return (
        <div>
            {boost.name}
            <FightStatistics fightStatistics={boost.fightStatistics}/>
        </div>
    );
}