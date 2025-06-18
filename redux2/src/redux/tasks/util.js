export const editTaskProperty = (state, action, field) => {
    let tobeChanged = state.relevant.filter((item) => {
        return item.id === action.payload.id
    })
    tobeChanged[field] = action.payload[field]
}

export const dropTaskField = (state, action, field) => {
    let tobeDropped = state.relevant.filter((item) => {
        return item.id === action.payload.id
    })
    tobeDropped[field] = null
}