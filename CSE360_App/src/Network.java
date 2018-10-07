import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
//TODO
// Check for duplicate end nodes
import java.util.LinkedHashSet;


public class Network {
	
	private Errors error = new Errors();
	protected int size; //Number of nodes in network
	private Node start; //Start node of network
	private Node end; //End node of network
	
	private static LinkedHashSet<Path> paths; //Stores all paths in the network.
	//Each path is an object that stores a list of path names in order from start to end.
	//E.G. paths = [Path1, Path2, Path3]
	
	private HashMap<String, Node> map; //Keys are node names, values are corresponding node objects
	private HashMap<Node, ArrayList<Path>> pathMap; //Associates a node with a list of paths
	
	
    /**
     * 
     */
    public Network() {
    	size = 0;
    	paths = new LinkedHashSet<Path>(); // Array of path objects
    	start = null;
    	end = null;
    	map = new HashMap<String, Node>();
    	pathMap = new HashMap<Node, ArrayList<Path>>();
    }
    
    /**
     * @param name
     * @param duration
     * @param parents
     * @return an error code associated with Errors.java
     */
    public int add_node(String name, int duration, ArrayList<String> parents) {
    	if (map.containsKey(name)) {
    		return error.duplicate_node;
    	}
    	Node node = new Node(name, duration);
    	if(parents.isEmpty()) {
    		//If parents is empty then assume this node is the start node.
        	//If there is already a start node throw an error.
    		if(start == null) { //Check if start node is empty
    			start = node;
    		}else { //It already exists, can't have multiple start nodes!
    			//TODO
    			return error.orphaned_node;
    		}
    	}
    	else {//add child node to parent node
    		for(int i=0; i < parents.size(); i++) {
    			//Use map to find each parent node and add the current node as their child
    			map.get(parents.get(i)).add_child(node);
    		}
    	}
    	map.put(name, node); //Add new node to map
    	ArrayList<Path> emptyList = new ArrayList<>();
    	pathMap.put(node, emptyList); //Add new node to pathMap
    	size++; //Increment network size
    	update_paths(node, parents);
    	return error.no_error;
    	
    	//TODO
    }
    /**
     * @param node to evaluate
     * @param Arraylisy containing parent nodes of node
     * @return an error code associated with Errors.java
     */
    private int update_paths(Node node, ArrayList<String> parents) {
    	int errorCode = error.no_error;
    	//Build up a set of paths relevant to the given node
    	LinkedHashSet<Path> localPaths = new LinkedHashSet<Path>(); //Use a set to avoid duplicates
    	
    	//Loop through parent nodes, adding relevant paths to localPaths set
    	for(int i=0; i<parents.size();i++) {
    		Node parent_node = map.get(parents.get(i)); //Get the parent node object
    		if(parent_node == start) { //Check if parent is start node
    			//Build new path and add to localPaths list
    			Path path = new Path();
    			path.append_node(parent_node);
    			path.append_node(node);
    			localPaths.add(path);
    			pathMap.get(parent_node).add(path);
    		}
    		else { //Parent is not start node and already part of a path
    			//Add all paths associated with parrent_node to localPaths set
    			localPaths.addAll(pathMap.get(parent_node)); 
    		}
//    		System.out.println("pathMap.get(parent_node):" + pathMap.get(parent_node));
//    		printPathMap();	
    	}
    	// Now all relevant paths are added to localPaths
    	
    	// evaluate each path in localPaths
    	Path[] pathArray = new Path[localPaths.size()]; // create array from localPaths to iterate through each path
    	localPaths.toArray(pathArray); //Copy path linked hash set to the array
    	for(int i=0; i<pathArray.length;i++) {
    		if(pathArray[i].append_node(node) == error.no_error) {//Append node to path at position i
    			errorCode = error.duplicate_node;
    		}
    	}
    	//Update pathMap
    	ArrayList<Path> pathList = new ArrayList<Path>(Arrays.asList(pathArray));//Convert LinkedHashSet to arraylist
    	pathMap.put(node, pathList); //Replace old path list with updated path list for given node
    	
    	//Update global paths set
    	paths.addAll(localPaths);
    	
    	//Check if node is the end node
    	//If node has the same list of paths as Network.paths then it contains all paths
    	//and is therefore the end node.
    	if(Network.paths.equals(localPaths)) {
    		if(end == null) {//There is no end node set
    			end = node; //The current node is set as the end node
    		}
    		else { //There are multiple end nodes
    			return error.multiple_end_nodes;
    		}
    	}
    	//TODO
    	
    	return errorCode;
    }
    
