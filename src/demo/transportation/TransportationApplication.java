package demo.transportation;

import java.util.Scanner;

import demo.transportation.model.Container;
import demo.transportation.model.Goods;
import demo.transportation.model.SpecializedContainer;
import demo.transportation.model.TransportationProvider;

public class TransportationApplication {

	public static void main(String[] args) {
		
		System.out.println("For loading any good : enter comma seperated weight and price, e.g: 50,100");
		System.out.println("For Unloading goods: enter unload");
		System.out.println("For getting highest priced good: enter Highest Price");
		System.out.println("For getting transported weight of the container : enter Transported weight");
		System.out.println("For exiting the application enter exit");
		
		TransportationApplication transportationApplication = new TransportationApplication();
		transportationApplication.acceptUserActions();
	}
	
	private void acceptUserActions() {
		
		TransportationProvider transportProvider = new TransportationProvider();
		Container container = new SpecializedContainer(2000);
		transportProvider.generateContainer(container);
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			String command = in.nextLine();
			if(command.equalsIgnoreCase("exit")){
				System.out.println("You asked to exit the application");
				break;
			}else if(command.contains(",")) {
				//load goods in container
				String[] goodsData = command.split(",");
				float weight = Float.parseFloat(goodsData[0]);
				double price = 	Double.parseDouble(goodsData[1]);	
				Goods goods = new Goods(weight, price);
				transportProvider.getContainer().get(0).load(goods);
			}else if(command.contentEquals("unload")) {
				Goods good = transportProvider.getContainer().get(0).unload();
				if(null != good) {
					System.out.println("Unloaded goods from your container is: "+good);
				}
			}else if (command.trim().equalsIgnoreCase("Highest Price")) {
				Goods goods = transportProvider.getContainer().get(0).getHeighestPricedGood();
				System.out.println("The highest priced good in your container is: "+goods);
			}else if (command.trim().equalsIgnoreCase("Transported Weight")) {
				System.out.println("Total weight of transported goods in container is: "+transportProvider.getContainer().get(0).weightOfTransportedGoods());
			}else {
				System.out.println("You have entered an invalid option !!");
			}
		}
	}
}
