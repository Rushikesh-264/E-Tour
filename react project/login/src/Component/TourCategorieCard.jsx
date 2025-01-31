import React from "react";
import { Card, Button } from "react-bootstrap";
import "../SubCategoriesCard.css";

const TourCategoryCard = ({ image_url, tour_name, duration_days, duration_nights, description, price }) => {
    return (
        <Card className="package-card">
            <Card.Img variant="top" src={image_url} className="package-image" />
            {/* <Card.Img variant="top" src={image_url} alt={tour_name} style={{ height: "200px", objectFit: "cover" }} /> */}
            {/* <Card.Body style={{ height: "16rem", overflow: "hidden" }}> */}
            <Card.Body className="package-description">
                <Card.Title className="package-title">{tour_name}</Card.Title>
                <Card.Text className="package-text">
                    <strong>{duration_days} Days / {duration_nights} Nights</strong>
                    <br />
                    <div style={{
                        display: '-webkit-box',
                        WebkitBoxOrient: 'vertical',
                        WebkitLineClamp: 3,  // Limits to 3 lines
                        overflow: 'hidden',
                        textOverflow: 'ellipsis',
                    }}>
                        {description}
                    </div>
                </Card.Text>
                <h5  className="package-price">₹{price.toFixed(2)}</h5>
                <Button variant="primary" className="mt-2">View Details</Button>
            </Card.Body>
        </Card>
    );
};

export default TourCategoryCard;