    public Node get_node(String name) {
    	return map.get(name);
    }
    
    public boolean isEmpty() {
    	return size == 0;
    }
    
    /**
     * @return an ArrayList of paths in the network
     */
    public ArrayList<Path> get_paths() {
    	//Convert paths to ArrayList
    	ArrayList<Path> pathsList = new ArrayList<Path>(paths);
    	
    	return pathsList;
    }
    
    
    
    /**
     * Print information about the network to the console.
     * First each node's attributes are printed(name, duration, and children).
     * 
     * Example node formatting:
     * NodeName(Duration): Child1, Child2, Child3
     * 
     * Then each path is printed. Example path formatting:
     * Path1(duration):Node1->Node2->Node3
     */
    public void printInfo() {
    	System.out.println("Network Debug Info:\n");
    	System.out.println("Network size: " + size);
    	
    	// Print each node
    	System.out.println("Nodes: [NodeName(Duration): Child1, Child2, Child3]\n");
    	System.out.println("Start node: " + start.get_name()+ "[" + start + "]\n");
    	for(HashMap.Entry<String, Node> pair: map.entrySet()) {
    		Node node = pair.getValue();
    		String output = "•"; //Create output string
    		output += node.get_name(); //Add name
    		output += "(" + node.get_duration() + "): ";
    		//Print Child Nodes:
    		ArrayList<Node> nodeList = node.get_children();
    		for(int i=0; i < nodeList.size();i++) {
    			output += nodeList.get(i).get_name();
    			if(i != nodeList.size() - 1) {
    				output += ", ";
    			}
    		}
    		System.out.println(output); //Print the current node's info
    	}
    	System.out.println("\n");
    	
    	
    	// Print each path
    	System.out.println("Paths: [PathX(duration):Node1->Node2->Node3]\n");
    	ArrayList<Path> tmpPathList = get_paths();
    	for(int i = 0; i<tmpPathList.size();i++) {
    		Path path = tmpPathList.get(i); //Get current path object
    		String output = "•"; //Create output string
    		output += "Path" + i + "(" + path.get_duration() + "):";
    		for(int j = 0;j<path.path.size();j++) {// Loop through each node in path
    			output += path.path.get(j).get_name();
    			if(j != path.path.size() - 1) {//Check if -> should be added
    				output += "->";
    			}
    		}
    		System.out.println(output);
    	}
    	System.out.println("\n");
    }
    /**
     * Shows the relations between node names and node objects stored in map
     */
    public void printMap() {
    	System.out.println("Map:");
    	for (String name: map.keySet()){

            String key = name.toString();
            String value = map.get(name).get_name();  
            System.out.println(key + " -> " + value + "(" + map.get(name)+")");  
    	} 
    	System.out.println("\n");
	}
    /**
	 * Shows the relations between node objects and path lists stored in pathMap
	 */
	public void printPathMap() {
		System.out.println("pathMap:");
		for (Node name: pathMap.keySet()){
	
	        String key = name.get_name();
	        String value = "";
	        if(!(pathMap.get(name) == null)) {
	        	 value = pathMap.get(name).toString();
	        	 System.out.println(key + " -> " + value);
	        }
	         
	          
		} 
		System.out.println("\n");
	}
	
	public void printPaths() {
		System.out.println("paths:");
		System.out.println(paths.toString() + "\n");
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
