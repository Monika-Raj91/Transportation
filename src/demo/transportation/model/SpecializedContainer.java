package demo.transportation.model;

public class SpecializedContainer extends Container{

	private float grossWeight;
	
	public SpecializedContainer(float grossWeight) {
		super();
		this.grossWeight = grossWeight;
	}

	@Override
	public boolean load(Goods goods) {
		if((totalWeight == grossWeight) || ((totalWeight+goods.getWeight()) > grossWeight )) {
			System.out.println("The container is full!!  No more Goods can be added");
			return false;
		}
		
		goods.setGoods(firstGood);
		firstGood = goods;
		totalWeight += goods.getWeight();
		return true;
	}

	@Override
	public Goods unload() {
		
		if(this.isEmpty()) {
			System.out.println("The container is empty!!  You cannot unload it");
			return null;
		}
		
		Goods unloadedGood = firstGood;
		firstGood = firstGood.getGoods();
		totalWeight = totalWeight - unloadedGood.getWeight();
		return unloadedGood;
	}
	
}
