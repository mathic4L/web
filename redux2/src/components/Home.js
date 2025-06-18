import {useDispatch, useSelector} from "react-redux";
import {Task} from "./Task";

const Home = () => {
    const dispatch = useDispatch()
    const relevant = useSelector((state) => {
        return state.tasks.relevant
    })
    const archived = useSelector((state) => {
        return state.tasks.archived
    })

    return (
        <>
            <div>
                <title>{"relevant"}</title>
                <button>{"add task"}</button>
                {relevant.map((i) => {
                    return Task(i)
                })}
            </div>
            <div>___________________________</div>
            <div>
                <title>{"archived"}</title>
                {archived.map((i) => {
                    return Task(i)
                })}
            </div>
        </>
    )
}

export  {Home}