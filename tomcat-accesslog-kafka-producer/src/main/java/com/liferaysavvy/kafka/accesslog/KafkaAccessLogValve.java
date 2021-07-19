package com.liferaysavvy.kafka.accesslog;

import com.liferaysavvy.kafka.accesslog.constants.KafkaConstants;
import com.liferaysavvy.kafka.accesslog.producer.KafkaMessageSender;
import org.apache.catalina.valves.AbstractAccessLogValve;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import java.io.CharArrayWriter;

public class KafkaAccessLogValve extends AbstractAccessLogValve {
    private static final Log log = LogFactory.getLog(KafkaAccessLogValve.class);
    @Override
    public void log(CharArrayWriter message) {
        try {
            log.info("Info##########Sending kafka record: {}"+ message);
            String tomcatInstance = System.getProperty(KafkaConstants.LIFERAY_NODE_SYSTEM_PROPERTY);
            new Thread(() -> new KafkaMessageSender().sendMessage(tomcatInstance + " - - " + message.toString())).start();
           /* Thread thread = new Thread(){;
                public void run(){
                    System.out.println("Thread Running");
                }
            };
            thread.start();*/
        } catch (Exception e) {
            log.error("Access logs are not sending to Kafka",e);
        }

    }
}
