package br.inatel.pos.mobile.dm110.impl;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.inatel.pos.mobile.dm110.api.HelloService;
import br.inatel.pos.mobile.dm110.api.Result;
import br.inatel.pos.mobile.dm110.interfaces.HelloRemote;

@RequestScoped
public class HelloServiceImpl implements HelloService {
	
	@EJB(lookup="java:app/dm110-ejb-1.0.0-SNAPSHOT/HelloBean!br.inatel.pos.mobile.dm110.interfaces.HelloRemote")
	private HelloRemote helloBean;

	@Override
	public String sayHello(String name) {
		String message = helloBean.sayHello(name);
		return "<h1>" + message + "</h1>";
	}

	@Override
	public Result buildMessage(String firstName, String lastName) {
		String message = "Hello " + firstName + " " + lastName + " !";

		Result result = new Result();
		result.setFirstName(firstName);
		result.setLastName(lastName);
		result.setMessage(message);
		return result;
	}
}
