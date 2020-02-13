package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

	private Date moment;
	private OrderStatus status;
	private List<OrderItem> items = new ArrayList<>();
	private Client client;

	public Order() {
	}

	public Order(Client client, OrderStatus status, Date moment) {

		this.client = client;
		this.status = status;
		this.moment = moment;

	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addItem(OrderItem items) {
		this.items.add(items);
	}

	public void removeItem(OrderItem items) {
		this.items.remove(items);
	}

	public Double total() {

		double total = 0;

		for (OrderItem c : items) {

			double c_subTotal = c.subTotal();
			total += c_subTotal;

		}

		return total;

	}

public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("ORDER SUMMARY:\n");
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + client.getName() + " (" + (sdf2.format(client.getBirthDate())));
		sb.append(") - " + client.getEmail() + "\n");
		sb.append("Order items:\n");
		
		for(OrderItem c : items) {
			sb.append(c.getProduct().getName() + ", $" + c.getProduct().getPrice()  + ", Quantity: " + c.getQuantity() + ", Subtotal: $" + 
		String.format("%.2f", c.subTotal()) + "\n");
		}
		
		sb.append("Total price: " + this.total());
		
		
		return sb.toString();
		
	}

}
