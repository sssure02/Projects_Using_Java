
package proj4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


public class MusicDB {
    
    private ArrayList<Artist> artists;
    
    
    public MusicDB(){
        artists = new ArrayList<>();
        
    }
    
    public ArrayList<Artist> get_allArtists(){
        return artists;
    
    }
    
    public ArrayList<String> get_allAlbums(ArrayList<Artist> all_artists){
        ArrayList<String> albums = new ArrayList<>();
        
        for(int i = 0; i < all_artists.size(); i++){
            Artist temp = all_artists.get(i);
            for(int j = 0; j < temp.get_albumlist().size(); j++){
                String album = temp.get_albumName(j);
                if(albums.isEmpty()) {
                    albums.add(album);
            
                } else if(albums.size() == 1){
                    String albumNAME = albums.get(0);
                    if(albumNAME.compareTo(album) < 0){
                        albums.add(album);
                    } else {
                        albums.add(0,album);
                    }
            
                } else {
                    int k = 0;
                    while(k < albums.size()){
                        String albumNAME = albums.get(k);
                        if(albumNAME.compareTo(album) < 0){
                            k++;
                    
                        } else {
                            albums.add(k,album);
                            break;
                        }
                    }
            
                    if(k == albums.size()){
                        albums.add(album);
            
                    }
                }
            }
        }

        
        return albums;
    }
    
    public void add_artist(String artistName, int artistID){
        Artist new_artist = new Artist(artistName, artistID);
        
        if(artists.isEmpty()) {
            artists.add(new_artist);
        } else if(artists.size() == 1){
            String artistNAME = artists.get(0).get_artistName();
            if(artistNAME.compareTo(artistName) < 0){
                artists.add(new_artist);
            } else {
                artists.add(0,new_artist);
            }
        } else {
            int i = 0;
            while(i < artists.size()){
                String artistNAME = artists.get(i).get_artistName();
                if(artistNAME.compareTo(artistName) < 0){
                    i++;
                } else {
                    artists.add(i,new_artist);
                    break;
                }
            }
        }
        
    }
    
    public void add_album(int albumID, int artistID, String albumName){
        Album album = new Album(albumID, artistID, albumName);
        int i = 0;
        while(i < artists.size()){
            if(artists.get(i).get_artistID() == artistID){
               artists.get(i).add_album(album);
               break;
            }
            i++;
        }
        
    }
    
   public static Connection getConnection() throws SQLException{
        String dburl = "jdbc:sqlite:music_artists.sqlite";
        Connection connection  = DriverManager.getConnection(dburl);
        
        return connection;
    }
    
}
