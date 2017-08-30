package RabbitMQ;

import java.util.HashMap;

/**
 * @description:
 * @email:
 * @author: lizhixin
 * @createDate: 15:42 2017/8/30
 */
public class ProducerTest {

    public ProducerTest() throws Exception{

        QueueConsumer consumer = new QueueConsumer("lzxQueue");
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();

        QueueProducer producer = new QueueProducer("lzxQueue");

        for (int i = 0; i < 100000; i++) {
            HashMap message = new HashMap();
            message.put("message number", i);
            producer.sendMessage(message);
            System.out.println("Message Number "+ i +" sent.");
        }
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        new ProducerTest();
    }
}
