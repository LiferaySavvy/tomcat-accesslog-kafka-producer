package com.liferaysavvy.kafka.accesslog.constants;
public final class KafkaConstants {
    private KafkaConstants(){}
    public static final String TOPIC = "liferay-tomcat-access-logs";
    // Kafka Brokers
    public static final String BOOTSTRAP_SERVERS = "localhost:9092, localhost:9093, localhost:9094";
}
