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
    var divAlign = {
      textAlign: 'center',
      marginTop: '25vh',
    };
    var linkSize = {
      fontSize: '8rem',
    };
    var inputStyle = {
      width: '100%',
    };

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
          <div className="form-container fade-in signup">
            <h2 className="location-subtitle subtitle">Select a kewl starting location {this.props.user.data.name}!</h2>
            <form className="form" onSubmit={this.handleSubmit}>
              <input style={inputStyle} className="input form-control" name="location" type="text" />
              <button className="btn btn-primary submit-button" type="submit">Select</button>
            </form>
          </div>
        </div>
      );
    } else {
      return (
        <div>
          <NavBar />
          <div style={divAlign}>
            <Link style={linkSize}className="question-title fade-in answer" to={'/question'} >Let's get started!</Link>
          </div>
        </div>
      );
    }
  }

}

function mapStateToProps(state) {
  return { user: state.user };
}

export default connect(mapStateToProps, { getUserPage })(UserPage);
