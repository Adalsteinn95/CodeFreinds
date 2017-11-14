import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { connect } from 'react-redux';
import { getUserPage, postLocation } from '../actions';
import Loading from './loading';
import NavBar from './navbar';

class UserPage extends Component {


  componentDidMount() {
    this.props.getUserPage();
  }


  handleSubmit(e) {
    e.preventDefault();
    console.log(e.target.location.value);
    postLocation(e.target.location.value);
    console.log(postLocation(e.target.location.value).payload);
  }

  render() {
    if (!this.props.user.data) {
      return (
        <div>
          <Loading />
        </div>
      );
    } else {
      return (
        <div>
          <NavBar />
          <h1 className="title fade-in">Welcome to kewlkvis {this.props.user.data.name}</h1>
          <div>Select a starting loaction</div>
          <form onSubmit={this.handleSubmit.bind(this)}>
            <input name="location" type="text" />
            <button type="submit">Select</button>
          </form>
          <Link className="question-title fade-in" to={'/question'} >Click me to get to the fun</Link>
        </div>
      );
    }
  }

}

function mapStateToProps(state) {
  return { user: state.user };
}

export default connect(mapStateToProps, { getUserPage })(UserPage);
