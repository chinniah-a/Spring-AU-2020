let myArray = [1,2,3,4,5,6,7,8,9,10];
let otherArray = [11,12,13,14,15,16,17,18,19,20];


console.log('Concat ' + myArray.concat(otherArray));

/*Concat 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20 */

console.log('Every ' + myArray.every(x => x < 20));

// Every true 

console.log('Filter ' + myArray.filter(x => x%3 == 0));

// Filter 3,6,9

console.log('forEach ');

myArray.forEach( x => console.log(2 * x));

/* forEach     
2
4
6
8
10
12
14
16
18
20 */



console.log('indexOf ' + myArray.indexOf(5));

// indexOf 4

console.log('Join ' + myArray.join('$'));

// Join 1$2$3$4$5$6$7$8$9$10

console.log('lastIndexOf ' + myArray.lastIndexOf(6));

// lastIndexOf 5

console.log('Map ' + myArray.map(x => x * 2));

// Map 2,4,6,8,10,12,14,16,18,20

console.log('Pop ' + myArray.pop());

// Pop 10

myArray.push(1);

console.log(myArray);

// [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 1 ]

console.log('Reduce: ' + myArray.reduce((total,num) => total - num));

// Reduce: -44

console.log('ReduceRight: ' + myArray.reduceRight((x,y) => x + y));

// ReduceRight: 46

console.log('Reverse: ' + myArray.reverse());

// Reverse: 1,9,8,7,6,5,4,3,2,1

console.log('Shift: ' + myArray.shift());

// Shift: 1

console.log('Slice: ' + myArray.slice(5,9));

// Slice: 4,3,2,1

console.log('Some: ' + myArray.some(x => x == 5));

// Some: true

console.log('Sort: ' + myArray.sort((a,b) => a - b));

// Sort: 1,2,3,4,5,6,7,8,9

console.log('Splice ' + myArray.splice(1,2,4,5));

// Splice 2,3

console.log(myArray);

// [ 1, 4, 5, 4, 5, 6, 7, 8, 9 ]

console.log('toString ' + myArray.toString());

// toString 1,4,5,4,5,6,7,8,9

console.log('Unshift ' + myArray.unshift(10));

// Unshift 10

console.log(myArray);

// [ 10, 1, 4, 5, 4, 5, 6, 7, 8, 9 ]
