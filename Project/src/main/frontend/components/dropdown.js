import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { getUserPage } from '../actions';
import { connect } from 'react-redux';
import { logoutUser } from '../actions';

class DropDown extends Component {

  handleLogout() {
    logoutUser(this.props.user.data).payload
      .then((result) => {
        this.setState({
          login: false,
          loading: true,
        });
      })
        .catch((error) => {
          this.setState({
            login: true,
            loading: false,
          });
        });
  }

  componentDidMount() {
    this.props.getUserPage();
  }

  render() {
    if (this.props.user.data == null) {
      return (
        <div></div>
      );
    }
    else if (this.props.user.data.loginStatus) {
      return (
          <div>
            <div className="dropbtn">
              <img src="https://www.hi.is/sites/default/files/styles/simaskra_stor/public/staffmyndir/sn-snorri_agnarsson1398308014_90x120.jpg" alt="userpic" className="userpic" />
              <span className="username">{this.props.user.data.name}</span>
              <div className="dropdown-content">
                <Link className="dropdown-item" to="/profile">Profile</Link>
                <form onSubmit = {this.handleLogout.bind(this)}>
                  <button type="submit" className="dropdown-item logout-button">Log out</button>
                </form>
              </div>
            </div>
          </div>
      );
    }
    else {
      return (
        <div></div>
      );
    }
  }

}
function mapStateToProps(state) {
  return { user: state.user };
}


export default connect(mapStateToProps, { getUserPage })(DropDown);
