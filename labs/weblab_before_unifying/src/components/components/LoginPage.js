import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import {auth} from "../thunks/auth";

export const LoginPage = () => {
    const dispatch = useDispatch();
    const error = useSelector((state) => state.stage.error);

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = async (e) => {
        e.preventDefault();
        dispatch(auth({username, password}))
    };

    return (
        <div>
            <h1>Login</h1>
            <form onSubmit={handleLogin}>
                <input
                    type="text"
                    placeholder="Username"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                />
                <input
                    type="password"
                    placeholder="Password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
                <button type="submit">Login</button>
            </form>
            {error && <p>{error}</p>}
        </div>
    );
};

