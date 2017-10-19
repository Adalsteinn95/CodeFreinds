import React, { Component } from 'react';
import { connect } from 'react-redux';
import { fetchQuestion } from '../actions';


class Question extends Component {
  componentDidMount(){
      this.props.fetchQuestion();
  }


  constructor(props){
    super(props);

    this.state = { term: ''};


    this.onSubmit_answer1 = this.onSubmit_answer1.bind(this);
    this.onSubmit_answer2 = this.onSubmit_answer2.bind(this);
    this.onSubmit_answer3 = this.onSubmit_answer3.bind(this);

  }

  onSubmit_answer1(event){

    this.setState({term: ''});
  }

  onSubmit_answer2(event){

    this.setState({term: ''});
  }

  onSubmit_answer3(event){

    this.setState({term: ''});
  }



  render() {
    const object = this.props.questions;

    return (
      <div>
        <form onSubmit={this.onSubmit_answer1}>
          <input
            placeholder="Get a five day forecast in your favorie cities"
            value={object.city1}
            type="submit"
          />
        </form>
        <form onSubmit={this.onSubmit_answer2}>
          <input
            placeholder="Get a five day forecast in your favorie cities"
            value={object.city2}
            type="submit"
          />
        </form>
        <form onSubmit={this.onSubmit_answer3}>
          <input
            placeholder="Get a five day forecast in your favorie cities"
            value={object.currentLoc}
            type="submit"
          />
        </form>
      </div>
    );
  }

}

function mapStateToProps(state){
  return { questions: state.question}
}

export default connect(mapStateToProps, {fetchQuestion})(Question);
