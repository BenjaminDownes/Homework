import java.util.ArrayList;
import java.util.HashMap;
//TODO
// Check for duplicate end nodes


public class Network {
	
	private Errors error = new Errors();
	protected int size; //Number of nodes in network
	private Node start; //Start node of network
	
	private ArrayList<Path> paths; //Stores all paths in the network.
	//Each path is an object that stores a list of path names in order from start to end.
	//E.G. paths = [Path1, Path2, Path3]
	
	private HashMap<String, Node> map; //Keys are node names, values are corresponding node objects
	private HashMap<Node, ArrayList<Path>> pathMap;
	
	
    public Network() {
    	size = 0;
    	paths = new ArrayList<>(); // Array of path objects
    	start = null;
    	map = new HashMap<String, Node>();
    	pathMap = new HashMap<Node, ArrayList<Path>>();
    }
    
    public int add_node(String name, int duration, ArrayList<String> parents) {
    	if (map.containsKey(name)) {
    		return error.duplicate_node;
    	}
    	Node node = new Node(name, duration);
    	if(parents.isEmpty()) {
    		//If parents is empty then assume this node is the start node.
        	//If there is already a start node throw an error.
    		if(start == null) { //Check if start node is empty
    			start = new Node(name, duration);
    		}else { //It already exists, can't have multiple start nodes!
    			//TODO
    			return error.orphaned_node;
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
    	update_paths(node);
    	return error.no_error;
    	
    	//TODO
    }
    private int update_paths(Node node) {
    	//List of paths for given node
    	ArrayList<Path> paths = pathMap.get(node);
    	//TODO
    	
    	return error.no_error;
    }
    
//    public void insert_node(String name, int duration, ArrayList<String> parents, ArrayList<String> children) {
//    	//TODO
//    }
    
//    public void link_nodes(String parent, String child) {
//    	//TODO
//    	map.get(parent).add_child(map.get(child));
//    }
    
//    public boolean remove_node(String name) {
//    	//TODO
//    	return false; //Placeholder
//    }
    
    public boolean isEmpty() {
    	return size == 0;
    }
    
    public ArrayList<Path> get_paths() {
    	return paths;
    }
}
