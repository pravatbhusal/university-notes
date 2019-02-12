<body>
<h3>This Hygiene Guide is from Mike Scott from the University of Texas</h3>
<p>The link to his original style-guide is here:</p>
<a href="https://www.cs.utexas.edu/~scottm/cs312/handouts/program_hygiene.html">https://www.cs.utexas.edu/~scottm/cs312/handouts/program_hygiene.html</a>
<h1><font face="Arial">Simple <i>Program Hygiene</i> Rules for Java</font></h1>
<p><font face="Arial"><i>Program hygiene</i>, aka style, entails a program's readability and logic
structuring. Program hygiene is just as important as correctness in
programming. This is
useful for you, the programmer, when you are writing code and us, the
graders
for reading and making sense of a program. Also, in industry and
real-world
situations, you usually do not write a whole program at once, nor do
you only
look at programs you wrote. Usually industry programmers are looking at
code
they did not write or wrote a long time ago, which is where style and
comments
become very important to understanding programs. (Organizations that want to 
produce quality software have style guides
<a href="https://google.github.io/styleguide/javaguide.html">such as this one</a>.)</font></p>
<p><font face="Arial">Rules to live by. </font></p>
<p><font face="Arial"><b>0. The Golden Rule</b></font></p>
<p><font face="Arial">It is difficult to enumerate all of the features of good 
program hygiene and trying to do so in an introductory programming class can be 
confusing. So we are presenting some simple rules, but keep in mind just because 
something is not covered here does not mean it isn't an example of BAD program 
hygiene. The golden rule is your program and code should be easily understood by&nbsp; 
another computer scientist, software developer, or programmer.</font></p>
<p><font face="Arial"><b>1. Capitalize class names</b></font></p>
<p><font face="Courier New">public class Thing</font></p>
<p><font face="Arial"><b>2. Do NOT capitalize the first letter of
methods or
variables</b></font></p>
<p><font face="Courier New">public void methodName() { } </font></p>
<p><font face="Courier New">int num1 = 3;</font></p>
<p><font face="Arial">Notice: In the above example, interior letters of
method
names and variables can be capitalized. Usually when two or more words
are
combined into one method name or variable name, we capitalize the
additional
words i.e. methodName. This is sometimes referred to as camelBack.</font></p>
<p><font face="Arial"><b>3. Write comments! </b></font></p>
<p><font face="Arial">Comments do not have to be excessive;  they won't
be on every line of a program. However, there should at least be a
comment
explaining the whole class, comments for each method, and comments for confusing or long parts of
the code. If you have good program hygiene and keep your code and methods 
simpler, the less comments you need.</font></p>
<p><font face="Courier New">// comment every method</font></p>
<p><font face="Courier New">//and include comments inside the code for
tricky
parts</font></p>
<p><font face="Arial"><b>4. Use meaningful variable names</b></font></p>
<p><font face="Courier New">int numTokens;</font></p>
<p><font face="Courier New">double hypotenuse;</font></p>
<p><font face="Arial">DON'T use </font><font face="Courier New">double
h</font><font face="Arial">;
or</font><font face="Courier New"> int nT</font><font face="Arial"> -
these are
too vague. Also, don't use 10 words in 1 variable - that's a little too
much. </font></p>
<p><font face="Arial">Although they are short names, it's ok to use x
or y if
they represent coordinates.</font></p>
<p><font face="Arial"><code>i</code>, <code>j</code>, and <code>k</code> are 
fine for loop control variables if it is they are simply counting out steps of 
the loop. However, if the loop control variable has more meaning then give it a 
more meaningful name. For example if the loop control variable represents mass 
in kilograms use <code>massInKg</code> instead of <code>i</code>.</font></p>
<p><font face="Arial"><b>5. Use constants for constant values</b></font></p>
<p><font face="Arial">Ex: Above, if you are calculating prices of
items, the
texasTaxRate will be useful. However, this doesn't change frequently -
it is
constant. So, in Java you should declare this constant like:</font></p>
<p><font face="Courier New">final double TRAVIS_PROPERTY_TAX_RATE =
0.014;</font></p>
<p><font face="Arial">Similarly, if you are using any real world value
that is
constant, like how much quarters are worth, or what gravity is, declare
it final
in your program.</font></p>
<p><font face="Arial">Notice: I used all capital letters for the
constant,
separating words with underscores. This is a widespread Java convention.</font></p>
<p><font face="Arial"><b>6. Indent!</b></font></p>
<p><font face="Arial">When you declare a class or a method, indent at
least 3
spaces to start the next line. All method declarations should line up
with each
other. Also, when you have an if-statement or a loop-statement, you
should
always indent the body at least 3 spaces.&nbsp; You should be fine if
you follow
any of the indention patterns from the textbook. </font></p>
<p><font face="Arial">You are free to use what every brace style your like best 
as long as you are consistent.</font></p>
<p><font face="Courier New">public class Thing {<br>
&nbsp;</font></p>
<p><font face="Courier New">&nbsp;&nbsp; public static void
main(String[] args) {<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; int num = 3;</font></p>
<p><font face="Courier New">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; for(int i = 0; i &lt; <br>
<br>
&nbsp;&nbsp; } // main<br>
<br>
}// Thing</font></p>
<p><b><font face="Arial">7.</font></b><font face="Arial"><b> Limit the Scope of 
variables and constants.</b></font></p>
<p><font face="Arial">Limit the scope of variables and constants to the smallest 
necessary. This means do not use static variables as a form of global variables. 
s. </font></p>
<p><font face="Arial"><b>8. Structure and Removing Redundancy.</b></font></p>
<p><font face="Arial">Use methods (and later, classes) to provide structure to 
your program and remove redundancy. Methods should do one thing. Methods that 
grow to 30+ lines of code are often doing multiple things and should be broken 
into smaller methods to provide an understandable structure. </font></p>
<p><font face="Arial"><b>9. Avoid magic numbers</b></font></p>
<p><font face="Arial">If you have a literal numeric value in your code, it 
likely has some meaning. Use a variable or constant to make that meaning clear.</font></p>
<p><font face="Arial" size="4"><code>// bad<br>
double bmi = 703.0 * massInLbs / (heightInIn * heightInIn ); // 703? what is 
that?</code></font></p>
<p><font face="Arial" size="4"><code>// good<br>
final double ENGLISH_UNITS_CONVERSION_FACTOR = 703.0;<br>
double bmi = ENGLISH_UNITS_CONVERSION_FACTOR * massInLbs / (heightInIn * 
heightInIn );</code></font></p>
<p><b><font face="Arial">10</font></b><font face="Arial"><b>. </b></font><b>
<font face="Arial">Chapter specific rules</font></b></p>
<p><font face="Arial">For CS312 <a href="IntroJavaStyleGuide.pdf">refer to this 
document for chapter specific rules for program hygiene</a>.</font></p>
</body>
</html>
