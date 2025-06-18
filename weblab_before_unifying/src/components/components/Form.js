// import {Button} from "primereact/button";
// import {InputText} from "primereact/inputtext";
// import {RadioButton} from "primereact/radiobutton";
// import React, {useState} from "react";
//
// export function Form() {
//
//     const [buttonValue, setButtonValue] = useState(0);
//     const [textFieldValue, setTextFieldValue] = useState(0);
//     const [radioValue, setRadioValue] = useState(0);
//
//     const handleButtonClick = (value) => {
//         setButtonValue(value);
//     };
//     const handleTextFieldChange = (event) => {
//         const value = parseInt(event.target.value);
//         setTextFieldValue(value);
//     };
//     const handleRadioChange = (event) => {
//         const value = parseInt(event.target.value);
//         setRadioValue(value);
//     };
//
//     return (
//         <>
//             <h2>Calc</h2>
//             <div className="input-section">
//                 <h3>Buttons (-2 to 2)</h3>
//                 <Button label="-2" onClick={() => handleButtonClick(-2)}/>
//                 <Button label="-1" onClick={() => handleButtonClick(-1)}/>
//                 <Button label="0" onClick={() => handleButtonClick(0)}/>
//                 <Button label="1" onClick={() => handleButtonClick(1)}/>
//                 <Button label="2" onClick={() => handleButtonClick(2)}/>
//                 <input type={"text"} readOnly name={"x"} value={buttonValue}/>
//                 {/*<p>Selected value: {buttonValue}</p>*/}
//             </div>
//             <div className="input-section">
//                 <h3>Text Field (-3 to 3)</h3>
//                 <InputText name={"y"} value={textFieldValue.toString()} onChange={handleTextFieldChange}/>
//                 <p>Entered value: {textFieldValue}</p>
//             </div>
//             {/* Radio buttons for input */}
//             <div className="input-section">
//                 <h3>R</h3>
//                 <RadioButton inputId="r1" name="r" value={1} onChange={handleRadioChange} checked={radioValue === 1}/>
//                 <label htmlFor="r1">1</label>
//                 <RadioButton inputId="r2" name="r" value={2} onChange={handleRadioChange} checked={radioValue === 2}/>
//                 <label htmlFor="r2">2</label>
//                 <RadioButton inputId="r3" name="r" value={3} onChange={handleRadioChange} checked={radioValue === 3}/>
//                 <label htmlFor="r3">3</label>
//                 <RadioButton inputId="r4" name="r" value={4} onChange={handleRadioChange} checked={radioValue === 4}/>
//                 <label htmlFor="r4">4</label>
//                 <RadioButton inputId="r5" name="r" value={5} onChange={handleRadioChange} checked={radioValue === 5}/>
//                 <label htmlFor="r5">5</label>
//             </div>
//         </>
//     )
// }