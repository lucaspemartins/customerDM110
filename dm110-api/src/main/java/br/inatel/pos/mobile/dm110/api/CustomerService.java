package br.inatel.pos.mobile.dm110.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/inventory")
public interface CustomerService {
	
	@POST
	@Path("/customer/{customerName}/{email}")
	void addNewCustomer(@PathParam("customerName") String customerName, @PathParam("email") String email);
	
	@GET
	@Path("/customer/all")
	@Produces(MediaType.APPLICATION_JSON)
	String[] listCustomerNames();
}
