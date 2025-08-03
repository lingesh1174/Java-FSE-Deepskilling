const SyntheticEvent=()=>{
    const clickEvent=(e)=>{
        alert("I was Clicked...");
        console.log("Synthetic event triggered",e);
    }
    return(
        <button onClick={clickEvent}>Click on me</button>
    )
}

export default SyntheticEvent;