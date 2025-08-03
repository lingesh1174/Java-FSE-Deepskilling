import './App.css';
import Counter from './Components/Counter';
import CurrencyConvertor from './Components/CurrencyConvertor';
import SyntheticEvent from './Components/SyntheticEvent';
import Welcome from './Components/Welcome';

function App() {
  return (
    <div>
      <Counter/>
      <Welcome/><br/>
      <SyntheticEvent/>
      <CurrencyConvertor/>
    </div>
  );
}

export default App;
