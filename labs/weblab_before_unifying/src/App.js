import {useSelector} from 'react-redux';
import {LoginPage} from './components/components/LoginPage';
import React from 'react';
import {Main} from "./components/components/Main";

export const App = () => {

    const isAuthenticated = useSelector((state) => state.auth.isAuthenticated);

    return (
        <div>
            {isAuthenticated ? <h1><Main/></h1> : <LoginPage/>}
        </div>
    );
};