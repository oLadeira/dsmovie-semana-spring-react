import axios from "axios";
import MovieCard from "components/MovieCard";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { MoviePage } from "types/movie";
import { BASE_URL } from "utils/requests";

function Listing() {

    const [pageNumber, setPageNumber] = useState(0);

    useEffect(() => {
        axios.get(`${BASE_URL}/movies/?page=1&size=30&sort=id,ASC`)
        .then(response => {
    
            //fazendo um casting do data da response para o tipo MoviePage
            const data = response.data as MoviePage;
            setPageNumber(data.number);
        })
    }, []);
 

    return (
        <>
            <p>{pageNumber}</p>
            <Pagination></Pagination>

            <div className="container">
                <div className="row">
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard></MovieCard> 
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard></MovieCard> 
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard></MovieCard> 
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard></MovieCard> 
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard></MovieCard> 
                    </div>

                </div>
            </div>                     
        </>
    );
}

export default Listing;