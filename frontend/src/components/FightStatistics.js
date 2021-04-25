import React, {useState, useEffect} from 'react'
import { Badge } from 'react-bootstrap';

export default function FightStatistics(props) {
    const fightStatistics = props.fightStatistics;

    return (
        <Badge className={props.className} variant="secondary">
            ATK: {fightStatistics.atk} HP: {fightStatistics.hp} INI: {fightStatistics.ini}
        </Badge>
    );
}