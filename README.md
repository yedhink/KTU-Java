# Introduction
This repo consists of my work on Java and the simple programs which i had done inorder to learn Java. To be specific my aim was to familiarize
with the APJ Abdul Kalam Technological University's (initially Kerala Technological University(KTU)) [syllabus](https://drive.google.com/file/d/0B9ojglPaasIEUUFuSVRXbDlZTEk/view) for Java. 
Created this repository with the aim of helping out my friends and others to understand the basics of Java and to understand its scope by doing some programs. 

# Requirements
1) Java (Obviously) --> [Install Java](https://java.com/en/download/help/download_options.xml)
2) Java SE Development Kit(JDK) --> [Install JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html)
3) For coding make use of IDEs like [IntelliJ](https://www.jetbrains.com/idea/download/index.html#section=linux) or Text Editors like [Sublime Text](https://www.sublimetext.com/3)
   or the classic and powerful command line editor [vim](https://www.vim.org/download.php) which i use. `¯\_(ツ)_/¯`

# How to use my repositiory? 
Assuming that you've already installed the requirements and it is in a working condition. Then:-    
1) Fork the repository(optional)
2) Clone/Download the files into your local machine  
   ###### For Linux Users :-  
   [Set up git](https://help.github.com/articles/set-up-git/) in your local machine  
   From the Clone with HTTPs section, copy the clone URL for the repository.  
   Then from command line create a clone in your local machine by:-  
   > `git clone url`  
   ###### For Other Users :-
   Follow this [documentation](https://help.github.com/articles/cloning-a-repository/)

# Content
In the programs that i've done , i have covered and most importantly used concepts such as :

1)[Classes and Objects](https://www.tutorialspoint.com/java/java_object_classes.htm),
2)[Operators and their Precedence](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html),
3)[Pacakges](https://www.tutorialspoint.com/java/java_packages.htm),
4)[Method Overiding and Overloading](https://www.programcreek.com/2009/02/overriding-and-overloading-in-java-with-examples/), 
5)[Static Instances](https://www.javatpoint.com/static-keyword-in-java), 
6)[Threads](https://www.javaworld.com/article/2077138/java-concurrency/introduction-to-java-threads.html), 
7)[String](https://www.tutorialspoint.com/java/java_strings.htm), 
8)[Streams and IO](https://docs.oracle.com/javase/1.5.0/docs/api/java/io/package-summary.html), 
9)[Exception Handling](https://docs.oracle.com/javase/tutorial/essential/exceptions/), 
10)[AWT](https://www.javatpoint.com/java-awt), 
11)[Swing](http://zetcode.com/tutorials/javaswingtutorial/), 
12)[File Handling](http://www.dailyfreecode.com/code/file-handling-java-3430.aspx), 
13)[Event Hadnling](https://docs.oracle.com/javase/tutorial/uiswing/events/index.html), 
14)[Data Structures](http://java.wikia.com/wiki/Data_Structures) etc.

A bit about what each directory in my repo has to offer

`
1) EastKtuMath
	└──── Numerical Integration using Trapezoidal or Simpsons Methods
	└──── Get all the math steps as output (optional)
	└──── Streams for IO 
	└──── An exquisite expression parser included within
	└──── And yes you guessed it right! I used to do all my math assignements this way. :D

2) Threads
	└──── By Runnable Interface 
	└──── By Extending Thread Class
	└──── Runnable Interface in Main
	└──── Synchronization
	└──── Some fine practice problems

3) EventHandling
	└──── Creates a simple login Graphical User Interface(GUI)
	└──── Covers basics of java.awt and some of Swing
	└──── Learn basics of Listeners 
	└──── Basics from this required in upcoming programs

4) Overloading and Overriding
	└──── Learn the basics of Overloading,Overriding
	└──── Dynamic Method Dispatching 
	└──── What's super() and what is "this"? You will see
	└──── Basics of jump statements
	└──── Basics of Packages

5) S3CsSgpa      
	└──── Well? Want to apply what you've learnt? This is your opportunity. 
	└──── Creates a simple GUI to find your SGPA
	└──── File Handling basics
	└──── Sorting 
	└──── Data Structures 
	└──── Provides a great idea on javax.swing(the 'x' matters :p) 
	└──── Love designing? Play with java.awt.Color
`      

# What's next?
Now what you waiting for? Compile the `*.java` files and run it.
The most easiest way would be to change directory into the one which you want. Then do :

> `javac -d . *.java`

After creating the compiled .class file, just run it using (avoid the .class extension) :

> `java name_of_the_compiledfile_you_want_to_run`

What if it's part of a Package? No problemo. After compiling , Run :

> `java nameOfPackage.filename`

## License  
This project is licensed under the MIT License - see the [LICENSE.md](https://github.com/yedhink/KTU-Java/blob/master/LICENSE) file for details
