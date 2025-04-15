plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.dagger.hilt)
}

android {
    namespace = "dev.vincenzocostagliola.data"
    testNamespace = "dev.vincenzocostagliola.data"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.timber)
    implementation("org.jetbrains.kotlin.kapt:org.jetbrains.kotlin.kapt.gradle.plugin:2.0.21")


    /**HILT*/
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    /**SERIALIZATION*/
    implementation(libs.kotlin.serialization)

    /**DATE TIME*/
    implementation(libs.threeTen)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}