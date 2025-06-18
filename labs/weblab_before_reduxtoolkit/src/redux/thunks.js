import {getAllCalculations} from "../service/CalculationService";
import {getAttemptsAction} from "./actions";

export const fetchAttempts = () => {
    return async function thunkFetchAttempts(dispatch, getState) {
        const response = await getAllCalculations(getState())
        dispatch(getAttemptsAction(response.data))
    }
}