export function LoginButton(props){
    return(
        <button onClick = {props.onClick}>
            Login
        </button>
    )
}

export function GuestGreeting(props){
    return(
        <div>
            <h1>Please sign up.</h1>
            <LoginButton onClick={props.onClick}/>
        </div>
    )
}