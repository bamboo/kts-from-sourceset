plugins {
    `kotlin-dsl`
}

apply<org.gradle.kotlin.dsl.plugins.precompiled.PrecompiledScriptPlugins>()

dependencies {
    testCompile("junit:junit:4.12")
    testCompile("com.nhaarman:mockito-kotlin:1.6.0")
}
