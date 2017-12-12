package br.inatel.pos.mobile.dm110.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.inatel.pos.mobile.dm110.entities.Customer;


@Stateless
public class CustomerDAO {
	
	@PersistenceContext(unitName = "inventory")
	private EntityManager em;
	
	public void insert(Customer customer) {
		em.persist(customer);
	}
	
	public List<Customer> findAll() {
		return em.createQuery("from Customer c", Customer.class).getResultList();
	}
}
