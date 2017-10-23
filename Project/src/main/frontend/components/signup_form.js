import React, { Component } from 'react';
import SignuUpInputs from './sign_up_inputs';
import LoginForm from './login_form';
import { Link } from 'react-router-dom';

class Signup extends Component {

    submitSignup = (values) => {
      console.log(values);
    }

    submitLogin = (values) => {
      console.log(values);
    }

    render() {
        return (
          <div className="signup-container">
            <LoginForm onSubmit={this.submitLogin}/>
            <SignuUpInputs onSubmit={this.submitSignup}/>
            <Link to={'/question'}> Question </Link>
          </div>
        );
    }

}

export default Signup;
