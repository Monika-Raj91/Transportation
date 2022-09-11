package test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import demo.transportation.model.Container;
import demo.transportation.model.Goods;
import demo.transportation.model.SpecializedContainer;

public class SpecializedContainerTest {

	Container container;
	
	@Before
	public void setup() {
		container = new SpecializedContainer(1000);
	}
	
	@Test
	public void loadGoodsUptoAllowedWeightTest() {
		Goods goods1 = new Goods(500, 25000);
		boolean isGoodLoaded = container.load(goods1);
		assertTrue(isGoodLoaded);
		
	}
	
	@Test
	public void noUploadIfContainerFullTest() {
		Goods goods1 = new Goods(500, 25000);
		container.load(goods1);
		Goods goods2 = new Goods(1000, 4000);
		boolean isGoodLoaded = container.load(goods2);
		assertFalse(isGoodLoaded);
	}
	
	@Test
	public void unloadGoodsInReverseOrder() {
		Goods goods1 = new Goods(5, 20);
		Goods goods2 = new Goods(10, 25); 
		Goods goods3 = new Goods(15, 30);
		container.load(goods1);
		container.load(goods2);
		container.load(goods3);
		
		Goods unloadedGoods = container.unload();
		assertEquals("Goods are unloaded in reverse order", 15.0, unloadedGoods.getWeight(), 0.01);
		
		unloadedGoods = container.unload();
		assertEquals("Goods are unloaded in reverse order", 10.0, unloadedGoods.getWeight(), 0.01);
	}
	
	
	@Test
	public void unloadEmptyContainerTest() {
		Goods goods = container.unload();
		assertTrue("Unloaded good will be null", goods == null);
	}
	
	
	@Test
	public void getHeighestPricedGoodsTest() {
		Goods goods1 = new Goods(50, 250);
		container.load(goods1);
		Goods goods2 = new Goods(100, 400);
		container.load(goods2);
		Goods goods3 = new Goods(10, 50);
		container.load(goods3);
		Goods goods = container.getHeighestPricedGood();
		assertEquals("Check highest priced good", "Good [weight=100.0, price=400.0]", goods.toString());
	}
	
	@Test
	public void getWeightOfTransportedGoodsTest() {
		Goods goods1 = new Goods(50, 250);
		container.load(goods1);
		Goods goods2 = new Goods(100, 400);
		container.load(goods2);
		Goods goods3 = new Goods(10, 50);
		container.load(goods3);
		
		assertEquals("Test weight of transported goods in container", 160.0, container.weightOfTransportedGoods(), 0.0);
	}
}
