package junit;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Customer {

	private static final Map<String,Customer> CONTAINER = new HashMap<String,Customer>();
	
	
	static{
		System.out.println("111");
	}
	
	static void loadCustomers(){
		new Customer("jerrik").store();
		new Customer("smith").store();
		new Customer("john").store();
		
		printAllCustomers();
	}
	
	static void loadCustomers2(){
		new Customer("jerrik1").store();
		new Customer("smith2").store();
		new Customer("john3").store();
		
		printAllCustomers();
	}
	
	private static void printAllCustomers() {
		for(Iterator<Entry<String, Customer>> it = CONTAINER.entrySet().iterator();it.hasNext();){
			Entry<String, Customer> entry = it.next();
			System.out.println("customerName: " + entry.getKey() + " ,value: " + entry.getValue());
		}
	}

	private void store(){
		CONTAINER.put(this.customerName, this);
	}
	
	public final void  show(){
		
	}
	
	
	private String customerName;

	private Customer(String customerName) {
		this.customerName = customerName;
	}
	
	public static void main(String[] args) {
		Customer.loadCustomers();
		Customer.loadCustomers2();
	}
}
