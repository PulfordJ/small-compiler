package pdflatexplugin
// Modified from solution posted at: http://forums.gradle.org/gradle/topics/gradle_and_latex
import groovy.text.SimpleTemplateEngine
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.jar.Attributes
import org.apache.tools.ant.taskdefs.condition.Os
import org.gradle.api.Task
import org.gradle.api.tasks.StopExecutionException
import org.gradle.api.tasks.wrapper.Wrapper
import org.gradle.util.GradleVersion
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.apache.tools.ant.filters.ReplaceTokens
import org.gradle.api.tasks.Copy
import java.io.File

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.api.tasks.testing.Test
import org.gradle.api.tasks.JavaExec
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.file.FileTree

public class PdflatexPlugin implements Plugin<Project> {
    def Project project

    void apply(Project project) {
        this.project = project
        //project.plugins.apply JavaPlugin

        def pdflatexSettings = project.extensions.create("pdflatex", PdflatexSettings)

        project.sourceSets { main { resources { srcDir pdflatexSettings.srcDir } }
        }

        project.task('copyDocs', type: Copy) {
        
            def stagingDir = project.file(pdflatexSettings.stagingDirName)
            stagingDir.mkdirs()
              from(pdflatexSettings.srcDir) { include '**/*.tex','**/*.inc' }
              //filter(ReplaceTokens, tokens: [release: version, docVersion: docVersion])
              into stagingDir
              includeEmptyDirs = false
        }

        project.task('myInitConfig', type: Copy) {

            def stagingDir = project.file(pdflatexSettings.stagingDirName)
            stagingDir.mkdirs()
            from(pdflatexSettings.srcDir) { include '**/*.tex' //
            }
            into stagingDir
            includeEmptyDirs = false
        }

        project.task('copyPdfToDocsFolder', type: Copy) {
            def docDir = project.file(pdflatexSettings.docsDirName)
            docDir.mkdirs()
                from(pdflatexSettings.stagingDirName) { include '**/*.pdf' //
                }
                into docDir
                includeEmptyDirs = false
            
        }

        project.task('genDocs') {
            project.myInitConfig.execute()
            cleanLatex(project.file(pdflatexSettings.stagingDirName))
            project.copyDocs.execute()
            if (!isLatexInstallled()) {
              throw new StopExecutionException('Latex is not installed. We skip the document!')
            }
            project.ext.set("tree", project.fileTree(dir: pdflatexSettings.stagingDirName))
            project.tree.include '**/*.tex'
            project.tree.each {File file ->
              compileLatex(file)
            }
            project.copyPdfToDocsFolder.execute()
            
        }


    }

    
 
void cleanLatex(File dir) {
  project.file(dir.path).mkdirs()
  project.ant.delete() {
    fileset(dir: dir, includes: "*.aux, *.lg, *.tmp, *.html, *.pdf, *.log, *.dvi, *.css, *.fdb_latexmk, *.idv, *.toc, *.xref, *.4ct, *.4tc, *.out")
  }
}
 
void compileLatex(File fileToProcess) {
  3.times {
    project.ant.exec(executable: 'pdflatex', dir: fileToProcess.parent, failonerror: true) { arg(value: fileToProcess.name) }
  }
  3.times {
    project.ant.exec(executable: 'makeindex', dir: fileToProcess.parent, failonerror: true) { arg(value: fileToProcess.name) }
  }
  3.times {
    project.ant.exec(executable: 'pdflatex', dir: fileToProcess.parent, failonerror: true) { arg(value: fileToProcess.name) }
  }
}

boolean isLatexInstallled() {
  boolean ret_val = false;
  try {
    project.ant.exec(output: 'build/texstaging/findLatexOut', executable: 'pdflatex', dir: project.projectDir) { arg(line: "-help") }
    ret_val = true
  } catch (Throwable e) {
    e.printStackTrace();
    ret_val = false
  }
  return ret_val
}

}
