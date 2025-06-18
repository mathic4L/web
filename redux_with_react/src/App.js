import {createStoreCustom, mainRedux} from "./store";
import {Provider} from "react-redux";
import {createStore} from "redux";
import {stateReducer} from "./reducers";
import {VisibleTodoList} from "./container/VisibleTodoList";
import AddTodo from "./container/AddTodo";
import {Footer} from "./view/Footer";


export function App() {
    let store = createStore(stateReducer, createStoreCustom([], ""));
    const unsubscribe = store.subscribe(() =>
        console.log(store.getState())
    );
    return (
        <div>
            <Provider store={store}>
                <AddTodo/>
                <VisibleTodoList/>
                <Footer/>
            </Provider>
        </div>
    );
}
