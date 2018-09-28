# class Network()

## 

# class Node(name, duration, dependencies)

private int duration

private list children

private string name

## get_paths()
return list of path objects

## get_children()
return list of node objects

## set_children(list of node objects)

## add_child(node object)

## remove_child(node object)

## get_name()
return node name

## set_name(string)

---
# class Path()

## add_node(string)

## remove_node(string)

## get_duration()
return path's total duration

## get_path()
private int duration

private list path

return list of strings containing node names

e.g. ["a", "b", "c"]
