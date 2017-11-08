import React from 'react';
import { Field, reduxForm } from 'redux-form';

let LoginForm = props => {
  const { handleSubmit } = props;
  return (
    <div>
      <div id ="signin" className="form-container fade-in login">
        <h2 className="subtitle">Sign in to get started!</h2>

        <form className="form" onSubmit={handleSubmit}>
          <div className="form_input-fields">
            <Field name="name" component="input" className="input form-control" type="text" placeholder="name" />
            <Field name="pass" component="input" className="input form-control" type="password" placeholder="password" />
          </div>
            <button type="submit" className="submit-button">Ready</button>
        </form>
        <div className="card-footer">
          <a id="notAlreadyAccount" className="sub-subtitle subtitle">Signup here!</a>

        </div>
    </div>
  </div>
  /*
    <div className="form-control">
      <div className="page-login">
        <h1>Log In</h1>
      </div>
      <form onSubmit={ handleSubmit }>
        <div className="form-group">
          <label className="name">Name</label>
          <Field name="name" component="input" type="text" className="form-control" />
        </div>
        <div className="form-group">
          <label className="pass">Password</label>
          <Field name="pass" component="input" type="password" className="form-control" />
        </div>
        <button type="submit" className="btn btn-primary">Submit</button>
      </form>
    </div>
    */
  );
};

function validate(values) {

}


LoginForm = reduxForm({
  validate,
  form: 'loginForm',
})(LoginForm);

export default LoginForm;
