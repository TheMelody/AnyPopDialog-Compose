pluginManagement {
    repositories {
        maven(url = "https://maven.aliyun.com/repository/public")
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven(url = "https://maven.aliyun.com/repository/public")
        google()
        mavenCentral()
    }
}

rootProject.name = "My Application"
include(":app")
include(":any_pop_dialog_library")
