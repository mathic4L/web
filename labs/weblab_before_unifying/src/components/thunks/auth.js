import {validateAuth} from "../../service/CalculationService";
import {setLocalAuthData} from "../auth/auth";
import {createAsyncThunk} from "@reduxjs/toolkit";

export const auth = createAsyncThunk(
    "auth",
    async ({username, password}, rejectWithValue) => {
    try {
        const response = await validateAuth({username, password})

        if (response.status >= 200 && response.status < 300) {
            setLocalAuthData({username, password});
            return true
        } else {
            return rejectWithValue('bad response')
        }
    } catch (error) {
        return rejectWithValue('Error occurred during login');
    }
})