package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<>();
		
		System.out.println("Enter the number of products; ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Product " + i + " data: ");
			System.out.println("Common, used or imported (c/u/i)");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if(ch == 'c') {
				list.add(new Product(name, price) );
			}
			else if(ch == 'i') {
				System.out.print("Custom free: ");
				double customFree = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customFree));
			}
			else if(ch == 'u') {
				System.out.print("Manufacture date: ");
				Date date = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, date));
			}
		  
		}
           System.out.println();
           System.out.println("PRICE TAG");
           for(Product prod: list) {
        	   System.out.println(prod.priceTag());
           }
	}

}
