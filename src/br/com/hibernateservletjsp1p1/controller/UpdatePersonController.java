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
 * Servlet implementation class UpdatePersonController
 */
@WebServlet("/UpdatePersonController")
public class UpdatePersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePersonController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cmd = request.getParameter("cmd");
        
        if(cmd.equalsIgnoreCase("update1")){
        	
        	update1(request,response);
        	
        }else if(cmd.equalsIgnoreCase("update2")){
        	
        	update2(request,response);        	
        	        	
        }
		
	}
	
	
	protected void update1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PersonRepositoryJPA prj = new PersonRepositoryJPA(JPA.em());
		
		PersonRepository pr = prj;
		
		Long idPerson = Long.parseLong(request.getParameter("idPerson"));
		
		try {
			
			Person person = pr.findById(idPerson);
			request.setAttribute("person", person);
			request.getRequestDispatcher("updatePerson.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	protected void update2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   PersonRepositoryJPA prj = new PersonRepositoryJPA(JPA.em());
		
		   PersonRepository pr = prj;

           Person person = new Person(Long.parseLong(request.getParameter("idPerson")),
        		                           request.getParameter("namePerson"));		
		
           
           Address address = new Address( Long.parseLong(request.getParameter("idAddress")),
        		                                request.getParameter("streetAddress"),
        		                                Integer.parseInt(request.getParameter("numberAddress")),
        		                                     request.getParameter("districtAddress"));
           
           
           person.setAddress(address);
           address.setPerson(person);
           
           
           
           try {
        	   
			pr.update(person);
			request.setAttribute("msg", "Updated Successfully!");
			List<Person> listPerson = (List<Person>) pr.findAll();
			request.setAttribute("listPerson", listPerson);
			request.getRequestDispatcher("retrievePerson.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           
	}

}
