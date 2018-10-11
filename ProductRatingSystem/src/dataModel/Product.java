package dataModel;

public class Product {

	//field
	private String productID;
	
	//constructor
	public Product(String productID) {
		this.productID = productID;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

}
