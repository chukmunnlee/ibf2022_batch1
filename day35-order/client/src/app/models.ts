export interface LineItem {
	item: string
	quantity: number
}

export interface Order {
	name: string
	email: string
	lineItems: LineItem[]
}

export interface PlaceOrderResponse {
	orderId: string
}
