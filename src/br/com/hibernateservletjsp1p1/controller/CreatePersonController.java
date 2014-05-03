package br.com.hibernateservletjsp1p1.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.hibernateservletjsp1p1.entity.Address;
import br.com.hibernateservletjsp1p1.entity.Person;
import br.com.hibernateservletjsp1p1.repository.JPA;
import br.com.hibernateservletjsp1p1.repository.PersonRepository;
import br.com.hibernateservletjsp1p1.repository.PersonRepositoryJPA;

/**
 * Servlet implementation class CreatePersonController
 */
@WebServlet("/CreatePersonController")
public class CreatePersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePersonController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		createPerson(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		createPerson(request,response);
	}
	
	
	protected void createPerson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PersonRepositoryJPA prj = new PersonRepositoryJPA(JPA.em());
		PersonRepository pr = prj;
		
		

		Person p = new Person(null,
				                request.getParameter("namePerson"));
		
		
		Address a = new Address(null,
				                    request.getParameter("streetAddress"),
				                Integer.parseInt(request.getParameter("numberAddress")),
				                        request.getParameter("districtAddress"));
		
		
		
		p.setAddress(a);
		a.setPerson(p);
		
		
		try {
			
			pr.save(p);
			request.setAttribute("msg", "Created Successfully!");
			List<Person> listPerson = (List<Person>) pr.findAll();
			request.setAttribute("listPerson", listPerson);
			request.getRequestDispatcher("retrievePerson.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
