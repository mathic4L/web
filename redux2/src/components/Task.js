import {useDispatch} from "react-redux";
import {dropTaskDescription, editTaskDescription, editTaskName, removeTask} from "../redux/tasks/taskSlice"

const Task = ({id, name, description, creationDate, lastEdit}) => {

    const dispatch = useDispatch()
    const handleRemoveTask = () => {
        dispatch(removeTask({id}))
    }
    const handleEditName = () => {
        dispatch(editTaskName({id, name: name + '1'}))
    }
    const handleEditDescription = () => {
        dispatch(editTaskDescription({id, description: description + '1'}))
    }
    const handleDropDescription = () => {
        dispatch(dropTaskDescription({id}))
    }

    return (
        <div>
            <title>
                {name}
                <ul>
                    <button onClick={handleEditName}>edit name</button>
                </ul>
            </title>
            <p>
                {description}
                <ul>
                    <button onClick={handleEditDescription}>edit desc</button>
                    <button onClick={handleDropDescription}>drop desc</button>
                </ul>
            </p>
            <p>{`created ${creationDate}, lastEdit ${lastEdit}`}</p>
            <ul>
                <button onClick={handleRemoveTask}>archive</button>
            </ul>
        </div>
    )
}

export {Task}