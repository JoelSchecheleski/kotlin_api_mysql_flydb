import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.6"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.5.31"
	kotlin("plugin.spring") version "1.5.31"
	kotlin("plugin.jpa") version "1.5.31" // ajustar problemas de construtores padrão
}

group = "com.mercadolivro"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-validation:2.5.6")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc:2.5.5")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.5.6")
	implementation("org.springframework.boot:spring-boot-starter-data-rest:2.5.5")
	implementation("org.springframework.boot:spring-boot-starter-web:2.5.6")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	// Migration
	implementation("org.flywaydb:flyway-core:8.0.3")

	// Swagger
	implementation("io.springfox:springfox-swagger2:3.0.0")
	implementation("io.springfox:springfox-swagger-ui:3.0.0")
	implementation("io.springfox:springfox-boot-starter:3.0.0")

	// Log
	implementation("org.apache.logging.log4j:log4j-core:2.14.1")
	implementation("org.apache.logging.log4j:log4j-api:2.14.1")

	// Database
	runtimeOnly("com.h2database:h2:1.4.200")
	runtimeOnly("mysql:mysql-connector-java:8.0.25")
	testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.6")

	// Spring Security
	implementation("org.springframework.boot:spring-boot-starter-security:2.5.6")
	testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.6")
	testImplementation("org.springframework.security:spring-security-test:5.5.1")

	// JWT
	implementation("io.jsonwebtoken:jjwt:0.9.1")

	// Mocking library for Kotlin
	testImplementation("io.mockk:mockk:1.12.0")

}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
