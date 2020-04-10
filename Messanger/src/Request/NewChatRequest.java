package Request;

import java.io.Serializable;
import java.util.ArrayList;

public class NewChatRequest extends Request implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<String> users;
    public void addUser(String nik){
        users.add(nik);
        return;
    }

    public ArrayList<String> getUsers() {
        return users;
    }

    public NewChatRequest() {
        reqest = Request.NEW_CHAT;
        users = new ArrayList<>();
    }
}
