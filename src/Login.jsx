import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    console.log(username)
    console.log(password)
    const adminLogin = () => {
            if(username === 'admin' && password === 'admin') {
                navigate('/admin');
            }
            else {
                alert('wrong credentials');
            }
    }
    const userLogin = (email, passwrd) => {
        const fetchUserById = async() => {
            try {
                const response = await axios.get(`http://localhost:8080/api/users/email/${email}`);
                const data = response.data;
                    if(data) {
                        if(data.password === passwrd) {
                            navigate(`/home/${data.id}`);
                        }
                        else {
                            alert('wrong credentials');
                        }
                    }
                    else {
                        alert('no account with this username');
                    }
            }
            catch(err) {
                alert(err);
            }
        }
        fetchUserById();
    }
    return (
        <div>
            <h1>Login</h1>
            <div className="container">
                <input 
                        placeholder="username" 
                        value={username} 
                        onChange={(e) => {setUsername(e.target.value)}}
                />
                <input  
                        type='password' 
                        placeholder="password" 
                        value={password} 
                        onChange={(e) => {setPassword(e.target.value)}}
                />
                <br/>
                <button id="" onClick={() => password && username ? userLogin(username, password) : alert('empty input')}>Log in as user</button>
                <br/>
                <button id="admin-login-button:hover" onClick={() => password && username ? ( adminLogin() ) : alert('empty input')}> Log in as admin </button>
                <br/>
                <button onClick={() => { navigate('/register')}}>Sign in</button>
            </div>
        </div>
    );
}

export default Login;