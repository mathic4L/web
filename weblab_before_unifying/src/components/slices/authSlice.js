import { createSlice } from '@reduxjs/toolkit';
import {auth} from "../thunks/auth";
import {errorExtraReducer, loadingExtraReducer} from "./common";
import {initialState} from "./initialState";


const authSlice = createSlice({
    name: 'auth',
    initialState,
    reducers: {},
    extraReducers: (builder)=>{
        builder
            .addCase(auth.pending, loadingExtraReducer)
            .addCase(auth.rejected, errorExtraReducer)
            .addCase(auth.fulfilled, (state, action)=>{
                state.auth.isAuthenticated = true
            })
    }
});

// деструктуризация экшенов, выведенных из редьюсеров в authSlice
// каждый вида (payload)=>{/**/}
// export const { loginSuccess, loginFailure, logout } = authSlice.actions;
export const authReducer = authSlice.reducer ;