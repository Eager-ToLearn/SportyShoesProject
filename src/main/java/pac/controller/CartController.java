package pac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pac.global.GlobalData;
import pac.model.Products;
import pac.service.ProductsService;

@Controller
public class CartController 
{
	//@Autowired
	ProductsService productsService;
	
//	@GetMapping("/addToCart/{id}")
//	public String addToCart( @PathVariable int id)
//	{
//		GlobalData.cart. add(productsService.getProById(id));
//		return "redirect:/shop";
//	}
	
	@GetMapping("/cart")
	public String cartGet(Model model)
	{
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Products::getPrice).sum());
		model.addAttribute("cart", GlobalData.cart);
		return "cart";
	}
	
	

}
