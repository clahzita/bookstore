/**
 * 
 */
package com.bookstore.codehome.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home page controller
 * 
 * @author clarissa
 *
 */
@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public void index() {
		System.out.println("Carregando produtos");
	}

}
