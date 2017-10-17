import { combineReducers } from 'redux';
import QuestionReducer from './reducer_questions';

const rootReducer = combineReducers({
  question: QuestionReducer
});

export default rootReducer;
