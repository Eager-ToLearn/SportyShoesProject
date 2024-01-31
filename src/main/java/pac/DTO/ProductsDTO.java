package pac.DTO;

public class ProductsDTO 
{
	private int id;
	private String name;
	private int CategoryId;
	private double price;
	private double size;
	private String description;
	private String image_name;
	private String color;
	public ProductsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductsDTO(int id, String name, int categoryId, double price, double size, String description,
			String image_name, String color) {
		super();
		this.id = id;
		this.name = name;
		CategoryId = categoryId;
		this.price = price;
		this.size = size;
		this.description = description;
		this.image_name = image_name;
		this.color = color;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage_name() {
		return image_name;
	}
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "ProductsDTO [id=" + id + ", name=" + name + ", CategoryId=" + CategoryId + ", price=" + price
				+ ", size=" + size + ", description=" + description + ", image_name=" + image_name + ", color=" + color
				+ "]";
	}
	
	

}
