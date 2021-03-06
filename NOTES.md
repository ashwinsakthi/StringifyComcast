# StringifyComcast

Exercise on basic rest apis using java and string operations.

# i. Required features

The following features have been added.

#### •	For the /stringinate endpoint, for a given input string we need to find the character that occurs most frequently and add that character, along with its number of occurrences to the API response JSON. You decide how to represent this in the JSON response. Ignore white space and punctuation.
#### •	For the stats endpoint, track which string input has been seen the most times. Return this value as the most_popular key in the response JSON.
#### •	For the stats endpoint, track which string input is the longest string to be seen by the server and return as the longest_input_received key in the response JSON.


# ii. Developer Choice feature

#### • Basic Input/Output validations are done
#### • Unit testing is done with Coverage reports.
#### • Functional testing is done with Coverage reports.
#### • Code has been refactored and design has been maintained such that no processing is done at the controller and only performed at the Service layer.

# iii.	Citations

• GeelsForGeeks
• Some examples from Stack Overflow

https://stackoverflow.com/questions/49263227/problems-returning-the-length-of-the-longest-string-among-the-values-of-input-in/49263871

https://www.geeksforgeeks.org/how-to-find-the-entry-with-largest-key-in-a-java-map/

https://stackoverflow.com/questions/5911174/finding-key-associated-with-max-value-in-a-java-map

https://stackoverflow.com/questions/11647889/sorting-the-mapkey-value-in-descending-order-based-on-the-value


# iv.	Decision 

A Basic Rest API with the aim of achieving the desired functionality has been completed .

A Simple Controller with Service Classes and pojos for JSON generation.

Unit Test Cases and Functional test cases covering 80% of the code has been taken care.

https://stackoverflow.com/questions/38635381/how-to-manually-commit-offset-in-spark-kafka-direct-streaming

 You can use Spark Streaming to consume your messages from Kafka topics, store them in MongoDB and then again repost them to some other Kafka topics (as per your requirement)

If you choose to use Spark Streaming, please make sure to use Reliable Receivers so that there is no data loss due to any kind of failure as this is one of your main requirements to replace the java based application (running on WLP) with Spark.

Spark can run as a standalone app (using threads to simulate distribution) or using a cluster manager like Kubernetes, YARN or built-in Spark Standalone. With cluster managers you can use more CPUs and increase throughput.

In case of failure , the same process should pick up the Kafka messages and reprocess the same.

Yes. That's a Kafka consumer's contract (so it should also work similarly in different envs like this PaaS / WebSphere setup).

I'd consider Spark but not for "Resiliency, Scalability, Performance, No Data Loss, and Maintainability" but simply because what you're doing is batch processing and does not need a full-blown application server that is up and running all the time.


