
package proj2;

public class Goblin extends Enemy {
    
    public Goblin(){
        super((int) Math.round((Math.random()+1)*5), (int) Math.round((Math.random()*30)+70));
        
        
    }
  
    @Override
    public String attack(){
        return "Gurgle!";
        
    }
}
