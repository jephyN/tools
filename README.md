# Java Tools Library

A collection of utility classes providing various text processing and mathematical calculations.

## Overview

This project contains several utility classes that offer different functionalities:

- Text processing and search operations
- Mathematical calculations
- Word manipulation and validation

## Classes

### LongestWord

Finds the longest French word that can be constructed from a given set of characters.

**Features:**

- Case-insensitive character matching
- Pre-defined list of French words
- Optional return type for safe handling

**Usage Example:**

```java
String characters = "abcd";
Optional<String> longestWord = extractLongestWord(characters);
if (longestWord.isPresent()) {
    logger.info("The longest word is: " + longestWord.get());
} else {
    logger.info("No word found.");
}
```

### FindKeyWord

Finds all occurrences of a given keyword within a specified text.

**Features:**

- Case-insensitive keyword searching
- Accent and diacritical mark normalization
- Multiple occurrence detection
- Returns list of starting indices
- Support for French text processing

**Usage Example:**

```java
String keyword1 = "ali";
String text1 = "Alice aux pays des merveilles et ali baba";
logger.log(Level.INFO, FOLLOWING_INDICES, 
           new Object[]{keyword1, text1, findOccurrences(text1, keyword1)});
```

### FactorialCalculator

Calculates the factorial of a given integer n (0 <= n <= 100).

**Features:**

- Supports calculation of factorials for numbers 0 to 100
- Uses BigInteger for precise large number calculations
- Input validation with IllegalArgumentException
- Recursive implementation
- Thread-safe calculation

**Usage Example:**

```java
try {
    int n = 10;
    BigInteger factorialResult = factorial(n);
    logger.log(Level.INFO, "The factorial of {0} is : {1}", 
                    new Object[]{n, factorialResult});
} catch (IllegalArgumentException e) {
    logger.severe(e.getMessage());
}
```

