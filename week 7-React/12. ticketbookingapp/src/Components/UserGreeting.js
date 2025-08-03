export function LogoutButton(props){
    return(
        <button onClick = {props.onClick}>
            Logout
        </button>
    )
}

export function UserGreeting(props){
    return(
        <div>
            <h1>Welcome back!</h1>
            <LogoutButton onClick={props.onClick}/>
        </div>
    )
}