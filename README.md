# DISCONTINUED!
# HTPL - Hyper Text Programming Language
A programming language using html tag syntax
Built using ANTLR4 as an experiment 

*Work in progress*

### Todo:
<ul>
  <li>DONE: Variable Declaration</li>
  <li>DONE: Function Declaration</li>
  <li>DONE: Call Function</li>
  <li>DONE: If - Else</li>
  <li>DONE: For Loop </li>
  <li>DONE: While Loop </li>

<li>Class and Object oriented Programming</li>
</ul>


## Sample Code
```html

<!-- HTPL block: Code starts here -->
<htpl>

    <!-- create a variable a with value 5 -->
    <a = 5/>


    <!-- call the out tag (built in) to print anything -->
    <!-- this also shows the string concatenation operator -->
    <!-- Output : The value of a is 5 -->

    <out "The value of a is "+ a/>

    <!-- In HAPL, function is essentially a block of code -->
    <!-- that can take parameters and return a value -->
    <!-- this block takes a name and prints out "Hello, name" -->
    <sayHello name>
        <out "Hello, "+ name/>
    </sayHello>

    <!-- call the sayHello block with the name "Fahid" -->
    <!-- output : Hello, Fahid -->
    <sayHello "Fahid"/>

    <!-- repeat a block 5 times -->
    <!-- call the repeat block (built in) -->
    <repeat 5>
        <out "Hello, World!"/>
    </repeat>


    <!-- repeat a block 5 times with particular variable changing -->
    <!-- this is essentially a for loop -->
    <!-- here: repeat the block from i = 1 to i <= 5, with step = 1 (default) -->
    <repeat i , 1 , 5>
        <out "Hello, World! and i = "+ i/>
    </repeat>


    <!-- repeat a block 5 times with particular variable changing -->
    <!-- this is essentially a for loop -->
    <!-- here: repeat the block from i = 1 to i <= 10, with step = 2 -->
    <repeat i , 1 , 10 , 2>
        <out "Hello, World! and i = "+ i/>
    </repeat>


    <!-- repeat a block until condition is false -->
    <!-- this is essentially a while loop -->
    <!-- call the repeat while block (built in) -->
    <z = 5/>
    <repeat while z > 2>
        <out "Hello, World! From Repeat While and z = "+ z/>
        <z = z - 1/> //omitting this will cause an infinite loop
    </repeat>

</htpl>


```
