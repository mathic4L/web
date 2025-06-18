import {configureStore} from "@reduxjs/toolkit";
import {tasksReducer} from "./tasks/taskSlice";
import {authReducer} from "./auth/authSlice";

let store = configureStore({
    reducer: {
        tasks: tasksReducer,
        auth: authReducer
    }
})

export {store}