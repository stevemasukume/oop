# TANAKA STEVE MASUKUME - H250643V

## Department of Computer Science

# Object-Oriented Programming in Java

This repository contains the practical work for the supplied university lab
manual.

## Directories

- **practicalAssignment:** Abstract `Account`, `SavingsAccount`, `CurrentAccount` and a polymorphic `BankDemo`.
- **lab01 through lab10:** One folder per lab, with `Exercise1.java` through `Exercise5.java` in each folder.
- **labs:** Consolidated reference solutions for the practical exercises in Labs 1-10.
- **libraryProject:** The Lab 11 Library Management System mini-project.

## VS Code Java Configuration

The workspace configures `labs`, `practicalAssignment` and `libraryProject` as
separate Java source folders. This matches the package declarations used by
the lab exercises and prevents package errors in the Problems panel.

## Compile and Run the Lab Exercises

From the repository root:

```bash
javac -d out labs\LabExercises.java labs\LabExercisesRunner.java
java -cp out LabExercises
```

## Run an Individual Exercise from the Repository Root

```bash
javac -d out labs\lab01\Exercise1.java
java -cp out lab01.Exercise1
```

## Compile and Run the Bank Demo

From the repository root:

```bash
javac -d out practicalAssignment\*.java
java -cp out BankDemo
```

## Compile and Run the Library Demo

```bash
cd libraryProject
javac *.java
java LibraryDemo --demo
```

## Interactive Library Menu

Run the following command inside the `libraryProject` directory:

```bash
java LibraryMenu
```

The library application persists items, members and loans as CSV files in its
`data` directory.