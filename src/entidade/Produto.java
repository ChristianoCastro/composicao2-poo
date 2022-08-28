package entidade;


public class Produto {
    private String name;
	private Double price;
	
	public Produto(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public Produto(String productName, double productPrice) {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}