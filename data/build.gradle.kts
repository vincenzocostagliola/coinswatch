plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.android.library)
    alias(libs.plugins.ksp)
    alias(libs.plugins.dagger.hilt)
}

android {
    namespace = "dev.vincenzocostagliola.data"
    testNamespace = "dev.vincenzocostagliola"
    compileSdk = 35

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_21.toString()
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.timber)


    /**HILT*/
    // For hilt Implementation
    implementation (libs.hilt)
    ksp(libs.hilt.compiler)

    /**SERIALIZATION*/
    implementation(libs.kotlin.serialization)

    /**DATE TIME*/
    implementation(libs.threeTen)
    /**NETWORK*/
    implementation(libs.bundles.network)
    /**COROUTINES*/
    implementation(libs.bundles.coroutines)
    implementation(libs.sandwich)
}