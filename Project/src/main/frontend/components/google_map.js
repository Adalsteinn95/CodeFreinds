import React, {Component} from 'react';

class GoogleMap extends Component {

  componentDidMount() {
    var geocoder = new google.maps.Geocoder();

    console.log(this.props);


    new google.maps.Map(this.refs.map, {
      zoom: 10,
      center: {
        lat: this.props.lon,
        lng: this.props.lat
      }
    });
  }
  render() {
    var divStyle = {
      width: "100%",
      height: "100%"
    };
    return (
      <div style={divStyle} className="maps" ref="map"></div>
    );
  }

}

export default GoogleMap;
