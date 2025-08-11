package com.mainfiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 * Simple analogy:
Kafka = Post office that handles letters (messages)

Zookeeper = The post office manager that keeps track of which desk handles which mail, who's working, and organizes 
everything behind the scenes
 
 Think of a Restaurant:
Kafka = The Waiter::
	--Takes orders from customers (producers).
	--Delivers those orders to the kitchen (Kafka topic).
	--Brings back the food to customers (consumers).
	--Handles lots of orders efficiently.

Zookeeper = The Restaurant Manager::
	--Keeps track of which waiter is working which table (manages coordination).
	--Makes sure orders don’t get lost or mixed up (manages order coordination).
	--Organizes staff and resources so everything runs smoothly.

Summary:
Kafka (Waiter) handles the flow of information (orders/food).
Zookeeper (Manager) handles the coordination and organization behind the scenes.
 
 */
//START THE ZOOKEEPER SERVER
//START THE KAFKA MAILBOX

//http://localhost:8067/send?message="Hello Kafka Happy Learning"

@SpringBootApplication(scanBasePackages = "com")
public class SpringBootEntry {
	  public static void main(String[] args) {
	        SpringApplication.run(SpringBootEntry.class, args);
	    }
}
/*

.   ____          _            __ _ _
/\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
\\/  ___)| |_)| | | | | || (_| |  ) ) ) )
'  |____| .__|_| |_|_| |_\__, | / / / /
=========|_|==============|___/=/_/_/_/

:: Spring Boot ::                (v3.5.4)

2025-08-09T12:59:35.644+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [           main] com.mainfiles.SpringBootEntry            : Starting SpringBootEntry using Java 17.0.6 with PID 33668 (D:\WIPRO2025\WiproSpringBootApacheKafka\WiproSpringBootApacheKafka\target\classes started by Administrator in D:\WIPRO2025\WiproSpringBootApacheKafka\WiproSpringBootApacheKafka)
2025-08-09T12:59:35.654+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [           main] com.mainfiles.SpringBootEntry            : No active profile set, falling back to 1 default profile: "default"
2025-08-09T12:59:38.662+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8067 (http)
2025-08-09T12:59:38.691+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2025-08-09T12:59:38.692+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.43]
2025-08-09T12:59:38.834+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2025-08-09T12:59:38.838+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 3052 ms
2025-08-09T12:59:40.466+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8067 (http) with context path '/'
2025-08-09T12:59:40.582+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [           main] o.a.k.clients.consumer.ConsumerConfig    : ConsumerConfig values: 
	allow.auto.create.topics = true
	auto.commit.interval.ms = 5000
	auto.include.jmx.reporter = true
	auto.offset.reset = earliest
	bootstrap.servers = [localhost:9092]
	check.crcs = true
	client.dns.lookup = use_all_dns_ips
	client.id = consumer-my-group-1
	client.rack = 
	connections.max.idle.ms = 540000
	default.api.timeout.ms = 60000
	enable.auto.commit = false
	enable.metrics.push = true
	exclude.internal.topics = true
	fetch.max.bytes = 52428800
	fetch.max.wait.ms = 500
	fetch.min.bytes = 1
	group.id = my-group
	group.instance.id = null
	group.protocol = classic
	group.remote.assignor = null
	heartbeat.interval.ms = 3000
	interceptor.classes = []
	internal.leave.group.on.close = true
	internal.throw.on.fetch.stable.offset.unsupported = false
	isolation.level = read_uncommitted
	key.deserializer = class org.apache.kafka.common.serialization.StringDeserializer
	max.partition.fetch.bytes = 1048576
	max.poll.interval.ms = 300000
	max.poll.records = 500
	metadata.max.age.ms = 300000
	metadata.recovery.strategy = none
	metric.reporters = []
	metrics.num.samples = 2
	metrics.recording.level = INFO
	metrics.sample.window.ms = 30000
	partition.assignment.strategy = [class org.apache.kafka.clients.consumer.RangeAssignor, class org.apache.kafka.clients.consumer.CooperativeStickyAssignor]
	receive.buffer.bytes = 65536
	reconnect.backoff.max.ms = 1000
	reconnect.backoff.ms = 50
	request.timeout.ms = 30000
	retry.backoff.max.ms = 1000
	retry.backoff.ms = 100
	sasl.client.callback.handler.class = null
	sasl.jaas.config = null
	sasl.kerberos.kinit.cmd = /usr/bin/kinit
	sasl.kerberos.min.time.before.relogin = 60000
	sasl.kerberos.service.name = null
	sasl.kerberos.ticket.renew.jitter = 0.05
	sasl.kerberos.ticket.renew.window.factor = 0.8
	sasl.login.callback.handler.class = null
	sasl.login.class = null
	sasl.login.connect.timeout.ms = null
	sasl.login.read.timeout.ms = null
	sasl.login.refresh.buffer.seconds = 300
	sasl.login.refresh.min.period.seconds = 60
	sasl.login.refresh.window.factor = 0.8
	sasl.login.refresh.window.jitter = 0.05
	sasl.login.retry.backoff.max.ms = 10000
	sasl.login.retry.backoff.ms = 100
	sasl.mechanism = GSSAPI
	sasl.oauthbearer.clock.skew.seconds = 30
	sasl.oauthbearer.expected.audience = null
	sasl.oauthbearer.expected.issuer = null
	sasl.oauthbearer.header.urlencode = false
	sasl.oauthbearer.jwks.endpoint.refresh.ms = 3600000
	sasl.oauthbearer.jwks.endpoint.retry.backoff.max.ms = 10000
	sasl.oauthbearer.jwks.endpoint.retry.backoff.ms = 100
	sasl.oauthbearer.jwks.endpoint.url = null
	sasl.oauthbearer.scope.claim.name = scope
	sasl.oauthbearer.sub.claim.name = sub
	sasl.oauthbearer.token.endpoint.url = null
	security.protocol = PLAINTEXT
	security.providers = null
	send.buffer.bytes = 131072
	session.timeout.ms = 45000
	socket.connection.setup.timeout.max.ms = 30000
	socket.connection.setup.timeout.ms = 10000
	ssl.cipher.suites = null
	ssl.enabled.protocols = [TLSv1.2, TLSv1.3]
	ssl.endpoint.identification.algorithm = https
	ssl.engine.factory.class = null
	ssl.key.password = null
	ssl.keymanager.algorithm = SunX509
	ssl.keystore.certificate.chain = null
	ssl.keystore.key = null
	ssl.keystore.location = null
	ssl.keystore.password = null
	ssl.keystore.type = JKS
	ssl.protocol = TLSv1.3
	ssl.provider = null
	ssl.secure.random.implementation = null
	ssl.trustmanager.algorithm = PKIX
	ssl.truststore.certificates = null
	ssl.truststore.location = null
	ssl.truststore.password = null
	ssl.truststore.type = JKS
	value.deserializer = class org.apache.kafka.common.serialization.StringDeserializer

2025-08-09T12:59:40.712+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [           main] o.a.k.c.t.i.KafkaMetricsCollector        : initializing Kafka metrics collector
2025-08-09T12:59:41.111+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [           main] o.a.kafka.common.utils.AppInfoParser     : Kafka version: 3.9.1
2025-08-09T12:59:41.113+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [           main] o.a.kafka.common.utils.AppInfoParser     : Kafka commitId: f745dfdcee2b9851
2025-08-09T12:59:41.113+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [           main] o.a.kafka.common.utils.AppInfoParser     : Kafka startTimeMs: 1754724581109
2025-08-09T12:59:41.118+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [           main] o.a.k.c.c.i.ClassicKafkaConsumer         : [Consumer clientId=consumer-my-group-1, groupId=my-group] Subscribed to topic(s): test-topic
2025-08-09T12:59:41.156+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [           main] com.mainfiles.SpringBootEntry            : Started SpringBootEntry in 6.364 seconds (process running for 7.312)
2025-08-09T12:59:42.048+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [ntainer#0-0-C-1] org.apache.kafka.clients.Metadata        : [Consumer clientId=consumer-my-group-1, groupId=my-group] Cluster ID: xPSA9jzlSTC79vmxbXdYyw
2025-08-09T12:59:42.050+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [ntainer#0-0-C-1] o.a.k.c.c.internals.ConsumerCoordinator  : [Consumer clientId=consumer-my-group-1, groupId=my-group] Discovered group coordinator dhaya-1075-t:9092 (id: 2147483647 rack: null)
2025-08-09T12:59:42.059+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [ntainer#0-0-C-1] o.a.k.c.c.internals.ConsumerCoordinator  : [Consumer clientId=consumer-my-group-1, groupId=my-group] (Re-)joining group
2025-08-09T12:59:42.128+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [ntainer#0-0-C-1] o.a.k.c.c.internals.ConsumerCoordinator  : [Consumer clientId=consumer-my-group-1, groupId=my-group] Request joining group due to: need to re-join with the given member-id: consumer-my-group-1-72fc3c6a-7696-4428-9e7b-9dd4572df027
2025-08-09T12:59:42.129+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [ntainer#0-0-C-1] o.a.k.c.c.internals.ConsumerCoordinator  : [Consumer clientId=consumer-my-group-1, groupId=my-group] (Re-)joining group
2025-08-09T12:59:42.156+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [ntainer#0-0-C-1] o.a.k.c.c.internals.ConsumerCoordinator  : [Consumer clientId=consumer-my-group-1, groupId=my-group] Successfully joined group with generation Generation{generationId=7, memberId='consumer-my-group-1-72fc3c6a-7696-4428-9e7b-9dd4572df027', protocol='range'}
2025-08-09T12:59:42.165+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [ntainer#0-0-C-1] o.a.k.c.c.internals.ConsumerCoordinator  : [Consumer clientId=consumer-my-group-1, groupId=my-group] Finished assignment for group at generation 7: {consumer-my-group-1-72fc3c6a-7696-4428-9e7b-9dd4572df027=Assignment(partitions=[test-topic-0])}
2025-08-09T12:59:42.240+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [ntainer#0-0-C-1] o.a.k.c.c.internals.ConsumerCoordinator  : [Consumer clientId=consumer-my-group-1, groupId=my-group] Successfully synced group in generation Generation{generationId=7, memberId='consumer-my-group-1-72fc3c6a-7696-4428-9e7b-9dd4572df027', protocol='range'}
2025-08-09T12:59:42.240+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [ntainer#0-0-C-1] o.a.k.c.c.internals.ConsumerCoordinator  : [Consumer clientId=consumer-my-group-1, groupId=my-group] Notifying assignor about the new Assignment(partitions=[test-topic-0])
2025-08-09T12:59:42.244+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [ntainer#0-0-C-1] k.c.c.i.ConsumerRebalanceListenerInvoker : [Consumer clientId=consumer-my-group-1, groupId=my-group] Adding newly assigned partitions: test-topic-0
2025-08-09T12:59:42.261+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [ntainer#0-0-C-1] o.a.k.c.c.internals.ConsumerUtils        : Setting offset for partition test-topic-0 to the committed offset FetchPosition{offset=3, offsetEpoch=Optional.empty, currentLeader=LeaderAndEpoch{leader=Optional[dhaya-1075-t:9092 (id: 0 rack: null)], epoch=0}}
2025-08-09T12:59:42.264+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [ntainer#0-0-C-1] o.s.k.l.KafkaMessageListenerContainer    : my-group: partitions assigned: [test-topic-0]
2025-08-09T13:03:17.330+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [nio-8067-exec-2] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2025-08-09T13:03:17.331+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [nio-8067-exec-2] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2025-08-09T13:03:17.333+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [nio-8067-exec-2] o.s.web.servlet.DispatcherServlet        : Completed initialization in 2 ms
2025-08-09T13:03:17.449+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [nio-8067-exec-2] o.a.k.clients.producer.ProducerConfig    : ProducerConfig values: 
	acks = -1
	auto.include.jmx.reporter = true
	batch.size = 16384
	bootstrap.servers = [localhost:9092]
	buffer.memory = 33554432
	client.dns.lookup = use_all_dns_ips
	client.id = WiproSpringBootApacheKafka-producer-1
	compression.gzip.level = -1
	compression.lz4.level = 9
	compression.type = none
	compression.zstd.level = 3
	connections.max.idle.ms = 540000
	delivery.timeout.ms = 120000
	enable.idempotence = true
	enable.metrics.push = true
	interceptor.classes = []
	key.serializer = class org.apache.kafka.common.serialization.StringSerializer
	linger.ms = 0
	max.block.ms = 60000
	max.in.flight.requests.per.connection = 5
	max.request.size = 1048576
	metadata.max.age.ms = 300000
	metadata.max.idle.ms = 300000
	metadata.recovery.strategy = none
	metric.reporters = []
	metrics.num.samples = 2
	metrics.recording.level = INFO
	metrics.sample.window.ms = 30000
	partitioner.adaptive.partitioning.enable = true
	partitioner.availability.timeout.ms = 0
	partitioner.class = null
	partitioner.ignore.keys = false
	receive.buffer.bytes = 32768
	reconnect.backoff.max.ms = 1000
	reconnect.backoff.ms = 50
	request.timeout.ms = 30000
	retries = 2147483647
	retry.backoff.max.ms = 1000
	retry.backoff.ms = 100
	sasl.client.callback.handler.class = null
	sasl.jaas.config = null
	sasl.kerberos.kinit.cmd = /usr/bin/kinit
	sasl.kerberos.min.time.before.relogin = 60000
	sasl.kerberos.service.name = null
	sasl.kerberos.ticket.renew.jitter = 0.05
	sasl.kerberos.ticket.renew.window.factor = 0.8
	sasl.login.callback.handler.class = null
	sasl.login.class = null
	sasl.login.connect.timeout.ms = null
	sasl.login.read.timeout.ms = null
	sasl.login.refresh.buffer.seconds = 300
	sasl.login.refresh.min.period.seconds = 60
	sasl.login.refresh.window.factor = 0.8
	sasl.login.refresh.window.jitter = 0.05
	sasl.login.retry.backoff.max.ms = 10000
	sasl.login.retry.backoff.ms = 100
	sasl.mechanism = GSSAPI
	sasl.oauthbearer.clock.skew.seconds = 30
	sasl.oauthbearer.expected.audience = null
	sasl.oauthbearer.expected.issuer = null
	sasl.oauthbearer.header.urlencode = false
	sasl.oauthbearer.jwks.endpoint.refresh.ms = 3600000
	sasl.oauthbearer.jwks.endpoint.retry.backoff.max.ms = 10000
	sasl.oauthbearer.jwks.endpoint.retry.backoff.ms = 100
	sasl.oauthbearer.jwks.endpoint.url = null
	sasl.oauthbearer.scope.claim.name = scope
	sasl.oauthbearer.sub.claim.name = sub
	sasl.oauthbearer.token.endpoint.url = null
	security.protocol = PLAINTEXT
	security.providers = null
	send.buffer.bytes = 131072
	socket.connection.setup.timeout.max.ms = 30000
	socket.connection.setup.timeout.ms = 10000
	ssl.cipher.suites = null
	ssl.enabled.protocols = [TLSv1.2, TLSv1.3]
	ssl.endpoint.identification.algorithm = https
	ssl.engine.factory.class = null
	ssl.key.password = null
	ssl.keymanager.algorithm = SunX509
	ssl.keystore.certificate.chain = null
	ssl.keystore.key = null
	ssl.keystore.location = null
	ssl.keystore.password = null
	ssl.keystore.type = JKS
	ssl.protocol = TLSv1.3
	ssl.provider = null
	ssl.secure.random.implementation = null
	ssl.trustmanager.algorithm = PKIX
	ssl.truststore.certificates = null
	ssl.truststore.location = null
	ssl.truststore.password = null
	ssl.truststore.type = JKS
	transaction.timeout.ms = 60000
	transactional.id = null
	value.serializer = class org.apache.kafka.common.serialization.StringSerializer

2025-08-09T13:03:17.452+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [nio-8067-exec-2] o.a.k.c.t.i.KafkaMetricsCollector        : initializing Kafka metrics collector
2025-08-09T13:03:17.486+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [nio-8067-exec-2] o.a.k.clients.producer.KafkaProducer     : [Producer clientId=WiproSpringBootApacheKafka-producer-1] Instantiated an idempotent producer.
2025-08-09T13:03:17.555+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [nio-8067-exec-2] o.a.kafka.common.utils.AppInfoParser     : Kafka version: 3.9.1
2025-08-09T13:03:17.556+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [nio-8067-exec-2] o.a.kafka.common.utils.AppInfoParser     : Kafka commitId: f745dfdcee2b9851
2025-08-09T13:03:17.556+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [nio-8067-exec-2] o.a.kafka.common.utils.AppInfoParser     : Kafka startTimeMs: 1754724797555
2025-08-09T13:03:17.576+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [afka-producer-1] org.apache.kafka.clients.Metadata        : [Producer clientId=WiproSpringBootApacheKafka-producer-1] Cluster ID: xPSA9jzlSTC79vmxbXdYyw
2025-08-09T13:03:17.581+05:30  INFO 33668 --- [WiproSpringBootApacheKafka] [afka-producer-1] o.a.k.c.p.internals.TransactionManager   : [Producer clientId=WiproSpringBootApacheKafka-producer-1] ProducerId set to 1002 with epoch 0
Received message: "Hello Kafka Happy Learning"
*/