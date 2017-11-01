import React, { Component } from 'react';
import { connect } from 'react-redux';
import Answer from './answer_prop';
import { fetchQuestion } from '../actions';
import { Link } from 'react-router-dom';

class Question extends Component {

  componentWillMount() {
    this.props.fetchQuestion();

  }

  constructor(props){
    super(props);

    this.state = {
      clicked: false
    };

    this.handleClick = this.handleClick.bind(this);

    this.getNewQuestion = this.getNewQuestion.bind(this);

  }

  handleClick(event){
    this.setState({
      clicked: true
    });
    setTimeout(this.props.fetchQuestion, 2000);
  }


  getNewQuestion(){
    this.setState({
      clicked: false
    });
  }


  render() {
    const value = this.props.questions.data;


    if(!this.props.questions.data){
      return(
        <div className="waiting-container__header">
          <h1>
            loading....
          </h1>
        </div>
      );
    }


    if(this.state.clicked){
      return (
        <div className="waiting-container">
          <div className = "waiting-container__button">
            <button className="btn btn-primary" onClick={this.getNewQuestion}>Get new question</button>
          </div>
        </div>
      );
    } else {

      return (
        <div>
          <h1 className="title fade-in">kewlkvis</h1>
          <div className = "question-container">
            <h2 className="question-title fade-in">Which city is closer to {value.currentCity}</h2>
            <div onClick={this.handleClick} className="answer-container">
              <Answer country={value.country1} city={value.city1} />
              <Answer onClick={this.handleClick} country={value.country2} city={value.city2} />
            </div>
          </div>
          <div className = "userpage">
            <Link className="question-title fade-in" to={`/userpage`} >Userpage</Link>
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
