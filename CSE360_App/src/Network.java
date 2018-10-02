import java.util.ArrayList;
import java.util.HashMap;
//TODO
// Check for duplicate end nodes
import java.util.LinkedHashSet;


public class Network {
	
	private Errors error = new Errors();
	protected int size; //Number of nodes in network
	private Node start; //Start node of network
	private Node end; //End node of network
	
	private static ArrayList<Path> paths; //Stores all paths in the network.
	//Each path is an object that stores a list of path names in order from start to end.
	//E.G. paths = [Path1, Path2, Path3]
	
	private HashMap<String, Node> map; //Keys are node names, values are corresponding node objects
	private HashMap<Node, ArrayList<Path>> pathMap; //Associates a node with a list of paths
	
	
    public Network() {
    	size = 0;
    	paths = new ArrayList<>(); // Array of path objects
    	start = null;
    	end = null;
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
    	update_paths(node, parents);
    	return error.no_error;
    	
    	//TODO
    }
    private int update_paths(Node node, ArrayList<String> parents) {
    	//Store paths relevant to node
    	LinkedHashSet<Path> paths = new LinkedHashSet<Path>(); //Use a set to avoid duplicates
    	
    	//Loop through parent nodes, adding relevant paths to path set
    	for(int i=0; i<parents.size();i++) {
    		Node parent_node = map.get(parents.get(i)); //Get the parent node object    		
    		paths.addAll(pathMap.get(parent_node)); //Add associated paths to path set
    	}
    	
    	// evaluate each path
    	Path[] pathArray = new Path[paths.size()]; // create array to iterate through each path
    	paths.toArray(pathArray); //Copy path linked hash set to the array
    	for(int i=0; i<pathArray.length;i++) {
    		Path path = pathArray[i]; //Load Path object
    		if(!path.append_node(node)) {//Append node to path
    			return error.duplicate_node;
    		}
    	}
    	//Check if node is the end node
    	//If node has the same list of paths as Network.paths then it contains all paths
    	//and is therefore the end node.
    	if(Network.paths.equals(pathMap.get(node))) {
    		if(end == null) {//There is no end node set
    			end = node; //The current node is set as the end node
    		}
    		else { //There are multiple end nodes
    			return error.multiple_end_nodes;
    		}
    	}
    	//TODO
    	
    	return error.no_error;
    }
    
    public boolean isEmpty() {
    	return size == 0;
    }
    
    public ArrayList<Path> get_paths() {
    	return paths;
    }
    
 // The following methods are lower priority as they are not necessary for phase 1.
    
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
    
    
}
