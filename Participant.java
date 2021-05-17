public class Participant{
    private String name;
    private int identifier;
    private MessageInterface mRef;

    public Participant(String name, int identifier, MessageInterface mRef){
        this.name = name;
        this.identifier = identifier;
        this.mRef = mRef;
    }

    public String getParticipantName(){
        return name;
    }

    public int getParticipantIdentifier(){
        return identifier;
    }

    public MessageInterface getParticipantReference(){
        return mRef;
    }
}