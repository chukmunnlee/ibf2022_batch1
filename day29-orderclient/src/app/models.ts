export interface LineItem {
	item: string
	quantity: number
}

// Order send to Spring Boot
export interface Order {
	name: string
	email: string
	deliveryDate: string
	lineItems: LineItem[]
}

// response from Spring Boot
export interface OrderResponse {
	orderId: string
	message: string
}
