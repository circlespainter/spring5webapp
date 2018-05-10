import org.jetbrains.kotlin.gradle.dsl.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	repositories {
//        maven(uri("https://dl.bintray.com/kotlin/kotlin-dev"))
//        maven(uri("https://dl.bintray.com/kotlin/kotlin-eap"))
//        maven(uri("https://plugins.gradle.org/m2/"))
//
        mavenCentral()
//        jcenter()
	}
	dependencies {
        classpath(cfg.springgradle.depMgmtPlugin.depStr)
		classpath(cfg.springboot.gradlePlugin.depStr)
        classpath(cfg.kotlin.gradlePlugin.depStr)
        classpath(cfg.kotlin.allOpenPlugin.depStr)
        classpath(cfg.kotlin.noArgPlugin.depStr)
	}
}

plugins {
//    java
    kotlin("jvm") version cfg.kotlin.V
    kotlin("plugin.spring") version cfg.kotlin.V
    kotlin("plugin.jpa") version cfg.kotlin.V
    id(cfg.springboot.gradlePluginId) version cfg.springboot.V
    id(cfg.springgradle.depMgmtPluginId) version cfg.springgradle.V
}

repositories {
    mavenCentral()
//    jcenter()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = cfg.kotlin.jvmTarget
    }
}

configurations.all {
	resolutionStrategy {
		// fail eagerly on version conflict (includes transitive dependencies)
		// e.g. multiple different versions of the same dependency (group and name are equal)
		failOnVersionConflict()
	}
}

dependencies {
    compile(kotlin("stdlib"))
    compile(kotlin("reflect"))

    compile("org.springframework.boot:spring-boot-starter-actuator")
	compile("org.springframework.boot:spring-boot-starter-data-jpa")
	compile("org.springframework.boot:spring-boot-starter-thymeleaf")
	compile("org.springframework.boot:spring-boot-starter-web")

	compile("com.fasterxml.jackson.module:jackson-module-kotlin")

	runtime("com.h2database:h2")

	testCompile("org.springframework.boot:spring-boot-starter-test")
}

kotlin {
    experimental.coroutines = Coroutines.ENABLE
}
