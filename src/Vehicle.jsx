import React from "react";

const Vehicle = ({car}) => {
    return (
        <div className="vehicle-card" key={car.id}>
            <h3 className="vehicle-title">Vehicle Details</h3>
            <div className="vehicle-info">
                <p><strong>ID:</strong> <span className="vehicle-id">{car.id}</span></p>
                <p><strong>Brand:</strong> <span className="vehicle-brand">{car.brand}</span></p>
                <p><strong>Model:</strong> <span className="vehicle-model">{car.model}</span></p>
                <p><strong>Class:</strong> <span className="vehicle-class">{car.claSS}</span></p>
                <p><strong>Top Speed:</strong> <span className="vehicle-top-speed">{car.topSpeed} MPH</span></p>
                <p><strong>Price:</strong> <span className="vehicle-price">${car.price}</span></p>
            </div>
        </div>
    )
}

export default Vehicle;