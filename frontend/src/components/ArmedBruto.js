import React from 'react'
import {ListGroup} from 'react-bootstrap';
import FightStatistics from './FightStatistics.js';
import Boost from './Boost.js';
import Stuff from './Stuff.js';
import BrutoClass from './BrutoClass.js';

export default function ArmedBruto(props) {
    const armedBruto = props.armedBruto;

    return (
        <div className={props.className}>
            <div className="text-center">
                <h4>{ armedBruto.name }</h4>
                <FightStatistics fightStatistics={armedBruto.totalFightStatistics} />
            </div>

            <BrutoClass brutoClass={armedBruto.brutoClass}/>

            <div>Boosts</div>
            <ListGroup>
                {armedBruto.equipedBoosts.map(boost =>
                    (<ListGroup.Item>
                        <Boost boost={boost}/>
                    </ListGroup.Item>))}
            </ListGroup>

            <div>Stuffs</div>
            <ListGroup>
                {armedBruto.equipedStuffs.map(stuff =>
                    (<ListGroup.Item>
                        <Stuff stuff={stuff}/>
                    </ListGroup.Item>))}
            </ListGroup>
        </div>
    );
}