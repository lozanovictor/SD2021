import java.util.ArrayList;

public class ParticipantList{
    private ArrayList<Participant> list;

    public ParticipantList(){
        list = new ArrayList<Participant>();
    }

    public boolean addParticipant(Participant p){
        return list.add(p);
    }

    public boolean removeParticipant(int identifier){
        Participant aux;
        aux = getParticipantByIdentifier(identifier);
        if(aux != null)
            return list.remove(aux);
        else
            return false;
    }

    public Participant getParticipantByName(String name){
        Participant aux = null;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getParticipantName().equals(name)){
                aux = list.get(i);
                break;
            }
        }
        return aux;
    }

    public Participant getParticipantByIdentifier(int identifier){
        Participant aux = null;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getParticipantIdentifier() == identifier){
                aux = list.get(i);
                break;
            }
        }
        return aux;
    }

    public Participant[] getListAsArray(){
        Participant[] array;
        array = new Participant[list.size()];
        for(int i = 0; i < array.length; i++){
            array[i] = list.get(i);
        }
        return array;
    }
}