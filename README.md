# Computer Science Portfolio

This repository contains selected projects and portfolio artifacts from my Computer Science program at Southern New Hampshire University. Each section represents work completed in a different course and demonstrates skills I have developed in areas such as software development, system design, operating platforms, Agile development, security, and problem solving.

The purpose of this portfolio is to document my progress throughout the program and provide examples of how I approach designing, developing, and evaluating software solutions.

## Portfolio Courses

* **CS 230 – Operating Platforms**
* **CS 250 – Software Development Lifecycle**
* **CS 255 – System Analysis and Design**
* **CS 320 – Software Test, Automation, and Quality Assurance**
* **CS 305 – Software Security**
* **CS 300 – Data Structures and Algorithms: Analysis and Design**


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


---

# CS 300 – Data Structures and Algorithms Analysis and Design

## Portfolio Artifacts

* [Project One Pseudocode and Runtime Analysis](CS300/Project_One_Pseudocode_and_Runtime_Analysis.docx) — the completed design document, including runtime and memory comparisons for vectors, hash tables, and binary search trees.
* [ProjectTwo.cpp](CS300/ProjectTwo.cpp) — the completed C++ advising program that loads course records, prints courses in alphanumeric order, and displays a course with its prerequisite titles.
* [Course Data](CS300/CS_300_ABCU_Advising_Program_Input.csv) — the course-provided input used with the program.

### Build and Run

From the CS300 folder, compile with a C++17 compiler and run the program:

```sh
g++ -std=c++17 -Wall -Wextra -Wpedantic ProjectTwo.cpp -o course-planner
./course-planner
```

Choose option 1 and enter `CS_300_ABCU_Advising_Program_Input.csv`. Option 2 prints the sorted course list, option 3 displays one course and its prerequisites, and option 9 exits. The program uses only standard C++ headers and does not require CSVParser or custom header files.

## Reflection

### What was the problem I was solving in the projects for this course?

The projects focused on an advising program for ABCU that helps users review Computer Science courses and their prerequisites. Project One compared data structures and developed pseudocode for loading course records, validating prerequisites, searching for courses, and printing a sorted course list. Project Two implemented the design in C++. The finished program reads the supplied CSV file, prints courses in alphanumeric order, and displays a selected course with the numbers and titles of its prerequisites.

### How did I approach the problem, and why are data structures important to understand?

I started with the operations the program needed to support, then compared vectors, hash tables, and binary search trees in terms of runtime, memory, and ordering. I selected a hash table because course and prerequisite lookups are central to the advising task. In Project Two, an unordered_map stores courses by course number, while a temporary vector of pointers is sorted when the user requests the full list. This provides expected constant-time lookup and O(n log n) sorting without copying every course object. Understanding data structures helped me recognize the tradeoff between fast lookup and naturally ordered output, along with the worst-case behavior and memory overhead of each option.

### How did I overcome roadblocks encountered during the activities or projects?

One challenge was validating prerequisites when the referenced course appeared later in the file. I handled this by loading the records first and checking prerequisite references after the complete file had been read. The supplied CSV also includes blank prerequisite columns, so the implementation ignores those fields while still requiring a course number and title. Another concern was preventing an unsuccessful reload from damaging previously loaded data. I used a temporary hash table and replaced the active table only after validation succeeded. Testing duplicate records, missing prerequisites, malformed rows, failed file loads, and sorted output helped verify these decisions.

### How has this work expanded my approach to designing software and developing programs?

The projects encouraged me to evaluate the required operations before choosing a data structure. I now consider expected and worst-case runtime, memory use, input validation, and the frequency of each operation together. Moving from pseudocode to working code also showed me that a design needs to accommodate the actual input format, such as the CSV's empty prerequisite columns. I would continue separating planning, implementation, and verification while revisiting design assumptions when real data exposes a mismatch.

### How has this work changed the way I write programs that are maintainable, readable, and adaptable?

I organized the program into functions for CSV parsing, course loading, menu validation, sorted output, and course lookup. The Course structure keeps related information together, and descriptive names and focused comments explain the purpose of each operation. Consistent course-number normalization makes searches easier to use, while controlled error messages make invalid input easier to diagnose. Keeping data processing separate from menu handling makes future changes more manageable, such as adding a new output format or replacing the storage structure without rewriting the entire program.
