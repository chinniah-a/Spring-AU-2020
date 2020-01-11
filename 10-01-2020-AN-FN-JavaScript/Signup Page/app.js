const getElem = document.getElementById;




//var number = \[0-9]+\;

console.log(password);

const validate = () => {
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    var cpassword = document.getElementById('re-password').value;
    var output = document.getElementById('output');
    if(username.length > 50 || password.length > 50){
        output.innerText = 'Username and Password cannot be longer than 50 Characters';
    }
    else if(password != cpassword){
        output.innerText = 'Passwords Do Not Match';
    }
    else if(password.length < 8){
        output.innerText = 'Password needs to be atleast 8 Characters';
    }
    else if(!/[0-9]+/.test(password)){
        output.innerText = 'Password Must have atleast one number';
    }
    else if(!/[a-z]+/.test(password)){
        output.innerText = 'Password Must have atleast one Small letter';
    }
    else if(!/[A-Z]+/.test(password)){
        output.innerText = 'Password Must have atleast one Capital letter';
    }
    else if(!/[@$*]/.test(password)){
        output.innerText = 'Password Must have atleast one of the following Special Chars: $ @ *' ;
    }
    else if(!/abc/.test(password)){
        output.innerText = 'Password Must have abc';
    }
    else{
        output.innerText = 'Username: ' + username + ' Password:' + password;
        console.log('Username: ' + username + ' Password:' + password);
        alert('Username: ' + username + ' \nPassword:' + password)
    }
}