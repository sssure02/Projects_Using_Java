// Sai Sravani Sure
// CIS 2353
// Summer 2022
// Prof. John P. Baugh

package proj3;


public class Image {
    private String name;
    private String[] categories;
   
    
    public Image(String name, String[] categories){
        this.name = name;
        this.categories = categories;
    }
    
    public void set_name(String name){
        this.name = name;
    }
    
    public String get_Name(){
        return name;
    }
    
     public String[] get_categories(){
        return categories;
    }
    
}
