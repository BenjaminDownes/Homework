import java.util.ArrayList;

public class Path {
    protected int duration; //Total duration of path
    protected ArrayList<Node> path; //Stores a list of path names in order from start to end.
    Errors error = new Errors();
    //E.G. path = ["Node a", Node b", "Node c"]
    
    public Path() {
    	duration = 0;
    	path = new ArrayList<>();
    }
    
    //returns false if node to be added already exists on the path
    public int append_node(Node n) {
        if(path.contains(n)) //Check if node already exists
            return error.node_loop;
        else {
	    duration += n.get_duration();
	    path.add(n);
            return error.no_error;
        }
    }

    //allows a path to be passed in and set as the current path
    public void set_path(ArrayList<Path> nodeList) {
        path = (ArrayList)nodeList.clone();
    }

    //cycles through entire path to check if there are loops in the path
    //there is a loop in the path if a node exists in the path multiple times
    public int find_loops() {        
        for(int i = 0; i < path.size(); i++) {
            for(int j = i+1; j < path.size(); j++) {
                if(path.get(i).equals(path.get(j))) {
                    return error.node_loop;
                }
            }
        }
        return error.no_error;
    }
    
    //returns false if node could not be removed (doesn't exist in path)
    public boolean remove_node(Node n) {
    	if(path.isEmpty())
            return false;
    	else if(!path.contains(n))
            return false;
        else {
            duration -= n.get_duration();
            path.remove(n);
            return true;
        }
    }
    
    public int get_duration() {
    	return duration;
    }
    
    //public ArrayList<String> get_ //Returns a list with the names of each node in the path
    // E.G. ["a", "b", "c"]
    
    public ArrayList<Node> get_path(){
    	return path;
    }
}
