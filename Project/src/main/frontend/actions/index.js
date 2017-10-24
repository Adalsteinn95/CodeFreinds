import axios from 'axios';


export const FETCH_DATA = 'fetch_city';
export const POST_ANSWER = 'post_answer';
export const CREATE_USER = 'create_user';

const ROOT_URL = "http://localhost:8080/api/Question";


export function fetchQuestion(){
  const request = axios.get(`${ROOT_URL}`);


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
