package shoppingcart;


// POJO for Product
public class Product {
	int Id,quantity,price;
	String name;
	
	public Product(int Id, String name, int quantity,int price) {
		this.Id = Id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "[Id: " + this.Id + "\tNAME: " + this.name + "\tQUANTITY:" + this.quantity + " \tPRICE: " + this.price + " ]";
	}
	
	
}
