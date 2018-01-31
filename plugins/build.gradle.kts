import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

dependencies {

    compile(project(":runtime"))

    testCompile(gradleKotlinDsl())
    testCompile("junit:junit:4.11")
    testCompile("com.nhaarman:mockito-kotlin:1.5.0")
}

tasks {

    "compileKotlin"(KotlinCompile::class) {
        kotlinOptions {
            freeCompilerArgs = listOf(
                // enable nullability annotations
                "-Xjsr305=strict",
                // nevermind kotlin-compiler-embeddable copy of stdlib
                "-Xskip-runtime-version-check",
                // recognize *.gradle.kts files as Gradle Kotlin scripts
                "-script-templates", "kebab.KotlinScriptPlugin")
        }
    }
}
