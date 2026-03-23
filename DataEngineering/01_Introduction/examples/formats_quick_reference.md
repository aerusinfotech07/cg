# Data Formats – Quick Reference

| Format | Structure | Best for | Watch out for |
|--------|-----------|----------|----------------|
| **CSV** | Rows, text | Simple exchange, Excel | Types, commas, encodings |
| **JSON** | Nested text | APIs, configs | Size, schema drift |
| **JSONL** | One JSON per line | Streaming logs | Same as JSON per line |
| **Parquet** | Columnar binary | Analytics, lakes | Not human-readable raw |
| **Avro** | Row binary + schema | Kafka, evolution | Needs schema registry often |

**Compression:** Often **Snappy** or **Zstd** with Parquet; **Gzip** for CSV/JSON in object storage.
