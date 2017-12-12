package br.inatel.pos.mobile.dm110.interfaces;

public interface Customer {
	
	void addNewCustomer(String customerName, String email);
	
	String[] listCustomerNames();
}
