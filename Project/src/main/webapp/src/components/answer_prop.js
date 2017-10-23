import React, { Component } from 'react';
import { connect } from 'react-redux';
import { postAnswer } from '../actions';

class Answer extends Component {
  constructor(props){
    super(props);
    this.state = { currentAnswer: ''};

    this.handleClick = this.handleClick.bind(this);

  }

  handleClick(event){
    const value = event.target.innerHTML;
    postAnswer(value);
  }


  render() {

    const value = this.props.city;
    return (
      <div className="answer-container">
        <span className= "answer-container_item" onClick={this.handleClick}>
          {this.props.country},
          {this.props.city}
        </span>
      </div>
    );
  }

}

export default connect(null, {postAnswer})(Answer);
