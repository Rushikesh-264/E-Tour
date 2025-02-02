import React, { useEffect } from 'react'
import { useLocation } from 'react-router-dom';
import '../SubCategoriesCard.css'
import ItineraryCard from './ItineraryCard';
import { Button, Container } from 'react-bootstrap';

export default function Iternary() {
    const location = useLocation();
    let category = location.state?.tour_name || "Tour Packages";
    let imageurl = location.state?.image_url || "Image";
    useEffect(() => {
        window.scrollTo(0, 0);
    }, []);

    const itineraryData = [{
        "itinerary": [
            {
                "day": 1,
                "destination": "Zurich → Lucerne",
                "activities": [
                    "Arrive in Zurich, take a train to Lucerne (~1 hour)",
                    "Explore Chapel Bridge, Old Town, and the Lion Monument",
                    "Take a boat ride on Lake Lucerne"
                ],
                "overnight": "Lucerne",
            
            },
            {
                "day": 2,
                "destination": "Mount Titlis or Pilatus",
                "activities": [
                    "Take a day trip to Mt. Titlis (cable car, Ice Flyer, snow activities) or Mt. Pilatus (cogwheel railway)",
                    "Return to Lucerne for the evening"
                ],
                "overnight": "Lucerne"
            },
            {
                "day": 3,
                "destination": "Lucerne → Interlaken → Jungfraujoch",
                "activities": [
                    "Take a scenic train to Interlaken (~2 hours)",
                    "Travel to Jungfraujoch (Top of Europe) via Grindelwald or Lauterbrunnen",
                    "Explore Ice Palace, Sphinx Observatory, and Alpine views"
                ],
                "overnight": "Interlaken"
            },
            {
                "day": 4,
                "destination": "Lauterbrunnen & Mürren",
                "activities": [
                    "Visit Lauterbrunnen Valley (Staubbach & Trümmelbach Falls)",
                    "Take a cable car to Mürren & Schilthorn (007 Bond Experience)",
                    "Enjoy breathtaking views and scenic hikes"
                ],
                "overnight": "Interlaken"
            },
            {
                "day": 5,
                "destination": "Zermatt & Matterhorn (or Return to Zurich)",
                "activities": [
                    "Option 1: Take a train to Zermatt (~2.5 hours), visit Gornergrat for Matterhorn views, explore car-free Zermatt",
                    "Option 2: Return to Zurich, explore the city (Bahnhofstrasse, Old Town, Rhine Falls)",
                    "Fly back home"
                ],
                "overnight": "Zurich or departure"
            }
        ]
    }]
    return (
        <div className="subcategories-tour-container">
            <div className="header" style={{ backgroundImage: `url(${imageurl})` }}>
                <div className="overlay"></div>
                <h1 className="tour-name">{category}</h1>
            </div>
            <Container className="py-5">
            {itineraryData[0]?.itinerary?.map((item) => (
    <ItineraryCard key={item.day} {...item} />
))}

            </Container>
            

        </div>
    )
}