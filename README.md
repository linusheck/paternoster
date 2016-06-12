# paternoster
A 2D programming language with arrows.

The documentation is very spartanic, but I hope you can get all the information you need from it.

This is a little programming language that follows arrows around the file.

The program starts at: ↤, ↥, ↦ or ↧  and then follows the given direction.
If ←, ↑, →, ↓, ↖, ↗, ↘, ↙ are hit the program will follow their direction.

The code can also modify itself.

There are operations, which are basically commands. Some have results, some do actions.

Let's look at a little program.

```
↦ M 2 2 "+" M 2 8 "X" ↓
↑ P                   ←
```

Okay, there's a lot going on in this. Let's start at ↦, which tells the program to start there.
Now, M is called. M is the modify operation. It modifies the character at [2, 2] to be a plus.
This changes the M into a +. + is an add operation, and it takes two arguments, like this:
+ 1 3 => 4
After that, there is another modify operation which modifies the character on [2, 8] to be a X.
X simply terminates the program. The program would now look like this:
```
↦ + 2 2 X+" M 2 8 "X" ↓
↑ P                   ←
```
Now there's an arrow which redirects the program. Now we hit P, which prints the result of the next operation.
The next operation is + 2 2, so it will print 4. X terminates the program.

These are the current operations:

A assigns a variable to a value.
```
A example 5
```
will assign 5 to example.

P prints a value.
```
P example
```
will print 5.
```
p example
```
will print 5 without linebreak.

"" is a string.
```
P "Hello World!"
```
will print Hello World!

The operations +, -, /, * and % work as you would think they do.

=, < and > are conditional operators. They work like math operations, and return 1 for true and 0 for false.

! inverts 1 to 0 and 0 to 1.

? is an if operation.
After testing, they follow the arrows ↿, ⇃, ↼, ⇀ if the condition is true.
```
? = x 1 ⇃ P "x is not 1."
        X
```
will only print "x is not 1" if x is not one.

