package br.inatel.pos.mobile.dm110.impl;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.inatel.pos.mobile.dm110.api.CustomerService;
import br.inatel.pos.mobile.dm110.interfaces.CustomerRemote;

@RequestScoped
public class CustomerServiceImpl implements CustomerService {

	@EJB(lookup = "java:app/dm110-ejb-1.0.0-SNAPSHOT/CustomerBean!br.inatel.pos.mobile.dm110.interfaces.CustomerRemote")
	private CustomerRemote customerBean;

	@Override
	public void addNewCustomer(String customerName, String email) {
		customerBean.addNewCustomer(customerName, email);
		
	}

	@Override
	public String[] listCustomerNames() {
		return customerBean.listCustomerNames();
	}

}
