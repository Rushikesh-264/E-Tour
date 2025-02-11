import React, { useEffect, useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import '../SubCategoriesCard.css';
import ItineraryCard from './ItineraryCard';
import { Container, Button } from 'react-bootstrap';

export default function Iternary() {
    const location = useLocation();
    const navigate = useNavigate();

    // const { tourName, imageurl, tourId,subcategoryMaster,price,durationDays,durationNights,endDate,startDate  }= location.state ||{};
    const { 
        tourName, 
        imageUrl, 
        price, 
        durationDays, 
        durationNights, 
        endDate, 
        startDate, 
        tourId, subcategoryMaster
    } = location.state || {};
    
    const handleBookNow = () => {
        navigate('/booking', { state: {  tourName,  imageUrl,price,durationDays,durationNights,endDate,startDate,tourId,subcategoryMaster } });
    };
    
    
    useEffect(() => {
        window.scrollTo(0, 0);
    }, []);
    const [itineraryData, setitineraryData] = useState([]);
        // console.log(tourId)
        
        useEffect(() => {
            if (tourId
            ) {
                fetch(`http://localhost:8086/api/subcategory/${subcategoryMaster}/tours/${tourId}/itenary`)
                    .then(response => response.json())
                    .then(data => setitineraryData(data))
                    .catch(error => console.error("Error fetching subcategories:", error));
            }
        }, [tourId]);
        // console.log(itineraryData)

    return (
        <div className="subcategories-tour-container">
            <div className="header" style={{ backgroundImage: `url(${imageUrl})` }}>
                <div className="overlay"></div>
                <h1 className="tour-name">{tourName}</h1>
            </div>
            <Container className="py-5">
            {itineraryData.length > 0 ? (
                    itineraryData.map((item, index) => (
                        <ItineraryCard key={index} {...item} />
                    ))
                ) : (
                    <p>No itinerary available.</p>
                )}

                <Button className="mt-4 w-100" onClick={handleBookNow}>
                    Book Now
                </Button>
            </Container>
        </div>
    );
}
