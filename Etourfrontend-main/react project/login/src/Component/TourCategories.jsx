import React from "react";
import "../SubCategoriesCard.css"

import { Container, Row, Col } from "react-bootstrap";

import TourCategoryCard from "./TourCategorieCard";
import { useLocation } from "react-router-dom";

export default function TourCategories() {
    const location = useLocation();
    let category = location.state?.title || "Tour Packages";
    let imageurl = location.state?.image || "Image";

    const tour = [
        {
            tour_name: "Scenic Switzerland Escape",
            duration_days: "7",
            duration_nights: "6",
            image_url:  "https://images.unsplash.com/photo-1477271706509-fecda7438b68?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8U2NlbmljJTIwU3dpdHplcmxhbmQlMjBFc2NhcGV8ZW58MHx8MHx8fDA%3D",
            price: 2499.99,
            description:
                "Experience the breathtaking beauty of Switzerland, from the snow-capped Alps to the serene lakes. Visit Zurich, Lucerne, Interlaken, and Geneva, enjoying scenic train rides and Swiss chocolates.",
        },
        {
            tour_name: "Italy Grand Tour",
            duration_days: "10",
            duration_nights: "9",
            image_url:  "https://images.unsplash.com/photo-1509356843151-3e7d96241e11?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8c3dlZGVufGVufDB8fDB8fHww",
            price: 3299.99,
            description:
                "Explore Italy’s rich history and culture, from Rome's Colosseum to Venice’s canals. Visit Florence, Milan, and the Amalfi Coast, savoring authentic Italian cuisine along the way.",
        },
        {
            tour_name: "Romantic France Getaway",
            duration_days: "8",
            duration_nights: "7",
            image_url:  "https://images.unsplash.com/photo-1516472680426-3eeaf52d8005?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTIyfHxSb21hbnRpYyUyMEZyYW5jZSUyMEdldGF3YXl8ZW58MHx8MHx8fDA%3D",
            price: 2899.99,
            description:
                "Discover France’s most enchanting destinations, including Paris, the French Riviera, and Bordeaux. Visit iconic landmarks like the Eiffel Tower and enjoy fine wine and gourmet food.",
        },
    ];

    return (
        
            <div className="subcategories-tour-container">
            <div className="header" style={{ backgroundImage: `url(${imageurl})` }}>
                <div className="overlay"></div>
                <h1 className="tour-name">{category}</h1>
            </div>
            <div className="subcategories-details  ">
                            {tour.map((tourData, index) => (
                                <div key={index} xs={12} sm={6} md={4} className="mb-4">
                                    <TourCategoryCard {...tourData}/>
                                </div>
                            ))}
            </div>

            
            {/* <Container className="mt-5">
                <Row>
                    {tour.map((tourData, index) => (
                        <Col key={index} xs={12} sm={6} md={4} className="mb-4">
                            
                            <TourCategoryCard {...tourData}/>
                        </Col>
                    ))}
                </Row>
            </Container> */}
        </div>
    );
}
