package antlr4

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.compile.JavaCompile

public class Antlr4 implements Plugin<Project> {

    void apply(Project project) {
        project.tasks.create('dummyname1', JavaCompile) << {
        }
    }

}
