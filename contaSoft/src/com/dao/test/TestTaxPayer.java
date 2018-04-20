package com.dao.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dao.entities.TaxPayer;

public class TestTaxPayer {

	
	private static EntityManager manager;
	private static EntityManagerFactory emf;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		
		try{
			emf = Persistence.createEntityManagerFactory("persitenceH2");
			manager = emf.createEntityManager();
			
			List<TaxPayer> taxpayer = (List<TaxPayer>) manager.createQuery("FROM TaxPayer").getResultList();
			System.out.println("En esta db hay:" + taxpayer.size() + " taxpayers");
		}catch(Exception e) {
			throw e;
		}
		
		
		
	}
}
