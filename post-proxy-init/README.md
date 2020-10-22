# Post proxy initialization

- Introduced **@PostProxy** annotation for initialization method after proxy configuration
- Demonstrated 3-phase construction (1) constructor, (2) @PostConstruct and (3) @PostProxy initialization
- @PostProxy could be used when transactions needed on initialization

