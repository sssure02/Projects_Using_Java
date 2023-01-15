
package proj2;


public class Dragon extends Enemy {
    
    public Dragon(){
        super((int) Math.round((Math.random()*500)+1000), (int) Math.round((Math.random()*750)+1250));
    }
    
    @Override
    public String attack(){
        return "Rawr!";
        
    }
}
