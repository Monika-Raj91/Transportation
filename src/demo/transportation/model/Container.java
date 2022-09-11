package demo.transportation.model;

public abstract class Container {
	private String id;
	private float grossWeight;
	float totalWeight;
	Goods firstGood;
	
	public float getGrossWeight() {
		return grossWeight;
	}

	public void setGrossWeight(float grossWeight) {
		this.grossWeight = grossWeight;
	}
	
	public boolean isEmpty() {
		return firstGood == null;
	}
	
	public float weightOfTransportedGoods() {
		return totalWeight;
	}
	
	public Goods getHeighestPricedGood() { 
		Goods highestPricedGood = firstGood;
		if(firstGood != null) {
			Goods goods = firstGood;
			while(goods != null) {
				if(goods.getPrice() > highestPricedGood.getPrice()) {
					highestPricedGood = goods;
				}
				goods = goods.getGoods();
			}
		}
		return highestPricedGood;
	}
	
	public abstract boolean load(Goods goods);
	
	public abstract Goods unload();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Goods getFirstGood() {
		return firstGood;
	}

	public void setFirstGood(Goods firstGood) {
		this.firstGood = firstGood;
	}
	
	
	
}
