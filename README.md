# Bitcoin Unspent Outputs By Address

## Overview

A Spring Boot java application that exposes a REST interface to get all unspent transaction outputs for a specific address
(uses the blockchain API)

## Prerequisites
 * Java 8 (To build & run)
 * Maven (To build)
 * The project uses lombok (https://projectlombok.org) so you may need to install the lombok plugin for your IDE.

## Building it
```
 mvn clean install
```

## Running it
```
 java -jar <PATH_TO_JAR_DIR>/bitcoin-<VERSION>-SNAPSHOT.jar
```

## Querying it :
  GET from http://localhost:8080/address/:bitcoin_addr returns list of unspent transaction outputs for this address
