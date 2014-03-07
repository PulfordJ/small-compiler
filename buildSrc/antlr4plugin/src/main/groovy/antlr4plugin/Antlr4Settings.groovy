package antlr4plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.api.tasks.testing.Test

public class Antlr4Settings  {
    def String grammarpackage = ""
    def String antlrSource = 'src/main/antlr'
    def String javaSource = "src/generated/java"
    def version = "4.1"
    /*
    final String name

    Antlr4Settings(String name) {
        this.name = name
    }
    */
}
