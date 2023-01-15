package proj2;


public class Ogre extends Enemy {
    
    public Ogre(){
        super((int) Math.round((Math.random()*80)+120), (int) Math.round((Math.random()*100)+200));
    }
    
    @Override
    public String attack(){
        return "Ugh!";
        
    }
}
