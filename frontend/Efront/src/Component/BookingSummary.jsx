import React, { useEffect, useState } from "react";
import { Container, Card, Table, Row, Col, Button } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import { useLocation, useNavigate } from "react-router-dom";

const BookingSummary = () => {
    const [passengers, setPassengers] = useState([]);
    const [profileDetails, setProfileDetails] = useState({});
    const [totalPrice, setTotalPrice] = useState(0);

    useEffect(() => {
        const storedPassengers = JSON.parse(localStorage.getItem("passengers")) || [];
        
        
        const storedTotalPrice = localStorage.getItem("totalPrice") || 0;

        setPassengers(storedPassengers);
        
        setTotalPrice(parseFloat(storedTotalPrice));
    }, []);
    const location = useLocation();
    const {  durationDays, durationNights, endDate, startDate, tourName,  } = location.state || {}
    const navigate = useNavigate()
    const confirmbooking= ()=>{
      navigate('/payment')
    }

    return (
        <Container className="mt-4 p-4 border rounded bg-light">
            <h2 className="text-center mb-4">Booking Summary</h2>

            {/* Tour Details */}
            <Card className="mb-4 p-3 shadow-sm">
                <Card.Body>
                    <Card.Title className="text-primary">{tourName}</Card.Title>
                    <Card.Text>
                        {durationDays} &  {durationNights} |
                        Start Date: {startDate} - End Date: {endDate}
                    </Card.Text>
                </Card.Body>
            </Card>

            {/* Profile Details */}
            <Card className="mb-4 p-3 shadow-sm">
                <Card.Body>
                    <Card.Title>Profile Details</Card.Title>
                    <Row>
                        <Col md={6}><strong>Name:</strong> {profileDetails.name}</Col>
                        <Col md={6}><strong>Mobile:</strong> {profileDetails.mobile}</Col>
                    </Row>
                    <Row className="mt-2">
                        <Col md={6}><strong>Email:</strong> {profileDetails.email}</Col>
                    </Row>
                </Card.Body>
            </Card>

            {/* Passenger Details Table */}
            <Card className="mb-4 p-3 shadow-sm">
                <Card.Body>
                    <Card.Title>Passengers</Card.Title>
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Name</th>
                                <th>DOB</th>
                                <th>Mobile</th>
                                <th>Email</th>
                                <th>Passenger Type</th>
                                <th>Price (₹)</th>
                            </tr>
                        </thead>
                        <tbody>
                            {passengers.length > 0 ? (
                                passengers.map((passenger, index) => (
                                    <tr key={index}>
                                        <td>{index + 1}</td>
                                        <td>{passenger.firstName} {passenger.lastName}</td>
                                        <td>{passenger.dob}</td>
                                        <td>{passenger.mobile}</td>
                                        <td>{passenger.email}</td>
                                        <td>{passenger.passengerType}</td>
                                        <td>₹{passenger.price}</td>
                                    </tr>
                                ))
                            ) : (
                                <tr>
                                    <td colSpan="7" className="text-center">No passengers added.</td>
                                </tr>
                            )}
                        </tbody>
                    </Table>
                </Card.Body>
            </Card>

            {/* Total Price */}
            <Card className="p-3 shadow-sm text-center">
                <h4>Total Price: ₹{totalPrice.toFixed(2)}</h4>
            </Card>
            <Button type='primary' onClick={confirmbooking}  className="my-3" >Confirm booking</Button>

        </Container>
    );
};

export default BookingSummary;
