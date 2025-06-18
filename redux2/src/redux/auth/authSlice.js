import {createSlice} from "@reduxjs/toolkit";

const initialState = {
    username: '',
    password: '',
    isAuthed: false
}

const loginReducer = (state, action) => {
    if (action.payload.username === 'user' &&
        action.payload.password === 'user') {
        state.isAuthed = true
        state.username = action.payload.username
        state.password = action.payload.password
    }
}

const logoutReducer = (state, action) => {
    state.isAuthed = false
}

const authSlice = createSlice({
    name: 'auth',
    initialState: initialState,
    reducers: {
        login: loginReducer,
        logout: logoutReducer
    }
})

export const {login, logout} = authSlice.actions
export const authReducer = authSlice.reducer
