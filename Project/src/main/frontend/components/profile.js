import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { connect } from 'react-redux';
import { getUserPage } from '../actions';
import Loading from './loading';
import NavBar from './navbar';

class Profile extends Component {
  componentDidMount() {
    this.props.getUserPage();
  }

  render() {
    var divStyle = {
        textAlign: 'center',
    };
    if (!this.props.user.data) {
      return (
        <div>
          <Loading />
        </div>
      );
    } else {
      return (
        <div style={divStyle}>
          <NavBar />
          <h1 className="title">Hello {this.props.user.data.name}</h1>
          <div className="question-title fade-in">Your highscore is: {this.props.user.data.score}</div>
          <Link className="question-title fade-in" to={'/question'} >Click me to get to the fun</Link>
        </div>
      );
    }
  }

}

function mapStateToProps(state) {
  return { user: state.user };
}

export default connect(mapStateToProps, { getUserPage })(Profile);
