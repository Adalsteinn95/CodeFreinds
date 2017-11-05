import React from 'react';
import { Field, reduxForm} from 'redux-form';

let LoginForm = props => {
  const { handleSubmit } = props
  return (
    <div class="main-content">
      <div id ="signin" class="form-container fade-in login">
        <h2 class="subtitle">Sign in to get started!</h2>

        <form class="form" onSubmit={handleSubmit}>
          <div class="form_input-fields">
            <input  component="input" class="input" type="text" placeholder="email">
            <input  component="input" class="input" type="password" placeholder="password">
          </div>
            <button type="submit" class="submit-button">Ready</button>
          <hr class="hr-line">
        </form>
        <div class="card-footer">
          <a onClick="showSignUp()"id="alreadyAccount" class="sub-subtitle subtitle">Signup here!</a>

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
}

function validate(values){

}


LoginForm = reduxForm({
  validate,
  form: 'loginForm'
})(LoginForm)

export default LoginForm;
