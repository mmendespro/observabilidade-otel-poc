# Project README

## Introduction

OpenTelemetry is an Observability framework and toolkit designed to create and manage telemetry data such as traces, metrics, and logs. Crucially, OpenTelemetry is vendor and tool-agnostic, meaning that it can be used with a broad variety of Observability backends, including open source tools like Jaeger and Prometheus, as well as commercial offerings. OpenTelemetry is a Cloud Native Computing Foundation (CNCF) project.

![solution-stack](./docs/imgs/solution.png)

This project has the stack bellow:
1. Loki: a horizontally scalable, highly available, multi-tenant log aggregation system inspired by Prometheus. It is designed to be very cost effective and easy to operate. It does not index the contents of the logs, but rather a set of labels for each log stream.
2. Prometheus: an open-source systems monitoring and alerting toolkit.
3. Tempo: an open source, easy-to-use, and high-scale distributed tracing backend. Tempo is cost-efficient, requiring only object storage to operate, and is deeply integrated with Grafana, Prometheus, and Loki. Tempo can ingest common open source tracing protocols, including Jaeger, Zipkin, and OpenTelemetry.
4. Grafana: the leading open source visualization and dashboarding platform that allows you to query, visualize, alert on, and understand your data no matter where it’s stored.
5. Jaeger: Distributed tracing observability platforms.
6. Zipkin: a distributed tracing system. It helps gather timing data needed to troubleshoot latency problems in service architectures.
7. Open Telemetry Collector: offers a vendor-agnostic implementation of how to receive, process and export telemetry data. It removes the need to run, operate, and maintain multiple agents/collectors. This works with improved scalability and supports open source observability data formats (e.g. Jaeger, Prometheus, Fluent Bit, etc.) sending to one or more open source or commercial back-ends.

## Prerequisites

To run this project, you will need the following:

* Java Development Kit (JDK) 17 or higher
* Apache Maven 3.8 or higher
* Docker

## Getting Started

1. Clone the project repository: git clone https://github.com/mmendespro/observabilidade-otel-poc.git
2. Navigate to the project directory: cd project-name
3. Build the project using Maven: mvn clean package
4. Build the Docker image: docker build -t project-name .
5. Run the Docker container: docker run -p 8080:8080 project-name

The application will be accessible at `http://localhost:8080`.

## Project Structure

The project is structured as follows:

* `src/main/java`: Contains the Java source code for the application.
* `src/test/java`: Contains the unit tests for the application.
* `pom.xml`: The Maven project configuration file.
* `Dockerfile`: The Docker image build configuration file.
* `README.md`: This file.

## Contributing

We welcome contributions to this project. Please read the CONTRIBUTING.md file for more information on how to contribute.

## License

This project is licensed under the MIT license. See the LICENSE file for more information.