# kafka-data-genetrator
kafka-data-gen is a simple message generation tool that will create defined size events and send them to
kafka at a certain rate(Events per Second).

#### Build
kafka-data-gen is a gradle project and can be built using the `gradle install` command.
A jar file is created which can be used for data generation. kafka-data-gen.jar

#### Examples
With EPS Throttling:
java -jar build/libs/kafka-data-gen.jar -message-count 20000000 -message-size 256 -topic kafka-demo -bootstrap.servers "localhost:9092" -acks all -kafka-retries 0 -kafka-batch-size 60000 -kafka-linger 1 -kafka-buffer-memory 33554432 -eps 10000

Unlimited EPS:
java -jar build/libs/kafka-data-gen.jar -message-count 20000000 -message-size 256 -topic kafka-demo -bootstrap.servers "localhost:9092" -acks all -kafka-retries 0 -kafka-batch-size 60000 -kafka-linger 1 -kafka-buffer-memory 33554432 -eps 0

With Header support

java -jar build/libs/kafka-data-gen.jar -message-count 10 -message-size 256 -topic kafka-demo -bootstrap.servers "localhost:9092" -acks all -kafka-retries 0 -kafka-batch-size 60000 -kafka-linger 1 -kafka-buffer-memory 33554432 -eps 0 -generate-kafka-headers true -header-gen-profile 0


#### Command Line Options

* `message-count`: Sets amount of messages to create.
* `message-size`: Sets size of messages to create.
* `eps`: Amount of events per second to send to Kafka. Set to 0 for un-throttled event creation.
* `topic`: Kafka Topic to send messages to.
* `bootstrap.servers`: Kafka Servers to send messages to.
* `acks`: Acknowledgement Scheme (all, 1, 0).
* `kafka-retries `: Kafka retries amount.
* `kafka-batch-size`: Kafka batch size amount.
* `kafka-linger`: Kafka linger setting(ms).
* `kafka-buffer-memory`: Kafka buffer amount.
* `worker-thread-count`: default is 4
* `eventFormat` : default is JSON. Other options include kinesis
* `output-stdout` : default is false. Will write records to standard out
* `generate-kafka-headers` : default is false. Will generate kafka records with populated headers. Used in conjunction with -header-gen-profile
* `header-gen-profile` : default is -1. Will populate Kafka records with a certain profile. 0 is all the same headers, 1 is completely random headers, 2 is alternating 1 header value every 100 records

