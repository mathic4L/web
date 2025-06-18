import {useSelector} from "react-redux";
import {AuthPage} from "./AuthPage";
import {Home} from "./Home";

const Main = ()=>{
    let isAuthed = useSelector((state)=>{return state.auth.isAuthed})

    return(
        <>
            {isAuthed ? <Home/> : <AuthPage/>}
        </>
    )
}

export {Main}