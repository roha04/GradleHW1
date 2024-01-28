plugins {
    id("java")
}

group = "org.gradle"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.google.code.gson:gson:2.8.9")
}
tasks.jar {
    archiveFileName.set("myname.jar") // This renames the JAR file with a custom name and retains the .jar extension
}
tasks.jar {
     {
        archiveFileName.set("app.jar")
    }
    manifest {
        attributes(mapOf("Main-Class" to "com.example.Main"))
    }
    from(configurations.compileClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}


tasks.test {
    useJUnitPlatform()
}
