import React, { Component } from 'react';
import SignuUpInputs from './sign_up_inputs';
import LoginForm from './login_form';
import { createUser, loginUser, listenForError } from '../actions';
import { connect } from 'react-redux';
import UserPage from './user_page';
import { Link } from 'react-router-dom';
import Loading from './loading';
import NavBar from './navbar';

class Signup extends Component {

  constructor(props) {
    super(props);

    this.state = {
      login: false,
      signup: false,
      loading: false,
      alrdAccount: false,
    };

    this.handleClick = this.handleClick.bind(this);
    this.handleClick2 = this.handleClick2.bind(this);
  }
  handleClick(event){
    this.setState({
      alrdAccount: true,
    });
  }

  handleClick2(event){
    this.setState({
      alrdAccount: false,
    });
  }


  submitSignup = (values) => {
    this.setState({
      loading: true,
    });

    createUser(values).payload
      .then((result) => {
        let error = listenForError().payload
          .then((result) => {
            console.log(result);
            if (!result.data) {
              this.setState({
                login: true,
                loading: false,
                error: result.data,
              });
            } else {
              this.setState({
                login: false,
                loading: false,
                error: result.data,
              });
            }
          })
          .catch((error) => {
            this.setState({
              login: false,
              loading: false,
            });
          });
      })
      .catch((error) => {
        this.setState({
          login: false,
          loading: false,
        });
      });


  }

  submitLogin = (values) => {
    this.setState({
      loading: true,
    });

    loginUser(values).payload
      .then((result) => {
        let error = listenForError().payload
        .then((result) => {
          if (!result.data) {
            this.setState({
              login: true,
              loading: false,
              error: result.data,
            });
          } else {
            this.setState({
              login: false,
              loading: false,
              error: result.data,
            });
          }
        })
        .catch((error) => {
          console.log(error);
        })
      })
      .catch((error) => {
        this.setState({
          login: false,
          loading: false,
        });
      });
  }

  render() {
    var divStyle = {
      textAlign: 'center',
      cursor: 'pointer',
    };

    var fontStyle = {
      background: 'linear-gradient(to right, #FFEB3B, #ede96c)',
      fontSize: '3em',
      fontFamily: 'Lobster, cursive',
      margin: '0 auto',
      backgroundClip: 'text',

    };

    if (this.state.loading) {
      return (
            <div>
              <Loading />
            </div>
          );
    }
    if (this.state.login) {
      return (
            <div>
              <UserPage />
            </div>
          );
    }

    if (this.state.alrdAccount){
      return(
        <div>
          <NavBar />
          <div className="signup-container">
            <h1 className="title fade-in">Welcome to kewlkvis</h1>
            <div className="error-container fade-in">
              <h3 className="error-item">{this.state.error}</h3>
            </div>
            <LoginForm onSubmit={this.submitLogin} />
            <div onClick={this.handleClick2} style={divStyle}>
              <a style={fontStyle} className="subtitle">Click here if you need an account!</a>
            </div>
          </div>
        </div>
      );
    }
    else {
      return (
            <div>
              <NavBar />
              <div className="signup-container">
                <h1 className="title fade-in">Welcome to kewlkvis</h1>
                <div className="error-container fade-in">
                  <h3 className="error-item">{this.state.error}</h3>
                </div>
                <SignuUpInputs onSubmit={this.submitSignup} />
                <div onClick={this.handleClick} style={divStyle}>
                  <a style={fontStyle} className="subtitle">Click here if you already have an account!</a>
                </div>
              </div>
            </div>
          );
    }
  }

}

function mapStateToProps(state) {
  return { user: state.user };
}

export default connect(mapStateToProps, { createUser })(Signup);
