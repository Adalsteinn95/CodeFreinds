import React from 'react'
import { Field, reduxForm} from 'redux-form'

let SignuUpInputs = props => {
  const { handleSubmit } = props
  return (
    <div className="form-control">
      <div className="page-signup">
        <h1>Sign Up</h1>
      </div>
      <form onSubmit={ handleSubmit }>
        <div className="form-group">
          <label className="name">Name</label>
          <Field name="username" component="input" type="text" className="form-control" />
        </div>
        <div className="form-group">
          <label className="password">Password</label>
          <Field name="password" component="input" type="password" className="form-control" />
        </div>
        <div className="form-group">
          <label className="email">Email</label>
          <Field name="email" component="input" type="email" className="form-control" />
        </div>
        <div className="form-group">
          <label className="email">Location</label>
          <Field name="location" component="input" type="text" className="form-control" />
        </div>
      </form>
      <button type="submit" className="btn btn-primary">Submit</button>
    </div>
  );
}

//handle errors
function validate(values){
  const errors = {};

  return errors;
}


SignuUpInputs = reduxForm({
  validate,
  form: 'contact'
})(SignuUpInputs)

export default SignuUpInputs;
