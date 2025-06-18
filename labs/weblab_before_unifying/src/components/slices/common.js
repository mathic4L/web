export const loadingExtraReducer = (state, action)=>{
    state.stage.loading = true
}

export const errorExtraReducer = (state, action)=>{
    console.log(state)
    state.stage.error = action.payload
    state.stage.loading = false
}
