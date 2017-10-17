import React, { Component } from 'react';
import { Field, reduxForm } from 'redux-form';
import { Link } from 'react-redux';
import { connect } from 'react-redux';
import { createUser } from '../actions';

class SignUp extends Component {
  renderField(field){
    return(
      <div>
        <label>{field.label}</label>
        <input
        type="text"
        {...field.input}
        />
      </div>
    );
  }

  onSubmit(values){
    console.log(values);
  }

  render() {
    const { handleSubmit } = this.props;

    return (
      <form onSubmit={handleSubmit(this.onSubmit.bind(this))}>
        <Field
          label="Username for user"
          name="username"
          type="text"
          Component={this.renderField}
        />
        <Field
          label="Password for User"
          name="password"
          type="password"
          Component={this.renderField}
        />
      </form>
    );
  }
}

function validate(values){
  const errors = {};

  //handle the errors here

  return errors;
}

export default reduxForm({
  validate,
  form: 'Create new User'
})(
  connect(null,{ createUser })(SignUp));
