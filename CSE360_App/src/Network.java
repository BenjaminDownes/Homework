import java.util.ArrayList;

public class Network {
	
	protected int size; //Number of nodes in network
	private Node start; //Start node of network
	private ArrayList<Path> paths; //Stores all paths in the network.
	//Each path is an object that stores a list of path names in order from start to end.
	//E.G. paths = [Path1, Path2, Path3]
	
	
    public Network() {
    	size = 0;
    	paths = new ArrayList<>(); // Array of path objects
    	start = null;
    }
    
    public void add_node(String name, int duration, ArrayList<String> parents) {
    	
    	if(parents.isEmpty()) {
    		//If parents is empty then assume this node is the start node.
        	//If there is already a start node should this case throw an error and do nothing? Or should it add an
        	//orphaned node anyway?
    		start = new Node();
    	}
    	
    	//TODO
    }
    
    public void insert_node(String name, int duration, ArrayList<String> parents, ArrayList<String> children) {
    	//todo
    }
    
    public void link_nodes(String parent, String child) {
    	//todo
    }
    
    public boolean remove_node(String name) {
    	//todo
    	return false; //Placeholder
    }
    
    public boolean isEmpty() {
    	return size == 0;
    }
    
    public ArrayList<Path> get_paths() {
    	return paths;
    }
}
