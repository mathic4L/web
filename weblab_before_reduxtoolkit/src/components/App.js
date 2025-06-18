import {BrowserRouter, Route, Routes} from "react-router-dom";
import Input from "./Main";
import {Test} from "./Test";

export function App() {

    return (
        <div>
            {/*<BrowserRouter>*/}
            {/*    <Input/>*/}
            {/*    <Output/>*/}
            <Test/>
            {/*</BrowserRouter>*/}
        </div>
    );
}
