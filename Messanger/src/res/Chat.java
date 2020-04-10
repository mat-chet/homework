package res;

import api.ISave;

import java.io.Serializable;
import java.util.ArrayList;

public class Chat implements Serializable {
    @Override
    public String toString() {
        return "Chat{" +
               "id=" + id +
               '}';
    }

    private static final long serialVersionUID = 1L;


    private final int id;

    public int getId() {
        return id;
    }

    private ArrayList<String> users;
    private ArrayList<Message> messages;

    public ArrayList<String> getUsers() {
        return users;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public Chat(ArrayList<String> users, ArrayList<Message> messages, int id) {
        this.id = id;
        this.users = users;
        this.messages = messages;
    }

    public void addMess(ArrayList<Message> arr){
        messages.addAll(arr);
    }

    public void addMess(Message mes){
        messages.add(mes);
    }

    public void addUser(String uu){
        users.add(uu);
    }





    public void save(ISave out) {


        out.save(messages);

    }

    public UsersChatID getUsersChatID(){
        UsersChatID usersChatID = new UsersChatID(users,id);
        return usersChatID;
    }

}
