Notes - Second Level Cache (Ehcache)

- Second-level cache stores entities across sessions (SessionFactory scope).
- @Cacheable + @Cache enables Hibernate to put Product in the cache region.
- Ehcache settings are in src/main/resources/ehcache.xml.
- In logs, the second get() in a new session should avoid a DB hit if cache is working.
