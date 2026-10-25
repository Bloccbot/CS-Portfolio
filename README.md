# Computer Science Portfolio

This repository contains selected projects and portfolio artifacts from my Computer Science program at Southern New Hampshire University. Each section represents work completed in a different course and demonstrates skills I have developed in areas such as software development, system design, operating platforms, Agile development, security, and problem solving.

The purpose of this portfolio is to document my progress throughout the program and provide examples of how I approach designing, developing, and evaluating software solutions.

## Portfolio Courses

* **CS 230 – Operating Platforms**
* **CS 250 – Software Development Lifecycle**
* **CS 255 – System Analysis and Design**
* **CS 320 – Software Test, Automation, and Quality Assurance**
* **CS 305 – Software Security**


Additional course projects will be added as I continue through the Computer Science program.

---

# CS 230 – Operating Platforms

## Portfolio Artifact

**Artifact:** The Gaming Room Software Design Document

The Gaming Room was the client for this project. They wanted to expand their Android game, *Draw It or Lose It*, into a web-based application that could support users on multiple operating platforms. The design needed to manage games, teams, and players while maintaining unique names and identifiers and considering storage, memory, networking, scalability, and security.

## Reflection

### What did I do particularly well in developing this documentation?

I think I did well organizing the client's requirements and connecting them to specific design decisions. The document compares platform options and explains why Linux is a strong production server choice while still allowing players to use Windows, macOS, Linux, Android, and iOS through a browser.

### What about the design document process was helpful when developing the code?

Working through the design document helped me understand the structure of the application before focusing on implementation. The UML domain model and requirements made relationships between Game, Team, Player, Entity, and GameService easier to understand and helped clarify where patterns such as singleton and iterator fit into the design.

### If I could revise one part of the document, what would I improve?

I would continue improving the system architecture section by adding more detail about how the production database, server instances, and real-time communication would work together. That would make the transition from the prototype to a full production environment even clearer.

### How did I interpret the user's needs and implement them into the software design? Why is this important?

I focused on The Gaming Room's need to support multiple platforms without maintaining a separate version of the game for every device. A browser-based client with centralized server-side game logic addresses that requirement while also supporting consistent game state and security. Considering user needs is important because a technically sound design is not useful if it does not solve the client's actual problem.

### How did I approach designing the software, and what would I use in the future?

I approached the design by first identifying the client's requirements and constraints, then comparing platform options and connecting those findings to architecture, storage, memory, networking, and security decisions. For similar projects, I would continue using requirements analysis, UML modeling, platform comparisons, and incremental design reviews before moving too far into implementation.

---

# CS 250 – Software Development Lifecycle

## Portfolio Artifact

**Artifact:** Sprint Review and Retrospective

This artifact demonstrates my understanding of Agile and Scrum practices through the SNHU Travel project. In this project, I reflected on Scrum roles, user stories, sprint planning, testing, communication, Sprint Reviews, and retrospectives. It shows how Agile practices can help teams adapt to changing requirements while delivering valuable software increments.

## Reflection

### How do I interpret user needs and implement them into a program? How does creating user stories help with this?

I interpret user needs by understanding what the user wants the software to accomplish before thinking about how to build it. User stories help break those needs into smaller, manageable tasks that focus on the value being delivered to the customer. This makes it easier to prioritize work, communicate with the team, and make sure the final product solves the user's problem.

### How do I approach developing programs? What Agile processes do I hope to incorporate into my future development work?

I approach development by breaking large projects into smaller tasks and completing them one step at a time. This course showed me the importance of planning, collaboration, and adapting when requirements change. In future projects, I hope to continue using Agile practices such as maintaining a prioritized backlog, writing clear user stories, participating in sprint planning, gathering regular feedback, and using retrospectives to continuously improve my work.

### What does it mean to be a good team member in software development?

Being a good team member means communicating openly, collaborating with others, and taking responsibility for my work. It also means being willing to accept feedback, help teammates when needed, and stay flexible when priorities change. Throughout this course, I learned that successful software development depends on teamwork, accountability, and a shared commitment to delivering value to the customer.


---

# CS 320 – Software Test, Automation, and Quality Assurance

## Portfolio Artifacts

Project One demonstrates input validation and automated JUnit 5 tests for an in-memory contact service:

* [Contact.java](CS320/ContactService/Contact.java)
* [ContactService.java](CS320/ContactService/ContactService.java)
* [ContactTest.java](CS320/ContactService/ContactTest.java)
* [ContactServiceTest.java](CS320/ContactService/ContactServiceTest.java)

Project Two evaluates the testing approach, results, strengths, and limitations across the contact, task, and appointment services:

* [Summary and Reflections Report](CS320/CS320_Project_Two_Summary_and_Reflections_Eddie_Loya.docx)

## Reflection

### How can I ensure that my code, program, or software is functional and secure?

