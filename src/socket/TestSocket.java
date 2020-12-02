package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class TestSocket {
    public String getIP() throws UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();
        return host.getHostAddress();
    }
    public void run() throws UnknownHostException {
        String ip=getIP();
        List<String> list=new ArrayList<>();
        char c1[];
        StringBuffer c2=new StringBuffer();
        c1=ip.toCharArray();
        for(int i=0,j=0;i<3;j++){
            if(c1[j]=='.'){
                i++;
            }
            c2.append(c1[j]);
        }
        String newip=c2.toString();
        for(int i=1;i<10;i++){
            String str =newip+i;
            System.out.println("正在测试:"+str);
            try {
                Process p = Runtime.getRuntime().exec("ping "+str);
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(),"GBK"));
                String line = null;
                boolean tag=false;
                while ((line=br.readLine())!=null){
                    if(line.contains("TTL")){
                        tag=true;
                        break;
                    }
                }
                if (tag){
                    list.add(newip+i);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("可用ip如下:");
        for (String t:list){
            System.out.println(t);
        }
    }

    public static void main(String[] args) throws IOException {
            TestSocket t=new TestSocket();
            t.run();
    }

}