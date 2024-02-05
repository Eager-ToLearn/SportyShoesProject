package pac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pac.model.Products;
import pac.repository.ProductsRepository;

@Service
public class ProductsService
{
	//@Autowired
	ProductsRepository productsRepository;
	
	public List<Products> getAllProducts()
	{
		return productsRepository.findAll();
	}

	public void addProducts(Products products)
	{
		productsRepository.save(products);
	}
	public void delProById(int id)
	{
		productsRepository.deleteById(id);
	}
	public Optional<Products> getProById(int id)
	{
		return productsRepository.findById(id);
	}
	public List<Products> getProByCat(int id)
	{
		return productsRepository.findByCategoryId(id);
	}
}
