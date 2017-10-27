import React, { Component } from 'react';
import SignuUpInputs from './sign_up_inputs';
import LoginForm from './login_form';
import { createUser , loginUser} from '../actions';
import { connect } from 'react-redux';
import UserPage from './user_page';
import { Link } from 'react-router-dom';

class Signup extends Component {

    constructor(props){
      super(props);

      this.state = {
        login: false,
        signup: false,
        user: {
          name: null,
          email: null,
          location: null,
          score: null,
        },
        loading: false,
      };
    }


    submitSignup = (values) => {
      createUser(values);

      this.setState({
        signup: true
      });
    }

    submitLogin = (values) => {
      this.setState({
        loading: true,
      });

      loginUser(values).payload
      . then((result) => {
            this.setState({
              login: true,
              name: result.data.name,
              email: result.data.email,
              location: result.data.location,
              score: result.data.score,
              loading: false,
            })

        })
        .catch((error) => {
            this.setState({
                login: false,
                loading: false,
            })

        });

    }

    render() {
        if(this.state.loading){
          return(
            <div>
              LOADING PLEASE WAIT.....
            </div>
          );
        }
        if(this.state.login){
          return(
            <div>
              <UserPage name={this.state.name} email={this.state.email}/>
            </div>
          );
        }
        else {
          return (
            <div className="signup-container">
              <h1 className="title fade-in">Welcom to kewlkvis</h1>
              <LoginForm onSubmit={this.submitLogin}/>
              <SignuUpInputs onSubmit={this.submitSignup}/>
            </div>
          );
        }

    }

}

function mapStateToProps(state){
  return { user: state.user}
}

export default connect(mapStateToProps, {createUser, loginUser})(Signup);
