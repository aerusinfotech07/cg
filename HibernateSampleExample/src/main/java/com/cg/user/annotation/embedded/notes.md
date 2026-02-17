Notes - Embedded / Embeddable (Annotation)

- @Embeddable defines a reusable value object mapped into the owning entity table.
- @Embedded marks the property on the entity that gets its columns stored in the same table.
- No separate table is created for Address; its columns are stored in EMBEDDED_EMPLOYEE.
- Use @AttributeOverrides if you need to embed the same type more than once.
