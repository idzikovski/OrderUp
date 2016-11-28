package category;

public class Subcategory {

	String name;
	Integer picture;
	int price;
	
	public Subcategory(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public Subcategory(String name, Integer picture, int price) {
		super();
		this.name = name;
		this.picture = picture;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPicture() {
		return picture;
	}
	public void setPicture(Integer picture) {
		this.picture = picture;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
