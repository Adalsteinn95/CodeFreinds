import React, {Component} from 'react';
import axios from 'axios';

class GoogleMap extends Component {

  componentDidMount() {
    var geocoder = new google.maps.Geocoder();

    var result

    axios.get(`https://maps.googleapis.com/maps/api/geocode/json?address=${this.props.address}&key=AIzaSyDHku5UVOWtBX0jL20kOs581txm_h9joHE`).then((result) => {
      result = result.data.results[0].geometry.location;
      var map = new google.maps.Map(this.refs.map, {
        zoom: 2,
        center: {
          lat: result.lat,
          lng: result.lng
        }
      });
      var b = new google.maps.LatLng(result.lat, result.lng);
      new google.maps.Marker({map: map, position: b, draggable: true, animation: google.maps.Animation.DROP});

      axios.get(`https://maps.googleapis.com/maps/api/geocode/json?address=${this.props.currentAddress}&key=AIzaSyDHku5UVOWtBX0jL20kOs581txm_h9joHE`).then((result) => {
        result = result.data.results[0].geometry.location;
        var b2 = new google.maps.LatLng(result.lat, result.lng);
        console.log(b.lat());
        new google.maps.Marker({map: map, position: b2, draggable: true, animation: google.maps.Animation.DROP});

        var line = new google.maps.Polyline({
          path: [
            new google.maps.LatLng(b.lat(), b.lng()),
            new google.maps.LatLng(b2.lat(),b2.lng())
          ],
          strokeColor: "#FF0000",
          strokeOpacity: 1.0,
          strokeWeight: 2,
          map: map
        });

      }).catch((error) => {
        console.log(error);
      });

    }).catch((error) => {
      console.log(error);
    });

  }
  render() {
    var divStyle = {
      width: "100%",
      height: "100%",
      borderRadius: "10px"
    };
    return (
      <div style={divStyle} className="maps" ref="map"></div>
    );
  }

}

export default GoogleMap;
