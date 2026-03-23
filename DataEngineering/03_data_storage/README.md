# Data Engineering – Data Storage

> **Goal:** Understand how and where data is persisted—databases, data lakes, warehouses, formats, and layout for performance and cost.

---

## 1. What Is Data Storage in Data Engineering?

**Data storage** is the layer where ingested data **lives** until it is processed, queried, or archived. Engineers choose **systems** and **formats** based on access patterns, query types, cost, and governance.

---

## 2. Major Storage Categories

| Category | Examples | Typical use |
|----------|----------|-------------|
| **OLTP databases** | PostgreSQL, MySQL | Applications, operational systems |
| **Data warehouses** | Snowflake, BigQuery, Redshift, Databricks SQL | Analytics, BI, structured reporting |
| **Data lakes** | S3 + Parquet, ADLS, GCS | Raw and curated data at scale, ML |
| **Lakehouse** | Delta Lake, Iceberg, Hudi | ACID tables on lake storage |
| **NoSQL** | MongoDB, Cassandra, DynamoDB | Flexible schema, high throughput |
| **Object storage** | S3, Azure Blob, GCS | Files, backups, lake backbone |
| **Search / analytics** | Elasticsearch, OpenSearch | Search, log analytics |

---

## 3. Warehouse vs Lake (Conceptual)

| Aspect | Data warehouse | Data lake |
|--------|----------------|-----------|
| **Schema** | Structured / modeled | Often schema-on-read for raw |
| **Workload** | SQL analytics, BI | Diverse: SQL, Spark, ML |
| **Governance** | Strong (usually) | Must be designed in |
| **Cost model** | Compute + storage | Cheap storage; pay for processing |

---

## 4. File Formats (Analytics)

| Format | Notes |
|--------|--------|
| **Parquet** | Columnar, compressed—default for **lake analytics** |
| **ORC** | Columnar, common in Hive ecosystems |
| **CSV** | Human-readable; poor for large analytics |
| **JSON / JSONL** | Flexible; verbose |
| **Avro** | Row-based binary with schema—common with **Kafka** |

---

## 5. Partitioning and Layout

- **Partition** large tables by **date**, **region**, or other high-cardinality filters to **prune** scans.  
- **Avoid** too many small files (small-file problem)—use compaction jobs.  
- **Bucketing** (Hive/Spark) distributes by hash for joins—use when appropriate.  

---

## 6. Tiers and Lifecycle

- **Hot** – Frequent access, SSD or premium tier.  
- **Warm** – Standard object storage.  
- **Cold / Archive** – Glacier, Archive tier for compliance and cost.  

**Lifecycle policies** auto-move or delete objects after N days (subject to policy).

---

## 7. Summary

- Match **storage** to **query patterns** (SQL warehouse vs flexible lake).  
- Use **columnar formats** (e.g. Parquet) for large analytical datasets.  
- **Partition**, **compress**, and apply **lifecycle** rules for cost and performance.

---

## Next module

→ [Data Processing](../04_data_processing/README.md)
