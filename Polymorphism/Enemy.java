package proj2;

public abstract class Enemy {
    private int weight;
    private int height;
    
    public Enemy(int weight, int height){
        this.weight = weight;
        this.height = height;
    }
    
    public void setWeight(int weight){
        this.weight = weight;
    }
    
    public int getWeight(){
        return weight;
    }
    
    public void setHeight(int height){
        this.height = height;
    }
    
    public int getHeight(){
        return height;
    }
    
    public abstract String attack();
}
