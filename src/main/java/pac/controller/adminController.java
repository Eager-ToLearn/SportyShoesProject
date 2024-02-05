package pac.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pac.DTO.ProductsDTO;
import pac.model.Category;
import pac.model.Products;
import pac.repository.CategoryRepository;
import pac.repository.ProductsRepository;
import pac.service.CategoryService;
import pac.service.ProductsService;
//admin
@Controller
public class adminController
{
	public static String uploadDir=System.getProperty("user.dir")+"/src/main/resources/static/PicturesOfProducts";
	
	//@Autowired
	CategoryService categoryService;
	
	//@Autowired
	ProductsService productsService;
	
	
	@GetMapping("/admin")
	public String administrator()
	{
		return "adminHome";
	}
	
	@GetMapping(value="/admin/categories")
	public String getCat(Model model)
	{
		model.addAttribute("categories",categoryService.getAllCategory());
		return "categories";
	}
	
	@GetMapping("/admin/categories/add")
	public String getCatAdd(Model model)
	{
		model.addAttribute("category", new Category());
		return "AddCategory";
	}
	
	@PostMapping("/admin/categories/add")
	public String SaveCat(@ModelAttribute("category") Category category)
	{
		categoryService.addCategory(category);
		return "redirect:/admin/categories";
		
		
	}
	@GetMapping("/admin/categories/delete/{id}")
	public String delCategory(@PathVariable int id)
	{
		categoryService.delCat(id);
		
		return "redirect:/admin/categories";
	}
	@GetMapping("/admin/categories/update/{id}")
	public String updateCategory(@PathVariable int id, Model model)
	{
		Optional<Category> category = categoryService.getCatById(id);
		if(category.isPresent())
		{
			model.addAttribute("category", category.get());
			return "AddCategory"; 
		}
		else
		{
			return "404";
		}
	
	}

	@GetMapping("/admin/products")
	public String products(Model model)
	{
		model.addAttribute("products", productsService.getAllProducts());
		return "Products";
		
	}
	
	@GetMapping("/admin/products/add")
	public String getAddPro(Model model)
	{
		model.addAttribute("productsDTO", new ProductsDTO());
		model.addAttribute("categories", categoryService.getAllCategory());
		
		return "AddProducts";
	}
	
	@PostMapping("/admin/products/add")
	public String addProductPost(@ModelAttribute ("productsDTO") ProductsDTO productsDTO,
			@RequestParam("productsPic") MultipartFile file,
			@RequestParam("image_name") String image_name) throws IOException
//	public String appProductPost(@ModelAttribute("productsDTO") ProductsDTO productsDTO, 
//			@RequestParam("PicturesOfProducts") MultipartFile file, @RequestParam("image_name") String image_name)throws IOException
//			                                   
{
		Products products = new Products();
		
		products.setId(productsDTO.getId());
		products.setName(productsDTO.getName());
		products.setCategory(categoryService.getCatById(productsDTO.getCategoryId()).get());
		products.setPrice(productsDTO.getPrice());
		products.setSize(productsDTO.getSize());
		products.setDescription(productsDTO.getDescription());
		
		
//		products.setId(productsDTO.getId());
//		products.setName(productsDTO.getName());
//		products.setCategory(categoryService.getCatById(productsDTO.getCategoryId()).get());
//		products.setPrice(productsDTO.getPrice());
//		products.setSize(productsDTO.getSize());
//		products.setDescription(productsDTO.getDescription());
		
		String imageUUID;
		if(!file.isEmpty())
		{
			imageUUID = file.getOriginalFilename();
			Path filenameAndPath=Paths.get(uploadDir, imageUUID);
			Files.write(filenameAndPath, file.getBytes());
		}
		else
		{
			imageUUID=image_name;
		}
		
		products.setImage_name(imageUUID);
		productsService.addProducts(products);
		
//		products.setImage_name(imageUUID);
//		productsService.addProducts(products);
		
		products.setColor(productsDTO.getColor());
		
		
		
	return "redirect:/admin/products";
}
	@GetMapping("/admin/product/delete/{id}")
	public String delProducts(@PathVariable int id)
	{
		productsService.delProById(id);
		return "redirect:/admin/products";
	}
//	@GetMapping("/admin/products/update/{id}")
//	public String updateProGet(@PathVariable int id ,Model model)
//	{
//		//List<Products> products = productsService.getProById(id);
//		//Products products = 
//		//Product product = Products.getProductById(id);
//		//Products products = productsService.getProById(id);
//		Products products = productsService.getProById(id);
//		ProductsDTO productsDTO = new ProductsDTO();
//		productsDTO.setId(products.getId());
//		productsDTO.setName(products.getName());
//		productsDTO.setCategoryId(products.getCategory().getId());
//		productsDTO.setPrice(products.getPrice());
//		productsDTO.setSize(products.getSize());
//		productsDTO.setDescription(products.getDescription());
//		productsDTO.setImage_name(products.getImage_name());
//		productsDTO.setColor(products.getColor());
//		
//		
//		model.addAttribute("categories", categoryService.getAllCategory());
//		model.addAttribute("productsDTO", productsDTO);
//		
//		
//	
//		
//		return "AddProducts";
//	}

	
}
