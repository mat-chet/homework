package answers;

import res.Chat;

import java.io.Serializable;

public class NewChatRequestReult extends Result implements Serializable {

    private static final long serialVersionUID = 1L;

    public Chat getChat() {
        return chat;
    }

    private Chat chat;

    public NewChatRequestReult(Chat chat) {
        result = Result.NEW_CHAT_RESULT;
        this.chat = chat;
    }
}
