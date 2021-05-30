Base Framework Structure: 

- BDD Framework
- Maven Project
- TestNG Library

Instructions to Execute:

* Clone Project and run in command line:
mvn clean verify -Dcucumber.options="--tags @demo" -Dbrowser=chrome -Denv=DEV

mvn         - Execute Maven project
--tags      - Cucumber feature file tags
-Dbrowser   - Chrome, firefox (browsers defined in Driver Class)
-Dend       - Define work environment Either QA or DEV or PROD (Configured in configuration.properties)

reports are generated in target directory
