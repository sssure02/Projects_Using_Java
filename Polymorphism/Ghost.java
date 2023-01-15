package proj2;


public class Ghost extends Enemy {
    
    public Ghost(){
        super(0,(int) Math.round((Math.random()*60)+90) );    
    }
    
    @Override
    public String attack(){
        return "Boo!";
        
    }
}
