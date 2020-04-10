package api;

import Request.ConnectionRequest;
import res.User;
import server.Server;
import server.ServerThread;

import java.util.List;

public interface IConnectionRequest{
    ConnectionRequest connectionRequest = null;
    User getUser();

    boolean connect(Server server, ServerThread serverThread);
}
