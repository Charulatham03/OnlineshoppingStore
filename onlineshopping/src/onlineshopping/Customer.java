package onlineshopping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Customer extends Thread
{

	private String name;
	private Store store;
	private HashMap<Integer, Integer> shoppingCart;
	
	public Customer(String name, Store store)
	{
		this.name=name;
		this.store=store;
		this.shoppingCart= new HashMap<Integer, Integer>();
	}
	
	public synchronized void addToCart()
	{
		Random random = new Random();
		ArrayList<Integer> plist = new ArrayList<Integer>(store.stock.keySet());
		int n  =  random.nextInt(5)+1;
		for(int i=1;i<=n;i++)
		{
			int index = random.nextInt(0, plist.size());
			int qty = random.nextInt(10)+1;
			shoppingCart.put(plist.get(index), qty);
		}
		
	}
	
	void viewCart()
	{
		shoppingCart.forEach((key,value)-> System.out.println(key + " : "+ value));
	}
	
	 void   buy()
	{
		store.sale(shoppingCart);
	}
	
	
	@Override
	public void run()
	{
		synchronized (this) {
			System.out.println(name + "do the shoping....");
			addToCart();
			buy();
		}
		
	}
}
