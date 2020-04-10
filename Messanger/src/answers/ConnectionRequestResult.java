package answers;

import java.io.Serializable;

public class ConnectionRequestResult extends Result implements Serializable {

    private static final long serialVersionUID = 1L;

    public boolean RESULT;

    public ConnectionRequestResult(boolean RESULT) {
        result = Result.CONNECTION_RESULT;
        this.RESULT = RESULT;
    }
}
