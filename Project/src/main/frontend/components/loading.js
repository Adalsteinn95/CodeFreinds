import React, { Component } from 'react';

class Loading extends Component {

  render() {
    return (
      <div className="lds-css ng-scope">
        <div className="lds-dual-ring">
          <div></div>
        </div>
      </div>
    );
  }

}

export default Loading;
