object cfg {
    private const val jetbrainsGroupId = "org.jetbrains"
    private const val kotlinGroupId = "org.jetbrains.kotlin"
    private const val kotlinxGroupId = "org.jetbrains.kotlinx"

    data class Artifact(val groupId: String, val artifactId: String, val version: String) {
        val depStr: String
            inline get() = "$groupId:$artifactId:$version"
    }

    object kotlin {
        val jvmTarget = "1.8"

        const val V = "1.2.41"

        val gradlePlugin = Artifact(kotlinGroupId, "kotlin-gradle-plugin", V)
        val allOpenPlugin = Artifact(kotlinGroupId, "kotlin-allopen", V)
        val noArgPlugin = Artifact(kotlinGroupId, "kotlin-noarg", V)
    }

    object coroutines {
        private const val V = "0.22.5"

        val coroutinesCoreCommonLib = Artifact(kotlinxGroupId, "kotlinx-coroutines-core-common", V)
        val coroutinesCoreJVMLib = Artifact(kotlinxGroupId, "kotlinx-coroutines-core", V)
        val coroutinesJDK8Lib = Artifact(kotlinxGroupId, "kotlinx-coroutines-jdk8", V)
        val coroutinesNIOLib = Artifact(kotlinxGroupId, "kotlinx-coroutines-nio", V)
    }

    const val springgradleGroupId = "io.spring.gradle"
    object springgradle {
        const val V = "1.0.5.RELEASE"

        private val depMgmtPluginArtifactId = "dependency-management-plugin"
        val depMgmtPluginId = "io.spring.dependency-management"
        val depMgmtPlugin = Artifact(springgradleGroupId, depMgmtPluginArtifactId, V)
    }

    const val springbootGroupId = "org.springframework.boot"
    object springboot {
        const val V = "2.0.2.RELEASE"

        val gradlePluginArtifactId = "spring-boot-gradle-plugin"
        val gradlePluginId = springbootGroupId
        val gradlePlugin = Artifact(springbootGroupId, gradlePluginArtifactId, V)
    }
}
