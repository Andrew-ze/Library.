# Library Management System

A console application modeling a community library's book lending system, built as part of Object Oriented Programming project, implemented in Java SE (JDK 8+).

## Project Structure

```
.
├── Book.java
├── Member.java
├── Loan.java
├── Library.java
└── LibraryDemo.java
```

## Classes

- **Book** – represents a book (auto-generated 13-digit ISBN, title, author, availability status)
- **Member** – represents a library member (auto-generated member ID, name, list of active loans)
- **Loan** – links a member to a borrowed book, with borrow and due dates
- **Library** – manages the collection of books and members; handles lending and returns

## Key Features

- Two overloaded constructors in `Book` (with and without author — defaults to "Unknown" if not provided)
- Auto-generated 13-digit ISBN for each book and random member IDs
- Enforced rule: a book cannot be lent out if it's already on loan
- `toString()` overrides on every class for readable, formatted output
- All methods return result strings rather than printing directly, keeping logic separate from display

## How to Run

```bash
javac Book.java Member.java Loan.java Library.java LibraryDemo.java
java LibraryDemo
```

## Design Notes

- All fields are `private` (encapsulation) — access is controlled through getters/setters
- `Library` *composes* `Book` and `Member` — they exist only within the context of the library
- `Member` *aggregates* `Loan` — loans are tracked via the member's list but exist as independent objects
- `Loan` *associates with* `Book` and `Member` — it references them without owning their lifecycle

## Requirements

- Java SE Development Kit (JDK) 8 or higher

## Author

Andrew Ategeka
