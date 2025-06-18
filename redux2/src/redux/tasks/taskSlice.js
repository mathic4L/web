import {createSlice} from '@reduxjs/toolkit'
import {dropTaskField, editTaskProperty} from "./util";
import {createTaskFabric} from "./task";


const initialState = {
    counter: 0,
    relevant: [],
    archived: []
}

const createTask = createTaskFabric();

const addTaskReducer = (state, action) => {
    let newTask = createTask(action.payload)
    state.relevant.push(newTask)
}

const removeTaskReducer = (state, action) => {
    let tobeRemoved = state.relevant.find((item) => {
        return item.id === action.payload
    })
    state.relevant = state.relevant.filter((item) => {
        return item === tobeRemoved
    })
    state.archived.push(tobeRemoved)
}

const editTaskNameReducer = (state, action) => {
    editTaskProperty(state, action, 'name')
}

const editTaskDescriptionReducer = (state, action) => {
    editTaskProperty(state, action, 'description')
}

const dropTaskDescriptionReducer = (state, action) => {
    dropTaskField(state, action, 'description')
}

const taskSlice = createSlice({
    name: "task",
    initialState: initialState,
    reducers: {
        addTask: addTaskReducer,
        removeTask: removeTaskReducer,
        editTaskName: editTaskNameReducer,
        editTaskDescription: editTaskDescriptionReducer,
        dropTaskDescription: dropTaskDescriptionReducer
    }
})

export const {
    addTask,
    removeTask,
    editTaskName,
    editTaskDescription,
    dropTaskDescription
} = taskSlice.actions
export const tasksReducer = taskSlice.reducer