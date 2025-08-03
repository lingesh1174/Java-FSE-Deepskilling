import './App.css';
import {IndianPlayers,OddPlayers,EvenPlayers} from './Components/IndianPlayers';
import ListofPlayers from './Components/ListofPlayers';
import {players} from './data';

function App() {
  var Flag = false;
  if(Flag){
    return(
      <div>
        <ListofPlayers players={players}/>
      </div>
    )
  }
  else{
    return (
      <div>
        <h1>Odd Players</h1>
        <OddPlayers players={players}/>
        <h1>Even Players</h1>
        <EvenPlayers players={players}/>
        <h1>List of Merged Indian Players</h1>
        {IndianPlayers.map((item)=>(
          <li>{item}</li>
        ))}
      </div>
    )
  }
}

export default App;