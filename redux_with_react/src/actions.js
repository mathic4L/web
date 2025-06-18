export const ACTION_ADD_TODO=  "ADD_TODO";
export const ACTION_TOGGLE_TODO = "ACTION_TOGGLE_TODO";
export const ACTION_Set_VISIBILITY_FILTER = "Set_VISIBILITY_FILTER";

export const addTodoAction = (text) => {
    return {
        type: ACTION_ADD_TODO,
        text: text
    }
}

export const setVisibilityFilterAction = (visibilityFilter) => {
    return {
        type: ACTION_Set_VISIBILITY_FILTER,
        visibilityFilter: visibilityFilter
    };
}

export const toggleTodoAction = (index) => {
    return {
        type: ACTION_TOGGLE_TODO,
        index: index
    }
}