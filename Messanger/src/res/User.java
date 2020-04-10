package res;

import java.io.Serializable;
import java.net.Socket;

public class User extends User0 implements Serializable {
    private static final long serialVersionUID = 1L;

    private String password;
    private String[] contacts = null;
    public boolean CONNECT = false;



    public User(String nik, String password) {
        super(nik);
        this.password = password;
    }

    public User(String nik, String password, String[] contacts) {
        super(nik);
        this.password = password;
        this.contacts = contacts;
    }
    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

    public User0 getUser0(){
        return this;
    }


}
