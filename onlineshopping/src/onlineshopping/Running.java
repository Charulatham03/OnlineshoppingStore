package onlineshopping;

import java.util.Random;

public class Running {
	
	public static void main(String[] args) {
		
		Store myStore = new Store();
		myStore.addProduct(new Product(101, "Pen", 150), 100);
		myStore.addProduct(new Product(102, "Toycar", 200), 100);
		myStore.addProduct(new Product(103, "HDD", 800), 100);
		myStore.addProduct(new Product(104, "Inventor", 600), 100);
		myStore.addProduct(new Product(105, "SSD", 850), 100);
		myStore.addProduct(new Product(106, "Monitor", 900), 100);
		myStore.addProduct(new Product(107, "Pendrive", 20), 100);
		
		myStore.showProducts();
		
		
//		Customer c1 = new Customer("Customer 1", myStore);
//		c1.start();
//		try {
//			c1.join();
//		} catch (InterruptedException e) {
//		
//			e.printStackTrace();
//		}
//		
//		c1.viewCart();
		
		Random random  = new Random();
		int n = random.nextInt(5)+1;
		
		Customer[] cutomers = new Customer[n];
		System.out.println(n+" Customers created!");
		
		for(int i =0;i<n;i++)
		{
			cutomers[i] = new Customer("Customer"+(i+1), myStore);
		}
		
		
		for(int i=0;i<n;i++)
		{
			
			cutomers[i].start();
			
			
		}
		
		for(int i=0;i<n;i++)
		{
			try {
				cutomers[i].join();
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
		}
		
		for(int i=0;i<cutomers.length;i++)
		{
			System.out.println("Customer"+ (i+1)+"Purches Details");
			cutomers[i].viewCart();
		}
		
		
		
		myStore.showProducts();
		
	}

}

