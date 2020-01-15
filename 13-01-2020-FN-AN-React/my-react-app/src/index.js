import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux'; 
import { createStore, applyMiddleware } from 'redux';      
import './index.css';
import App from './App';
import FirstComponent from './FirstComponent/FirstComponent';
import * as serviceWorker from './serviceWorker';
import { reduce } from './reducers/reducers';
import thunk from 'redux-thunk';

// var reducer = (state, action) => {
//     console.log('reducer', state, action);
//     return state;
//   }

export const storage = createStore(reduce, applyMiddleware(thunk));

ReactDOM.render(<div> 
    <Provider store = {storage}>
    <App /><FirstComponent />
    </Provider>
    </div>, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();

