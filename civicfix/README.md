CivicFix
========

CivicFix is a simple civic issue reporting application developed to help citizens raise local problems and help authorities track and resolve them in a transparent way.

Overview
--------
- Citizens can report issues related to roads, water supply, electricity, sanitation, or other public problems.
- Issues are stored with basic details: `title`, `description`, `category`, `status`.
- New issues default to status `OPEN` when created.
- Admins/officials can view, filter, update, and escalate issues via admin endpoints.

Architecture
------------
- Java Spring Boot backend
- MySQL database
- Layered structure with packages:
  - `com.civicfix.civicfix.Endity` (entities)
  - `com.civicfix.civicfix.Repository` (repositories)
  - `com.civicfix.civicfix.Service` (services)
  - `com.civicfix.civicfix.Controller` (controllers)

Design notes
------------
- No authentication/security is implemented (keeps project simple for demo).
- Admin/officials are represented logically via separate admin endpoints (e.g., `/civicfix/admin/*`).
- Escalation is handled by increasing an `escalationLevel` and setting status to `ESCALATED`.
- The design prioritizes clarity and simplicity for academic demonstration.

Key Endpoints
-------------
- Citizen endpoints (examples):
  - `POST /civicfix/issue/create` - create an issue (status set to OPEN)
  - `GET  /civicfix/issue/readall` - list all issues
  - `GET  /civicfix/issue/readbyid/{id}` - get issue by id
  - `PUT  /civicfix/issue/update/{id}` - update issue
  - `DELETE /civicfix/issue/delete/{id}` - delete issue

- Admin endpoints (examples):
  - `GET  /civicfix/admin/readallissues` - admin sees all issues
  - `GET  /civicfix/admin/readbystatus/{status}` - filter issues by status
  - `PUT  /civicfix/admin/updatestatus/{id}/{status}` - update status
  - `PUT  /civicfix/admin/escalate/{id}` - escalate (increase level and set ESCALATED)

Run locally
-----------
1. Create MySQL database `civicfix` and update `src/main/resources/application.properties` if needed.

2. Build and run:

```bash
mvn clean package
mvn spring-boot:run
```

3. Server runs on `http://localhost:8080` by default.

Notes for demo
--------------
- Show how a citizen creates an issue (`POST /civicfix/issue/create`).
- Then show how an admin lists all issues and updates status (`GET /civicfix/admin/readallissues`, `PUT /civicfix/admin/updatestatus/{id}/{status}`).
- Explain that role separation is logical (via endpoints) and not enforced by authentication in this version.

Extensions (future)
-------------------
- Add authentication and role-based access control
- Add user -> issue relationship (link creator)
- Add notification/email when status changes
- Add simple frontend to display issues and admin view

License
-------
This project is for educational/demo purposes.
