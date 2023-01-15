
package proj4;


public class Album {
    private String nameAlbum;
    private int albumID;
    private int artist_id;
    
    public Album(int albumID, int artist_id, String nameAlbum){
        this.nameAlbum = nameAlbum;
        this.albumID = albumID;
        this.artist_id = artist_id;
    }
    
    public String get_albumName(){
        return nameAlbum;
    }
    
    public void set_albumName(String nameAlbum){
        this.nameAlbum = nameAlbum;
    }
    
    public int get_albumID(){
        return albumID;
    }
    
    public void set_albumID(int albumID){
        this.albumID = albumID;
    }
    
    public int get_artist_id(){
        return artist_id;
    }
    
    public void set_artist_id(int artist_id){
        this.artist_id = artist_id;
    }
}
