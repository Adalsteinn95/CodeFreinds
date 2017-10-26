import React from 'react';
import { Field, reduxForm} from 'redux-form';

let LoginForm = props => {
  const { handleSubmit } = props
  return (
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
  );
}

function validate(values){

}


LoginForm = reduxForm({
  validate,
  form: 'loginForm'
})(LoginForm)

export default LoginForm;
