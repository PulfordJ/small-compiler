more src/test/java/CompilerShouldCompileWithoutError.java | perl -ne "print \"$+{code} \"  if /(?<blah>assert).*\"(?<code>.*)\".*/" > example.fs
