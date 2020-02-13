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
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//dados do cliente
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("E-mail: ");
		String clientEmail = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date clientBirthday = sdf.parse(sc.next());
		sc.nextLine();
		
		//dados do pedido
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String orderStatus = sc.nextLine(); 
		System.out.print("How many items to this order?: ");
		int products = sc.nextInt(); 
		sc.nextLine();
		Date moment = new Date(System.currentTimeMillis());
		
		//salvando dados na classe Order
		
		Order order = new Order(new Client(clientName, clientEmail, clientBirthday), 
				OrderStatus.valueOf(orderStatus), moment);
				
		for(int i = 0; i < products; i++) {
			
			System.out.println("Enter #" + (i + 1) + " item data:");
			
			System.out.print("Product name:");
			String productName = sc.nextLine();
			System.out.print("Product price:");
			double productPrice = sc.nextDouble();
			sc.nextLine();
			System.out.print("Quantity:");
			int productQuantity = sc.nextInt();
			sc.nextLine();
			
			order.addItem(new OrderItem(productQuantity, new Product(productName, productPrice)));
			
			
		}
		
		System.out.println();
		System.out.print(order.toString());
		
	
		sc.close();
		
		

	}

}
