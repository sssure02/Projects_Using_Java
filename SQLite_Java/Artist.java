
package proj4;

import java.util.ArrayList;


public class Artist {
    private String artistName;
    private int artistID;
    private ArrayList<Album> artistAlbums;   
    
    public Artist(String artistName, int artistID){
        this.artistName = artistName;
        this.artistID = artistID;
        artistAlbums = new ArrayList<>();
    }
    
    public String get_artistName(){
        return artistName;
    }
    
    public void set_artistName(String artistName){
        this.artistName = artistName;
    }
    
    public int get_artistID(){
        return artistID;
    }
    
    public ArrayList<Album>  get_albumlist(){
        return artistAlbums;
    }
    
    public void set_artistID(int artistID){
        this.artistID = artistID;
    }
    
    public void add_album(Album album){
        
        if(artistAlbums.isEmpty()) {
            artistAlbums.add(album);
        } else if(artistAlbums.size() == 1){
            String albumNAME = artistAlbums.get(0).get_albumName();
            if(albumNAME.compareTo(album.get_albumName()) < 0){
                artistAlbums.add(album);
            } else {
                artistAlbums.add(0,album);
            }
        } else {
            int i = 0;
            while(i < artistAlbums.size()){
                String albumNAME = artistAlbums.get(i).get_albumName();
                if(albumNAME.compareTo(album.get_albumName()) < 0){
                    i++;
                } else {
                    artistAlbums.add(i,album);
                    break;
                }
            }
            
            if(i == artistAlbums.size()){
                artistAlbums.add(album);
            }
        }
        
        
    }
    
    public String get_albumName(int a){
        return artistAlbums.get(a).get_albumName();
    }
}
