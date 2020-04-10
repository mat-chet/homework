package save;

import api.ISave;
import res.Message;

import java.io.PrintStream;
import java.util.List;

public class SaveToPrintStream implements ISave {
    PrintStream out;

    public SaveToPrintStream(PrintStream out) {
        this.out = out;
    }

    @Override
    public void save(List<Message> list) {
        for (int i = 0; i < list.size(); i++) {
            out.println(list.get(i));
        }
    }
}
