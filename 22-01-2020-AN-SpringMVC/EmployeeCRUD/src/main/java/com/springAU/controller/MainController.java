package com.springAU.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springAU.config.exception.IllegalPropertyException;
import com.springAU.config.exception.IllegalURLException;
import com.springAU.dao.EmployeeDAO;
import com.springAU.model.Employee;

@Controller
public class MainController { // Web Controller
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public ModelAndView add(ModelAndView model) throws IOException{
		
		List<Employee> listEmployees = employeeDAO.fetchAll();
	    model.addObject("listEmployees", listEmployees);
	    
	    System.out.println(listEmployees.size());
	    model.setViewName("home");
	    System.out.println(listEmployees.toString());
	    return model;
		//return "home";
	}
	
	@RequestMapping("/")
	public ModelAndView listEmployee(ModelAndView model) throws IOException{ 
	    List<Employee> listEmployees = employeeDAO.fetchAll();
	    model.addObject("listEmployees", listEmployees);
	    
	    System.out.println(listEmployees.size());
	    model.setViewName("home");
	    System.out.println(listEmployees.toString());
	    return model;
	}
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public ModelAndView newEmployee(ModelAndView model) { //Add Employee From
	    Employee employee = new Employee();
	    model.addObject("employee", employee);
	    model.setViewName("EmployeeForm");
	    return model;
	}
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST) // Method to save incoming Employee Object
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) throws IllegalPropertyException {
		String[] validation = employee.validate() ;
		if(!(validation.length == 0)) {
			throw new IllegalPropertyException(validation[0], validation[1]);
		}
	    employeeDAO.saveOrUpdate(employee);
	    return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET) // Delete Employee object
	public ModelAndView deleteEmployee(HttpServletRequest request) {
	    int Id = Integer.parseInt(request.getParameter("id"));
	    employeeDAO.deletById(Id);
	    return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editEmployee(HttpServletRequest request) {
	    int Id = Integer.parseInt(request.getParameter("id"));
	    Employee employee = employeeDAO.findById(Id);
	    ModelAndView model = new ModelAndView("EmployeeForm");
	    model.addObject("employee", employee);
	    
	 
	    return model;
	}
	
	
	 @ExceptionHandler(IllegalPropertyException.class) // Exception handling for illegal property set
	  public ModelAndView handleError(HttpServletRequest req, IllegalPropertyException ex) {
	    //logger.error("Request: " + req.getRequestURL() + " raised " + ex);

	    ModelAndView mav = new ModelAndView();
	    System.out.println(ex.toString());
	    mav.addObject("exception", ex.toString());
	    mav.addObject("url", req.getRequestURL());
	    mav.setViewName("error");
	    return mav;
	  }
	
	@ExceptionHandler(IllegalURLException.class) // Exception for illegal URL
	public String urlNotFound() {
		return "notFound";
	}
	
	@RequestMapping("**")
	public void notFoundError(ModelAndView modelAndView) {
		throw new IllegalURLException();
		
	}
	
	
	
	

}
