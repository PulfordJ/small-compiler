package antlr4plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.api.tasks.testing.Test
import org.gradle.api.tasks.JavaExec
import org.gradle.api.plugins.JavaPlugin

public class Antlr4Plugin implements Plugin<Project> {

    void apply(Project project) {
        project.plugins.apply JavaPlugin

        project.mainClassName = "InfixToPostfixRunner"

        print"apply task running."
        //project.tasks.create('dummyname1', Compile) << {
        //    options.encoding = 'UTF-8'
        //    println "Antlr plugin compile time task."
        //}
        /*
        def antlr4Settings = project.container(Antlr4Settings)
        project.extensions.antlr4 = antlr4Settings
        */
        def antlr4Settings = project.extensions.create("antlr4", Antlr4Settings)
        //project.tasks.withType(JavaCompile)
        project.tasks.withType(JavaCompile) {
            options.encoding = 'UTF-8'
        }

        project.tasks.withType(Test) {
            systemProperties = System.getProperties()
            testLogging.showStandardStreams = true
        }

        project.tasks.create('antlrOutputDir') {
            println "Building output dir for antlr."
            project.mkdir(antlr4Settings.javaSource)
        }

        project.getConfigurations().create('antlr4', {description = "ANTLR4"})
        /*
        project.tasks.create('configurations') {
            antlr4 {
                description = "ANTLR4"
            }
        }
        */
        

        
        /*
        project.tasks.findByPath('compileJava') {
            print "ADD DEPENDENCY TO GRAMMARSOURCE FROM COMPILEJAVA"
            dependsOn generateGrammarSource
            source antlr4Settings.output
        }
        */

        project.clean << {
            println "Antlr4 cleaner runs!"
            project.delete antlr4Settings.javaSource
        }        
        
        project.dependencies {
            println "Finding dependencies..."
            compile group: "org.antlr", name: "antlr4-runtime", version: antlr4Settings.version
            antlr4 group: "org.antlr", name: "antlr4", version: antlr4Settings.version
            //testCompile group: "junit", name: "junit", version: 

        }
        project.afterEvaluate{
        project.task('generateGrammarSource', dependsOn : 'antlrOutputDir', type :JavaExec) {
            println "COMMENCE GRAMMAR SOURCE GENERATION."
            //dependsOn 'antlrOutputDir'
            //description = 'Generates Java sources from ANTLR4 grammars.'

            inputs.dir project.file(antlr4Settings.antlrSource)
            outputs.dir project.file(antlr4Settings.javaSource)

            def grammars = project.fileTree(antlr4Settings.antlrSource).include('**/*.g4')

            main = 'org.antlr.v4.Tool'
            println "BEFORE CLASSPATH: "+classpath.getAsPath()
            println "ANTLR4 config: "+project.configurations.antlr4.allArtifacts
            classpath = project.configurations.antlr4
            println "AFTER CLASSPATH"
            //classpath = "ANTLR4"
            println classpath.getAsPath()
            def pkg = antlr4Settings.grammarpackage.replaceAll("\\.", "/")
            //def pkg = ""
            //args = ["-o", "${antlr.destinationDir}/${pkg}"/*, "-atn"*/, "-visitor", "-package", antlr.grammarpackage, grammars.files].flatten()
            args = ["-o", "${antlr4Settings.javaSource}/${pkg}"/*, "-atn"*/, "-visitor", grammars.files].flatten()

        }
        project.compileJava {
            dependsOn project.generateGrammarSource
            source antlr4Settings.javaSource
        }

}
        
        //def compileTask = project.tasks.withType(JavaCompile)
        //print compileTask.conventionMapping.type
        //compileTask.options.encoding = 'UTF-8'
        //compileTask.conventionMapping.options.encoding = 'UTF-8'
    }

}
