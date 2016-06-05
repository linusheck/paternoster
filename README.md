# paternoster
A 2D programming language with arrows.

This is a little programming language that follows arrows around the file.

The program starts at: ↤, ↥, ↦ or ↧  and then follows the given direction.
If '←', '↑', '→', '↓', '↖', '↗', '↘', '↙' are hit the program will follow their direction.

There are these operations right now:

X terminates the program.
↦ X does nothing.

A is an assign operation.

↦ A $EXAMPLE "HELLO WORLD" X
will define $EXAMPLE as "HELLO WORLD".

"" is a String.

P prints Strings.

↦ A $EXAMPLE "HELLO WORLD" P $EXAMPLE X
will print "HELLO WORLD".

That's it for now. I will add math soon, then it'll become interesting.
