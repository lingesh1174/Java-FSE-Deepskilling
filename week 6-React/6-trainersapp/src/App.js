import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './Home';
import TrainersList from './TrainersList';
import TrainerDetail from './TrainerDetail';
import trainers from './TrainersMock';

function App(){
  return(
    <BrowserRouter>
      <div>
        <h1>My Academy Trainers App</h1>
        <nav>
          <ul style={{ listStyle: 'none', display: 'flex', gap: '20px' }}>
            <li><Link to="/">Home</Link></li>
            <li>|</li>
            <li><Link to="/trainers">Trainers</Link></li>
          </ul>
        </nav>

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/trainers" element={<TrainersList data={trainers} />} />
          <Route path="/trainer/:id" element={<TrainerDetail />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;