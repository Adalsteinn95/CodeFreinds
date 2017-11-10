import React, { Component } from 'react';
import { getUserPage } from '../actions';
import { connect } from 'react-redux';
import DropDown from './dropdown';

class NavBar extends Component {

  render() {
    return (
      <div>
        <nav className="nav-container">
          <a href="#" className="kewl-subtitle title">kewlkvis</a>
          <div className="nav-right-side">
            <DropDown />
          </div>
        </nav>
      </div>

      );
  }


}
function mapStateToProps(state) {
  return { user: state.user };
}

export default connect(mapStateToProps, { getUserPage })(NavBar);
