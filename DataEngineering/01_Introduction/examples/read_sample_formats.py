"""
Data Engineering intro – reading CSV and JSON in Python (illustrative).
Requires: Python 3.9+ (stdlib only for this demo).
"""
import csv
import io
import json

# --- CSV: row-oriented, human-readable ---
csv_text = """id,name,price
1,Apple,1.50
2,Banana,0.75
"""
print("=== CSV parsed with csv.DictReader ===")
reader = csv.DictReader(io.StringIO(csv_text))
for row in reader:
    print(row)

# --- JSON: semi-structured, flexible ---
payload = {"items": [{"id": 1, "name": "Apple", "price": 1.5}]}
print("\n=== JSON dumps ===")
print(json.dumps(payload, indent=2))

print("\n=== JSON lines (JSONL) - one object per line ===")
for item in payload["items"]:
    print(json.dumps(item))
