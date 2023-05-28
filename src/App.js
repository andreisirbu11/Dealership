import './App.css'
import Home from './Home.jsx'
import Login from './Login.jsx'
import Admin from './Admin.jsx'
import Register from './Register.jsx'
import {
  BrowserRouter,
  Routes,
  Route 
} from 'react-router-dom'

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Login/>}/>
          <Route path='/home/:id' element={<Home/>}/>
          <Route path='/admin' element={<Admin/>}/>
          <Route path='/register' element={<Register/>}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
