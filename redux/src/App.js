import {useDispatch, useSelector} from "react-redux";
import {negative, positive} from "./reducers";

export const App = () => {

    const dispatch = useDispatch()
    let bool = useSelector((state) => {
        return state.bool
    })

    return (
        <>
            {bool ? <div>
                yes
                <button onClick={()=>{dispatch(negative())}}></button>
            </div> : <div>
                no
                <button onClick={()=>{dispatch(positive())}}></button>
            </div>}
        </>
    )
}
