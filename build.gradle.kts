plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.dv8tion:JDA:5.0.0-beta.24")
    implementation("org.slf4j:slf4j-simple:2.0.13")
    implementation("io.github.cdimascio:dotenv-java:3.2.0")
}

tasks.test {
    useJUnitPlatform()
}