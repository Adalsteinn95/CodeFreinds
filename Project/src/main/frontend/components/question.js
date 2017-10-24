import React, { Component } from 'react';
import { connect } from 'react-redux';
import Answer from './answer_prop';
import { fetchQuestion } from '../actions';


class Question extends Component {

  componentWillMount() {
    this.props.fetchQuestion();
  }

  render() {
    const value = this.props.questions.data;

    if(!this.props.questions.data){
      return (
        <div>
          loading....
        </div>
      );
    } else {

      return (
        <div>
          <h1 className="title fade-in">kewlkvis</h1>
          <div className = "question-container">
            <h2 className="question-title fade-in">Which city is closer to {value.currentCity}</h2>
            <div className="answer-container">
              <Answer country={value.country1} city={value.city1} />
              <Answer country={value.country2} city={value.city2} />
            </div>
          </div>
        </div>
      );

    }
  }

}

function mapStateToProps(state){
  return { questions: state.question}
}

export default connect(mapStateToProps, {fetchQuestion})(Question);
