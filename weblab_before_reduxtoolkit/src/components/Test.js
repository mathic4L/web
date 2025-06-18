import React from "react";
import axios from "axios";

export class Test extends React.Component {

    componentDidMount() {
        let encoded = btoa("user3:user3");
        console.log(encoded)
        axios.get("http://localhost:8080/calcs", {
            headers: {
                Authorization: `Basic ${encoded}`,
            }
        }).then(x=>this.setState(x))
    }

    render() {
        return(
            <div>{this.state}</div>
        )
    }
}