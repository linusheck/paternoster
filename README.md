# paternoster
A 2D programming language with arrows.

The documentation is very spartanic, but I hope you can get all the information you need from it.

This is a little programming language that follows arrows around the file.

The program starts at: ↤, ↥, ↦ or ↧  and then follows the given direction.
If '←', '↑', '→', '↓', '↖', '↗', '↘', '↙' are hit the program will follow their direction.

There are these operations right now:

'X' terminates the program.
↦ X does nothing.

'A' is an assign operation.

    ↦ A $EXAMPLE "HELLO WORLD" X
will define $EXAMPLE as "HELLO WORLD".

Something in quotes is a string. Strings have a backslash as skip.

    ↦ A $i 0 ↓
    
    ↓        ←             i$ ! i$ A         ←
    → P "YOU'RE A | ? = $i 1 ⇃\SQUID\→ NOW!" ↑
                             →\KID\\\↑
for instance skips all of the backslashes and just prints
YOU'RE A SQUID NOW!
YOU'RE A KID NOW!

In this program, you can also see |.
| holds the current operation (for instance the string here) and makes a new one.
If that operation is finished it will continue with the old one.
In this example, this is the if that is put between the string.

'P' prints strings and numbers.

    ↦ A $EXAMPLE "HELLO WORLD" P $EXAMPLE X
will print "HELLO WORLD".

'p' is the same as P, but doesn't do a line break after printing something.

There are 4 math operations right now, +, -, * and /.

They execute like this:

    ↦ A $EXAMPLE * 2 8 P $EXAMPLE X
will print 16.0.

'?' is a condition:

              → P "The case."     ↓
    ↦ ? = 1 1 ↿ P "Not the case." → X

They work with the arrows ↿ ⇃ ↼ ⇀.
Consult all_arrows.txt for all of the arrows.

'#' skips the next character.

There are the comparison operators =, <, and >. They work like math operations.
The operator '!' inverts 1 to 0 and 0 to 1.

If it runs in that direction, a program also works vertically, backwards and diagonally.

To start a program, just cd into the directory the jar is in and type
java -jar paternoster.jar [program file].
You have to code in a monospace font.
