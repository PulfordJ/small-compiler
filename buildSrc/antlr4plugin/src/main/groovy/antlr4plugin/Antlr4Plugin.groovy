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

        def antlr4Settings = project.extensions.create("antlr4", Antlr4Settings)

        project.tasks.withType(JavaCompile) {
            options.encoding = 'UTF-8'
        }

        project.tasks.withType(Test) {
            systemProperties = System.getProperties()
                testLogging.showStandardStreams = true
        }

        project.tasks.create('antlrOutputDir') {
            project.mkdir(antlr4Settings.javaSource)
        }

        project.getConfigurations().create('antlr4', {description = "ANTLR4"})

        project.clean << {
            project.delete antlr4Settings.javaSource
        }        

        project.dependencies {
            compile group: "org.antlr", name: "antlr4-runtime", version: antlr4Settings.version
                antlr4 group: "org.antlr", name: "antlr4", version: antlr4Settings.version
        }

            project.task('generateGrammarSource', dependsOn : 'antlrOutputDir', type :JavaExec) {

                inputs.dir project.file(antlr4Settings.antlrSource)
                outputs.dir project.file(antlr4Settings.javaSource)

                def grammars = project.fileTree(antlr4Settings.antlrSource).include('**/*.g4')

                                                                                         main = 'org.antlr.v4.Tool'
                                                                                         classpath = project.configurations.antlr4
                //classpath = "ANTLR4"
                def pkg = antlr4Settings.grammarpackage.replaceAll("\\.", "/")
                //def pkg = ""
                if (pkg != "") {
                args = ["-o", "${antlr4Settings.javaSource}/${pkg}"/*, "-atn"*/, "-visitor", "-package", antlr4Settings.grammarpackage, grammars.files].flatten()
                }
                else {
                    args = ["-o", "${antlr4Settings.javaSource}/${pkg}"/*, "-atn"*/, "-visitor", grammars.files].flatten()
                }

            }
            project.compileJava {
                dependsOn project.generateGrammarSource
                    source antlr4Settings.javaSource
            }

    }

}
