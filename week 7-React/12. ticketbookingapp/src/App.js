import { useState } from 'react';
import './App.css';
import Greeting from './Components/Greeting';

function App() {
  const [isLoggedIn,setIsLoggedIn] = useState(false);

  const handleLogin=()=>{
    setIsLoggedIn(!isLoggedIn);
  }
  return (
    <div className="App">
      <Greeting isLoggedIn={isLoggedIn} onClick={handleLogin} />
    </div>
  );
}

export default App;