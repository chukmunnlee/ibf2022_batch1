// Primitives - scalar type
let username = "fred"
let age = 50

// array, objects - reference type
// Array
let numList = [ 1, 2, 3, 4, 5 ]

// Function type
// Anonymous functions, lambda
let greetings = function(name) {
    console.info(`Hello ${name}`)
}

// Objects
let fred = {
    name: 'fred',
    age: 50
}

// Java - method
// function greetings(name) {
//     console.info(`Hello ${name}`)
// }

console.info(`name: ${username}, age: ${age}`)
console.info('numList ', numList, numList[3])
console.info('fred ', fred)
console.info('>>> greetings: ', greetings)

let hello = greetings

greetings(username)
hello()