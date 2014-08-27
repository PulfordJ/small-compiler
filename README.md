small-compiler
============

# Generate Documentation

```
gradle genDocs
```

# Extra running notes

As a result of splitting out the antlr and pdflatex plugins into seperate repos a little bit more setup is required.

1. Ensure small-compiler, pdflatexplugin and antlr4plugin all sit within one parent folder that you are comfortable holding a build directory.
2. Run build.gradle in pdflatexplugin directory.
3. Run build.gradle in antlr4plugin directory.
4. Notice the generated repo folder in the parent directory? small-compiler should now use that to successfully build.

# Running command
Once the above is done simply type:
```
gradle clean release run -Pargs="example.if"
```

All other documentation inside build/docs.
