# Data Engineering – Data Integration

> **Goal:** Understand how data from multiple systems is combined into a coherent view—schemas, keys, APIs, and master data concepts.

---

## 1. What Is Data Integration?

**Data integration** is the process of **combining data** from disparate sources so users and systems see a **consistent**, **unified** picture—across applications, regions, and business units.

---

## 2. Why It Is Hard

- **Different schemas** (column names, types, granularity)  
- **No single natural key** across systems  
- **Temporal mismatch** (snapshots at different times)  
- **Semantic drift** (same word, different meaning)  

---

## 3. Integration Patterns

| Pattern | Description |
|---------|-------------|
| **Consolidation** | Copy all sources into one platform (lake/warehouse) then join in SQL/Spark |
| **Federation** | Query across systems without moving all data (virtual) |
| **API / event integration** | Services exchange data via REST/events in real time |
| **Master Data Management (MDM)** | Golden record for customers, products, locations |

---

## 4. Keys and Identity

- **Surrogate keys** – System-generated IDs in the warehouse (often integers).  
- **Natural keys** – Business identifiers (email, SKU)—can change.  
- **Crosswalk / mapping tables** – Link source ID ↔ canonical ID.  

---

## 5. Schema Alignment

- **Canonical model** – Target schema for integrated data.  
- **Mapping / ETL rules** – Source A.column → Target X.column.  
- **Versioning** – When sources change schema, document and migrate.  

---

## 6. APIs and Real-Time Integration

- **REST/GraphQL** – Pull or push from SaaS.  
- **Events** – Same event consumed by multiple services (loose coupling).  
- **Idempotency keys** – Avoid duplicate side effects when retrying.  

---

## 7. Summary

- **Integration** = **unify** heterogeneous data for analytics and operations.  
- Invest in **keys**, **canonical schemas**, and **documentation** of mappings.  
- **MDM** and **event-driven** patterns scale with organizational complexity.

---

## Next module

→ [Data Quality & Governance](../06_data_quality_governance/README.md)
