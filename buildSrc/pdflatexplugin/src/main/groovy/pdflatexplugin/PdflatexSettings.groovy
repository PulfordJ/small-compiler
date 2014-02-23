package pdflatexplugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.api.tasks.testing.Test

public class PdflatexSettings  {
    def String srcDir = 'src/doc/latex'
    def String stagingDirName = 'build/texstaging'
    def String docsDirName = "build/docs"
}
