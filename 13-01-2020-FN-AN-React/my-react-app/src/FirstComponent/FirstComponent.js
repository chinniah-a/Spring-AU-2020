import React, { Component } from 'react';
//import logo from './logo.svg';
import './FirstComponent.css';
//import PostData from '../data.json'
import { connect } from 'react-redux';

import { fetchPollution,search } from './FirstComponentFunctions'

class FirstComponent extends Component  {
   search = (event) => {
      console.log('Bruh');

      var regex = new RegExp(event.target.value);

      this.props.dispatch(search(regex));

      //let filtered = this.state.filter.filter( x => regex.test(x.city));


      //this.setState({pollution : searchStore.dispatch({"type" : "search", "reg" : regex})});
      //this.store();
      
   }

   constructor(props){
    super(props);
    this.state = {
        pollution : [],
        filter : [],
        error : null,
    };
  
}

    componentDidMount(){

        this.props.dispatch(fetchPollution());
      }

    render() {
      const { error, pollution } = this.props;

    if (error) {
      return <div>Error! {error.message}</div>;
    }

    // <button onClick = {this.store}> Save Results </button>
    //     <button onClick = {this.retrieve}> Get Previous Results </button>

  return (
    
    <div className="FirstComponent">
        <h1>FirstComponent</h1>

        <input type = "text" id = "Search" class = "textbox" placeholder = "Search" onKeyUp = {this.search}></input>

      

        <div className="Pollution">
        <h1>Pollution Data : Search Station wise</h1>
        <table>
          <tbody>
            <tr>
              <td><b>ID</b></td>
              <td><b>Country</b></td>
              <td><b>State</b></td>
              <td><b>City</b></td>
              <td><b>Station</b></td>
              <td><b>Update</b></td>
              <td><b>Pol_ID</b></td>
              <td><b>Min</b></td>
              <td><b>Max</b></td>
              <td><b>Avg</b></td>
              <td><b>Unit</b></td>
            </tr>
          {pollution.map((pollutant) => (
            <tr key={pollutant.id}>
              <td>{pollutant.id}</td>
              <td>{pollutant.country}</td>
              <td>{pollutant.state}</td>
              <td>{pollutant.city}</td>
              <td>{pollutant.station}</td>
              <td>{pollutant.last_update}</td>
              <td>{pollutant.pollutant_id}</td>
              <td>{pollutant.pollutant_min}</td>
              <td>{pollutant.pollutant_max}</td>
              <td>{pollutant.pollutant_avg}</td>
              <td>{pollutant.pollutant_unit}</td>
            </tr>
          ))}
          </tbody>
        </table>
      </div>

      </div>
  );
}
}   

var mapStateToProps = (state) => {
  return {
      pollution: state.pollution
  };
}

export default connect(mapStateToProps)(FirstComponent);
// export default FirstComponent;
