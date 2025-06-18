import {validator} from "./auxl/validator";
import React, { useState } from 'react';
import { Button } from 'primereact/button';
import { InputText } from 'primereact/inputtext';
import { RadioButton } from 'primereact/radiobutton';
import {Form} from "./Form";
import {Out} from "./Out";

const Main = (props) => {
    return (
        <>
            <Form/>
            <Out/>
        </>
    );
};

export default Main;


