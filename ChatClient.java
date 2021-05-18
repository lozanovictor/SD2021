import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        ChatInterface obj = null;
        MessageInterfaceImpl mRef;
        Scanner sc;
        int chatIdentifier;
        String message;

        try {
            mRef = new MessageInterfaceImpl();
            sc = new Scanner(System.in);
            Registry registry = LocateRegistry.getRegistry(8080);
            obj = (ChatInterface)registry.lookup("ChatServer");
            
            chatIdentifier = obj.joinGroup(args[0], mRef);
            if(chatIdentifier != -1){
                System.out.print(" >> ");
                message = sc.nextLine();
                while(!message.equals("exit")){
                    obj.message(chatIdentifier, message);
                    System.out.print(" >> ");
                    message = sc.nextLine();
                }
                obj.leaveGroup(chatIdentifier);
            }
            else{
                System.out.println("Nao foi possivel entrar no chat");
                System.out.println("Nome possivelmente ja utilizado");
            }

            System.exit(0);
        } catch (Exception e) {
            System.out.println("ChatClient exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
