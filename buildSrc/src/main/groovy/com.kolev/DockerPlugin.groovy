package com.kolev

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Copy
import org.gradle.api.tasks.Exec

class DockerPluginExtension {
    String source
    String dest
}

class DockerPlugin implements Plugin<Project> {
    void apply(Project project) {

        def extension = project.extensions.create('docker', DockerPluginExtension)

        if (extension.source == null) {
            extension.source = project.file("${project.projectDir}/src/main/docker")
        }

        if (extension.dest == null) {
            extension.dest = project.file("${project.buildDir}/doker")
        }

        project.task('prepareDockerFiles', type: Copy) {
            from "${extension.source}"
            from project.configurations.runtime
            from project.jar
            into "${extension.dest}"
        }

        project.task('buildImage', type: Exec) {
            inputs.dir(project.file("${extension.dest}"))
            outputs.upToDateWhen { false }
            workingDir "${extension.dest}"
            commandLine 'docker', 'build', '-t',  "pupok-${project.name}:${project.version}", '.'
        }

        project.buildImage.dependsOn('prepareDockerFiles')
        project.build.dependsOn('buildImage')

    }
}