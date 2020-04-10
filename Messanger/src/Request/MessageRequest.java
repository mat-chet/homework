package Request;

import res.Message;

import java.io.Serializable;

public class MessageRequest extends Request implements Serializable {
    private static final long serialVersionUID = 1L;
    public Message message;

    public MessageRequest(Message message) {
        this.message = message;
        reqest = Request.MESSAGE;
    }
}
