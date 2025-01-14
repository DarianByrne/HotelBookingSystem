package ie.hotelbooking;

import ie.hotelbooking.dao.CustomerDAO;
import ie.hotelbooking.model.Customer.Customer;
import java.sql.Date;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world!");

		String name = "Kyle Purcell";
		String phoneNumber = "087-3513813";
		String email = "kylepurcell1998@gmail.com";
		Date dateOfBirth = Date.valueOf("1998-07-05");
		String address = "Castlecomer";

		CustomerDAO customerDAO = new CustomerDAO();
		Customer customerOne = new Customer(name, phoneNumber, email, dateOfBirth, address);

		customerDAO.deleteCustomer(customerOne);
	}
}