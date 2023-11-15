package onlineshopping;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Store 
{
	ArrayList<Product> products;
	HashMap<Integer, Integer> stock;
	
	Store()
	{ 
		products=new ArrayList<Product>();
		stock= new HashMap<Integer, Integer>();
	}
	synchronized void addProduct(Product product, int qty)
	{
		products.add(product);
		stock.put(product.getId(), qty);
	}
	
	synchronized void sale(HashMap<Integer, Integer> carts)
	{
		for(Map.Entry<Integer, Integer> item: carts.entrySet())
		{
			int sQty = stock.get(item.getKey());
			if(sQty>=item.getValue())
			{
				int newQty = sQty - item.getValue();
				stock.replace(item.getKey(), newQty);
				
			}
		}
	
	}
	
	
	void showProducts()
	{
		System.out.println("=================================================");
		System.out.printf("%-15s%-15s%-15s%-15s\n=================================================\n","PID","Name","Price","Qty");
		for(Product p: products)
		{
			System.out.printf("%-15d%-15s%-15.2f%-15d\n",p.getId(),p.getName(),p.getPrice(),stock.get(p.getId()));
		}
	}
	

	
	
}


