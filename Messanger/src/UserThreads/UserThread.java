package UserThreads;

import Request.AllUsersRequest;
import Request.ConnectionRequest;
import Request.NewChatRequest;
import answers.AllUsersRequestResult;
import answers.ConnectionRequestResult;
import answers.Result;
import protocol.Protocol;
import res.*;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class UserThread implements Runnable{
    UserChatThread userChatThread = null;
    public Socket clientSocket;
    public Thread userReadThread;
    public Scanner systemIn;
    ObjectInputStream in;
    ObjectOutputStream out;
    User user;
    ArrayList<Chat> chats = new ArrayList<>();
    public static void main(String[] args) {
        Thread userThread = new Thread(new UserThread());
        userThread.start();
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
        try {
            System.out.println("client");
            System.out.println("enter address:");
            systemIn = new Scanner(System.in);
            String address = systemIn.nextLine();
            if(address.equals("local"))
                clientSocket = new Socket(InetAddress.getLocalHost(), Protocol.PORT);
            else
                clientSocket = new Socket(address, Protocol.PORT);
            InputStream inS = System.in;
            System.out.println(1);
            InputStream in0 = clientSocket.getInputStream();
            OutputStream out0 = clientSocket.getOutputStream();
            System.out.println(2);

            out = new ObjectOutputStream(out0);
            System.out.println(3);
            in = new ObjectInputStream(in0);
            System.out.println(4);
            System.out.println("регистрация или вход(1 2)");
            int q = systemIn.nextInt();

            String pass,nik;
            System.out.println("введите nik и password:");
            systemIn.nextLine();
            nik = systemIn.nextLine();
            pass = systemIn.nextLine();
            ConnectionRequest con = new ConnectionRequest(nik, pass);

            if(q == 1) {
                user = con.getUser();
                TimeUnit.SECONDS.sleep(1);
                out.writeObject(new AddNewUser(con));
                System.out.println("write!");
            }
            if(q == 2){
                user = con.getUser();
                TimeUnit.SECONDS.sleep(1);
                out.writeObject(new ConnectUser(con));
                System.out.println("write!");
            }
            try {
                Object o = in.readObject();
                ConnectionRequestResult connectionRequestResult = (ConnectionRequestResult) o;
                UserThreadRead userThreadRead = new UserThreadRead(this);
                userReadThread = new Thread(userThreadRead);
                userReadThread.start();
                if(connectionRequestResult.RESULT){
                    while (true){
                        System.out.println("1-все пользователи, 2-создать чат,3-список чатов, 4-открыть  чат");
                        int qq = systemIn.nextInt();
                        Result result = null;
                        switch (qq){
                            case 1:{
                                out.writeObject(new AllUsersRequest());
                                waitTime();
                            }break;

                            case 2:{
                                NewChatRequest chat = new NewChatRequest();
                                String ss;
                                systemIn.nextLine();
                                while (!(ss = systemIn.nextLine()).equals("")){
                                    chat.addUser(ss);
                                }
                                out.writeObject(chat);
                            }break;

                            case 3:{
                                OutChats();
                            }break;
                            case 4:{
                                int idChat = systemIn.nextInt();
                                Chat chat = findChatID(idChat);
                                if(chat != null){
                                    userChatThread = new UserChatThread(this,chat);
                                    Thread userChatTT = new Thread(userChatThread);
                                    userChatTT.start();
                                    waitTime();
                                    userChatThread = null;
                                }
                                else
                                    System.out.println("error id!");

                            }break;

                            default:
                                System.out.println("error number");
                                return;
                                //break;
                        }
                    }
                }
                else
                    return;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Chat findChatID(int idChat) {
        for(int i = 0;i<chats.size();i++){
            if(chats.get(i).getId() == idChat) {

                System.out.println("find Chat");
                return chats.get(i);
            }
        }
        return null;
    }

    public boolean waitT = false;
    private void waitTime(int i){
        waitT = true;
        int k = 0;
        while (waitT && k<i){
            try {
                TimeUnit.MICROSECONDS.sleep(1);
                k++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void waitTime(){
        waitT = true;
        while (waitT){
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void AddNewChat(Chat chat){
        chats.add(chat);
    }

    private void OutChats(){
        for(int i = 0;i<chats.size();i++){
            System.out.println(chats.get(i));
        }
    }

    public void addNewMessByChatsID(Message message){
        for (int i = 0; i < chats.size(); i++) {
            if(chats.get(i).getId() == message.getIdChat()){
                chats.get(i).addMess(message);
                break;
            }
        }
    }

}
