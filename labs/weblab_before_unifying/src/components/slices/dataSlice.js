import {createSlice} from "@reduxjs/toolkit";
import {fetchData, fetchResult} from "../thunks/fetchData";
import {initialState} from "./initialState";

export const dataSlice = createSlice({
    name: "data",
    initialState,
    // slice's action reducers
    reducers: {},
    // extern action reducers
    extraReducers: (builder) => {
        builder
            // immutability предоставляет redux toolkit
            .addCase(fetchData.pending, (state, action) => {
                state.stage.loading = true;
            })
            .addCase(fetchData.fulfilled, (state, action) => {
                state.data = action.payload;
                state.stage.loading = false;
                state.stage.error = null;
            })
            .addCase(fetchData.rejected, (state, action) => {
                state.stage.error = action.payload;
            })
            .addCase(fetchResult.pending, (state, action) => {
                state.stage.loading = true;
            })
            .addCase(fetchResult.fulfilled, (state, action) => {
                state.data.push(action.payload);
                state.stage.loading = false;
                state.stage.error = null;
            })
            .addCase(fetchResult.rejected, (state, action) => {
                state.stage.error = action.payload;
            })
    }
})

export const dataReducer = dataSlice.reducer