import axios from 'axios';


export const FETCH_DATA = 'fetch_city';
export const CREATE_USER = 'create_user';

const ROOT_URL = "http://localhost:8080/api/Question";


export function fetchQuestion(){
  const request = axios.get(`${ROOT_URL}`);

  return {
    type: FETCH_DATA,
    payload: request
  };
}

export function createUser(){
  onst postRequest = axios.post("http://localhost:8080/showuser",{
    "name": "Fred",
    "pass": "1234",
    "email": "lala@hi.is"
  });

  return {
    type: CREATE_USER,
    payload: postRequest
  };
}
