import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {firstValueFrom} from "rxjs";
import {Order, OrderResponse} from "./models";

@Injectable()
export class OrderService {

	constructor(private http: HttpClient) { }

	placeOrder(order: Order): Promise<OrderResponse> {
		return firstValueFrom(
			this.http.post<OrderResponse>('/api/order', order)
		)
	}
}
