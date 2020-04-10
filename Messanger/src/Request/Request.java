package Request;

import java.io.Serializable;

public class Request implements Serializable {

    private static final long serialVersionUID = 1L;

    public int reqest;
    public final static int ERROR = -1;
    public final static int NEW_CHAT = 0;
    public final static int ALL_USERS = 1;
    public final static int MESSAGE = 2;
}
