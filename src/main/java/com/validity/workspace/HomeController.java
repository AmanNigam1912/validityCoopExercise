package com.validity.workspace;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.validity.workspace.ReadAndProcessCSV.ReadAndProcessCSV;
import com.validity.workspace.pojo.Person;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//map the incoming request to this ModelAndView if url ends with "/home"
	@RequestMapping("/home")
	public ModelAndView helloWorld() throws IOException {
		
		//Create an instance of ReadAndProcessCSV class
		ReadAndProcessCSV csv = new ReadAndProcessCSV();
		
		//This will parse and populate the ArrayList with Person objects	
		csv.readPersonInfo();
		
		//HashMap will store all the duplicates and none duplicates records returned by duplicateORNot method
		HashMap<Person, ArrayList<Person>> map = csv.duplicateORNot();

		//Call the jsp page "home" with a map variable
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("map",map);
		
		return mv;
	}
	
}
