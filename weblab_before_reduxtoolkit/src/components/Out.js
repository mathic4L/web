import {Button} from "primereact/button";
import {InputText} from "primereact/inputtext";
import {RadioButton} from "primereact/radiobutton";
import React from "react";

export function Out(value) {
    return (
        <>
            {`${value.x}\t${value.y}\t${value.r}\t${value.result}`}
        </>
    )
}