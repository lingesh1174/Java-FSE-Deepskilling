import {GuestGreeting} from "./GuestGreeting";
import {UserGreeting} from "./UserGreeting";

function Greeting(props){
    const isLoggedIn = props.isLoggedIn;
    if(isLoggedIn)
        return <UserGreeting onClick={props.onClick}/>
    return <GuestGreeting onClick={props.onClick}/>
}

export default Greeting;