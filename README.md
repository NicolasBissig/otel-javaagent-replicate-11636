# otel-javaagent-replicate-11636

Issue replication repository for https://github.com/open-telemetry/opentelemetry-java-instrumentation/discussions/11636

## Steps to reproduce

1. Clone this repository
2. Run `./mvnw package` to package and ensure you have built the `replicate:0.0.1-SNAPSHOT` image.
3. Run `docker-compose up` to start the application and the agent.

## Expected behavior

1. Open `http://localhost:3000` and explore Tempo traces
2. Observe that the traces are being sent to Tempo

## Actual behavior

1. No Traces, but Loki Logs appear
2. Logs display 
   ```
   replicate-1     | [otel.javaagent 2024-07-22 08:43:02:010 +0000] [supportability_metrics_reporter] DEBUG io.opentelemetry.javaagent.shaded.instrumentation.api.internal.SupportabilityMetrics - Suppressed Spans by 'io.opentelemetry.tomcat-10.0' (SERVER) : 1
   ```

## Workaround

Remove this dependency from the `pom.xml` file:

```xml
<!-- This dependency is the problem -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>3.1.0</version>
</dependency>
```
