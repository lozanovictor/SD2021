import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ChatServer{
    public static void main(String[] args){
        try{
            ChatInterfaceImpl obj = new ChatInterfaceImpl();
            Registry registry = LocateRegistry.getRegistry("localhost");
            registry.rebind("ChatServer", obj);
            System.out.println("ChatServer bound in registry");
        }
        catch(RemoteException e){
            System.out.println("ChatServer err: " + e.getMessage());
        }
    }
}