package pac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pac.model.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> 
{

	List<Products> findByCategoryId(int id);
	

}
