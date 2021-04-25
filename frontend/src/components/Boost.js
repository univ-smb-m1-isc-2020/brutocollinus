import React, {useState, useEffect} from 'react'
import FightStatistics from './FightStatistics.js';

export default function Boost(props) {
    const boost = props.boost;

    return (
        <div>
            {boost.name}
            <FightStatistics className="float_right" fightStatistics={boost.fightStatistics}/>
        </div>
    );
}