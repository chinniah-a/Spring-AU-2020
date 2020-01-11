var usernames = ["bro101", "genryder", "dspatil", "hello", "darshan121", "rohitgonzo",'groveforlife','regretfulgemini'];
var matched = [...usernames];
var sorted = document.getElementById('sorted');
var result = document.getElementById("result");
result.innerHTML = usernames.join('\n');
//sorted.innerText = [...usernames].sort().join('\n');
var search = () => {
            var pattern = document.getElementById("username").value;
            var reg = new RegExp(pattern);
            matched = usernames.filter((element) => reg.test(element));
            console.log(matched);
            var joinedArr = matched.join("\n");
            result.innerHTML = joinedArr;
            sorted.innerHTML = [...matched].sort().join('\n');
        }
var sortunsorted = () => {
    result.innerHTML = [...matched].sort().join('\n');
}