# Kafka Java Example

This repository showcase using Kafka with vanilla Java.

### Start Kafka & Create the Topics

Follow the example commands in the `kafka-cli-commands.txt` which can be found under the `src/main/resources` folder.

### One Producer - One Consumer Group with Multiple Consumer Instances

Under this example, we should expect each individual consumer instances within the One Consumer Group to pick up messages from the
Kafka topic. The messages would be shared between the different consumer instances. This allows load balancing of Consumer messages.

1) Run the `ProducerApp.java`

....

Ensure `KafkaConfig.java` has same GROUP_ID_CONFIG for all Kafka Consumer instances - change if needed

2) Run as many `ConsumerApp.java` as needed

When running say 5 partitions, you should expect the 5 partitions to be shared amongst the Kafka consumer instances.



### One Producer - Multiple Consumer Group each with One Consumer Instance

Under this example, we should expect the same message to be delivered to each Consumer Group. Effectively this enables a
more publisher-subscriber communication model because the messages are being broadcast to each Consumer Groups. Each consumer group
is particularly an individual separate consumer of the Topic.

The consumer instances within the Consumer Groups still follow the same rules as above example such that the message will be
load balanced amongst the individual consumer instances.

1) Run the `ProducerApp.java`

....

Change `KafkaConfig.java` to have a different (unique) GROUP_ID_CONFIG for all Kafka Consumer instances

2) Run as many `ConsumerApp.java` as needed

Regardless of the number of partitions, you should expect all the messages to be broadcast to all participating
Consumer Groups.


