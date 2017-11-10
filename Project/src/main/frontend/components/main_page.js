import React, { Component } from 'react';
import Question from './question';
import NavBar from './navbar';

class MainPage extends Component {

  render() {
    return (
      <div className="main-container">
        <Question />
      </div>
    );
  }

}

export default MainPage;
