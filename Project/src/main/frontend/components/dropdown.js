import React, { Component } from 'react';
import { getUserPage } from '../actions';
import { connect } from 'react-redux';

class DropDown extends Component {
  componentDidMount() {
    this.props.getUserPage();
  }

  render() {
    console.log(this.props.user.data);
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
                <a className="dropdown-item" href="#">Userpage</a>
                <a className="dropdown-item" href="#">Log out</a>
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
