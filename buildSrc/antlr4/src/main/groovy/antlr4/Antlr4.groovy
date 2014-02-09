package antlr4

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.api.tasks.testing.Test

public class Antlr4 implements Plugin<Project> {

    void apply(Project project) {
        print"apply task running."
        //project.tasks.create('dummyname1', Compile) << {
        //    options.encoding = 'UTF-8'
        //    println "Antlr plugin compile time task."
        //}
        
        //project.tasks.withType(JavaCompile)
        project.tasks.withType(JavaCompile) {
            options.encoding = 'UTF-8'
        }

        project.tasks.withType(Test) {
            systemProperties = System.getProperties()
            testLogging.showStandardStreams = true
        }
        /*
        project.tasks.create('antlrOutputDir') << {
            mkdir(antlr.destinationDir)
        }
        */
        //def compileTask = project.tasks.withType(JavaCompile)
        //print compileTask.conventionMapping.type
        //compileTask.options.encoding = 'UTF-8'
        //compileTask.conventionMapping.options.encoding = 'UTF-8'
    }

}
