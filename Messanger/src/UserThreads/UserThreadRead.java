package UserThreads;

import answers.AllUsersRequestResult;
import answers.MessageResult;
import answers.NewChatRequestReult;
import answers.Result;
import res.User;

import java.io.IOException;
import java.util.ArrayList;

public class UserThreadRead implements Runnable {

    UserThread userThread;
    public UserThreadRead(UserThread userThread) {
        this.userThread = userThread;
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
        while (true){
            try {
                Result result = (Result) userThread.in.readObject();
                switch (result.result){
                    case Result.ALL_USERS_RESULT:{
                        AllUsersRequestResult allUsersRequestResult = (AllUsersRequestResult) result;
                        ArrayList<String> users = allUsersRequestResult.getUsers();
                        System.out.println("Users:");
                        for(int i = 0;i<users.size();i++)
                            System.out.println(users.get(i));
                        System.out.println();
                        userThread.waitT = false;
                    }break;
                    case Result.NEW_CHAT_RESULT:{
                        NewChatRequestReult newChatRequestReult = (NewChatRequestReult) result;
                        userThread.AddNewChat(newChatRequestReult.getChat());
                        System.out.println("добавлен новый чат");
                    }break;
                    case Result.MESSAGE:{
                        if(userThread.userChatThread!=null){
                            userThread.userChatThread.addMessage(((MessageResult)result).message);
                        }
                        else{
                            userThread.addNewMessByChatsID(((MessageResult)result).message);
                        }
                    }break;
                    default:{
                        System.out.println("error RESULT");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
