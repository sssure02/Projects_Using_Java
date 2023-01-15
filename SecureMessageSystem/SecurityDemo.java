package proj1;


import java.util.Scanner;

public class SecurityDemo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SecuritySystem textMessages = new SecuritySystem();
        String main_menu = "\n" +"""
                               Please type one of the following:
                                0 - exit program 
                                1 - send a message 
                                2 - view inbox 
                                3 - view users  """ + "\n";
        
        System.out.println(main_menu);     
        
        while(true){
            int choice = sc.nextInt();
            if (choice == 0){
                    System.out.println("\nThanks for using the Secure Messaging Program. Goodbye!");
                    break;
            } else if(choice == 1){
                    String message;
                    String key;
                    System.out.println("\nSend a message to whom and from whom in the form:");
                    System.out.println("To From Message : Key");
                    System.out.println("\n" + textMessages.view_users());
                    int to = sc.nextInt()- 1;
                    int from = sc.nextInt() - 1;

                    String restOfLine = sc.nextLine();
                    String[] allParts = restOfLine.split(" : ");
                    message = allParts[0];
                    key = allParts[allParts.length -1];

                    textMessages.addMessage(to, from, message, key);
                    System.out.println("Sent message from " + textMessages.usernames.get(from) + " to " + 
                        textMessages.usernames.get(to) + " \"" + message + "\""); 
                    System.out.println(main_menu);
                    continue;
            } else if (choice == 2){
                    System.out.println("\nView your inbox. Who are you?");
                    System.out.println(textMessages.view_users());
                    String nameOfUser = textMessages.usernames.get(sc.nextInt()-1);
                    SecuritySystem.viewInbox(textMessages, nameOfUser);
                    System.out.println(main_menu);
                    continue;
            } else if(choice == 3) {
                    System.out.println("\nUser List: \n");
                    System.out.println(textMessages.view_users());
                    System.out.println(main_menu);
                    continue;
            }   // end if-else
        }  // end while
    } // end main
} // end class
