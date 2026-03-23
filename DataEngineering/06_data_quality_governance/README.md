# Data Engineering – Data Quality & Governance

> **Goal:** Understand how organizations keep data **fit for use** and **managed** under policy—quality dimensions, catalogs, lineage, and stewardship.

---

## 1. Data Quality (DQ)

**Data quality** means data is **fit for its intended purpose**—accurate, complete, consistent, and timely enough for decisions.

### 1.1 Common dimensions

| Dimension | Question |
|-----------|----------|
| **Accuracy** | Does it reflect reality? |
| **Completeness** | Are required fields present? |
| **Consistency** | Same meaning across systems? |
| **Timeliness** | Fresh enough for the use case? |
| **Uniqueness** | Duplicate records controlled? |
| **Validity** | Conforms to format and business rules? |

### 1.2 Implementing DQ in pipelines

- **Declarative checks** (Great Expectations, dbt tests, SQL assertions)  
- **Monitoring** – dashboards on null rates, row counts, distributions  
- **Quarantine** – bad records to a side table or DLQ for inspection  

---

## 2. Data Governance

**Data governance** is the **set of policies, roles, and processes** that ensure data is **managed as an asset**: known, trusted, secure, and compliant.

### 2.1 Pillars

| Pillar | Includes |
|--------|----------|
| **Metadata** | Definitions, owners, business glossary |
| **Catalog** | Searchable inventory of datasets (e.g. DataHub, Collibra, Atlas) |
| **Lineage** | Where data came from and where it flows |
| **Access control** | Who can read/write what (RBAC, ABAC) |
| **Stewardship** | Data owners and stewards per domain |
| **Compliance** | GDPR, HIPAA, SOC2—retention, consent, audit |

---

## 3. Lineage

- **Upstream** – sources and transforms feeding a table.  
- **Downstream** – dashboards, models, reports relying on a table.  
- **Impact analysis** – “If this column changes, what breaks?”  

Tools: open-source (OpenLineage, Marquez) + commercial platforms.

---

## 4. Business Glossary

- **Terms** defined in business language (e.g. “active customer”).  
- **Technical mapping** to columns and tables.  
- Reduces **misinterpretation** across teams.

---

## 5. Summary

- **Quality** = measurable dimensions + **automated checks** + **monitoring**.  
- **Governance** = **policy + people + tools** (catalog, lineage, stewardship).  
- Together they support **trust** and **compliance** at scale.

---

## Next module

→ [Data Security & Privacy](../07_data_security_privacy/README.md)
