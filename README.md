[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=22085089)
# advent-of-code-2025-day1

## Git Config
```
git config user.name "user"
git config user.email "email"
```

## Compiling and Running Java Programs
Note that since the shape classes are separate classes, you will need to compile ALL the files (at least one time).  You can do this by running
```
javac *.java
```
The star means to compile every file that is a Java file type.

Run your code by running
```
java Main.java
```

After you compile the shape classes, you only need to compile and run `Main.java` as usual.

# Instructions

## Advent of Code 2025
Go to [Advent of Code 2025 - Day 1 (Link)](https://adventofcode.com/2025/day/1).  Login with your Google student account, and get your unique program input.  Copy and paste the input into the file named `input.txt`.  Complete the program in `Main.java`

Specifically look at the `Scanner` class methods, and the `parseInt` method from the `Integer` class from the [AP Java Quick Reference](https://apcentral.collegeboard.org/media/pdf/ap-computer-science-a-java-quick-reference.pdf).

## --- Day 1: Secret Entrance ---
You arrive at the secret entrance to the North Pole base ready to start decorating. Unfortunately, the **password** seems to have been changed, so you can't get in. A document taped to the wall helpfully explains:

"Due to new security protocols, the password is locked in the safe below. Please see the attached document for the new combination."

The safe has a dial with only an arrow on it; around the dial are the numbers `0` through `99` in order. As you turn the dial, it makes a small click noise as it reaches each number.

The attached document (your puzzle input) contains a sequence of **rotations**, one per line, which tell you how to open the safe. A rotation starts with an `L` or `R` which indicates whether the rotation should be to the **left** (toward lower numbers) or to the **right** (toward higher numbers). Then, the rotation has a distance value which indicates how many clicks the dial should be rotated in that direction.

So, if the dial were pointing at `11`, a rotation of `R8` would cause the dial to point at `19`. After that, a rotation of `L19` would cause it to point at `0`.

Because the dial is a circle, turning the dial **left from `0`** one click makes it point at `99`. Similarly, turning the dial **right from `99`** one click makes it point at `0`.

So, if the dial were pointing at `5`, a rotation of `L10` would cause it to point at `95`. After that, a rotation of `R5` could cause it to point at `0`.

The dial starts by pointing at `50`.

You could follow the instructions, but your recent required official North Pole secret entrance security training seminar taught you that the safe is actually a decoy. The actual password is the **number of times the dial is left pointing at 0 after any rotation in the sequence.**

For example, suppose the attached document contained the following rotations:

```
L68
L30
R48
L5
R60
L55
L1
L99
R14
L82
```

Following these rotations would cause the dial to move as follows:

- The dial starts by pointing at `50`.
- The dial is rotated `L68` to point at `82`.
- The dial is rotated `L30` to point at `52`.
- The dial is rotated `R48` to point at `0`.
- The dial is rotated `L5` to point at `95`.
- The dial is rotated `R60` to point at `55`.
- The dial is rotated `L55` to point at `0`.
- The dial is rotated `L1` to point at `99`.
- The dial is rotated `L99` to point at `0`.
- The dial is rotated `R14` to point at `14`.
- The dial is rotated `L82` to point at `32`.

Because the dial points at 0 a total of three times during this process, the password in this example is `3`.

Analyze the rotations in your attached document. What's the actual password to open the door?

**Hints:** Because the dial is a continuous circle that can go from 0 - 99, it behaves like a "clock", and you can use modulo 100 to compute its numbers.

**Example**

- If the dial is at `99`, and you do `R3`, you expect to point at 2, and
$$ 99 + 3 = 102 \equiv 2 \pmod{100} $$