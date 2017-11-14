import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { connect } from 'react-redux';
import { getUserPage, postLocation } from '../actions';
import Loading from './loading';
import NavBar from './navbar';

class UserPage extends Component {

  constructor(props) {
    super(props);

    this.state = {
      loading: false,

    };

  }


  componentDidMount() {
    this.props.getUserPage();
  }


  handleSubmit(e) {
    e.preventDefault();
    this.setState({
      loading: true,
    });

    postLocation(e.target.location.value);

    this.setState({
      loading: false,
    });

  }

  render() {
    if (!this.props.user.data || this.state.loading) {
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
