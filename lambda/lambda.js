const hello = function(name) {
    console.info(`Hello ${name}`)
}
const username = 'fred'
const hi = hello
const names = [ 'fred', 'betty', 'barney', 'wilma' ]

const sayHello = function(fn, args) {
    // if fn is a function, then I can call the function
    fn(args)
}
const power = function(args) {
    console.info('>>>> power: ', Math.pow(args, 2))
}

console.info('>>> hello: ', hello)
hello(username)
hi('barney')

sayHello(hello, 'wilma')

console.info('Say hello to these guys ', names)
for (let n of names)
    sayHello(hello, n)

sayHello(power, 5)