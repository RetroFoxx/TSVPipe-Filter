## Table of contents
* [General info](#general-info)
* [Part 1](#part-1)
* [Part 2](#part-2)
* [Part 3](#part-3)

## General info
This project is a programming assignment that enforces principles of good class construction to a simple but potentially very large database system.
The assignment has us think of the system in terms of API libraries and exceptions. We are asked to write our system so that it never holds more than a few lines of input at a time within main storage, but rather makes decisions and accumulates information as the information is “passing by”. This is called the “Pipes&Filters” pattern.

The Unix family ofoperating systems provides many shell commands that operate on this pattern. See:http://www.linfo.org/filters.htmlNote that Java supports a similar concept of streams and provides a package for using them, but we are not asked to use that part of the API. Rather, we are asked to use our existing knowledge of Java to explore the stream concept itself. For this assignment, we are asked to write them from scratch, to better understand them.
Streams are used for “Big Data”. They have some interesting properties. As the Java APIstates:
1. Streams use little storage and create few data structures, but are best conceived of as a kindof pipeline through which data flows.
2. Streams do not modify the incoming data at all. Methods that operate on streams just producenew streams of data that have been derived from the incoming stream. These new streamscan be larger, or smaller, or of different types. Or they may simply have aggregate datasuch as the minimum, maximum, average, or those values that are inside or outside someacceptable limits, or those values that have some other properties of interest (e.g., “All thesalespeople in Kansas.”)
3. Streams can often be processed quickly and by a kind of LazyEvaluation pattern, such asfinding the first value that meets some criteria (“Is any customer named Bill?”), or such asfinding just the first N components that meet certain criteria. These are called “immediate”operations, since they don’t have to examine the entire stream. (The other operations arecalled “terminal”.)
4. Streams can be arbitrarily long, even bigger than main store can hold. They in fact may neverend, like data that is generated continuously from physicalsensors, like speed or temperature,or from social processes that have no conceptual reason to stop, like political websites.
5. Streams can be created, processed, and output in parallel(although we won’t do that in this assignment).
6. Streams can be thought of as a kind of Iterator pattern: as the stream “goes by”, the methods will see each component exactly once. However, unlike with a ListIterator, a stream has to be“revisited” if you want to backup, since it holds only a limited portion of the data, and it canonly go in one direction. This sometimes is a reason not to usethem at all.We will use as our example of streams a standard tab separatedfile, *.tsv, whose fields areseparated by tabs (’\t’) and whose lines are terminated by newlines (’\n’). Each line is a “record”.Each record follows the invariant that it has the proper number and types of fields, and that no fieldis allowed to have a ’\t’ or ’\n’ in it. The first line of the *.tsv file contains “headers”, that is, real world descriptions taken from the use case. Even if the file has been stored as a small complete text file on external storage, it is still processed one record at a time internally in the computer system. It is critically important5
that the file be properly formed. This is where the concepts of API libraries and exceptions comein. Your system should not trust anyone to give it a properly formed *.tsv file or stream, so yoursystem will have to check it and complain about violations.

## Part 1
Part 1 asks us to write a stream method that reads a *.tsv file one record at a time, checks the record for proper form, and outputs the record to a *.tsv file if it is correctly formatted. A file has proper form if the output file is the same as the input file.

Some details:
System needs to check if the file exists, and if file is properly formatted.
Choice of data structure to record the record cannot be hard-coded, must be derived from stream itself. System must discover and encode format somehow.

## Part 2 
Encapsulate method from step 1 into two classes, TSVFilter and TSVPipeline. TSVFilter uses the Builder pattern, so that it is a flexible way to build a specific instance of the TSVFilter class.
TSVPipeline does most of work. Program a select operation that imitates the relational db select operation.

## Part 3
Extend filter so we also allow a terminal stream operation. Code Min, Max, build terminal operation into TSVFilter.
