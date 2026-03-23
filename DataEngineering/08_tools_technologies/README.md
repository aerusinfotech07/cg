# Data Engineering – Tools & Technologies

> **Goal:** Map the **ecosystem** of languages, platforms, and products data engineers use—and how they fit together in a modern stack.

---

## 1. Programming & Query

| Tool / skill | Role |
|--------------|------|
| **SQL** | Essential—warehouses, Spark SQL, transformations |
| **Python** | Pipelines, APIs, Spark/PySpark, orchestration SDKs |
| **Scala / Java** | Spark JVM, Kafka, performance-sensitive systems |
| **Bash** | Scripting, automation, containers |

---

## 2. Orchestration & Workflow

| Tool | Notes |
|------|--------|
| **Apache Airflow** | DAG-based scheduling; Python-native; widely used |
| **Dagster, Prefect** | Modern alternatives; strong typing and testing |
| **Cloud-native** | AWS Step Functions, GCP Composer, Azure Data Factory |

---

## 3. Big Data Processing

| Tool | Notes |
|------|--------|
| **Apache Spark** | Batch, streaming, SQL, large-scale transforms |
| **Apache Flink** | Stream processing, low latency |
| **dbt** | SQL transforms in warehouse; tests, documentation |

---

## 4. Streaming & Messaging

| Tool | Notes |
|------|--------|
| **Apache Kafka** | Durable log, pub/sub, streaming backbone |
| **Kafka Connect** | Connectors to DBs, S3, etc. |
| **Pulsar, AWS Kinesis** | Alternatives in cloud |

---

## 5. Storage & Catalogs

| Tool | Notes |
|------|--------|
| **Cloud object storage** | S3, GCS, ADLS—lake foundation |
| **Snowflake / BigQuery / Redshift** | Managed warehouses |
| **Delta Lake / Iceberg / Hudi** | Lakehouse table formats |
| **Apache Hive / Metastore** | Legacy metadata; still common |

---

## 6. Data Quality & Observability

| Tool | Notes |
|------|--------|
| **Great Expectations / dbt tests** | Declarative checks |
| **Monte Carlo, Datafold** | Commercial data observability |

---

## 7. Infrastructure & DevOps

| Tool | Notes |
|------|--------|
| **Docker / Kubernetes** | Packaging and running workloads |
| **Terraform** | Infrastructure as code |
| **CI/CD** | GitHub Actions, GitLab—test pipelines before deploy |

---

## 8. How a Stack Fits Together (Example)

```
[Sources] → [Ingest: Kafka / Airbyte / CDC] → [Lake: S3 + Parquet]
    → [Spark / dbt transforms] → [Warehouse: Snowflake]
    → [BI: Tableau / Looker] + [ML features]
```

**Airflow** orchestrates batch jobs; **Kafka** streams events; **Spark** processes large volumes; **dbt** models SQL in the warehouse.

---

## 9. Summary

- No single tool wins—**choose** for **latency, scale, team skills, and cost**.  
- **SQL + Python + Spark + cloud** is a common backbone.  
- **Orchestration** and **observability** are as important as raw processing power.

---

## End of core tutorial series

→ Return to [HOME](../HOME.md) or [Tutorial index](../TUTORIAL_INDEX.md)
