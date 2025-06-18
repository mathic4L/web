import {ACTION_ADD_TODO, ACTION_Set_VISIBILITY_FILTER, ACTION_TOGGLE_TODO} from "./actions";
import {combineReducers} from "redux";


const todosReducer = (state = [], action) => {
    switch (action.type) {
        case ACTION_ADD_TODO:
            return [
                ...state,
                {
                    text: action.text,
                    done: false
                }]
        case ACTION_TOGGLE_TODO:
            return state.map((todo, index) => {
                if (index === action.index) {
                    return Object.assign({}, todo, {done: true})
                }
                return todo;
            })
        default:
            return state;
    }
}

const visibilityFiltersReducer = (state = {}, action) => {
    switch (action.type) {
        case ACTION_Set_VISIBILITY_FILTER:
            return action.visibilityFilter;
        default:
            return state;
    }
}

export const stateReducer = combineReducers(
    {
        todos: todosReducer,
        visibilityFilter:
        visibilityFiltersReducer
    }
)

/*
 or
 export const stateReducer = (state = {}, action) => {
    return {
        todos: todosReducer(state.todos, action),
        visibilityFilter: visibilityFiltersReducer(state.visibilityFilter, action),
    }
}
 */

