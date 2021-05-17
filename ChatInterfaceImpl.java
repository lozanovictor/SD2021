import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;

public class ChatInterfaceImpl extends UnicastRemoteObject implements ChatInterface{
    private ParticipantList pList;
    private int pIdentifier;
    
    public ChatInterfaceImpl() throws java.rmi.RemoteException {
        super();
        pList = new ParticipantList();
        pIdentifier = 0;
    }

    public int joinGroup(String name, MessageInterface ref) throws java.rmi.RemoteException{
        Participant aux;
        aux = pList.getParticipantByName(name);
        if(aux == null){
            aux = new Participant(name, pIdentifier, ref);
            pIdentifier++;
            if(pList.addParticipant(aux))
                return aux.getParticipantIdentifier();
            else
                return -1;
        }
        else
            return -1;
    }

    public void leaveGroup(int id) throws java.rmi.RemoteException{
        boolean success;
        success = pList.removeParticipant(id);
        Participant aux;
        if(!success)
            System.err.println("Erro saida chat: " + id + " nao encontrado");
    }

    public void message(int id, String msg) throws java.rmi.RemoteException{
        Participant sender;
        Participant[] array;

        sender = pList.getParticipantByIdentifier(id);
        if(sender == null)
            System.err.println("Erro envio mensagem: " + id + " nao encontrado");
        else{
            array = pList.getListAsArray();
            for(int i = 0; i < array.length; i++){
                if(array[i].getParticipantIdentifier() != id){
                    array[i].getParticipantReference().messageNotification(sender.getParticipantName(),msg);
                }
            }
        }
    }
}