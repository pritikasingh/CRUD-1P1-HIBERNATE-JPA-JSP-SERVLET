package br.com.hibernateservletjsp1p1.filter;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.hibernateservletjsp1p1.repository.JPA;

/**
 * Fecha os entity managers da thread ao final da requisi��o, se houver
 */
@WebFilter
public class CloseEntityManagerFilter implements Filter {

    public void destroy() {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    	EntityManager em = JPA.em();
        em.getTransaction().begin();
    	chain.doFilter(request, response);
       
    	System.out.println();
    	
    	try {

            
    		em.getTransaction().commit();
    		
    		

        }catch(Exception ex){
        	
        	em.getTransaction().rollback();
        	
        	
        }
        	
        	finally {
        

            //Filtra urls com extens�o 
            String path = ((HttpServletRequest) request).getRequestURI();
            String resource = path.substring(path.lastIndexOf('/'));
            if (resource.indexOf(".") <= 0) {

                 em = JPA.em(false);
                if (em != null && em.isOpen()) {

                    em.close();

                }

            }

        }

    }

    public void init(FilterConfig filterConfig) throws ServletException {


    }

}