
package proj4;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Proj4 {
    public static void main(String[] args){
        Connection connection;
        MusicDB newDB =  new MusicDB();
        
        try{
            connection  = MusicDB.getConnection();
            Statement statement = connection.createStatement();
            
            String query1 = "SELECT * FROM Artists";
            ResultSet product1 = statement.executeQuery(query1);
            
            while(product1.next()){
               newDB.add_artist(product1.getString("Name"), product1.getInt("ArtistID"));
            }
            
            product1.close();
            
            String query2 = "SELECT * FROM Albums";
            ResultSet product2 = statement.executeQuery(query2);
            
            while(product2.next()){
              newDB.add_album(product2.getInt("AlbumID"), product2.getInt("ArtistID"),product2.getString("Name") );
              
            }
            
            product2.close();
            
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
        ArrayList<Artist> all_artists = newDB.get_allArtists();
        ArrayList<String> all_albums = newDB.get_allAlbums(all_artists);
        System.out.println("Artist and Album Listing" + "\n");
        
        System.out.println("Artists");
        System.out.println("----------");
        for(int i = 0; i < all_artists.size(); i++){
            System.out.println(all_artists.get(i).get_artistName());
        }
        
        System.out.println("\n" + "Albums");
        System.out.println("------------");
        for(int i = 0; i < all_albums.size(); i++){
            System.out.println(all_albums.get(i));
        }
        
        
        System.out.println("\n" + "Albums by Artist");
        System.out.println("-------------------");
        for(int i = 0; i < all_artists.size(); i++){
            System.out.println(all_artists.get(i).get_artistName());
            for(int j = 0; j < all_artists.get(i).get_albumlist().size(); j++){
                System.out.println("\t" + all_artists.get(i).get_albumName(j));
            }
        }
        
    }
    
    
}
