import React, { Component } from 'react';
import { getUserPage } from '../actions';
import { connect } from 'react-redux';
import { Link } from 'react-router-dom';
import DropDown from './dropdown';

class NavBar extends Component {
  handleClick() {
    e.preventDefault();
    window.location.replace('../');
  }

  render() {
    return (
      <div>
        <nav className="nav-container">
          <Link to="/" onClick={this.handleClick.bind(this)} className="kewl-subtitle title">kewlkvis</Link>
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
