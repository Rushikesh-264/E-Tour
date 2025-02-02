import React from "react";
import { Card, Button } from "react-bootstrap";
import "../SubCategoriesCard.css";
import { useNavigate } from "react-router-dom";

const TourCategoryCard = ({ image_url, tour_name, duration_days, duration_nights, description, price }) => {
    const navigation = useNavigate();

    const handlenavigation = () => {
        navigation('/iternary', { state: { tour_name ,image_url } })
    }
    return (
        <Card className="package-card">
            <Card.Img variant="top" src={image_url} className="package-image" />
            
            <Card.Body className="package-description">
                <Card.Title className="package-title">{tour_name}</Card.Title>
                <Card.Text className="package-text">
                    <strong>{duration_days} Days / {duration_nights} Nights</strong>
                    <br />
                    <div style={{
                        display: '-webkit-box',
                        WebkitBoxOrient: 'vertical',
                        WebkitLineClamp: 3,  
                        overflow: 'hidden',
                        textOverflow: 'ellipsis',
                    }}>
                        {description}
                    </div>
                </Card.Text>
                <h5  className="package-price">₹{price.toFixed(2)}</h5>
                <Button variant="primary" className="mt-2" onClick={handlenavigation}>View Details</Button>
            </Card.Body>
        </Card>
    );
};

export default TourCategoryCard;
