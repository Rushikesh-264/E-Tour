import React, { useEffect, useState } from "react";
import { Row, Col } from "react-bootstrap";
import CategoriesCard from "./CatergoriesCard";
import SearchBar from "./SearchBar";
// import CategoriesCard from "./CategoriesCard";



export default function Categories() {
    const [categories, setCategories] = useState([]);
    
    useEffect(() => {
        fetch("http://localhost:8086/api") 
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok");
                }
                return response.json();
            })
            .then(data => setCategories(data))
            .catch(error => console.error("Error fetching categories:", error));
    }, []);
    console.log(categories)
    return (
        <>
            <div
                style={{
                    backgroundImage: `
            linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), 
            url("https://images.unsplash.com/photo-1531572753322-ad063cecc140?q=80&w=1776&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
        `,
                    backgroundSize: "cover",
                    backgroundPosition: "center",
                    backgroundRepeat: "no-repeat",
                    height: "auto",
                    padding: "2rem",
                    paddingInline: '8vw'
                }}
            >
                <SearchBar /> 
                <h1
                    style={{
                        marginLeft: "1rem",
                        paddingBottom: "1.5rem",
                        color: "#ffffff",
                        textShadow: "2px 2px 4px rgba(0, 0, 0, 0.8)",
                    }}
                >
                    Categories
                </h1>

                <Row className="g-4">
                    {categories.map((data, index) => (
                        <Col key={index} md={4} className="mb-4">
                            <CategoriesCard
                                title={data.category_Name}
                                text={data.text}
                                imageUrl={ data.category_Image_Path}
                                id={data.catMasterid}
                                buttonLabel={"Explore"}
                            />
                        </Col>
                    ))}
                </Row>
            </div>
        </>
    );
}
