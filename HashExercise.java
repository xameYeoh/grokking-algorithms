import java.util.*;
class HashExercise{
    HashMap<String, Boolean> hash = new HashMap<String, Boolean>();
    
    void checkVoter(String name){
        if(hash.containsKey(name)) System.out.println("Kick them out!");
        else {
            hash.put(name, true);
            System.out.println("Let them vote!");
        }
    }
    
    public static void main(String[] args){
        HashExercise hash = new HashExercise();
        hash.checkVoter("Mike");
        hash.checkVoter("Mike");
    }
}
