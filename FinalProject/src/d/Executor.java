package d;

import java.util.ArrayList;

public class Executor extends Employee {
	public Executor(String name, String surname, Integer salary) {
		super(name, surname, salary);

	}

	public static ArrayList<Order> orders=new ArrayList<Order> ();
	public ArrayList<Order> executedOrders = new ArrayList<Order>();
	private int bonus;
	

	public void addExecutedOrder(Order o) {
		executedOrders.add(o);
	}

	public void addNewOrder(Order o) {
		orders.add(o); 
	}

	public void addbonus(int bonus) {
		this.salary +=bonus;
	}

	@Override
	public int compareTo(Object arg0) {
		 Executor e = ( Executor)arg0;
		return this.surname.compareTo(e.getSurname());
	}
}

