DSCOW
=========

`DSCOW` provides decision support for cross-organisational workflows modelled in `Rpl`, utilising the simulation capability of `RplTool`. `Rpl`  is inspired by an active object language [ABS](https://abs-models.org/), and has a Java-like syntax and actor-based concurrency model. In actor-based concurrency models, actors are primitives for concurrent computation. Actors can send a finite number of messages to each other, create a finite number of new actors, or alter their private states. One of the primary characteristics of actor-based concurrency models is that only one message is processed per actor, so the invariants of each actor are preserved without locks.

In addition, the language has
explicit notions for logical disjunction and conjunction between the task dependencies, qualitative assessment of resources, method invocation with deadlines and time
advancement. The language also supports a static cost analysis which allows the workflow analysers to estimate the effect
of changes in collaborative workflows concerning cost in terms of
execution time.

Inside this repository, we develop the core tool of the `Rpl` modelling
language.

## **Installing Dependencies**

Running the RplTool requires installing Java (version 11 or greater) and Erlang (version 23 or greater). Java can be downloaded, e.g., from https://adoptopenjdk.net. Erlang is available at https://www.erlang.org/downloads (but also check below for platform-specific instructions).

### **Installing dependencies on MacOS**

On MacOS, the homebrew package manager can be used to install the dependencies. After installing homebrew, run the following commands in a terminal:

`brew tap adoptopenjdk/openjdk`

`brew install erlang git adoptopenjdk11`

### Installing dependencies on Windows

On Windows, the Chocolatey package manager can be used to install the dependencies. First, install Chocolatey following the instructions at https://chocolatey.org/install, then run the following command in a terminal with Administrator rights:

`choco install openjdk11 git erlang visualstudio2019buildtool`

To compile the RplTool, make sure to run the command `./gradlew build` from a developer shell (Start -> Visual Studio 2019 -> Developer PowerShell for VS 2019).

### Installing dependencies on Linux

On Linux, check if your distribution offers the programs pre-packaged in the version needed (JDK11, Erlang >= 23, a C compiler); otherwise, download from the distribution pages linked above.

## Compilation

To compile, clone the git repository and run gradle (after installing the necessary dependencies):

`git clone https://github.com/razi236/DSCOW.git`

Afterwards, go to the directory `DSCOW` using the following command:

`cd DSCOW`

Now build the tool using the following command:

`./gradlew assemble`

Finally, run the tool.

`make`
