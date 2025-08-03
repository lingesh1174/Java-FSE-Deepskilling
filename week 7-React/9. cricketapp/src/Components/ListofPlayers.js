const ListofPlayers =({players})=>{
    const ShowPlayers =()=>{
        return(
            players.map((item)=>{
                return(
                    <div>
                        <li>Mr. {item.name} <span>{item.score}</span></li>
                    </div>
                )
            })
        )
    }
    const LowScorers =()=>{
        let players70 = players.filter(item => item.score<=70)
        return(
            players70.map((item)=>{
                return(
                    <div>
                        <li>Mr. {item.name} <span>{item.score}</span></li>
                    </div>
                )
            })
        )
    }
    return(
        <div>
            <h1>List of Players</h1>
            <ShowPlayers/>
            <h1>List of Players scored less than 70</h1>
            <LowScorers/>
        </div>
    )
}

export default ListofPlayers;