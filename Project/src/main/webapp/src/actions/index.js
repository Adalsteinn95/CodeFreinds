import axios from 'axios';


export const FETCH_DATA = 'fetch_city';

const ROOT_URL = "http://localhost:8080/api/Question";


export function fetchQuestion(){
  const request = axios.get(`${ROOT_URL}`);

  return {
    type: FETCH_DATA,
    payload: request
  };
}
