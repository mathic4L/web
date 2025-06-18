import React from 'react';
import axios from 'axios';

const baseUrl = `http://localhost:8080/calcs`;


const getAuth = (store) => {
    const username = store.getState().auth.username;
    const password = store.getState().auth.password;
    const token = btoa(`${username}:${password}`);
    return {Authorization: token}
}

export async function getAllCalculations(store) {
    return await axios.get(`${baseUrl}`, {
        headers: Object.assign({}, getAuth(store))
    })
}

// export async function getCalculationsById(id) {
//     return await axios.get(`${baseUrl}/${id}`)
// }

// export async function updateCalculation(id, author) {
//     return await axios.put(`${baseUrl}/${id}`, author)
// }

export async function createCalculation(calculation, store) {
    return await axios.post(`${baseUrl}`, calculation, {
        headers: Object.assign({}, getAuth(store))
    })
}

// export async function deleteCalculationById(id) {
//     return await axios.delete(`${baseUrl}/${id}`)
// }



