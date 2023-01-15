package proj1;

public class SecureMessage {
    private String message;
    private String sourceName;
    private String destName;
    private String key;
  
    public SecureMessage(String message, String sourceName, String destName, String key){
        this.message = message;
        this.sourceName = sourceName;
        this.destName = destName;
        this.key = key;
    } // end const
    
    public String getMessage(String key){
        if(this.key.equals(key)){
            return message;
        } else {
            return "Secret key does not match stored key. Message cannot be returned without authentication.";
        }
    } // end getMessage
    
    public String getSourceName(){
        return sourceName;
       
    } // end getSourceName
    
    public String getDestName(){
        return destName;
       
    } // end getDestName
    
} // end class
