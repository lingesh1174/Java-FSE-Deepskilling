import { useState } from "react";

const Counter= () =>{
    const [count, setCount] = useState(0);

    const sayHello= () =>{
        alert("Hello Member!!!");
    }
    const increment = () =>{
        setCount(count + 1);
        sayHello();
    }
    const decrement = () =>{
        setCount(count - 1);
    } 
    return(
        <div>
            <p>Count : {count}</p>
            <button onClick = {increment} >Increment</button>
            <br/>
            <button onClick = {decrement}>Decrement</button>
        </div>
    )
}

export default Counter;