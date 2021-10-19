

Good afternoon. I am not able to follow the question completely or the requirement leading to this question.

Why do you want to integrate Spark streaming with Kafka Streaming (KStreams) and not just the Kafka Topic?

Kafka Streaming is Kafka's stream processing framework for processing streaming data. Ideally, if your only requirement is to process Kafka streaming data then KStreams is a better choice since it is natively supported by Kafka.

You can also use Spark Streaming (KafkaUtils class in Java) to create a direct stream for processing event streaming data from the Kafka Topics.

Integrating Kafka Streams with Spark Streaming is something I am not able to follow.


One is a micro-batch processing, and the other is event at a time processing. So in a well curated architecture where containers have been used to cluster the Kafka it can, but the complexity goes higher in terms of managing them.
As the topology is quite different, Spark stream has higher latency and Kafka stream has low latency. Spark is fault tolerance easy and Kafka Stream is fault tolerance expensive.
Because of this difference, I would say No they're not compatible
