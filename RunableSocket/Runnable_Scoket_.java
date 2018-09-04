package RunableSocket;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runnable_Scoket_ {
    public void main(String args[]) throws Exception{
        int port = 55555;
        ServerSocket serverSocket= new ServerSocket();//创建服务
//      线程池
        ExecutorService threadPool= Executors.newFixedThreadPool(100);
        while(true){
            Socket socket = serverSocket.accept();//坚挺端口异常已抛出
            Runnable runable=()->{
                try {
                    InputStream inputStream = socket.getInputStream();
                    byte[] bytes = new byte[1024];//缓冲区
                    int len;
                    StringBuilder sb = new StringBuilder();
                    while((len = inputStream.read(bytes)) != -1){
                        sb.append(new String(bytes,0,len,"UTF-8"));
                    }
                    System.out.println("接收消息"+sb);
                    inputStream.close();
                    socket.close();
                }catch (Exception e){

                }
            };
            threadPool.submit(runable);
            Runnable runnables = new Runnable(){

                @Override
                public void run() {

                }
            };
            threadPool.submit(runnables);
        }
    }
}
