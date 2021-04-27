import React from 'react'
import FightStatistics from './FightStatistics.js';

export default function BrutoClass(props) {
    const brutoClass = props.brutoClass;

    return (
        <div>
            {brutoClass.name}
            <FightStatistics fightStatistics={brutoClass.fightStatistics}/>
        </div>
    );
}