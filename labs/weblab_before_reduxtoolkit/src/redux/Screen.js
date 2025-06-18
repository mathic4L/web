import React, { useEffect } from '@reduxjs/toolkit';
import { useDispatch, useSelector } from 'react-redux';
import { fetchPoints } from './actions/pointsActions';

const Screen = () => {
    const dispatch = useDispatch();
    const points = useSelector((state) => state.points.points);

    useEffect(() => {
        dispatch(fetchPoints());
    }, [dispatch]);

    return (
        <div>
            <h1>Points</h1>
            <ul>
                {points.map((point, index) => (
                    <li key={index}>{JSON.stringify(point)}</li>
                ))}
            </ul>
        </div>
    );
};

export default App;
