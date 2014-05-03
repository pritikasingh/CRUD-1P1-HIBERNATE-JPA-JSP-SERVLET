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
import br.com.hibernateservletjsp1p1.repository.PersonRepository;
import br.com.hibernateservletjsp1p1.repository.PersonRepositoryJPA;

/**
 * Servlet implementation class DeletePersonController
 */
@WebServlet("/DeletePersonController")
public class DeletePersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePersonController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		deletePerson(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		deletePerson(request,response);
	}
	
	
	protected void deletePerson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  PersonRepositoryJPA prj = new PersonRepositoryJPA(JPA.em());
		  PersonRepository pr = prj;
          
          Long idPerson = Long.parseLong(request.getParameter("idPerson"));
          
          try {
        	
        	Person person = pr.findById(idPerson);
        	  
			pr.remove(person);
			request.setAttribute("msg", "Deleted Successfully!");
			List<Person> listPerson = (List<Person>) pr.findAll();
			request.setAttribute("listPerson", listPerson);
			pr.clear();
			request.getRequestDispatcher("retrievePerson.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			System.out.println("Erro do Servlet");
			e.printStackTrace();
		}
          
          
          
		
	}

}
