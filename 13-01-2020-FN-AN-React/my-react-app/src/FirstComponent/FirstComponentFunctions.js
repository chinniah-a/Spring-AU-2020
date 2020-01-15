export const SUCCESS = 'SUCCESS';
export const ERROR = 'ERROR';
export const SEARCH = 'SEARCH';

export const fetchPollution = () => {
  return dispatch => {
    
    return fetch("data.json")
      .then(handleErrors)
      .then(res => res.json())
      .then(data => {
        dispatch(fetchPollutionSuccess(data));
        console.log(data);
        return data;
      })
      .catch(error => dispatch(fetchPollutionFailure(error)));
  };
}

export const  fetchPollutionSuccess = pollution => ({
  type: SUCCESS,
  payload: { pollution }
});

 export const fetchPollutionFailure = error => ({
  type: ERROR,
  payload: { error }
});
 

export const search = regex => ({
  type: SEARCH,
  payload: { regex }
});

const handleErrors = (response) => {
    if (!response.ok) {
      throw Error(response.statusText);
    }
    return response;
  }  




