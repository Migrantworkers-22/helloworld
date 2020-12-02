import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BrokerServer  类来对外提供Broker类服务
 */
public class BrokerServer implements  Runnable{

    public static int serverPort= 9999;

    private  final Socket socket;

    public BrokerServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                BufferedReader in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());

        ){
            while (true){
                String str = in.readLine();
                if (str==null){
                    continue;
                }
                System.out.println("接收到原始数据："+str);

                if (str.equals("CONSUME")){//CONSUME 表示要消费一条信息
                    String message = Broker.consume();
                    out.println(message);
                    out.flush();
                }
                else{
                    Broker.produce(str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws  Exception {
        ServerSocket serverSocket = new ServerSocket(serverPort);
        while (true){
            //-----accept 该方法如无连接会阻塞等待连接
            BrokerServer brokerServer = new BrokerServer(serverSocket.accept());
            new Thread(brokerServer).start();
        }
    }
}

