import {createStore} from "redux";
import {stateReducer} from "./reducers";
import {ACTION_ADD_TODO, addTodoAction, setVisibilityFilterAction, toggleTodoAction} from "./actions";

export const VISIBILITY_FILTER_DONE = "done";
export const VISIBILITY_FILTER_TODO = "todo";
export const VISIBILITY_FILTER_ALL = "all";

export const createStoreCustom = (todos, visibilityFilter) => {
    return {
        todos: todos,
        visibilityFilter: visibilityFilter
    };
};

export const createTask = (text, done) => {
    return {
        text: text,
        done: done
    }
}
