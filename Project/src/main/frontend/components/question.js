import React, { Component } from 'react';
import { connect } from 'react-redux';
import Answer from './answer_prop';
import { fetchQuestion } from '../actions';
import { Link } from 'react-router-dom';
import Loading from './loading';
import GoogleMap from './google_map';



class Question extends Component {

  componentWillMount() {
    this.props.fetchQuestion();

  }


  constructor(props){
    super(props);

    this.state = {
      clicked: false,
      loading: false,
      city1: "",
      city2: "",
      location1: {},
      location2: {}
    };

    this.handleClick = this.handleClick.bind(this);
    this.getNewQuestion = this.getNewQuestion.bind(this);

  }

  handleClick(event){
    this.setState({
      clicked: true,
      loading: true,
      city1: this.props.questions.data.city1,
      city2: this.props.questions.data.city2
    });


    setTimeout(this.props.fetchQuestion, 2000);

    this.setState({
      loading: false,
    });
  }


  getNewQuestion(){
    this.setState({
      clicked: false,
      city1: this.props.questions.data.city1,
      city2: this.props.questions.data.city2
    });
  }


  render() {
    const value = this.props.questions.data;

    if(!value || this.state.loading === true){

      return(
        <div>
          <Loading />
        </div>
      );
    }




    var mapContainerStyle = {
      display: "flex",
      flexDirection: "row",
      width: "100%",
      height: "500px"
    };

    var mapItemStyle = {
      display: "flex",
      flexDirection: "column",
      width: "50%",
      margin: "10px",
      textAlign: "center"
    };

    var waitingContainerStyle = {
      width:"100%"
    };





    if(this.state.clicked && this.state.loading === false){

      return (
        <div className="waiting-container">
          <div className = "waiting-container__button">
            <button className="btn btn-primary" onClick={this.getNewQuestion}>Get new question</button>
          </div>
          <div style={mapContainerStyle} className="map-container">
            <div style={mapItemStyle} className="map-item">
              <h1>{this.state.city1}</h1>
              <GoogleMap address={value.city1}/>
            </div>
            <div style={mapItemStyle} className="map-item">
              <h1>{this.state.city2}</h1>
              <GoogleMap address={value.city2}/>
            </div>
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
        </div>
      );

    }
  }


}

function mapStateToProps(state){
  return { questions: state.question}
}

export default connect(mapStateToProps, {fetchQuestion})(Question);
