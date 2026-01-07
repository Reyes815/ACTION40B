package sample;

public class Animals {
    private String species;
    private boolean canHop;
    private boolean canSwim;
    
    public Animals(String specName, boolean hopper, boolean swimmer) {
        species = specName;
        canHop = hopper;
        canSwim = swimmer;
    }
    
    public boolean canHop() {return canHop;}
    public boolean canSwim() {return canSwim;}
    public String toString() {return species;}
}



