
let p = new Promise(
	(resolve, reject) => {
		// do some work
		setTimeout(() => {
			console.info('timeout, calling resolve')
			resolve({ message: 'success!!!' })
		}, 3)
	}
)

// Catch the resolve
p
	.then(
		data => { 
			console.info('>>> data: ', data) 
			throw "this is an exception"
		}
	)
	.then(
		data => {
			console.info('>>>> 2nd then: ', data.toUpperCase())
		}
	)
	.catch(error => {
		console.error('>>>> error: ', error)
		return 'Everything is resolved'
	})
	.then(data => {
		console.info('>>> after catch: ', data)
	})

