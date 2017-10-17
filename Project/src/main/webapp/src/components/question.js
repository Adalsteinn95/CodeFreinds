import React, { Component } from 'react';
import { connect } from 'react-redux';
import { fetchQuestion } from '../actions';

class Question extends Component {
  componentDidMount(){
    this.props.fetchQuestion();
  }

  renderQuestion(){
    console.log(this.props.questions);
  }

  render() {
    return (
      <div>
        Þetta verður spurningar
        {this.renderQuestion()}
      </div>
    );
  }

}

function mapStateToProps(state){
  return { questions: state.question}
}

export default connect(mapStateToProps, {fetchQuestion})(Question);
