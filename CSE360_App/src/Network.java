import java.util.ArrayList;
import java.util.HashMap;

public class Network {
	
	protected int size; //Number of nodes in network
	private Node start; //Start node of network
	
	private ArrayList<Path> paths; //Stores all paths in the network.
	//Each path is an object that stores a list of path names in order from start to end.
	//E.G. paths = [Path1, Path2, Path3]
	
	private HashMap<String, Node> map; //Keys are node names, values are corresponding node objects
	
	
    public Network() {
    	size = 0;
    	paths = new ArrayList<>(); // Array of path objects
    	start = null;
    	map = new HashMap<String, Node>();
    }
    
    public void add_node(String name, int duration, ArrayList<String> parents) {
    	
    	Node node = new Node(name, duration);
    	if(parents.isEmpty()) {
    		//If parents is empty then assume this node is the start node.
        	//If there is already a start node throw an error.
    		if(start == null) { //Check if start node is empty
    			start = new Node(name, duration);
    		}else { //It already exists, can't have multiple start nodes!
    			//TODO
    			//Throw ERROR
    		}
    	}
    	else {
    		for(int i=0; i < parents.size(); i++) {
    			//add child node to parent node
    			map.get(parents.get(i)).add_child(node);
    		}
    	}
    	map.put(name, node); //Add new node to map
    	size++; //Increment network size
    	
    	//TODO
    }
    
    public void insert_node(String name, int duration, ArrayList<String> parents, ArrayList<String> children) {
    	//TODO
    }
    
    public void link_nodes(String parent, String child) {
    	//TODO
    	map.get(parent).add_child(map.get(child));
    }
    
    public boolean remove_node(String name) {
    	//TODO
    	return false; //Placeholder
    }
    
    public boolean isEmpty() {
    	return size == 0;
    }
    
    public ArrayList<Path> get_paths() {
    	return paths;
    }
}
