# Introduction to Data Engineering – Full Notes (Module 1)

**Estimated duration:** 8 hours  

This document is the **single entry point** for Module 1. Detailed sections are split into separate files for easier navigation and printing.

---

## Table of Contents

1. [What is Data Engineering?](notes/01_what_is_data_engineering.md)  
2. [Data Lifecycle and Data Types](notes/02_data_lifecycle_and_data_types.md)  
3. [Data Sources and Data Formats](notes/03_data_sources_and_data_formats.md)  

---

## Module at a Glance

| Topic | Key ideas |
|-------|-----------|
| **What is Data Engineering?** | Building and operating **data pipelines** and **platforms** so data is **reliable, scalable, and usable** for analytics and ML. |
| **Data lifecycle & types** | Stages from **capture** to **archive**; **structured / semi-structured / unstructured**; **batch vs streaming**. |
| **Sources & formats** | **DBs, APIs, files, streams**; **CSV, JSON, Parquet, Avro** and when to use each. |

---

## Diagrams

All figures are **original SVG images** in [`images/`](images/). They render inline in VS Code, GitHub, and most Markdown viewers. File list:

| Image | Topic |
|-------|--------|
| `de_roles_flow.svg` | Sources → Data Engineering → consumers |
| `de_medallion_architecture.svg` | Ingestion → bronze/silver/gold → consumption |
| `data_lifecycle_linear.svg` | Lifecycle stages |
| `medallion_pipeline.svg` | Bronze → silver → gold |
| `data_structure_types.svg` | Structured / semi / unstructured |
| `batch_vs_streaming.svg` | Batch vs streaming |
| `data_sources_categories.svg` | Source categories |
| `formats_comparison.svg` | Row vs columnar vs schema formats |

---

## Examples (Code)

| File | Description |
|------|----------------|
| [examples/read_sample_formats.py](examples/read_sample_formats.py) | Minimal CSV + JSON parsing in Python |
| [examples/formats_quick_reference.md](examples/formats_quick_reference.md) | One-page format comparison |

---

## Suggested 8-Hour Agenda

| Hours | Activity |
|-------|----------|
| 1–2 | Read §1 + discuss roles (DE vs analyst vs DS); draw your org’s data flow |
| 3–4 | Read §2 + sketch lifecycle for one real dataset; batch vs stream examples |
| 5–6 | Read §2 (types & quality) + short quiz on structured vs unstructured |
| 7–8 | Read §3 + run `read_sample_formats.py`; discuss Parquet vs CSV for a BI use case |

---

## Extended curriculum

After this introduction, continue with:

- [Data Collection](../02_data_collection/README.md)  
- [Data Storage](../03_data_storage/README.md)  
- [Data Processing](../04_data_processing/README.md)  
- [Data Integration](../05_data_integration/README.md)  
- [Data Quality & Governance](../06_data_quality_governance/README.md)  
- [Data Security & Privacy](../07_data_security_privacy/README.md)  
- [Tools & Technologies](../08_tools_technologies/README.md)  

See **[TUTORIAL_INDEX.md](../TUTORIAL_INDEX.md)** for the full map.

---

*End of index document — open the linked note files for full explanations, diagrams, and tables.*
