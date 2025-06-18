import {BrowserRouter, Link, NavLink, Outlet, Route, Routes, useNavigate, useParams} from "react-router-dom";

export const Main = () => {
    return (
        <BrowserRouter basename={"/api"}>
            <Routes>
                {/*nested routes*/}
                <Route path={"/"} element={<Home/>}>
                    <Route path={"footer"} element={<Footer/>}/>
                </Route>

                {/*nested urls' routes*/}
                <Route path={"shop"} element={<Shop/>}/>
                <Route path={"shop/cars"} element={<Cars/>}/>
                {/*dynamic path*/}
                <Route path={"/shop/cars/:carId"} element={<Car/>}/>
            </Routes>
        </BrowserRouter>
    )
}


const Cars = () => {
    return (
        <>
            <NavLink to={".."}>shop</NavLink>
            <div>
                its cars section in shop
                <div>
                    <NavLink to={"1"}>1st car</NavLink><br/>
                    <NavLink to={"2"}>2nd car</NavLink><br/>
                    <NavLink to={"3"}>3rd car</NavLink><br/>
                </div>
            </div>
        </>
    )
}

const Shop = () => {
    return (
        <>
            <NavLink to={".."}>home</NavLink>
            <div>
                its shop
            </div>
            <NavLink to={"cars"}>cars</NavLink>
        </>
    )
}

const Home = () => {
    return (
        <>
            <NavLink to={"/shop"}>shop</NavLink>
            <div>{"___"}</div>

            <div>its home page</div>
            {/*navlink = link + styles*/}
            {/*"to" поддерживает и относительные и абсолютные пути */}
            <div>our bestsellers</div>
            <NavLink to={"/shop/cars/1"}>car1</NavLink>

            <div>{"___"}</div>
            <Outlet/>
        </>
    )
}

const Footer = () => {
    return (
        <div>
            its hidden footer
        </div>
    )
}

const Car = (props) => {
    // removed
    // const {userId} = props.match.params

    // new:
    const {carId} = useParams()

    const navigate = useNavigate()
    const handleBack = (e) => {
        e.preventDefault()
        navigate(-1)
    }

    return (
        <>
            <button onClick={handleBack}>back</button>
            <div>
                <NavLink to={"/"}>home</NavLink>
                /
                <NavLink to={"/shop"}>shop</NavLink>
                /
                <NavLink to={"/shop/cars"}>cars</NavLink>
                /
                {/*
                <NavLink
  className={({ isActive }) => {
    const linkClasses = [classes.registerButton];
    if (isActive) linkClasses.push(classes.active);

    return linkClasses.join(" "); // returns "registerButton" or "registerButton active"
  }}
  to="/auth/SignUp"
>
  cart
</NavLink>
                */}
                <NavLink to={`/shop/cars/${carId}`}>{`${carId}`}</NavLink>
            </div>
            <div>{`carId = ${carId}`}</div>
            {/*<NavLink to={".."}>cars</NavLink>*/}
        </>
    )
}