plugins {
    alias(libs.plugins.runique.android.feature.ui)
}

android {
    namespace = "com.jlahougue.auth.presentation"
}

dependencies {
    implementation(libs.bundles.koin)

    implementation(projects.auth.domain)
    implementation(projects.core.domain)
}