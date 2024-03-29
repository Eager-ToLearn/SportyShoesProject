package pac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pac.model.Category;
import pac.repository.CategoryRepository;

@Service
public class CategoryService
{
	//@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> getAllCategory()
	{
		//categoryRepository.findAll();
		return categoryRepository.findAll();
	}
	
	public void addCategory(Category category)
	{
		categoryRepository.save(category);
	}
	public void delCat(int id)
	{
		categoryRepository.deleteById(id);
	}
	public Optional<Category> getCatById(int id)
	{
		return categoryRepository.findById(id);	}

}
