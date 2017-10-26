import React, { Component } from 'react';
import SignuUpInputs from './sign_up_inputs';
import LoginForm from './login_form';
import { Link } from 'react-router-dom';
import { createUser , loginUser} from '../actions';
import { connect } from 'react-redux';

class Signup extends Component {

    submitSignup(values){
      createUser(values);
    }

    submitLogin(values){
      loginUser(values);
    }

    render() {
        return (
          <div className="signup-container">
            <h1 className="title fade-in">Welcom to kewlkvis</h1>
            <LoginForm onSubmit={this.submitLogin}/>
            <SignuUpInputs onSubmit={this.submitSignup}/>
            <Link to={'/question'}> Question </Link>
          </div>
        );
    }

}

export default connect(null, {createUser, loginUser})(Signup);
