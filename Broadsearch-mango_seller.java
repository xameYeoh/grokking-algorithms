import java.util.*;

class MangoSellerSearcher {
    MyQueue queue;
    HashMap<String, String[]> hash;
    ArrayList<String> checked;
    
    MangoSellerSearcher(){
        queue = new MyQueue();
        hash = new HashMap<String, String[]>();
        checked = new ArrayList<String>();
        
        hash = addFriendsTo(hash);
        queue.addFriendsOf("You");
    }
    
    HashMap<String, String[]> addFriendsTo(HashMap<String, String[]> hash){
        hash.put("You", new String[]{"Bob", "Clare", "Alice"});
        hash.put("Bob", new String[]{"Peggy", "Anuj"});
        hash.put("Anuj", new String[]{"Peggy", "Anuj"});
        hash.put("Anuj", new String[]{});
        hash.put("Peggy", new String[]{});
        hash.put("Clare", new String[]{"Tom", "Johny"});
        hash.put("Tom", new String[]{});
        hash.put("Johny", new String[]{});
        hash.put("Alice", new String[]{"Peggy"});
        
        return hash;
    }
    
    boolean isMangoSeller(String name){
        checked.add(name);
        return name.endsWith("m");
    }
    
    boolean areThereMangoSellers(){
        while(!queue.isEmpty()){
            String person = queue.poll();
            if(!checked.contains(person)){
                if(isMangoSeller(person)) {
                    System.out.println(person+ " is a mango seller!");
                    return true;
                }
                else {
                    System.out.println(person + " is not a mango seller");
                    queue.addFriendsOf(person);
                }
            }
        }
        System.out.println("There are no mango sellers");
        return false;
    }
    
    class MyQueue extends LinkedList<String> {
        void addFriendsOf(String name){
            String[] friends = hash.get(name);
            for(String friend : friends) this.offer(friend);
        }
    }
     
    public static void main(String[] args){
        new MangoSellerSearcher().areThereMangoSellers();
    }
    
    
}
