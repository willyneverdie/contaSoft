package com.dao.test;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dao.commonentities.Address;
import com.dao.entities.TaxPayer;

public class TestTaxPayer {

	
	private static EntityManager manager;
	private static EntityManagerFactory emf;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		
		try{
			emf = Persistence.createEntityManagerFactory("persitenceH2");
			manager = emf.createEntityManager();

			initialLoad();
			
			List<TaxPayer> taxpayer = (List<TaxPayer>) manager.createQuery("FROM TaxPayer").getResultList();
			System.out.println("1En esta db hay:" + taxpayer.size() + " taxpayers");
			
			for(TaxPayer payer : taxpayer)
				System.out.println(payer.toString());
			
			System.out.println("asdasd");
			
		}catch(Exception e) {
			throw e;
		}
		
		
		
	}

	public static void initialLoad() {
		TaxPayer tp = new TaxPayer("15","Williams SA","Herrera","w@w.com");
		TaxPayer tp2 = new TaxPayer("16","Williams SA","Herrera","w@w.com");
		tp.setAddress(new Address("01","Local","Mi casa 01", LocalDate.now()));
		tp2.setAddress(new Address("02","Local","Mi casa 01", LocalDate.now()));
		manager.getTransaction().begin();
		manager.persist(tp);
		manager.persist(tp2);
		manager.getTransaction().commit();
	}
}
