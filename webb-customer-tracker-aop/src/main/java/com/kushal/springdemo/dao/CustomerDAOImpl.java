package com.kushal.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kushal.springdemo.entity.Customer;
import com.kushal.springdemo.util.SortUtils;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the Hibernate Session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		//get the current Hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();
		//create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by last_name",Customer.class);
		//execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		//return the results
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		//get the Hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();
		//Save the customer
		currentSession.saveOrUpdate(theCustomer);
		
	}


	@Override
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		//get session
		Session currentSession = sessionFactory.getCurrentSession();
		//fetch the customer
		Customer customer = currentSession.get(Customer.class, theId);
		return customer;
	}


	@Override
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId" , theId);
		theQuery.executeUpdate();
	}


	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		// TODO Auto-generated method stub
		// get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Customer> theQuery = null;
        // only search by name if theSearchName is not empty
        if (theSearchName != null && theSearchName.trim().length() > 0) {
            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Customer where lower(first_name) like :theName or lower(last_name) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");//% is for like clause in query, substring is also searchable now
        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Customer", Customer.class);            
        }
        
        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();
                
        // return the results        
        return customers;
	}


	@Override
public List<Customer> getCustomers(int theSortField) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// determine sort field
		String theFieldName = null;
		
		switch (theSortField) {
			case SortUtils.FIRST_NAME: 
				theFieldName = "first_name";
				break;
			case SortUtils.LAST_NAME:
				theFieldName = "last_name";
				break;
			case SortUtils.EMAIL:
				theFieldName = "email";
				break;
			default:
				// if nothing matches the default to sort by lastName
				theFieldName = "last_name";
		}
		
		// create a query  
		String queryString = "from Customer order by " + theFieldName;
		Query<Customer> theQuery = 
				currentSession.createQuery(queryString, Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
				
		// return the results		
		return customers;
	}

}
