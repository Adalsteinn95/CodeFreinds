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

  constructor(props) {
    super(props);

    this.state = {
      location: false,
    };

    this.handleSubmit = this.handleSubmit.bind(this);
    this.comfirmLocation = this.comfirmLocation.bind(this);
  }

  handleSubmit(e) {
    e.preventDefault();
    this.setState({
      loading: true,
    });

    postLocation(e.target.location.value);
    console.log(postLocation(e.target.location.value).payload);
    this.setState({
      loading: true,
    });
    setTimeout(this.comfirmLocation, 2000);
  }

  comfirmLocation() {
    this.setState({
      location: true,
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
    } else if (!this.state.location) {
      return (
        <div>
          <NavBar />
          <h1 className="title fade-in">Welcome to kewlkvis {this.props.user.data.name}</h1>
          <div>Select a starting loaction</div>
          <form onSubmit={this.handleSubmit}>
            <input name="location" type="text" />
            <button type="submit">Select</button>
          </form>
        </div>
      )
    } else {
      return (
        <div>
          <NavBar />
          <h1 className="title fade-in">Welcome to kewlkvis {this.props.user.data.name}</h1>
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
