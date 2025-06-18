import { configureStore } from '@reduxjs/toolkit';
import {authReducer} from './slices/authSlice';
import {dataReducer} from "./slices/dataSlice";
import {stageReducer} from "./slices/stageSlice";

export const store = configureStore({
    reducer: {
        auth: authReducer,
        data: dataReducer,
        stage: stageReducer,
    },
});