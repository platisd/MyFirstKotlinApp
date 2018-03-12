# Kotlin application demo
This repository contains a sample Kotlin application created to be demoed at the Global Android Platform team's study circle at Aptiv GOT.

## Kotlin
Kotlin looks to me like something in between JAVA and Python. Moreover, it looks like more modern and less verbose than JAVA. Kotlin can be used from the [command line](https://kotlinlang.org/docs/tutorials/command-line.html), without the need of a bulky IDE like Android Studio.

In this study circle we will first get to run a command-line `Hello World` Kotlin program, then go over the basic control flow syntax and finally work on a small assignment.

## Prerequisites
* Android Studio 3.0.0 or later
* JAVA 8
* A laptop that has the above installed :neckbeard:

## Hello World
**Αρχή ήμισυ παντός** - Ancient greek proverb translated into "The beginning is the half of everything".

It is attributed to various philosophers (i.e. Aristotle, Plato, Pythagoras). It implies that getting over the initial burden of _starting_ the pursue of a goal, is equivalent to half of the effort required to accomplish it. Practically, this means that after this workshop we will be half-done with porting all our Android applications to Kotlin. :sweat_smile:  

### Install Kotlin to your system
Do yourself a favor and do this on a modern Ubuntu 16.04 or later: `sudo snap install --classic kotlin`

If you really insist on Windows, try the following instructions I got from [here](https://turreta.com/2017/05/22/kotlin-compile-and-run-from-windows-command-line/)):
1. Get JAVA 8 and set `JAVA_HOME` appropriately. Will not cover this in these instructions.
1. Download a recent Kotlin compiler, e.g. [1.2.30](https://github.com/JetBrains/kotlin/releases/download/v1.2.30/kotlin-compiler-1.2.30.zip) and unzip.
2. The compiler `bat` scripts can be found inside the `bin/` folder.
3. Append the path to the Kotlin compiler's `bin/` directory to your `%PATH%`: `SET PATH=%PATH%;C:\Users\user123\Desktop\kotlinc\bin`

### Code
Create a `hello.kt` file with the following contents.

```kotlin
fun main(args: Array<String>) {
    println("Hello Global Android Platform team!")
}
```

### Compile & Run
* Compile it with: `kotlinc hello.kt -include-runtime -d hello.jar`
* Run it with: `java -jar hello.jar`

## Control flow in Kotlin
The following code examples were taken from [kotlinlang.org](https://kotlinlang.org/docs/reference/control-flow.html).
 
### If
 
```kotlin
 // Traditional usage 
 var max = a 
 if (a < b) max = b
 
 // With else 
 var max: Int
 if (a > b) {
     max = a
 } else {
     max = b
 }
  
 // As expression 
 val max = if (a > b) a else b
 
```
 
Since `if` can be used as an expression, I find the following usage the most peculiar:
 
```kotlin
val max = if (a > b) {
    print("Choose a")
    a // returns a
} else {
    print("Choose b")
    b
}

```
 
### When
`when` is the equivalent of `switch`, but on **steroids**. It can even do _ranges_! :muscle:
 
```kotlin

when (x) {
    1 -> print("x == 1")
    2 -> print("x == 2")
    3, 4 -> print("x == 3 or x == 4. Cool right?!")
    in 5..10 -> print("x ∈ [5, 10]")
    else -> { // Note the block
        print("x is neither 1 nor 2")
    }
}

```

One of the coolest parts is that we can use expressions as conditions.

```kotlin
when (x) {
    parseInt(s) -> print("s encodes x")
    else -> print("s does not encode x")
}
```
 
### For
Kotlin has a Python-like `for`.
 
```kotlin
for (message in uartMessages){
    print(uartMessage)
}

for (i in 1..3) {
    println(i)
}

```

### While
`while` looks more... conventional but it's useful that in the case of `do... while` you can access variables that were defined locally. No more having to initialize them outside!

```kotlin
while (x > 0) {
    x--
}

do {
    val y = retrieveData()
} while (y != null) // y is visible here!

```
 
## Classes
Classes do have some more _special_ syntax and grammar which will take too much time to cover in this study circle. Please refer to [kotlinlang.org](https://kotlinlang.org/docs/reference/classes.html) for more information.

## Assignment
Create an Android application which, upon a button press, sends a GET request to an external server that responds with the device's IP address which is then displayed on the screen. _Pro tip_ start by opening this project into your Android Studio (**version 3.0.0 or higher**) and use [Fuel](https://github.com/kittinunf/Fuel) which has already been set up for you.
