import React from "react";

export const Todo = (text, done, onClick) => {
    return <li
        onClick={onClick}
        style={{
            textDecoration: done ? 'line-through' : 'none',
        }}
    >{text}</li>
}