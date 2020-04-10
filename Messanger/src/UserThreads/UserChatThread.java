package UserThreads;

import Request.MessageRequest;
import res.Message;
import res.Chat;
import save.SaveToPrintStream;

import java.io.IOException;

public class UserChatThread implements Runnable {
    private UserThread userThread;
    private Chat chat;

    public UserChatThread(UserThread userThread,Chat chat) {
        this.userThread = userThread;
        this.chat = chat;
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
    @Override
    public void run() {
        String ss = userThread.systemIn.nextLine();
        ss = userThread.systemIn.nextLine();
        SaveToPrintStream saveToPrintStream = new SaveToPrintStream(System.out);
        chat.save(saveToPrintStream);
        while(ss!=null && !ss.equals("")){

            addNewMessage(ss);
            ss = userThread.systemIn.nextLine();
        }
        userThread.waitT = false;
    }

    private void addNewMessage(String ss) {
        Message message = new Message(ss,userThread.user.getNik(),chat.getId());
        try {
            userThread.out.writeObject(new MessageRequest(message));
        } catch (IOException e) {
            System.out.println("error sent message");
        }
    }
    public void addMessage(Message message){
        System.out.println(message);
        chat.addMess(message);
    }
}
