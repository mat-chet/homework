package answers;

import res.User;

import java.io.Serializable;
import java.util.ArrayList;

public class AllUsersRequestResult extends Result implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList<String> users;

    public ArrayList<String> getUsers() {
        return users;
    }

    public AllUsersRequestResult() {
        result = Result.ALL_USERS_RESULT;
        users = new ArrayList<>();
    }
    public void addUserNik(String nik){
        users.add(nik);
        return;
    }
}
