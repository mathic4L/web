import {useDispatch, useSelector} from 'react-redux'
import React from "react";
import {login} from "../redux/auth/authSlice";

const AuthPage = ()=>{
    const dispatch = useDispatch()
    let password = useSelector((state)=>{return state.auth.password})
    let username = useSelector((state)=>{return state.auth.username})

    const handleClick = ()=>{
        const username = document.getElementById('username').value
        const password = document.getElementById('password').value
        dispatch(login({username, password}))
    }

    return (
        <>
            <div style={{padding: '32px'}}>
                <input id={'username'} placeholder={username}/>
                <input id={'password'} placeholder={password}/>
                <button onClick={handleClick}>
                    auth
                </button>
            </div>
        </>
    )
}

export {AuthPage}