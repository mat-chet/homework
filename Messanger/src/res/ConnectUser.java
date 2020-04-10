package res;

import Request.ConnectionRequest;
import answers.ConnectionRequestResult;
import api.IConnectionRequest;
import server.Server;
import server.ServerThread;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConnectUser implements IConnectionRequest, Serializable {


    private static final long serialVersionUID = 1L;


    @Override
    public User getUser(){
        return connectionRequest.getUser();
    }
    private ConnectionRequest connectionRequest;

    public ConnectUser(ConnectionRequest connectionRequest) {
        this.connectionRequest = connectionRequest;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    public boolean connect(Server server, ServerThread serverThread) {
        CopyOnWriteArrayList<User> userList = server.getUsers();

        for(int i = 0;i<userList.size();i++){
            if(userList.get(i).getNik().equals(connectionRequest.getNik())
               && userList.get(i).checkPassword(connectionRequest.getPassword())
               && !userList.get(i).CONNECT) {
                //readUser.unlock;
                serverThread.setUser(userList.get(i));
                server.addServerThread(serverThread);
                return true;
            }

        }

        return false;

    }

    @Override
    public String toString() {
        return "ConnectUser{" +
               "connectionRequest=" + connectionRequest +
               '}';
    }
}
