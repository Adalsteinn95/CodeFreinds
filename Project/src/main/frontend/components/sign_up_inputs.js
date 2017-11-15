import React from 'react';
import { Field, reduxForm } from 'redux-form';

let SignuUpInputs = props => {
  const { handleSubmit } = props;
  return (

    <div className = "middle-container">
      <div id="signup" className="form-container fade-in signup">
        <h2 className="subtitle">Sign up to get started!</h2>

        <form id="signup-form" className="form" onSubmit={handleSubmit }>
          <div className="form_input-fields">
              <Field name="name" component="input" className="input form-control" type="text" placeholder="name" />
              <Field name="pass" component="input" className="input form-control" type="password" placeholder="password" />
              <Field name="email" component="input" className="input form-control" type="text" placeholder="email" />
          </div>
            <button id="signupbutton"type="submit" className="btn btn-primary submit-button">All set!</button>
        </form>
      </div>
    </div>
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
