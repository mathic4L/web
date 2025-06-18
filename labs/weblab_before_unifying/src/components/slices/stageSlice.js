import {createSlice} from "@reduxjs/toolkit";
import {initialState} from "./initialState";

const stageSlice = createSlice({
    name: "stage",
    initialState,
    reducers:{},
    extraReducers:(builder)=>{}
})

export const stageReducer = stageSlice.reducer;