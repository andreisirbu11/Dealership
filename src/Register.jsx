import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const Register = () => {
    const [user, setUser] = useState({
        name: '',
        email: '',
        password: '',
        idRol: 2
    })
    const navigate = useNavigate();
    const handleChange = (e) => {
        setUser(prev=>({...prev, [e.target.name]: e.target.value}))
    }
    const handleClick = async e => {
        e.preventDefault()
        try {
            if(user.email && user.name && user.password) {
                const response = axios.get(`http://localhost:8080/api/users/email/${user.email}`)
                const data = (await response).data
                if(data.email) {
                    alert('email already used')
                }
                else {
                    await axios.post('http://localhost:8080/api/users/add', user)
                    navigate(`/`)
                    alert('account successfuly created')
                }
            }
            else {
                alert('complete all fields')
            }
        }
        catch(err) {
            console.log(err)
        }
    }
    return(
        <div>
            <h1>Register</h1>
            <div className="container">
                <input
                    placeholder="name"
                    onChange={handleChange}
                    name="name"
                />
                <input
                    placeholder="username(email)"
                    onChange={handleChange}
                    name="email"
                />
                <input
                    type="password"
                    placeholder="password"
                    onChange={handleChange}
                    name="password"
                />
                <button onClick={handleClick}>Create account</button>
            </div>
        </div>
    )
}

export default Register;