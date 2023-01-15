package proj2;
import java.util.ArrayList;

public class EnemyDemo {
    public static void main(String[] args){
        ArrayList<Enemy> enemies = new ArrayList<>(); 
                
        int i = 0;
        while(i < 100){
            double n1 = Math.round((Math.random()*3)+1);
            int num = (int) n1;
            
            switch (num) {
                case 1:
                    enemies.add(new Goblin());
                    break;
                case 2:
                    enemies.add(new Ghost());
                    break;
                case 3:
                    enemies.add(new Ogre());
                    break;
                case 4:
                    enemies.add(new Dragon());
                    break;
            }
            i++;
        }
        
        for(int j = 0; j < enemies.size(); j++){
            System.out.println(enemies.get(j).attack());
        }
        
    }
}
