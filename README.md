# Spring Boot with Liqubase

Liquibase is an open-source database-independent library for tracking, managing and applying database schema change.
This sample code demonstrates the usage of liquibase with a spring boot application. Spring boot supports liquibase autoconfiguration from version 2.0.4.
The preconditions for this are the presence of `org.liquibase:liquibase-core` in the classpath and the availability of a `dataSource` bean.

## Liquibase Usage
Master changelog file is `src\main1resources\changelog-master.yaml` Each database object maintains its own changelog file under ``src\main1resources\changelog`.
Each changeset is uniquely identified by a `changesetId`.

## H2 database
This example uses file-based H2 database, which gets initialized during context initialization. Then the liquibase runtime acquires a lock on the `DATABASECHANGELOGLOCK` table,
compares the `DATABASECHANGELOG` table and identifies the changes (if any), executes the db commands and updates the changelogs.

## Other Useful Liquibase Commands
Refer [Liquibase command reference](https://www.liquibase.org/documentation/command_line.html) for a set of useful commands provided by liquibase for purposes like
`generating db diffs`, `performing rollbacks`, `generate ddl scripts from existing databases` etc.
