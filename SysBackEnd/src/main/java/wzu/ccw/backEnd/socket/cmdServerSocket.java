package wzu.ccw.backEnd.socket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class cmdServerSocket {


    public void work() throws IOException {

        ServerSocket serverSocket = new ServerSocket(8019);
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        while (true) {

            Socket socket = serverSocket.accept();
            Runnable runnable = () -> {

                BufferedReader bufferedReader =null;

                try {

                    bufferedReader =new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));


                    String str;

                    //通过while循环不断读取信息，

                    while ((str = bufferedReader.readLine()) !=null) {

                        //输出打印

                        System.out.println("客户端说：" + str);

                    }

                }catch (IOException e) {

                    e.printStackTrace();

                }

            };

            executorService.submit(runnable);

        }


    }




}
