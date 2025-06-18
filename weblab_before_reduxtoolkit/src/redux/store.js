import {configureStore} from "@reduxjs/toolkit";
import {reducer} from "./reducers";

export let store = configureStore({
    reducer: reducer
});
// Middleware thunk подключается автоматически благодаря redux toolkit





