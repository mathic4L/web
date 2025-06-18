/*
варианты хранения
redux slice - потеряется при перезагрузке страницы
session storage
local storage:
    По отдельности
    Вместе (как JSON):
    Зашифрованные (например, с использованием btoa)
*/


export const getLocalAuthData = () => {
    return JSON.parse(localStorage.getItem("authData"))
}

export const setLocalAuthData = (data) => {
    localStorage.setItem("authData", JSON.stringify(data))
}

export const clearLocalAuthData = (data) => {
    localStorage.removeItem("authData")
}


