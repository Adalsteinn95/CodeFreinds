import axios from 'axios';


export const FETCH_DATA = 'fetch_city';
export const POST_ANSWER = 'post_answer';
export const CREATE_USER = 'create_user';

const ROOT_URL = "https://notendur.hi.is/~aip7/API/tester/test.json";


export function fetchQuestion(){
  //const request = axios.get(`${ROOT_URL}`;
  const request = {
      "currentLoc": "London",
      "currentCountry": "Britain",
      "city1": "Berlin",
      "city2": "Paris",
      "country1": "Germany",
      "country2": "France"
    }

  return {
    type: FETCH_DATA,
    payload: request
  };
}

export function postAnswer(value){
  //const request = axios.get(`${ROOT_URL}`;
  console.log(value);
  /*
  return {
    type: POST_ANSWER,
    payload: request
  };*/
}


export function createUser(){
  const postRequest = axios.post(`${ROOT_URL}/user`);

  return {
    type: CREATE_USER,
    payload: postRequest
  }
}
