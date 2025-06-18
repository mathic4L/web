import {createStore, applyMiddleware, combineReducers} from '@reduxjs/toolkit'
import {actionTypes, getAttemptsAction} from "./actions";
import {createCalculation, getAllCalculations} from "../service/CalculationService";
import thunk from 'redux-thunk';
// import { combineReducers } from 'redux';



const attemptsReducer = async (state = [], action) => {
    switch (action.type) {
        case actionTypes.ADD_ATTEMPT:
            let calculation
                = await createCalculation(action.payload)
            return [
                ...state,
                calculation
            ]
        case actionTypes.GET_ATTEMPTS:
        default:
            return state;
    }
}

const emptyAuth = {isAuthed: false, username: null, password: null}
const authReducer = async (state = emptyAuth,
                           action) => {
    switch (action.type) {
        case actionTypes.LOGIN:
            return Object.assign({}, action.payload, {isAuthed: true});
        case actionTypes.LOGOUT:
            return Object.assign({}, {isAuthed: false})
        default:
            return state;
    }
}

export const reducer = combineReducers({
    attempts: attemptsReducer,
    auth: authReducer,
})