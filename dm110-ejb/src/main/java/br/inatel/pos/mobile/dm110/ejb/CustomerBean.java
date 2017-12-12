package br.inatel.pos.mobile.dm110.ejb;

import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.pos.mobile.dm110.dao.CustomerDAO;
import br.inatel.pos.mobile.dm110.entities.Customer;
import br.inatel.pos.mobile.dm110.interfaces.CustomerLocal;
import br.inatel.pos.mobile.dm110.interfaces.CustomerRemote;

@Stateless
@Local(CustomerLocal.class)
@Remote(CustomerRemote.class)
public class CustomerBean implements CustomerLocal, CustomerRemote {

	@EJB
	private CustomerDAO dao;
	
	@Override
	public void addNewCustomer(String customerName, String email) {
		Customer customer = new Customer();
		customer.setName(customerName);
		customer.setEmail(email);
		dao.insert(customer);
		
	}

	@Override
	public String[] listCustomerNames() {

		return dao.findAll()
				.stream()
				.map(Customer::getName)
				.collect(Collectors.toList())
				.toArray(new String[0]);
	}

	
}
