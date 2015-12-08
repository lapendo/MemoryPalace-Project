import java.util.*;
import java.util.Scanner;



public class MemoryPalace{
    
    private Map<String, List<String>> memoryPalace;
    private List<String> memoryTour;
    private Set<String> items;
    
    /** Constructs an  empty Memory Palace 
      */
    public MemoryPalace(){
        
        this.memoryTour = new LinkedList<String>();
        this.items = new HashSet<String>();
        this.memoryPalace = new HashMap<String, List<String>>();
     
    }

    
    /**Returns a map representation of the Memory Palace
      * 
      * Returns the map representation of the Memory Palace where each location
      * is a key that points to a linked list containing the item stored at 
      * that object and the description used to help remember
      * 
      * @return the map of the memory palace associating the locations to 
      * objects
      */ 
    public Map<String,List<String>> returnMap(){
        return this.memoryPalace;
    }
    
    /**Returns the Set of items to be remembered
      * 
      * @return the set of objects to be remembered
      */ 
    
    public Set<String> returnItems(){
        return this.items;
    }
    
    /** Adds a new memory to a new location at the end of the tour
      * 
      * @param location the string of the new location to store the memory
      * @param object the object to be placed at that location
      * @param bizarreDescription the bizarre and memorable description 
      * associated with the item and place
      */ 
    public void addMemory(String location, String object, String 
                              bizarreDescription){
        List<String> describedObject = new LinkedList<String>();
        describedObject.add(bizarreDescription);
        describedObject.add(object);
        this.memoryTour.add(location);
        this.items.add(object);
        this.memoryPalace.put(location, describedObject);
    }
    
    /**Tests whether a given item is in the memory palace
      * 
      * @param item string to check if object in memory palace
      * @return boolean true if item in memory palace, false otherwise
      */ 
    public boolean contains(String item){
        return items.contains(item); 
    }
    
    /**Removes an object from the memory palace based on its location
      * 
      * Removes the location, item pair from the map, the item from the set,
      * and the location from the linked list
      * 
      * @param location the location to remove from the memory palace
      */ 
    public void remove(String location){
        this.memoryTour.remove(location);
        this.items.remove(memoryPalace.get(location));
        this.memoryPalace.remove(location);
        
    }
    
    /**Returns a String representation of the places in the memory palace
      * 
      * @return a string representation of the tour through the places in
      * the memory palace
      */ 
    public String tourString(){
        String s = "";
        for (String i : memoryTour){
         s += i + " -> ";   
        }
        return s.substring(0, s.length() - 4 );
    }
    
    
    /** Returns a string representation of a tour through the memory palace
      * 
      * Gives a string representation of the memory palace, returning a string
      * representation of the place, the object that was stored there, as well 
      * as the description used to remember the item
      * 
      * @return the string representation of the complete tour through the 
      * memory palace
      */ 
    public String tourPalace(){
        String s = "";
        for (String i: memoryTour){
            List<String> description = memoryPalace.get(i);
            String weirdDescription = description.get(0);
            String itemToStore = description.get(1);
            s = s + "At the " + i + ", I stored " + itemToStore + ", which I "
                + "remembered by thinking about " + weirdDescription + ". -> ";
            
        }
        return s.substring(0, s.length() - 4);
    }
    
    /** Main Function
      * 
      * Prompts user for inputs for the place, item, and description
      * Ends once user inputs "stop" 
      */ 
    public static void main(String[] args){
       
        
        Scanner userInput = new Scanner(System.in).useDelimiter("\\n");
        MemoryPalace n = new MemoryPalace();
        System.out.print("Enter the item you would like to remember: ");
        String item = userInput.next();
        System.out.print("Where would you like to place this item in " +
                         "your memory palace? ");
        String place = userInput.next();
        System.out.print("Now come up with a crazy description of your item in"
                             + " this place to help you remember: ");
        String bizarreDescription = userInput.next();
        n.addMemory(place, item, bizarreDescription);
        while (true){
            System.out.print("Enter the item you would like to remember: ");
             item = userInput.next();
             if (item.equals("stop")){
                 break;
             }
            System.out.print("Where would you like to place this item in " +
                         "your memory palace? ");
            place = userInput.next();
            if (place.equals("stop")){
                break;
            }
            System.out.print("I will remember this by thinking about this"
                                 + " bizarre image: ");
            bizarreDescription = userInput.next();
            if (bizarreDescription.equals("stop")){
                break;
            }
            n.addMemory(place, item, bizarreDescription);
        }

        System.out.println("Your list of items to be remembered: " + 
                           n.returnItems());
        System.out.println("The key, value pairs associating each location" + 
                           " with the description and item: " + n.returnMap());
        System.out.println(n.tourPalace());
  
    }
  
}