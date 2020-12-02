import java.util.concurrent.ArrayBlockingQueue;

/**
 * 消息处socket理中心
 */
public class Broker {
    //队列存储的最大数量
    private  final  static int Max_SIZE=3;
    //保存消息数据的容器
    private static ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<>(Max_SIZE);

    //生产消息
    public static  void produce(String msg){
        /*
            offer()--- 如果插入数据时队列没满 返回true 如果满了返回false
         */
        if (messageQueue.offer(msg)){
            System.out.println("成功向消息队列中投递信息："+msg+"当前暂存消息队列的数量是"+messageQueue.size());
        }else {
            System.out.println("消息处理中心暂存的消息达到最大负荷，不能继续放入消息");
        }
        System.out.println("------------------------------------");
    }

    //消费消息
    public static  String consume(){
        /*
            pool方法删除数据时队列不为null 则返回队列头部的数据  如果队列为null立即返回null
         */
        String msg=messageQueue.poll();

        if (msg!=null){
            System.out.println("已经消费消息："+msg+"，当前暂存的消息数量是："+messageQueue.size());
        }else {
            System.out.println("消息队列中已经没有消息可供消费！");
        }

        System.out.println("------------------------------------");
        return msg;
    }
}

