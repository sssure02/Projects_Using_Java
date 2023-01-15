// Sai Sravani Sure
// CIS 2353
// Summer 2022
// Prof. John P. Baugh

package proj3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ImageDemo {
    public static void main(String[] args){
        Scanner infile;
        Scanner sc = new Scanner(System.in);
        ArrayList<Image> imageFiles = new ArrayList<>(); 
                
        try{
            infile = new Scanner(new File("image_info.txt"));
            
            while(infile.hasNext()){
                String line = infile.nextLine();
                String[] arrOfStr = line.split(" ");
                String file_name = arrOfStr[0];
                Image image = new Image(file_name, arrOfStr);   
                imageFiles.add(image);
            }
            
            infile.close();
        } 
        catch(FileNotFoundException ex){
            System.out.println("Error opening file.");
        } 
        
        
        
        System.out.print("What would you like to search for? (Type END to end the program) \n");
                
        while(true){
            String search_for = sc.nextLine();
            if(search_for.equalsIgnoreCase("end")) {
                break;
            }
            String[] parts = search_for.split(" ");
            String toPrint = "" ;
            // Same split as above but will be used for binary search of "or" and "and" in the user input only.
            String[] partsAnother = search_for.split(" "); 
            Arrays.sort(partsAnother);
            int index_or = Arrays.binarySearch(partsAnother, "or");
            int index_and = Arrays.binarySearch(partsAnother, "and");
            if(parts.length == 1){
                String category = parts[0].toLowerCase();
                for(int i = 0; i < imageFiles.size(); i++){
                    String[] values = imageFiles.get(i).get_categories();
                    Arrays.sort(values);
                    int index = Arrays.binarySearch(values, category);
                    if(index >= 0){
                    toPrint += imageFiles.get(i).get_Name() + "\n";
                    }
                }
            } else if( (index_or >= 0) && (index_and < 0) ){
                String category1 = parts[0].toLowerCase();
                String category2 = parts[2].toLowerCase();
                for(int i = 0; i < imageFiles.size(); i++){
                    String[] values = imageFiles.get(i).get_categories();
                    Arrays.sort(values);
                    int index1 = Arrays.binarySearch(values, category1);
                    int index2 = Arrays.binarySearch(values, category2);
                    if((index1 >= 0) || (index2 >=0)){
                    toPrint += imageFiles.get(i).get_Name()+ "\n";
                    }
                }
            } else if((index_or < 0) && (index_and >= 0)){
                String category1 = parts[0].toLowerCase();
                String category2 = parts[2].toLowerCase();
                for(int i = 0; i < imageFiles.size(); i++){
                    String[] values = imageFiles.get(i).get_categories();
                    Arrays.sort(values);
                    int index1 = Arrays.binarySearch(values, category1);
                    int index2 = Arrays.binarySearch(values, category2);
                    if((index1 >= 0) && (index2 >=0)){
                    toPrint += imageFiles.get(i).get_Name()+ "\n";
                    }
                }
            }
            
            if(toPrint.isBlank()){
                System.out.println("\n" + "Your search returned no results.\n" );
            } else {
            System.out.println("\n" + toPrint); }
            System.out.print("What would you like to search for? (Type END to end the program) \n");  
            
            
            
        }  // end while
    }
    
    
}
