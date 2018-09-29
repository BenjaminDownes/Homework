import java.util.ArrayList;

public class Path {
    protected int duration; //Total duration of path
    protected ArrayList<String> path; //Stores a list of path names in order from start to end.
    //E.G. path = ["Node a", Node b", "Node c"]
    
    public Path() {
    	duration = 0;
    	path = new ArrayList<>();
    }
    
    public void add_node(String name) {
    	//todo
    }
    
    public boolean remove_node(String name) {
    	//todo
    	return false; //Placeholder
    }
    
    public int get_duration() {
    	return duration;
    }
    
    public ArrayList<String> get_path(){
    	return path;
    }
}
