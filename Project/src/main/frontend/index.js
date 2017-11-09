import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';
import { BrowserRouter as Router, Route, browserHistory, Switch } from 'react-router-dom';
import promise from 'redux-promise';


import reducers from './reducers';
/* components*/
import Signup from './components/signup_form';
import Question from './components/question';
import NotFound from './components/not_found';
import UserPage from './components/user_page';
import NavBar from './components/navbar';


const createStoreWithMiddleware = applyMiddleware(promise)(createStore);

ReactDOM.render(
  <Provider store={createStoreWithMiddleware(reducers)}>
    <Router history={browserHistory}>
      <Switch>
        <Route path="/question" component={Question} />
        <Route path="/userpage" component={UserPage} />
        <Route path="/" component={Signup} />
        <Route path="*" component={NotFound} />
      </Switch>
    </Router>
  </Provider>
  , document.querySelector('.container'));
