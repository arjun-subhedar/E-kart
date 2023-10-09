package tables;
public class DeliveryAgent {
    int AgentID;
    String AgentName;
    int rating;
    public DeliveryAgent(){};
    public DeliveryAgent(int AgentID,String AgentName,int rating){
        this.AgentID=AgentID;
        this.AgentName=AgentName;
        this.rating=rating;
    }
    public int getAgentID() {
        return AgentID;
    }
    public void setAgentID(int agentID) {
        AgentID = agentID;
    }
    public String getAgentName() {
        return AgentName;
    }
    public void setAgentName(String agentName) {
        AgentName = agentName;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    

   


}
