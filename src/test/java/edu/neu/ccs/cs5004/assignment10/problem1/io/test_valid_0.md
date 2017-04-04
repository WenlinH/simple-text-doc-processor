# Header at Level 1

Headers appear on a line of their own. A header starts with the one or
more occurrences of the symbol `#` followed
by one space followed by text and ends with a newline.
Headers are section titles. The number of `#` symbols indicate the
nesting of headers.

## This is a header at level 2

Nested Headers might appear out of order, for example

#### Out of order header

# Paragraphs

Paragraphs are free form text. Paragraphs are separated by new lines.

This is the second paragraph in this section

# Lists

There are 2 kinds of lists, itemizations and enumerations.

## Itemization Lists

These are also called "bullet" lists. An itemization list always starts on a new line
and can use any of the following simbols to denote the beginning of at item
`*` or `+` or `-` followed by one space and then text for example

* itemization list, first element
* itemization list, second element
* itemization list, third element

We can mix the symbols as well, e.g.,

* itemization list, first element
+ itemization list, second element
- itemization list, third element

The last element of an itemization list is the one that is followed
by an empty line.

And of course we can nest itemization lists by adding 2 spaces in the beginning
of the line for evey nested level, e.g.,

* itemization list 1, first element
  * itemization list 2, first element
  * itemization list 2, second element
    * itemization list 3, first element
  * itemization list 2, third element
* itemization list 1 , second element

## Enumeration  Lists

Enumeration lists are similar to itemization lists but the items are marked with a numeral
that increases for each item.

Enumeration lists appear on a separate line and start with either `.` followed by one space
or two special characters `1.` followed by a space.

For example here is a numbered lists

1. This is the first item
1. the second item
1. the third item

As with itemization lists we can mix and match the special characters, e.g.,

. This is the first item
1. the second item
. the third item

The last element of an enumeration list is the one that is followed by an empty
line.

We can nest ordered lists by adding 2 spaces followed by the same special
characters (`.` or `1.`) for numbered lists, e.g.,

1. This is the first item of the outer list
1. This is the second item of the outer list
  1. This is the first item of the inner list
  1. This is the second item of the inner list
1. This is the third item of the outer list
