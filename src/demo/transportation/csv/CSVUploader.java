package demo.transportation.csv;

import demo.transportation.model.Container;
import demo.transportation.model.Goods;
import demo.transportation.model.TransportationProvider;

public class CSVUploader {
	private CSVParser csvParser;
	
	public static void main(String[] args) {
		
		String path = "C:\\Users\\Monika\\powercloud\\Transportation\\src\\demo\\transportation\\data.csv";
		CSVUploader csvUploader = new CSVUploader();
		TransportationProvider transportProvider = csvUploader.createTransportationProviderFromCSV(path);
		csvUploader.printContainerGoods(transportProvider);	
   }
	
	private TransportationProvider createTransportationProviderFromCSV(String path) {
		csvParser = new CSVParser();
		return csvParser.parseCSVCreateContainers(path);	
	}
	
	private void printContainerGoods(TransportationProvider transportationProvider) {
		transportationProvider.getContainer().stream().forEach(containerInstance -> {
			System.out.println("Goods in Container id "+containerInstance.getId()+" are :");
			
			if(((Container) containerInstance).getFirstGood() != null) {
				Goods goods = ((Container) containerInstance).getFirstGood();
				while(null != goods) {
					System.out.println(goods);
					goods = goods.getGoods();
				}
				System.out.println();
			}
		});
	}

}
