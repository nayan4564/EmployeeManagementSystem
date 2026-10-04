IF DB_ID('EmployeeManagementDB') IS NULL
 CREATE DATABASE EmployeeManagementDB;
GO
USE EmployeeManagementDB;
GO
-- Spring Data JPA creates/updates application tables on first run (ddl-auto=update).
-- This script creates the database only; do not manually create tables with a different schema.
