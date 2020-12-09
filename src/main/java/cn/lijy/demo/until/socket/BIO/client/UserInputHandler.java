package cn.lijy.demo.until.socket.BIO.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 处理用户输入的消息，并且发送给服务器端
 */
public class UserInputHandler implements Runnable {
    private ChatClient chatClient;


    public UserInputHandler(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public void run() {
        try {
            //等待用户输入信息
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String msg = reader.readLine();

                chatClient.sendMsgToServer(msg);

                if (chatClient.readyToQuit(msg)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
