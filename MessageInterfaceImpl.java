import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MessageInterfaceImpl extends java.rmi.server.UnicastRemoteObject implements MessageInterface{
    public MessageInterfaceImpl() throws java.rmi.RemoteException {
        super();
    }

    public void messageNotification(String sender, String msg) throws RemoteException{
        System.out.println("["+sender+"] "+msg);
        System.out.print(" >> ");
    }
}