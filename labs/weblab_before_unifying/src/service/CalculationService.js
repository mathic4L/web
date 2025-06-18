import axios from 'axios';
import {getLocalAuthData} from "../components/auth/auth";


const URL_ROOT = `http://localhost:8080`;
// const URL_LOGIN = `${URL_ROOT}/login`;
const URL_LOGIN = `${URL_ROOT}/calcs`;
const URL_CALCS = `${URL_ROOT}/calcs`;

const getAuthHeader = ({username, password})=> {
    const token = btoa(`${username}:${password}`);
    console.log(token)
    return {Authorization: "Basic dXNlcjI6dXNlcjI="}
}

export async function validateAuth(authData) {
    return await axios.get(`${URL_LOGIN}`, {
        headers: Object.assign({}, getAuthHeader(authData))
    })
}

export async function getAllCalculations() {
    return await axios.get(`${URL_CALCS}`, {
        headers: Object.assign({}, getAuthHeader(getLocalAuthData()))
    })
}

export async function createCalculation(calculation) {
    return await axios.post(`${URL_ROOT}`, calculation, {
        headers: Object.assign({}, getAuthHeader(getLocalAuthData()))
    })
}

// export async function getCalculationsById(id) {
//     return await axios.get(`${baseUrl}/${id}`)
// }

// export async function updateCalculation(id, author) {
//     return await axios.put(`${baseUrl}/${id}`, author)
// }

// export async function deleteCalculationById(id) {
//     return await axios.delete(`${baseUrl}/${id}`)
// }



