import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import java.util.LinkedHashSet;
//TODO add clear() method
//TODO check for reference to nonexistent parent

public class Network {
	
	private Errors error = new Errors();
	//protected int size; //Number of nodes in network
	private Node start; //Start node of network
	private Node end; //End node of network
	
	private static LinkedHashSet<Path> paths; //Stores all paths in the network.
	//Each path is an object that stores a list of path names in order from start to end.
	//E.G. paths = [Path1, Path2, Path3]
	
	private ArrayList<String> nodeNames; //Maintains a list of all node names
	private LinkedHashSet<String> parentSet; //maintains a set of parent nodes that are referenced by each node
//	private HashMap<Node, ArrayList<String>> nodesMap;
	
	private HashMap<String, Node> nodeMap; //Keys are node names, values are corresponding node objects
	private HashMap<Node, ArrayList<Path>> pathMap; //Associates a node with a list of paths
	
	private HashMap<String, Integer> durationMap; //Maps node names to duration
	private HashMap<String, ArrayList<String>> parentMap; //Maps node names to list of parents
	
	
    /**
     * 
     */
    public Network() {
    	//size = 0;
    	paths = new LinkedHashSet<Path>(); // Array of path objects
    	start = null;
    	end = null;
    	nodeMap = new HashMap<String, Node>();
    	pathMap = new HashMap<Node, ArrayList<Path>>();
    	nodeNames = new ArrayList<String>();
    	parentSet = new LinkedHashSet<String>();
    	//nodesMap = new HashMap<Node, ArrayList<String>>();
    	
    	durationMap = new HashMap<String, Integer>();
    	parentMap = new HashMap<String, ArrayList<String>>();
    }
    
    /**
     * Add a new node to the network.
     * @param name
     * @param duration
     * @param parents
     * @return error code
     */
    public int add_node(String name, int duration, ArrayList<String> parents) {
    	Node node = new Node(name, duration);
    	
    	//Check if node already exists
    	if(durationMap.get(name) != null) {
    		return error.duplicate_node;
    	}
    	
    	//Check for start node
    	else if(parents.isEmpty()) {
    		if(start == null) {
    			start = node; //Placeholder node to indicate start node exists
    			parentMap.put(name, parents);
    		}
    		else {
    			return error.multiple_start_nodes;
    		}
    	}
    	//Add node info to data structures
		durationMap.put(name, duration);
		System.out.println("Name: "+ name + " Parents: "+parents.toString());
		parentMap.put(name, parents);
		nodeNames.add(name);
		parentSet.addAll(parents);
		nodeMap.put(name, node);
		//size++;
		
    	return error.no_error;
    }
    
    
    /**
     * Build the network. If an error is encountered then network building will be aborted and an error code returned.
     * @return error code
     */
    public int build_network() {
    	System.out.println("Network size: " + nodeMap.size());
    	int errorCode = error.no_error;
    	
    	//Check for reference to nonexistent parent
    	for(String parent : parentSet) {
    		if(!nodeNames.contains(parent)) {
    			clear();
    			System.out.println("invalid_parent_reference");
    			return error.invalid_parent_reference;
    		}
    	}
    	
    	// Find end node
    	for(String nodeName : nodeNames) {
    		if(!parentSet.contains(nodeName)) {
    			if(end == null) {//make sure there is no other end node set
    				end = nodeMap.get(nodeName);
    			}
    			else {//An end node already exists!
    				clear();
    				System.out.println("multiple_end_nodes");
    				return error.multiple_end_nodes;
    			}
    		}
    	}
    	
    	//Recursively link nodes starting from end node
    	System.out.println("End node: "+end);
    	build_links(end);
    	
    	
    	//Build paths for the start node
    	ArrayList<Path> pathList = new ArrayList<Path>();
    	for(Node child: start.get_children()) {
    		Path path = new Path();
        	path.append_node(start);
        	path.append_node(child);
        	pathList.add(path);
        	paths.add(path);
        	pathMap.put(child, pathList);
    	}
    	pathMap.put(start, pathList);
    	errorCode = build_paths(start);
    	
    	for(Node child: start.get_children()) {
    		build_paths(child);
    	}
    	
    	
    	
    	System.out.println("Build netowrk error code: " + errorCode);
    	return errorCode;
    }
    