I start by turning each requirement into a testable condition and checking both expected behavior and invalid input. In the contact service, my JUnit tests check field length boundaries, null values, phone number formatting, duplicate IDs, and updates and deletions by ID. Running the tests after changes helps catch regressions. I also use encapsulation and validation to protect object state, including keeping the contact ID immutable. Passing tests and high coverage increase confidence, but they do not prove that software is secure or free of defects. For a production application, I would add code review, dependency checks, authorization tests, and integration and security testing appropriate to the system.

### How do I interpret user needs and incorporate them into a program?

I break user needs into specific behaviors, constraints, and acceptance criteria before writing code. For example, the contact requirements define which fields can change, how long each field can be, and how contacts are identified. I incorporate those rules into the model and service, then write tests that verify them. Testing values at the exact limit and just beyond it helps me check that my interpretation matches the requirement. If a requirement is unclear, I would clarify the expected behavior with the user instead of making an assumption that could lead to the wrong result.

### How do I approach designing software?

I begin with the requirements and divide the program into small classes with clear responsibilities. In this project, Contact handles contact data and field validation, while ContactService manages storage and operations by unique ID. Keeping those responsibilities separate makes the code easier to understand, test, and maintain. I build incrementally and use automated tests to evaluate each behavior as it is added. The projects reinforced the value of planning for invalid inputs and edge cases early, while keeping the design focused on the actual scope of the application.


---

# CS 305 – Software Security

## Portfolio Artifact

[Artemis Financial Practices for Secure Software Report](CS305/Artemis_Financial_Practices_for_Secure_Software_Report.docx)

This completed Project Two report documents the SHA-256 checksum implementation, certificate generation, HTTPS configuration, functional testing, dependency analysis, and remaining security risks for the Artemis Financial application.

## Reflection

### Who was the client, Artemis Financial, and what issue did the company want to address?

Artemis Financial is a financial consulting company that develops plans involving savings, retirement, investments, and insurance. The company needed to improve the security of its web application and protect information exchanged with clients. My project focused on adding a checksum for data integrity verification and configuring secure communication through HTTPS. The work also required reviewing software dependencies and documenting the controls still needed before a production release.

### What did I do well when identifying vulnerabilities, and why does secure coding matter to a company's well-being?

I did well combining manual code review with OWASP Dependency-Check instead of relying on either method alone. In Project One, I connected findings such as hardcoded database credentials, missing access controls, and unsafe balance calculations to specific code locations and proposed mitigations. I also distinguished dependency matches from confirmed, reachable vulnerabilities. Secure coding helps protect confidentiality, integrity, and availability. For a financial company, that supports accurate records, reliable service, customer trust, and reduced exposure to incident recovery costs.

### Which part of the vulnerability assessment was challenging or helpful?

The most challenging part was interpreting dependency findings in context. A CVE match does not establish that the affected feature is present, enabled, or reachable in the application. Checking versions, modules, and deployment conditions helped me prioritize issues without treating every scan result as an established exploit. The vulnerability assessment process flow was helpful because it organized the review across areas such as cryptography, APIs, client/server communication, error handling, code quality, input validation, and encapsulation.

### How did I increase layers of security, and how would I assess vulnerabilities and choose mitigations in the future?

I added SHA-256 checksum generation through Java MessageDigest, configured HTTPS on port 8443, and generated an RSA-backed X.509 development certificate in a PKCS12 keystore. The refactor also added defensive response headers, reduced error disclosure, and separated checksum generation from HTTP handling. These controls address different concerns: the checksum supports integrity verification, while HTTPS protects information in transit. In future work, I would combine dependency scanning, manual review, threat modeling, and security tests, then prioritize mitigations based on affected functionality, exposure, severity, and business impact. Production deployment would also require supported dependencies, a trusted certificate, managed secrets, authentication, and authorization.

### How did I verify functionality and security after refactoring, and check for new vulnerabilities?

I compiled and tested the refactored application with Maven. One test checked the exact expected SHA-256 digest for my personalized input, and another checked that the Spring application context loaded with the HTTPS configuration. Both tests passed, and I checked the HTTPS hash endpoint and certificate details. I then ran Dependency-Check and reviewed the results against the changes. The refactor added no third-party runtime library, but the inherited Spring Boot dependency baseline still produced vulnerability findings. I documented those remaining risks rather than treating passing tests or the absence of a new library as proof that the application was fully secure.

### What resources, tools, and coding practices will help me in future assignments or tasks?

Java MessageDigest, keytool, Maven, JUnit, Spring Boot configuration, and OWASP Dependency-Check were useful tools. NIST publications helped distinguish hashing from encryption, while Oracle documentation and OWASP guidance supported the implementation and review. I would continue using standard cryptographic APIs, explicit UTF-8 encoding, small classes with clear responsibilities, repeatable tests, and documented risk decisions. Running tests and dependency checks during the build would help identify regressions and newly disclosed vulnerabilities earlier.

### What could I show future employers from this assignment?

I could show this report as evidence that I can connect a client's security requirements to implementation choices and verification results. It includes the checksum implementation, certificate and HTTPS evidence, passing test results, and a review of dependency findings. It also shows that I can explain the limits of a development demonstration and identify the work needed for production readiness. That combination demonstrates practical Java security skills, testing discipline, and the ability to communicate technical risk clearly.
