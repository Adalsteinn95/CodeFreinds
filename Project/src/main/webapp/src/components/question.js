import React, { Component } from 'react';
import { connect } from 'react-redux';
import Answer from './answer_prop';
import { fetchQuestion } from '../actions';


class Question extends Component {

  componentWillMount() {
    this.props.fetchQuestion();
  }



  render() {
    const value = this.props.questions;

    return (
      <div className="question-container">
        <Answer country={value.currentCountry} city={value.currentLoc} />
        <Answer country={value.country1} city={value.city1} />
        <Answer country={value.country2} city={value.city2} />
      </div>
    );
  }

}

function mapStateToProps(state){
  return { questions: state.question}
}

export default connect(mapStateToProps, {fetchQuestion})(Question);
