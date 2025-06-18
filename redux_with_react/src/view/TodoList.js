import React from "react";
import {Todo} from "./Todo";

export const TodoList = (todos, todosOnClick) => {
    <ul>
        {todos.map((todo, index) => (
            <Todo
                key={index}
                {...todo}
                onClick={() => todosOnClick(index)}
            />
        ))}
    </ul>
}