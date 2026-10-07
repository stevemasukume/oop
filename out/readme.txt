# TANAKA STEVE MASUKUME - H250643V

## Department of Computer Science

# Object-Oriented Programming in Java
====================================

This repository contains the practical work for the supplied university lab
manual.

## Directories
-----------

* practicalAssignment: abstract Account, SavingsAccount, CurrentAccount and a
  polymorphic BankDemo.
* lab01 through lab10: one folder per lab, with Exercise1.java through
  Exercise5.java in each folder.
* labs: consolidated reference solutions for the practical exercises in
  Labs 1-10.
* libraryProject: the Lab 11 Library Management System mini-project.

## Compile and run the lab exercises:

```text
javac -d out LabExercises.java labs\LabExercises.java
java -cp out LabExercises
```

## Run an individual exercise from the repository root:

```text
javac -d out lab01\Exercise1.java
java -cp out lab01.Exercise1
```

## Compile and run the library demo:

```text
cd libraryProject
javac *.java
java LibraryDemo --demo
```

Run `java LibraryMenu` in `libraryProject` for the interactive menu. The
library application persists items, members and loans as CSV files in its data
directory.