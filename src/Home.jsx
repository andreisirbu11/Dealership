import axios from "axios";
import React, { useState } from "react";
import Vehicle from "./Vehicle.jsx";
import { useLocation } from "react-router-dom";

const Home = () => {
    const [vehicles, setVehicles] = useState([])
    const location = useLocation()
    const [brand, setBrand] = useState('');
    const userId = location.pathname.split('/')[2]

    let order = {
        idUser: userId,
        idVehicle: 0,
        rentDate: new Date(),
        returnDate: new Date()
    }
    const placeOrder = async() => {
        try {
            order.returnDate.setDate(order.rentDate.getDate() + 7)
            await axios.post("http://localhost:8080/api/orders/add", order)
            alert('order placed')
        }
        catch(err) {
            console.log(err)
        }
    }
    
    const fetchAllCars = async() => {
        try {
            const response = await axios.get('http://localhost:8080/api/vehicles')
            const data = response.data
            setVehicles(data)
        }
        catch(err) {
            console.log(err)
        }
    } 

    const fetchCarsByBrand = async() => {
        try {
            const response = await axios.get(`http://localhost:8080/api/vehicles/brand/${brand}`)
            const data = response.data
            setVehicles(data)
        }
        catch(err) {
            console.log(err)
        }
    }

    return (
        <div>
            <div>
                <h1>Carland</h1>
                <div className="search-container">
                    <input className="search-bar" placeholder="Search.." onChange={(e) => {setBrand(e.target.value)}}></input>
                    <button className="search-button" onClick = {brand ? fetchCarsByBrand : fetchAllCars}>Find</button>
                </div>
                <div>
                    <ul>
                        {vehicles.map(car =>
                            <li key={car.id}><Vehicle car = {car}/></li>
                        )}
                    </ul>
                </div>
                <div className="order-container">
                    <input type="number" className="order-input" placeholder="id" onChange={(e) => { order.idVehicle = e.target.value }}></input>
                    <button className="order-button" onClick={placeOrder}>Order vehicle</button>
                </div>
            </div>
        </div>    
    )
}

export default Home
