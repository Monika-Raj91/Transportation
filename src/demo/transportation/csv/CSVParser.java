package demo.transportation.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import demo.transportation.model.Container;
import demo.transportation.model.Goods;
import demo.transportation.model.SpecializedContainer;
import demo.transportation.model.TransportationProvider;

public class CSVParser {


	public TransportationProvider parseCSVCreateContainers(String path) {
		Scanner sc;
		TransportationProvider transportationProvider = new TransportationProvider();
		try {
			sc = new Scanner(new File(path));
			Container container = null;
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				if(line.contains("Container")) {
					String[] str = line.split(",");
					container = new SpecializedContainer(Float.parseFloat(str[2]));
					container.setId(str[1]);
					transportationProvider.generateContainer(container);
				}else {
					String[] str = line.split(",");
					Goods goods = new Goods(Float.parseFloat(str[0]), Double.parseDouble(str[1]));
					container.load(goods);
				}
			}
		
		}catch (FileNotFoundException e) {
			System.out.println("File for Data loading could not be found!!");
			e.printStackTrace();
		}
		return transportationProvider;
	}
}
