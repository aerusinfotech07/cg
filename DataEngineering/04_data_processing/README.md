# Data Engineering – Data Processing

> **Goal:** Understand how raw data is transformed into curated datasets—ETL/ELT, batch and stream processing, and idempotent design.

---

## 1. What Is Data Processing?

**Data processing** is the application of **transformations** to data: cleaning, joining, aggregating, enriching, and validating so downstream users (BI, ML, apps) get **trusted, usable** datasets.

---

## 2. ETL vs ELT

| Approach | Order | When common |
|----------|--------|-------------|
| **ETL** | **Extract** → **Transform** (outside warehouse) → **Load** | Legacy, heavy transforms before warehouse |
| **ELT** | **Extract** → **Load** raw → **Transform** **inside** warehouse (SQL) | Cloud warehouses with SQL scale; push compute to data |

Modern stacks often **land raw** then **transform in SQL** (ELT) or **Spark** on the lake.

---

## 3. Batch Processing

- **Scheduled jobs** (hourly, daily) read inputs → produce outputs.  
- Tools: **Apache Spark** (batch), **dbt** (SQL transforms), **Hive**, **Pandas** (small data).  
- **Idempotent** jobs: same inputs + logic → same outputs; safe to rerun.  

---

## 4. Stream Processing

- **Continuous** processing of event streams.  
- Tools: **Apache Flink**, **Kafka Streams**, **Spark Structured Streaming**.  
- Concepts: **windows** (tumbling, sliding), **watermarks**, **state**.  

---

## 5. Transformation Types

| Type | Examples |
|------|----------|
| **Cleansing** | Trim, type casting, null handling |
| **Deduplication** | By key, by window |
| **Joins** | Enrich events with dimensions |
| **Aggregations** | Sums, counts, sessionization |
| **Slowly changing dimensions** | Type 1/2 in dimensional modeling |
| **Feature engineering** | For ML (often in batch or stream) |

---

## 6. Data Quality in Processing

Embed validation in pipelines:

- **Constraints** (not null, unique, range)  
- **Anomaly detection** (volume spikes, null rate)  
- **Reconciliation** (source totals vs target totals)  

---

## 7. Summary

- **Processing** turns **raw** into **business-ready** data.  
- Choose **batch**, **stream**, or **both** based on latency needs.  
- Prefer **idempotent**, **tested** transforms with **quality checks** built in.

---

## Next module

→ [Data Integration](../05_data_integration/README.md)
