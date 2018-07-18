package plugins

import com.nhaarman.mockito_kotlin.*

import org.gradle.api.Project
import org.gradle.api.logging.Logger

import org.junit.Test

class MyGradlePluginTest {

    @Test
    fun `it logs debug message`() {
        // given:
        val logger = mock<Logger>()
        val project = mock<Project>()
        whenever(project.logger)
            .doReturn(logger)

        // when:
        val ctor = Class
            .forName("My_gradle_plugin_gradle")
            .getConstructor(Project::class.java)

        // SET BREAKPOINT HERE
        // then try to step into the precompiled .gradle.kts script
        ctor.newInstance(project)

        // then:
        verify(logger).debug("Hello from Gradle plugin!")
    }
}
