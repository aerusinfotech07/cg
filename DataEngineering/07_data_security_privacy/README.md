# Data Engineering – Data Security & Privacy

> **Goal:** Understand how to protect data in motion and at rest, control access, and respect privacy regulations—without blocking legitimate analytics.

---

## 1. Security vs Privacy

| Term | Focus |
|------|--------|
| **Security** | Confidentiality, integrity, availability—**who can access** and **whether data is tampered with**. |
| **Privacy** | **Individuals’ rights** about their personal data—collection, use, retention, deletion. |

Data engineers implement **technical controls** for both.

---

## 2. Core Security Controls

| Control | Examples |
|---------|----------|
| **Authentication** | SSO, IAM users, service accounts |
| **Authorization** | RBAC, row/column-level security in warehouses |
| **Encryption at rest** | KMS-managed keys for S3, databases |
| **Encryption in transit** | TLS for APIs, JDBC, Kafka |
| **Network** | VPCs, private endpoints, firewalls |
| **Secrets** | Vault, cloud secret managers—never hardcode keys |
| **Audit logs** | Who accessed what, when |

---

## 3. Personally Identifiable Information (PII)

- **PII** – Data that identifies a person (name, email, ID, IP in some contexts).  
- **Sensitive PII** – Health, financial, biometric—often stricter rules.  

**Techniques:**

- **Minimize** collection  
- **Tokenization** – Replace with reversible tokens where needed  
- **Masking** – Show partial data (e.g. `****1234`)  
- **Pseudonymization** – Replace identifier with a stable fake ID  
- **Aggregation** – Release only statistics at safe granularity  

---

## 4. Regulations (Awareness)

| Regulation | Region / scope | Themes |
|------------|------------------|--------|
| **GDPR** | EU | Consent, right to erasure, portability, DPA |
| **CCPA / CPRA** | California | Disclosure, opt-out, deletion |
| **HIPAA** | US healthcare | PHI safeguards |
| **Industry** | PCI-DSS for payments | Cardholder data |

**Note:** Engineers are not lawyers—always involve **legal/compliance** for interpretation.

---

## 5. Security in Pipelines

- **Least privilege** – Jobs use dedicated service accounts with minimal permissions.  
- **Separate** environments (dev/stage/prod); no production secrets in dev.  
- **Scan** dependencies and images for vulnerabilities.  
- **Classify** datasets (public, internal, confidential, restricted).  

---

## 6. Summary

- Apply **defense in depth**: identity, network, encryption, secrets, audit.  
- Treat **PII** with **purpose limitation** and **technical controls**.  
- Align with **organizational policy** and **regulatory** requirements.

---

## Next module

→ [Tools & Technologies](../08_tools_technologies/README.md)
