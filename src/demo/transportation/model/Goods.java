package demo.transportation.model;

public class Goods {

	private float weight;
	private double price;
	private Goods goods;
	
	
	
	public Goods(float weight, double price) {
		super();
		this.weight = weight;
		this.price = price;
	}
	
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Good [weight=" + weight + ", price=" + price + "]";
	}
	
	
	
}
