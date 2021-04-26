import React, {useState, useEffect} from 'react'
import FightStatistics from './FightStatistics.js';

export default function BrutoClass(props) {
    const brutoClass = props.brutoClass;

    return (
        <div>
            {brutoClass.name}
            <FightStatistics className="float-right" fightStatistics={brutoClass.fightStatistics}/>
        </div>
    );
}