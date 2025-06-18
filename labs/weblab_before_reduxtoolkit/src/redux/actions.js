export const actionTypes = {
    GET_ATTEMPTS: "getAttempts",
    ADD_ATTEMPT: "addAttempt",
    // UPDATE_ATTEMPTS: "updateAttempts",
    LOGIN: "LOGIN",
    LOGOUT: "LOGOUT"
}

export const addAttemptAction = (payload) => {
    return {
        type: actionTypes.ADD_ATTEMPT,
        payload: payload
    }
}

export const getAttemptsAction = (payload) => {
    return {
        type: actionTypes.GET_ATTEMPTS,
        payload: payload
    }
}

export const loginAction = (payload) => {
    return {
        type: actionTypes.LOGIN,
        payload: payload
    }
}

export const logoutAction = () => {
    return {
        type: actionTypes.LOGOUT,
    }
}