import React, {useState, useEffect} from 'react'

export default function AttackRecord(props) {
    const record = props.record;

    return (
        <div className={props.className}>
            { record.attacker.name + " inflige " + record.damage + " dégàt à " + record.defender.name + " il lui reste " + record.defenderHp}
        </div>
    );
}