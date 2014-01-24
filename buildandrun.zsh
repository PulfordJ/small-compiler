antlr4 src/InfixToPostfix.g4 -visitor &&  javac src/Infix*.java -d . && echo "Starting compiler" && java InfixToPostfixRunner example.mu
