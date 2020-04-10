package answers;

import Request.Request;
import res.Message;

import java.io.Serializable;

public class MessageResult extends Result implements Serializable {
    private static final long serialVersionUID = 1L;
    public Message message;

    public MessageResult(Message message) {
        this.message = message;
        result = Result.MESSAGE;
    }
}
