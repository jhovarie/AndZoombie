AndZoombie is android library use for faster development.

//How to use this library

Go to your androd project

Step 1. Add it in your root build.gradle at the end of repositories:

allprojects {
	repositories {
			...
		maven { url 'https://jitpack.io' }
	}
}

Step 2. Add the dependency to your app build.gradle

dependencies {
	implementation 'com.github.jhovarie:AndZoombie:Tag'
}

----------------------------------------------------------------------------------------------------
For Android Studio 2.3.3 this is how to setup this library -----------------------------------------

Step 1) Edit root build.gradle 

allprojects {
    repositories {
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}

Step 2) Edit app build.gradle

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    compile 'com.android.support.constraint:constraint-layout:1.0.2'
    compile 'com.github.jhovarie:AndZoombie:-SNAPSHOT'
    testCompile 'junit:junit:4.12'
}

Step 3) If you want to test if the library is already setup.
first import andzoombie.com.andzoombie_barik.LogDebug;
then invoke LogDebug.d("This is log message from andzoombie ");
Check the log message use barik tag to filter the log.