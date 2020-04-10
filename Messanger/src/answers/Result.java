package answers;

import java.io.Serializable;

public class Result implements Serializable {

    private static final long serialVersionUID = 1L;


    public int result;

    public final static int ERROR = -1;
    public final static int CONNECTION_RESULT = 0;
    public final static int ALL_USERS_RESULT = 1;
    public final static int NEW_CHAT_RESULT = 2;
    public final static int MESSAGE = 3;
}
