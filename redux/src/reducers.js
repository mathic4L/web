import {configureStore, createSlice} from '@reduxjs/toolkit'


const slice = createSlice({
    name: "main",
    initialState: {bool: false},
    reducers: {
        positive: (state, action)=>{
            state.bool = true;
        },
        negative: (state, action)=>{
            state.bool = false;
        }
    }
})


export const {positive, negative} = slice.actions

const reducer = slice.reducer;

export let store = configureStore({
    reducer
})
