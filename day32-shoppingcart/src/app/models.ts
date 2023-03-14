export interface Inventory {
	name: string 
	unitPrice: number
	image: string
}

export interface Selection extends Inventory {
	quantity: number
}
