package br.com.hibernateservletjsp1p1.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.hibernateservletjsp1p1.entity.Person;
import br.com.hibernateservletjsp1p1.repository.JPA;
import br.com.hibernateservletjsp1p1.repository.PersonRepositoryJPA;

/**
 * Servlet implementation class RetrievePersonController
 */
@WebServlet("/RetrievePersonController")
public class RetrievePersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrievePersonController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		retrievePerson(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		retrievePerson(request,response);
	}
	
	protected void retrievePerson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 PersonRepositoryJPA prj = new PersonRepositoryJPA(JPA.em());
		
          try {
        	  
			List<Person> listPerson = prj.findAll();
			request.setAttribute("listPerson", listPerson);
			request.getRequestDispatcher("retrievePerson.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
