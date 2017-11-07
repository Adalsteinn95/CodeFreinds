import React from 'react';
import { Field, reduxForm } from 'redux-form';

let SignuUpInputs = props => {
  const { handleSubmit } = props;
  return (

    <div className = "middle-container">
      <div id="signup" className="form-container fade-in signup">
        <h2 className="subtitle">Sign up to get started!</h2>
        <a id="alreadyAccount"className="sub-subtitle subtitle">Click here if you're kewl and have an account</a>

        <form className="form" onSubmit={handleSubmit }>
          <div className="form_input-fields">
              <Field name="name" component="input" className="input form-control" type="text" placeholder="name" />
              <Field name="pass" component="input" className="input form-control" type="password" placeholder="password" />
              <Field name="email" component="input" className="input form-control" type="text" placeholder="email" />
              <Field name="location" component="input" className="input form-control" type="text" placeholder="location" />
          </div>
          <button type="submit" className="btn btn-primary submit-button">All set!</button>
        </form>
      </div>
    </div>


/*
    <div className="form-control">
      <div className="page-signup">
        <h1>Sign Up</h1>
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
        <div className="form-group">
          <label className="email">Email</label>
          <Field name="email" component="input" type="email" className="form-control" />
        </div>
        <div className="form-group">
          <label className="location">Location</label>
          <Field name="location" component="input" type="text" className="form-control" />
        </div>
        <button type="submit" className="btn btn-primary">Submit</button>
      </form>
    </div>
*/

  );
};

// handle errors
function validate(values) {
  const errors = {};

  return errors;
}


SignuUpInputs = reduxForm({
  validate,
  form: 'contact',
})(SignuUpInputs);

export default SignuUpInputs;
