package Request;

import res.User;

import java.io.Serializable;

public class ConnectionRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    public String getNik() {
        return nik;
    }

    public String getPassword() {
        return password;
    }

    private String nik;
    private String password;

    public ConnectionRequest(String nik, String password) {
        this.nik = nik;
        this.password = password;
    }
    public User getUser(){
        return new User(nik,password);
    }

    @Override
    public String toString() {
        return "ConnectionRequest{" +
               "nik='" + nik + '\'' +
               ", password='" + password + '\'' +
               '}';
    }
}
