package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);

		System.out.println("Entre com os dados do cliente:");

		System.out.print("Nome: ");
		String nameClient = sc.nextLine();

		System.out.print("Email: ");
		String email = sc.nextLine();

		System.out.print("Data de aniversário: ");
		Date birthDate = sdf.parse(sc.nextLine());

		System.out.print("Entre com os dados do pedido: ");
		System.out.print("Status: ");
		String statusProduct = sc.nextLine();

		Order order = new Order(new Date(System.currentTimeMillis()), OrderStatus.valueOf(statusProduct),
				new Client(nameClient, email, birthDate));

		System.out.print("Quantos itens nesse pedido? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Digite o pedido #" + i + ": ");

			System.out.print("Nome do Produto: ");
			sc.nextLine();
			String nameProduct = sc.nextLine();

			System.out.print("Preço do produto: ");
			Double priceProduct = sc.nextDouble();

			System.out.print("Quantidade de produto: ");
			int quantityProduct = sc.nextInt();

			OrderItem orderItem = new OrderItem(quantityProduct, priceProduct, new Product(nameProduct, priceProduct));
			order.addItem(orderItem);
		}
		System.out.println();
		System.out.println("DADOS DO PEDIDO: ");
		System.out.println(order);

		sc.close();
	}
}
