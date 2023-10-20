# Project #3: Experiments with Hashing

* Author: Michael Dunn
* Class: CS321 Section #001
* Semester: Fall 2023

## Overview

This program creates two hash tables using the Linear Probing and Double Hashing strategies,
and compares their outputs. This is meant to reflect the differences between their hashing
functions and the impact on collisions. 

## Reflection

This project was very fun to work on. I enjoyed learning about hash function and the differenes
that a different hashing strategy can have on the end result. The object oriented principles
that we used to implement this design were pretty easy. I felt that I didn't have to really
think about how it would be structured after reading through the expected results as the 
design made sense.

One issue that I ran into that took me a while to figure out had to do with how I was hashing
each HashObject while inserting it. The parameter for insert included a HashObject x. When I
wanted to get the hash value for it, I would call `x.hashCode()` which ended up needing to be
`x.key.hashCode()`. This small fix caused my results to get extremely close to the expected
results. After fixing that, I was practically finished. It was very satisfying running the code
and seeing the diff return no differences.

## Compiling and Using

This section should tell the user how to compile your code.  It is
also appropriate to instruct the user how to use your code. Does your
program require user input? If so, what does your user need to know
about it to use it as quickly as possible?

### Compile:
```bash
javac HashtableTest.java
```

### Run with:
```bash
java HashtableTest <dataSource> <loadFactor> [<debugLevel>]

<dataSource>: 1 for random numbers, 2 for dates, 3 for word list
<loadFactor>: The ratio of objects to table size, denoted by α = n/m
<debugLevel>: 
           0 ==> print summary of experiment
               1 ==> same as 0 and dump the two hash tables to files at end
               2 ==> print debugging output for each insert
```

## Results

Results from the hash table experiments.

### Date Results:
```text
--------------------------------------------------------------------------------
HashtableTest: Found a twin prime table capacity: 95791
HashtableTest: Input: Date  Load factor: 0.50
	Using Linear Probing
HashtableTest: size of hashtable is 47896
	 Inserted 47896 elements, of which 0 were duplicates
	 Avg. no. of probes 1.08

	Using Double Hashing
HashtableTest: size of hashtable is 47896
	 Inserted 47896 elements, of which 0 were duplicates
	 Avg. no. of probes 1.12
--------------------------------------------------------------------------------
```

### Random Integer Results:
```text
--------------------------------------------------------------------------------
HashtableTest: Found a twin prime table capacity: 95791
HashtableTest: Input: Integer  Load factor: 0.50
	Using Linear Probing
HashtableTest: size of hashtable is 47896
	 Inserted 47896 elements, of which 0 were duplicates
	 Avg. no. of probes 1.50

	Using Double Hashing
HashtableTest: size of hashtable is 47896
	 Inserted 47896 elements, of which 0 were duplicates
	 Avg. no. of probes 1.38
--------------------------------------------------------------------------------
```

### Word List Results:
```text
--------------------------------------------------------------------------------
HashtableTest: Found a twin prime table capacity: 95791
HashtableTest: Input: Word-List  Load factor: 0.50
	Using Linear Probing
HashtableTest: size of hashtable is 47896
	 Inserted 1305930 elements, of which 1258034 were duplicates
	 Avg. no. of probes 1.60

	Using Double Hashing
HashtableTest: size of hashtable is 47896
	 Inserted 1305930 elements, of which 1258034 were duplicates
	 Avg. no. of probes 1.39
--------------------------------------------------------------------------------
```

## Sources used

[Scanner - StackOverflow](https://stackoverflow.com/questions/53745339/is-there-a-need-to-close-resource-if-we-use-try-with-resource)

[PrintF - StackOverflow](https://stackoverflow.com/questions/3853185/double-formatting-question-for-printf-in-java)

[Equals - StackOverflow](https://stackoverflow.com/questions/364454/findbugs-warning-equals-method-should-not-assume-anything-about-the-type-of-its)