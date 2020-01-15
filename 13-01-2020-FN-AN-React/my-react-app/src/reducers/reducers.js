const SUCCESS = 'SUCCESS';
const ERROR = 'ERROR';
const SEARCH = 'SEARCH';

const defaultState = {
    pollution: [],
    filter: null,
    copy: [],
    error: null
};


const store = (jsonData) => {
     localStorage.setItem('save',JSON.stringify(jsonData));
     localStorage.setItem('searchterm',document.getElementById('Search').value);
     
   }

const retrieve = () => {
     let data = JSON.parse(localStorage.getItem('save'));
     document.getElementById('Search').value = localStorage.getItem('searchterm');
     console.log(localStorage.getItem('bro'));
     return data;
   }

export const search = (state = defaultState,action) => {
    if (state.filter)
        {   
            console.log('Helooo Frands');
            return state.filter.filter( x => action['reg'].test(x.city));
        }
        
    else
        return 0;

}


export const reduce = (state=defaultState, action)=> {
    console.log(action)
    switch(action.type) {
        case SUCCESS:

        { if(localStorage.getItem('searchterm'))
        {
            return {
                pollution: retrieve(),
                filter: action.payload.pollution,
                copy: action.payload.pollution,
                error: null
            };
        }
            return {
                pollution: action.payload.pollution,
                filter: action.payload.pollution,
                copy: action.payload.pollution,
                error: null
            };
        }
        case ERROR:
            return {
                error: action.payload.error,
                pollution: [],
                filter: [],
                copy: []
            };

        case SEARCH:
            var regEx = action.payload.regex;
            var copy = state.copy;
            var filter = state.copy;
            var city = filter.filter(x => regEx.test(x['station']));

            store(city);

            return {
                ...defaultState,
                error: null,
                pollution: city,
                filter: filter,
                copy: copy
            }
        default:
            return state;
    }
}