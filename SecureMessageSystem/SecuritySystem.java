package proj1;

import java.util.ArrayList;
import java.util.Scanner;

public class SecuritySystem {
    ArrayList<String> usernames = new ArrayList<>();
    ArrayList<SecureMessage> messages = new ArrayList<>();   
    
    public SecuritySystem(){
        usernames.add("Max");
        usernames.add("Ksenia");
        usernames.add("Sally");
        usernames.add("Ali");
        usernames.add("Tyrone");
    }
    
    public void addMessage(int to, int from, String message, String key){
        messages.add(new SecureMessage(message, usernames.get(from), usernames.get(to), key));
    }
    
    public String view_users(){
        String listOfNames = "";
        for (String username : usernames) {
            listOfNames += usernames.indexOf(username)+1 + " - " + username + "\n" ;
        }
        return listOfNames;
    }
    
    public int giveNumMessageOfUser(String name){
       int num = 0; 
       for(SecureMessage message : messages){
           if(message.getDestName().equals(name)){
              num++;
           }
       }
       return num;
    }
    
    public ArrayList<SecureMessage> collectMessagesOfUser(String name){
       ArrayList<SecureMessage> userMessages = new ArrayList<>();
       for(SecureMessage message : messages){
           if(message.getDestName().equals(name)){
              userMessages.add(message);
           }
       }
       return userMessages;
    }
    
    public String showMessagesOfUser(ArrayList<SecureMessage> userMessages){
        String listOfNames = "";
        for (SecureMessage message : userMessages) {
            listOfNames += userMessages.indexOf(message)+1 + " - From " + message.getSourceName() + "\n" ;
        }
        return listOfNames;
    }
    
    public static void viewInbox(SecuritySystem messages, String userName){
        Scanner sc = new Scanner(System.in);
        boolean condition = true;
        System.out.println("\nHello " + userName + " you have " +  messages.giveNumMessageOfUser(userName) +
                " message waiting for you. Which do you want to read? \n Type 0 to go back to main menu.");
        System.out.println("\n(Type the number of the message)");
        ArrayList<SecureMessage> messagesOfUser = messages.collectMessagesOfUser(userName);
        System.out.println(messages.showMessagesOfUser(messagesOfUser));
          
        while(condition){  
            int from_whom = sc.nextInt();
            if(from_whom != 0){
                System.out.println("\nWhat is the key to read your message?");
                String present_key = sc.next();
                String result = messagesOfUser.get(from_whom-1).getMessage(present_key);
                if(!result.equals("Secret key does not match stored key. Message cannot be returned without authentication.")){
                    System.out.println("\nCorrect! Your message is:");
                    System.out.println("\"" + result + "\"");
                    messagesOfUser.remove(messagesOfUser.get(from_whom-1));
                    System.out.println("\nHello " + userName + " you have " +  messages.giveNumMessageOfUser(userName) +
                    " message waiting for you. Which do you want to read? \nType 0 to go back to main menu.");
                    System.out.println(messages.showMessagesOfUser(messagesOfUser));
                    
                } else{
                    System.out.println("\nIncorrect key.");
                    System.out.println("\nHello " + userName + " you have " +  messages.giveNumMessageOfUser(userName) +
                    " message waiting for you. Which do you want to read? \n Type 0 to go back to main menu.");
                    System.out.println("\n(Type the number of the message)");
                    System.out.println(messages.showMessagesOfUser(messagesOfUser));
                }// end if-else
            } else {
                condition = false;
                break;
            }
        } // end while   
    } 
    
}
