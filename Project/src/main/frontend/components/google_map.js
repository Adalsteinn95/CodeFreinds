import React, {Component} from 'react';
import axios from 'axios';

class GoogleMap extends Component {

  componentDidMount() {
    var geocoder = new google.maps.Geocoder();

    var result

    axios.get(`https://maps.googleapis.com/maps/api/geocode/json?address=${this.props.address}&key=AIzaSyDHku5UVOWtBX0jL20kOs581txm_h9joHE`)
    .then((result) => {
          result = result.data.results[0].geometry.location;
          new google.maps.Map(this.refs.map, {
            zoom: 10,
            center: {
              lat: result.lat,
              lng: result.lng
            },
            marker: {
              lat: result.lat,
              lng: result.lng
            }
          });

      })
      .catch((error) => {
          console.log(error);
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
