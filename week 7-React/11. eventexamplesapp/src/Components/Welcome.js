const Welcome =()=>{
    const sayWelcome=()=>{
        alert("Welcome!!!");
    }
    return(
        <button onClick={sayWelcome}>Say Welcome</button>
    )
}
export default Welcome;