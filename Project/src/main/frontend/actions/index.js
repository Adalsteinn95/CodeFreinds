import axios from 'axios';


export const FETCH_DATA = 'fetch_city';
export const POST_ANSWER = 'post_answer';
export const CREATE_USER = 'create_user';
export const LOGIN_USER = 'login_user';

const ROOT_URL = "http://localhost:8080/api/Question";


export function fetchQuestion(){
  const request = axios.get(`${ROOT_URL}`);


  return {
    type: FETCH_DATA,
    payload: request
  };
}

export function postAnswer(value){

  const feedback = {
    answer: value
  };

  const postrequest = axios.post("http://localhost:8080/api/answer/Question",feedback);

  return {
    type: POST_ANSWER,
    payload: postrequest
  };
}


export function createUser(value){
  const postRequest = axios.post("http://localhost:8080/API/signup",value);


  return {
    type: CREATE_USER,
    payload: postRequest
  }
}

export function loginUser(value){
  const postRequest = axios.post("http://localhost:8080/API/login",value);

  return {
    type: LOGIN_USER,
    payload: postRequest
  }


}
