pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PracticaLayouts"
include(":app")
include(":constraintlayout")
include(":primeraapp")
include(":generardado")
include(":calculadorapropinas")
include(":affirmations")
