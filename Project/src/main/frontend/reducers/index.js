import { combineReducers } from 'redux';
import QuestionReducer from './reducer_questions';
import { reducer as formReducer } from 'redux-form';
import UserReducer from './reducer_user';

const rootReducer = combineReducers({
  question: QuestionReducer,
  form: formReducer,
  user: UserReducer,
});

export default rootReducer;
