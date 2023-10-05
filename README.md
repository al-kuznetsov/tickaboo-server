# Tick-a-Boo Server (tickaboo-server)

This is the backend server for Tick-a-Boo project that help people to manage and track how their time is invested.

## Configure and run

### Database connection

Database connection is configured with properties:  
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/postgres
    username: postgres
    password: password
```
For testing purposes you can bootstrap a postgres database in docker with command   
`docker run --name postgis-local -p 5432:5432 -e POSTGRES_PASSWORD=password -d postgis/postgis:16-3.4`

## Code of Conduct

TBD

## Access to Binaries

TBD

## Documentation

TBD

## Build from Source

TBD

## Continuous Integration Builds

TBD

## Stay in Touch

TBD

## License

The Tick-a-Boo server is released under version 2.0 of the [Apache License](https://www.apache.org/licenses/LICENSE-2.0).