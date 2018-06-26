# course-api
RESTful Spring boot microservice used to manage the courses.

### Schema
Apache Derby is used as tmp data store. You can replace it with any desired data store.
```
Courses
- id 
- name
- description
- topic (Foreign key pointing to Topic)

Topic
- id 
- name
- description
```
