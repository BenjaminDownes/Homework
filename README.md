# class Node(name, duration, dependencies)

private int duration

private list dependencies

private string name

## get_paths()
return list of path objects

## get_dependencies()
return list of node objects

## set_dependencies(list of node objects)

## add_dependency(node object)

## remove_dependency(node object)

## get_name()
return node name

## set_name(string)

---
# class Path()

## get_duration()
return path's total duration

## get_path()
private int duration

private list path

return list of strings containing node names

e.g. ["a", "b", "c"]
