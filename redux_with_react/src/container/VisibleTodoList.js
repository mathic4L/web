import {connect} from 'react-redux';
import {VISIBILITY_FILTER_ALL, VISIBILITY_FILTER_DONE, VISIBILITY_FILTER_TODO} from "../store";
import {toggleTodoAction} from "../actions";
import {TodoList} from "../view/TodoList";

const mapStateToProps = (state) => {
    switch (state.visibilityFilter) {
        case VISIBILITY_FILTER_TODO:
            return state.todos.filter((x) => {
                return !x.done
            });
        case VISIBILITY_FILTER_DONE:
            return state.todos.filter((x) => {
                return x.done
            });
        case VISIBILITY_FILTER_ALL:
            return state.todos;
        default:
            return state.todos
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        onClickTodo: (index)=>{
            dispatch(toggleTodoAction(index));
        }
    }
}


export const VisibleTodoList = connect(
    mapStateToProps,
    mapDispatchToProps
)(TodoList)