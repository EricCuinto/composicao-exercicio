package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private Date moment;
	private OrderStatus status;

	private Client client;
	private List<OrderItem> items = new ArrayList<>();

	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}

	public Double total() {
		Double sum = 0.0;
		for (OrderItem c : items) {
			sum += c.subTotal();
		}
		return sum;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();
		System.out.println("**********************************");
		sb.append("Data do Pedido: " + sdf.format(moment) + "\n");
		sb.append("Status do Pedido: " + status + "\n");
		sb.append("Cliente: " + client + "\n");
		sb.append("Items do pedidos: \n");

		for (OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Preço total: R$ " + String.format("%.2f", total()));
		return sb.toString();
	}

}