    private void build_links(Node childNode) {
    	System.out.println("build_links: childNode = "+childNode);
    	//Recursively build linked network backwards from the end node
    	
    	//End case
    	if(childNode.get_name() == start.get_name()) {
    		System.out.println("build_links: found start node");
    		return;
    	}
    	for(String parentName : parentMap.get(childNode.get_name())) {
//    		if(parentName == start.get_name()) {
//    			start.add_child(childNode);
//    			return;
//    		}
    		Node parentNode = nodeMap.get(parentName);
    		parentNode.add_child(childNode);
    		build_links(parentNode);
    	}
    	return;
    	
    	
//    	//Look for nodes that are children of current node
//    	ArrayList<String> childNodes = findChildren(currentNode.get_name());
//    	//Link them with current node
//    	for(String child : childNodes) {
//    		Node childNode = new Node(child, durationMap.get(child));
//    		currentNode.add_child(childNode);
//    		build_links(childNode);
//    	}
//    	
    	
    	
    }
    
    private int build_paths(Node node) {
		// TODO Auto-generated method stub
		int errorCode = error.no_error;
		ArrayList<Path> pathList = pathMap.get(node);
		
		// Check if node == end node; return if true
		
		if(node == end) {
			return errorCode;
		}
		else {
			//Add first child node
			Node child = node.get_children().get(0);
			for(Path path : pathList) {
				path.append_node(child);
				pathMap.put(child, pathList);
			}
			
			//Loop through other nodes
			ArrayList<Node> children = node.get_children();
			//Loop through each child ignoring the first child
			for(int i = 1;i <  children.size(); i++) {
				Path newPath = new Path();
				//For each path that node is in, create new path with children[i] appended
				for(Path path : pathList) {
					newPath.set_path(path.get_path());
					newPath.append_node(children.get(i));
				}
				
			}
		}
		
	
		return errorCode;
		
		
//		ArrayList<Path> emptyList = new ArrayList<>();
//		pathMap.put(node, emptyList);
//		
//		return update_paths(node, parentMap.get(node.get_name()));
	}

	private ArrayList<String> findChildren(String parentName) {
		// TODO Auto-generated method stub
    	
    	ArrayList<String> children = new ArrayList<String>(); //child nodes to return
    	ArrayList<String> parents = new ArrayList<String>(); //parents of current searched node
    	String currentNode;
    	
    	for(int i = 0; i < nodeNames.size(); i++) {
    		currentNode = nodeNames.get(i);
    		parents.clear();
    		parents.addAll(parentMap.get(currentNode)); //Load parent list of current node
    		
    		for(int j = 0; j < parents.size(); j++) { //Loop through parents list looking for parentName
    			if(parents.get(j).equals(parentName)) {//Match!
    				children.add(currentNode); //Add current node as child of parentName
    			}
    		}
    	}
    	return children;
		
	}

