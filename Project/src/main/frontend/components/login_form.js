import React from 'react';
import { Field, reduxForm} from 'redux-form';

let LoginForm = props => {
  const { handleSubmit } = props
  return (
    <div className="form-control">
      <div className="page-login">
        <h1>Log In</h1>
      </div>
      <form onSubmit={ handleSubmit}>
        <div className="form-group">
          <label className="name">Name</label>
          <Field name="username-login" component="input" type="text" className="form-control" />
        </div>
        <div className="form-group">
          <label className="password">Password</label>
          <Field name="password-login" component="input" type="text" className="form-control" />
        </div>
      </form>
    </div>
  );
}

function validate(values){

}


LoginForm = reduxForm({
  validate,
  form: 'loginForm'
})(LoginForm)

export default LoginForm;
