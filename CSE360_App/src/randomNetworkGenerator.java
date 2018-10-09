import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.concurrent.ThreadLocalRandom;
public class randomNetworkGenerator {

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	Network network;
	
	public randomNetworkGenerator() {
		network = new Network();
	}
	
	public Network generate_network(int iterations) {
		
		ArrayList<String> nodes = new ArrayList<String>(); //Store set of created nodes
		
		// Make start node
		System.out.println("Making start node \n");
		String name = randomAlphaNumeric(5);
		int duration = ThreadLocalRandom.current().nextInt(0, 100 + 1);
		ArrayList<String> parents = new ArrayList<String>();
		network.add_node(name, duration, parents);
		nodes.add(name);
		
		System.out.println("Node name: " + name);
		System.out.println("Node duration: " + duration);
		System.out.println("Parents: " + parents.toString() + "\n");
		
		//Generate new nodes
		System.out.println("Generating nodes with " + iterations + " iterations");
		for(int i = 0; i < iterations - 2; i++) {
			parents = new ArrayList<String>();
			//Make node name
			name = randomAlphaNumeric(5);
			System.out.println("Node name: " + name);
			
			//Make node duration
			duration = ThreadLocalRandom.current().nextInt(0, 100 + 1);
			System.out.println("Node duration: " + duration);
			
			//Make parents list
			int num_parents;
			//if(nodes.size() == 1) {
				//num_parents = 1;
			//}
			//else {
				num_parents = ThreadLocalRandom.current().nextInt(1, nodes.size() + 1); // Number of parents to link to
			//}
			System.out.println("Linking to " + num_parents + " parents");
			Collections.shuffle(nodes);//Randomize list of nodes 
			for(int j = 0; j < num_parents; j++) {//Create parents list
				if(!(nodes.get(j) == name)) {//Don't link to self
					System.out.println("Adding " + nodes.get(j) + " as parent.");
					parents.add(nodes.get(j));
				}
				else {//Subtract from j to accommodate for not adding a parent node
					j--;
				}
				
			}
			System.out.println("Parents: " + parents.toString());
			network.add_node(name, duration, parents);
			nodes.add(name);
			System.out.println("Node list: " + nodes.toString() + "\n");
			
		}
		// Generate end node
		System.out.println("Making end node \n");
		name = randomAlphaNumeric(5);
		duration = ThreadLocalRandom.current().nextInt(0, 100 + 1);
		parents = new ArrayList<String>();
		//Link parent nodes
		for(int i = 0; i < nodes.size();i++) {
			if(network.get_node(nodes.get(i)).get_children().isEmpty()){
				parents.add(nodes.get(i));
			}
		}
		
		network.add_node(name, duration, parents);
		nodes.add(name);
		
		System.out.println("Node name: " + name);
		System.out.println("Node duration: " + duration);
		System.out.println("Parents: " + parents.toString() + "\n");
		
		return network;
	}
	
	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	
}
