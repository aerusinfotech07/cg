# Data Engineering – Data Collection

> **Goal:** Understand how data is captured and moved into the data platform—batch vs streaming, push vs pull, and common patterns.

---

## 1. What Is Data Collection?

**Data collection** (ingestion) is the process of **bringing data from source systems** into a controlled environment (data lake, warehouse, or message bus) where it can be stored, processed, and consumed.

It answers:

- **What** is collected? (events, tables, files, API responses)  
- **When**? (real-time, near real-time, hourly, daily)  
- **How**? (APIs, database replication, file drops, agents, CDC)  

---

## 2. Ingestion Modes

| Mode | Description | Typical use |
|------|-------------|-------------|
| **Batch** | Data moved in **scheduled chunks** (files, table snapshots) | Daily sales export, nightly warehouse load |
| **Micro-batch** | Small batches every few minutes | Near–real-time dashboards |
| **Streaming** | **Continuous** flow of events | Clickstream, IoT, logs |
| **Change Data Capture (CDC)** | Captures **inserts/updates/deletes** from databases | Keep lake/warehouse in sync with OLTP |
| **Full extract** | Complete copy of a dataset each run | Small dimensions, simple sources |
| **Incremental** | Only **new or changed** rows since last run | Large fact tables |

---

## 3. Collection Patterns

### 3.1 Pull-based (batch)

A job **pulls** data on a schedule:

- JDBC/ODBC to a database  
- REST API pagination  
- SFTP / cloud storage listing + download  

**Pros:** Simple to reason about; fits cron/Airflow.  
**Cons:** Latency bounded by schedule; load on source during extract.

### 3.2 Push-based (streaming)

Sources **push** events to a broker (Kafka, PUB/SUB, Kinesis):

- Producers send records to topics  
- Consumers (Flink, Spark Streaming) process downstream  

**Pros:** Low latency; scalable.  
**Cons:** Requires operational maturity (topics, schemas, monitoring).

### 3.3 Hybrid

- **Lambda:** Batch + stream paths for same data (often simplified over time).  
- **Kappa:** Stream-first; batch reprocessing from stream replay.  

---

## 4. Sources and Connectors (Recap)

| Source | Collection approach |
|--------|------------------------|
| OLTP databases | JDBC, bulk export, **CDC** (Debezium, native logs) |
| SaaS (Salesforce, etc.) | REST APIs, vendor connectors, Fivetran/Airbyte-style tools |
| Object storage | File arrival triggers, scheduled scans |
| Mobile / web apps | SDKs → events → Kafka or HTTP |
| IoT | MQTT → gateway → stream or batch |

---

## 5. Design Considerations

1. **Idempotency** – Re-running a job should not duplicate corrupt data (keys, dedupe).  
2. **Schema evolution** – New columns, nullable fields; Avro/JSON schema strategies.  
3. **Volume & rate** – Backpressure, partitioning, parallelism.  
4. **Failures** – Retries, dead-letter queues, alerting.  
5. **Ordering** – Event time vs processing time; watermarks in streams.  
6. **Legal / compliance** – Consent, regional restrictions before collection.  

---

## 6. Example: Conceptual Batch Pipeline

```
[Source DB] -- JDBC extract --> [Staging files / object storage] -- load --> [Bronze tables]
```

---

## 7. Example: Conceptual Streaming Pipeline

```
[App] -- produce --> [Kafka topic] -- consume --> [Stream processor] --> [Serving tables / lake]
```

---

## 8. Summary

- **Collection** = getting data **into** the platform reliably.  
- Choose **batch**, **stream**, or **CDC** based on latency and source capabilities.  
- Plan for **scale, failures, schema change, and compliance** from day one.

---

## Next module

→ [Data Storage](../03_data_storage/README.md)
