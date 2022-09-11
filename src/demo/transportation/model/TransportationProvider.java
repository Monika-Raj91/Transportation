package demo.transportation.model;

import java.util.ArrayList;
import java.util.List;

public class TransportationProvider {

	private List<Container> containers;

	public void generateContainer(Container container) {
		if(containers == null) {
			containers = new ArrayList<Container>();
		}
		containers.add(container);
	}
	
	public List<Container> getContainer() {
		return containers;
	}

}
