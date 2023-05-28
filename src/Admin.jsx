import React, { useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";

const Admin = () => {
    const [user, setUser] = useState({
        id: 0,
        name: "",
        email: "",
        password: "",
        idRol: 0
    })
    const [orderId, setOrderId] = useState(0)
    const handleDelete = async() => {
        try {
            await axios.delete(`http://localhost:8080/api/orders/delete/${orderId}`)
            alert("order deleted")
        }
        catch(err) {
            console.log(err)
        }
    }
    const handleChange = (e) => {
        setUser(prev=>({...prev, [e.target.name]: e.target.value}))
    }
    const handleUpdate = async() => {
        try {
            await axios.put(`http://localhost:8080/api/users/update/id/${user.id}`, user)
            alert('user updated')
        }
        catch(err) {
            console.log(err)
        }
    }
    console.log(user)
    return(
        <div>
            <div className="container">
                <h1>Delete order</h1>
                <input type="number" placeholder="id" onChange={(e) => { setOrderId(e.target.value)}}></input>
                <button onClick={handleDelete}>Delete order</button>
            </div>
            <div className="container">
                <h1>Update user</h1>
                <input type="number" placeholder="id" onChange={handleChange} name="id"></input>
                <input type="text" placeholder="name" onChange={handleChange} name="name"></input>
                <input type="text" placeholder="email"onChange={handleChange} name="email"></input>
                <input type="text" placeholder="password" onChange={handleChange} name="password"></input>
                <input type="number" placeholder="role" onChange={handleChange} name="idRol"></input>
                <button onClick={handleUpdate}>Update user</button>
            </div>
            <br/>
            <button id='btnLogout'><Link to='/'>Log out</Link></button>
        </div>
    );
}

export default Admin;