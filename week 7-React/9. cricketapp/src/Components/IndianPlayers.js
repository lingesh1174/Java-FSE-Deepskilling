const naming = ['First' , 'Second' , 'Third', 'Fourth' , 'Fifth' , 'Sixth' , 'Seventh']
const T20Players = ['First Player', 'Second Player', 'Third Player']
const RanjiTrophyPlayers = ['Fourth Player','Fifth Player', 'Sixth Player', 'Seventh Player']

export const IndianPlayers = [...T20Players,...RanjiTrophyPlayers]

export const OddPlayers=({players})=>{
    let Indians = players.filter(item => item.country === 'India')
    return(
        Indians.map((item,index)=>{
            if(index%2 === 0){
                return(
                    <li key={index}>{naming[index]} : {item.name} {index+1}</li>
                )
            }
            else
                return null
        })
    )
}

export const EvenPlayers=({players})=>{
    let Indians = players.filter(item => item.country === 'India')
    return(
        Indians.map((item,index)=>{
            if(index%2 !== 0){
                return(
                    <li key={index}>{naming[index]} : {item.name} {index+1}</li>
                )
            }
            else
                return null
        })
    )
}