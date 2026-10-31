# CompSci121JAVAGuesser

#### A Number Guessing Game that goes both ways

Constant turns is the number of guesses allowed (7).

```
function options():
    print "0) exit"
    print "1) Human Guesser"
    print "2) Computer Guesser"
    read a line from the user, convert it to an integer
    return that integer
```

```
function humanGuesser():
    create boolean variable humanWin, set to false
    create integer variable correctNum, set to a random whole number from 1 to 100
    for i from 0 to turns:
        print "Please enter a whole number 1-100:"
        read a line from the user, convert it to an integer called guess
        if guess is from 1 to 100:
            if guess < correctNum:
                print "Too Low"
            else if guess > correctNum:
                print "Too High"
            else:
                print "You Got It!"
                set humanWin to true
                stop the loop
        else:
            print "That Number isn't within the parameters"
            decrement i (an invalid guess does not use up a turn)
    if humanWin is false:
        print "Do Better Next Time"
```

```
function computerGuesser():
    create boolean variable computerWin, set to false
    create integer variable computerGuess, set to 50
    create integer variable minGuess, set to 1
    create integer variable maxGuess, set to 100
    print "Think of a whole number 1-100, enter 1 when ready"
    repeat reading an integer from the user until it equals 1
    for i from 0 to turns:
        print "The computer has guessed", computerGuess
        print "Too (H)igh, too (L)ow, or (C)orrect?"
        read a line from the user, call it human
        if human is "H" (ignoring case):
            set maxGuess to computerGuess - 1
            set computerGuess to computerGuess + ((minGuess - computerGuess - 1) / 2)
        else if human is "L" (ignoring case):
            set minGuess to computerGuess + 1
            set computerGuess to computerGuess + ((maxGuess - computerGuess + 1) / 2)
        else if human is "C" (ignoring case):
            print "The Computer is happy with its victory"
            set computerWin to true
            stop the loop
        else:
            print "That isn't one of the options"
            decrement i (an invalid answer does not use up a turn)
    if computerWin is false:
        print "The Computer is displeased with your lies"
```

Division in `computerGuesser` is whole-number division, so any remainder is dropped.

```
function main():
    set choice to options()
    while choice != 0:
        if choice == 1:
            humanGuesser()
        else if choice == 2:
            computerGuesser()
        else:
            print "That isn't one of the options, try again"
        set choice to options()
    return 0
```
