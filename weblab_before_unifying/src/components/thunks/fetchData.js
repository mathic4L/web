import {createAsyncThunk} from '@reduxjs/toolkit'
import {createCalculation, getAllCalculations} from "../../service/CalculationService";

/*
data/fetchData = async thunk creator id
обычно префикс используется = имя слайса
для

метод генерирует 3 действия с id:
data/fetchData/pending
data/fetchData/fulfilled
data/fetchData/rejected
 */
export const fetchData = createAsyncThunk(
    'data/fetchData',
    async () => {
        let data = (await getAllCalculations({})).data
        return await data.json()
    })


export const fetchResult = createAsyncThunk(
    'data/fetchResult',
    async ({x, y, radius}, {rejectWithValue}) => {
        try {
            return await createCalculation({x, y, radius}).data;
        } catch (error) {
            if (error.response) {
                // Сервер вернул ответ с ошибкой (4xx или 5xx)
                return rejectWithValue('Ошибка запроса');
            } else if (error.request) {
                // Запрос был отправлен, но ответа не было
                return rejectWithValue('Нет ответа от сервера');
            } else {
                // Произошла ошибка при настройке запроса
                return rejectWithValue('Ошибка при отправке запроса');
            }
        }
    }
);