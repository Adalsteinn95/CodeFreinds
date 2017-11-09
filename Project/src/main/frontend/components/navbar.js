import React, { Component } from 'react';
// import MainPage from './main_page'

class NavBar extends Component {

  render() {
    return (
      <div>
        <nav className="nav-container">
          <a href="#" className="kewl-subtitle title">kewlkvis</a>
          <div className="nav-right-side">
            <div className="dropbtn">
              <img src="https://www.hi.is/sites/default/files/styles/simaskra_stor/public/staffmyndir/sn-snorri_agnarsson1398308014_90x120.jpg" alt="userpic" className="userpic" />
              <span className="username">Snorri Agnarson</span>
              <div className="dropdown-content">
                <a className="dropdown-item" href="#">Userpage</a>
                <a className="dropdown-item" href="#">Log out</a>
              </div>
            </div>
          </div>
        </nav>
      </div>

    );
  }

}

export default NavBar;
