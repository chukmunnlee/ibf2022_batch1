import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {firstValueFrom} from "rxjs";
import {Order, PlaceOrderResponse} from "./models";

const URL = "http://localhost:8080/order"

@Injectable()
export class OrderService {

	constructor(private http: HttpClient) { }

	placeOrder(order: Order): Promise<PlaceOrderResponse> {
		return firstValueFrom(
			this.http.post<PlaceOrderResponse>(URL, order)
		)
	}
}
