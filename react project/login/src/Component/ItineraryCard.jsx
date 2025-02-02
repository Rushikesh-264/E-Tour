import { Card,  Row, Col } from "react-bootstrap";
import React from 'react'

const ItineraryCard = ({ day, destination, activities, overnight, image }) => {
    return (
        <Card className="mb-4 shadow-sm">
            <Row className="g-0">
                <Col md={8} className="p-3">
                    <Card.Body>
                        <Card.Title className="text-primary">Day {day}: {destination}</Card.Title>
                        <ul>
                            {activities.map((activity, index) => (
                                <li key={index}>{activity}</li>
                            ))}
                        </ul>
                        <Card.Text className="fw-bold">Overnight: {overnight}</Card.Text>
                    </Card.Body>
                </Col>
                <Col md={4}>
                    <Card.Img variant="top" src={image} alt={destination} className="img-fluid" />
                </Col>
            </Row>
        </Card>
    );
};
export default ItineraryCard;