package save;

import api.ISave;
import res.Message;

import java.util.ArrayList;
import java.util.List;

public class SaveToList implements ISave {
    private List<Message> messages = null;

    public List<Message> getMessages(){
        return messages;
    }

    @Override
    public void save(List<Message> list) {
        messages = new ArrayList<>(list);
        return;
    }
}
