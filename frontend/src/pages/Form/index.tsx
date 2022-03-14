import axios from 'axios';
import FormCard from 'components/FormCard';
import { useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { BASE_URL } from 'utils/requests';

function Form( ) {

    const params = useParams();

    return (
        <FormCard movieId={`${params.movieId}`}></FormCard>
    );
}

export default Form;