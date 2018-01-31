package plugins

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify

import org.gradle.api.Project
import org.gradle.api.logging.Logger

import org.junit.Test

class MyGradlePluginTest {

    @Test
    fun `it logs debug message`() {
        // given:
        val logger = mock<Logger>()
        val project = mock<Project> {
            on { getLogger() } doReturn logger
        }

        // when:
        Class
            .forName("My_gradle_plugin_gradle")
            .getConstructor(Project::class.java)
            .newInstance(project)

        // then:
        verify(logger).debug("Hello from Gradle plugin!")
    }
}