	/**
     * @param name
     * @param duration
     * @param parents
     * @return an error code associated with Errors.java
     */
    private int add_node_to_network(String name, int duration, ArrayList<String> parents) {
    	if (nodeMap.containsKey(name)) {
    		return error.duplicate_node;
    	}
    	//Create new node object
    	Node node = new Node(name, duration);
    	
    	//Check for start node
    	if(parents.isEmpty()) {
    		//If parents is empty then assume this node is the start node.
        	//If there is already a start node throw an error.
    		if(start == null) { //Check if start node is empty
    			start = node;
    		}else { //It already exists, can't have multiple start nodes!
    			return error.orphaned_node;
    		}
    	}
    	else {//add child node to parent node
    		for(int i=0; i < parents.size(); i++) {
    			//Use map to find each parent node and add the current node as their child
    			nodeMap.get(parents.get(i)).add_child(node);
    		}
    	}
    	nodeMap.put(name, node); //Add new node to map
    	ArrayList<Path> emptyList = new ArrayList<>();
    	pathMap.put(node, emptyList); //Add new node to pathMap
    	//size++; //Increment network size
    	return update_paths(node, parents);
    	
    	//TODO
    }
    /**
     * @param node to evaluate
     * @param Arraylist containing parent nodes of node
     * @return an error code associated with Errors.java
     */
    private int update_paths(Node node, ArrayList<String> parents) {
    	int errorCode = error.no_error;
    	//Build up a set of paths relevant to the given node
    	LinkedHashSet<Path> localPaths = new LinkedHashSet<Path>(); //Use a set to avoid duplicates
    	
    	//Loop through parent nodes, adding relevant paths to localPaths set
    	for(int i=0; i<parents.size();i++) {
    		Node parent_node = nodeMap.get(parents.get(i)); //Get the parent node object
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
    		// Check for a loop
    		int pathError = pathArray[i].append_node(node);
    		if(pathError != error.no_error) {
    			remove_node(node);
    			return pathError;
    		}
//    		if(pathArray[i].append_node(node) == error.no_error) {//Append node to path at position i
//    			errorCode = error.duplicate_node;
//    		}
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
    		//if(end == null) {//There is no end node set
    			end = node; //The current node is set as the end node
    		//}
    		//else { //There are multiple end nodes
    			//return error.multiple_end_nodes;
    		//}
    	}
    	//TODO
    	
    	return errorCode;
    }
    
    /**
     * @param node
     * Remove node from network.
     * Note this does not do any sanity checking and may leave the network in a broken state.
     */
    private void remove_node(Node node) {
    	nodeMap.remove(node); //Remove new node to map
    	pathMap.remove(node); //Remove new node to pathMap
    	//size--; //Decrement network size
    }
    
    private void clear() {
		// clear network contents
    	//size = 0;
    	paths.clear();
    	start = null;
    	end = null;
    	nodeMap.clear();
    	pathMap.clear();
    	nodeNames.clear();
    	parentSet.clear();
    	durationMap.clear();
    	parentMap.clear();
		
	}

	public Node get_node(String name) {
    	return nodeMap.get(name);
    }
    
    public boolean isEmpty() {
    	return nodeMap.size() == 0;
    }
    
    /**
     * @return an ArrayList of paths in the network
     */
    public ArrayList<Path> get_paths() {
    	//Convert paths to ArrayList
    	ArrayList<Path> pathsList = new ArrayList<Path>(paths);
    	//Sort list based on path duration
    	Collections.sort(pathsList, new PathComparator());
    	return pathsList;
    }
    
    public class PathComparator implements Comparator<Path>{
    	@Override
    	public int compare(Path path1, Path path2) {
    		int result;
    		if(path1.get_duration() > path2.get_duration()){
    			result = 1;
    		}
    		else if (path1.get_duration() < path2.get_duration()){
    			result = -1;
    		}
    		else {
    			result = 0;
    		}
    		return result;
    	}
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
    	System.out.println("Network size: " + nodeMap.size());
    	System.out.println("Start node: " + start);
    	System.out.println("End node: " + end);
    	
    	// Print each node
    	System.out.println("Nodes: [NodeName(Duration): Child1, Child2, Child3]\n");
    	//System.out.println("Start node: " + start.get_name()+ "[" + start + "]\n");
    	for(HashMap.Entry<String, Node> pair: nodeMap.entrySet()) {
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
    	for (String name: nodeMap.keySet()){

            String key = name.toString();
            String value = nodeMap.get(name).get_name();  
            System.out.println(key + " -> " + value + "(" + nodeMap.get(name)+")");  
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
    
	public void printDataStructures() {
		printMap();
		printPathMap();
		printPaths();
		System.out.println("Parent set: " + parentSet.toString());
		System.out.println("Parent Map: " + parentMap.toString());
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
