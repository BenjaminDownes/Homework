import java.util.ArrayList;

public class Path {
    protected int duration; //Total duration of path
    protected ArrayList<String> path; //Stores a list of path names in order from start to end.
    //E.G. path = ["Node a", Node b", "Node c"]
    
    public Path() {
    	duration = 0;
    	path = new ArrayList<>();
    }
    
    //returns false if node to be added already exists on the path
    public boolean append_node(Node n) {
        if(path.contains(n.get_name()))
            return false;
        else {
	    duration += n.get_duration();
	    path.add(n.get_name());
            return true;
        }
    }
    
    //returns false if node could not be removed (doesn't exist in path)
    public boolean remove_node(Node n) {
    	if(path.isEmpty())
            return false;
    	else if(!path.contains(n.get_name()))
            return false;
        else {
            duration -= n.get_duration();
            path.remove(n.get_name());
            return true;
        }
    }
    
    public int get_duration() {
    	return duration;
    }
    
    public ArrayList<String> get_path(){
    	return path;
    }
}
