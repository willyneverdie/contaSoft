package com.cs.entities;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.commonentities.Address;
import com.dao.entities.TaxPayer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class CompanyInfo
 */
public class CompanyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CompanyInfo() {
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EntityManager manager;
		EntityManagerFactory emf;
		//Type baseType = new TypeToken<List<TaxPayer>>() {}.getType();
		
		emf = Persistence.createEntityManagerFactory("persitenceH2");
		manager = emf.createEntityManager();

		TaxPayer tp = new TaxPayer("15","Williams SA","Herrera","w@w.com");
		TaxPayer tp2 = new TaxPayer("16","Williams SA","Herrera","w@w.com");
		tp.setAddress(new Address("01","Local","Mi casa 01", LocalDate.now()));
		tp2.setAddress(new Address("02","Local","Mi casa 01", LocalDate.now()));
		manager.getTransaction().begin();
		manager.persist(tp);
		manager.persist(tp2);
		manager.getTransaction().commit();
		
		List<TaxPayer> taxpayer = (List<TaxPayer>) manager.createQuery("FROM TaxPayer").getResultList();
		
		
		String objectToReturn = "{ key1: 'value1', key2: 'value2' }";
		
		Gson gson = new Gson();
		String tmp = gson.toJson(taxpayer, new TypeToken<List<TaxPayer>>() {}.getType());
		
		//new list
		List<String> test = new ArrayList<>();
		test.add("Will");
		test.add("Bee");
		
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		// Get the printwriter object from response to write the required json object to the output stream      
		PrintWriter out = response.getWriter();
		request.setAttribute("clients", "Williams");
		request.setAttribute("list", test);
		request.setAttribute("client", tmp);
		request.getRequestDispatcher("/WEB-INF/products.jsp").forward(request, response);
		
		// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
		//out.print(tmp);
		//out.flush();
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
