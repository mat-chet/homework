package server;

import protocol.Protocol;
import res.Chat;
import res.User;
import res.UsersChatID;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server implements Runnable {
    ServerSocket serverSocket;

    public CopyOnWriteArrayList<User> getUsers() {
        return users;
    }

    private CopyOnWriteArrayList<User> users = new CopyOnWriteArrayList<>();
    private ConcurrentMap<Integer,UsersChatID> ChatsID = new ConcurrentHashMap<>();


    public ConcurrentMap<Integer,UsersChatID> getChatsID() {
        return ChatsID;
    }

    public void addNewChatToChatsId(Chat chat){
        UsersChatID usersChatID = chat.getUsersChatID();
        ChatsID.put(usersChatID.ID,usersChatID);
    }

    public void addNewUserToChatsIdByID(Integer id,String nik){
        ChatsID.get(id).usersNik.add(nik);
    }

    public UsersChatID getUsersFromChatsByID(Integer id){
        return ChatsID.get(id);
    }

    private ConcurrentMap<String,ServerThread> serverThreads = new ConcurrentHashMap<>();

    public ConcurrentMap<String,ServerThread> getServerThreads() {
        return serverThreads;
    }
    public void delServerThread(ServerThread serverThread){
        serverThreads.remove(serverThread.getUser(),serverThread);
    }

    public static void main(String[] args) {
        Thread server = new Thread(new Server());
        server.start();
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
        System.out.println("start server");
        try {

            serverSocket = new ServerSocket(Protocol.PORT);
            System.out.println(InetAddress.getLocalHost());
            users = getNewUsers();
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("new client");
                Thread serverThread = new Thread(new ServerThread(socket,this, getID()));

                System.out.println("new ServerThread");
                serverThread.start();

                System.out.println("start new ServerThread");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private volatile int ID_FOR_NEW_THREAD = 0;
    private int getID() {
        return ID_FOR_NEW_THREAD++;
    }

    private volatile int NEW_CHAT_ID = 0;
    public synchronized int getChatID() {
        return NEW_CHAT_ID++;
    }

    private CopyOnWriteArrayList<User> getNewUsers() {
        return new CopyOnWriteArrayList<>();
    }

    public void addUser(User user){
        //writeUser.lock;
        users.add(user);
        //writeUser.unlock;
        return;
    }

    public void addServerThread(ServerThread serverThread){
        //writeServerThreads.lock;
        serverThreads.put(serverThread.getUser().getNik(),serverThread);
        //writeServerThreads.unlock;
        return;
    }

}
