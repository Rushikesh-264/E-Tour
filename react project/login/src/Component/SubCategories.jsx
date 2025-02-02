import SubCategoriesCard from "./SubCategoriesCard";
import "../SubCategoriesCard.css"
import { useLocation } from "react-router-dom";
import { useEffect } from "react";
// import CategoriesCard from "./CatergoriesCard";

export default function SubCategories() {
    useEffect(() => {
        window.scrollTo(0, 0);
    }, []);
    const tourPackages = [
        {
            image: "https://images.unsplash.com/photo-1509356843151-3e7d96241e11?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8c3dlZGVufGVufDB8fDB8fHww",
            title: "Switzerland",
            description: "Experience the majestic Swiss Alps, famous for skiing, scenic train journeys, and breathtaking landscapes.",
            price: "₹ 2,500",

        },
        {
            image: "https://plus.unsplash.com/premium_photo-1661919210043-fd847a58522d?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8cGFyaXN8ZW58MHx8MHx8fDA%3D",
            title: "France",
            description: "Explore Paris, the heart of France, known for the Eiffel Tower, world-class museums, and exquisite cuisine.",
            price: "₹ 1,800",

        },
        {
            image: "https://images.unsplash.com/photo-1533604848340-30ce9aeeb0be?w=600&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjB8fHJvbWUlMjB0fGVufDB8fDB8fHww",
            title: "Italy",
            description: "Discover the ancient wonders of Rome, from the Colosseum to the Vatican City, in the heart of Italy and exquisite cuisine.",
            price: "₹ 2,200",

        }
    ];
    const location = useLocation();
    let category = location.state?.title
    category = category.split(" ")[0];
    return (
        <div className="subcategories-tour-container">
            <div className="header">
                <div className="overlay"></div>
                <h1 className="tour-name">{category}</h1>
            </div>
            <div className="subcategories-details  ">
                {tourPackages.map((packageData, index) => (
                    <div key={index} className="w-full sm:w-1/2 md:w-1/3">
                        <SubCategoriesCard {...packageData} />
                    </div>
                ))}
            </div>
        </div>
    );
};

