/**
 * 
 */
package com.bookstore.codehome.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.codehome.models.BookType;
import com.bookstore.codehome.models.Product;
import com.bookstore.codehome.service.ProductService;

/**
 * 
 * @author clarissa
 *
 */
@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("/product")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/product");
		mv.addObject("products", service.findAll());
		
		return mv;
	}
	
	@GetMapping("/product/form")
	public ModelAndView add(Product product) {
		
		ModelAndView mv = new ModelAndView("/product-form");
		mv.addObject("product", product);
		mv.addObject("types",BookType.values());
		
		return mv;
	}
	
	@GetMapping("/product/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		return add(service.findOne(id));
	}
	
	@GetMapping("/product/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		service.delete(id);
		
		return findAll();
	}

	@PostMapping("/product/save")
	public ModelAndView save(@Valid Product product, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(product);
		}
		
		service.save(product);
		
		return findAll();
	}
}

