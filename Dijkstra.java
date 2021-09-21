import java.util.*;

class Dijkstra{
    HashMap<String, HashMap<String, Double>> graph;
    HashMap<String, Double> costs;
    HashMap<String, String> parents;
    ArrayList<String> processed;
    
    Dijkstra(){
        graph = new HashMap<String, HashMap<String, Double>>();
        
        graph.put("start", new HashMap<String, Double>());
        graph.get("start").put("A", 6.0);
        graph.get("start").put("B", 2.0);
        
        graph.put("A", new HashMap<String, Double>());
        graph.get("A").put("fin", 1.0);
        
        graph.put("B", new HashMap<String, Double>());
        graph.get("B").put("A", 3.0);
        graph.get("B").put("fin", 5.0);
        
        graph.put("fin", new HashMap<String, Double>());
        
        costs = new HashMap<String, Double>();
        
        costs.put("A", 6.0);
        costs.put("B", 2.0);
        costs.put("fin", Double.POSITIVE_INFINITY);
        
        parents = new HashMap<String, String>();
        
        parents.put("A", "start");
        parents.put("B", "start");
        parents.put("fin", null);
        
        processed = new ArrayList<String>();
    }
    
    String getNearestNode(){
        String nearestNode = null;
        Double lowestCost = Double.POSITIVE_INFINITY;
        
        for(String node : costs.keySet()){
            Double nodeCost = costs.get(node);
            if(nodeCost < lowestCost && !processed.contains(node)) {
                lowestCost = nodeCost;
                nearestNode = node;
            }
        }
        return nearestNode;
    }
    
    void go(){
        String node = getNearestNode();
        
        while(node != null){
            Double cost = costs.get(node);
            HashMap<String, Double> neighbours = graph.get(node);
            for(String name : neighbours.keySet()){
                Double newCost = cost + neighbours.get(name);
                if(newCost < costs.get(name)){
                    costs.replace(name, newCost);
                    parents.replace(name, node);
                }
            }
            processed.add(node);
            node = getNearestNode();
        }
    }
    
    public static void main(String[] args){
        Dijkstra d = new Dijkstra();
        d.go();
        System.out.println(d.costs);
    }
    
}
