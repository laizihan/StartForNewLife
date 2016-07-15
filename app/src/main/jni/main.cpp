#include "com_example_laizihan_startfornewlife_jniTest_JniTest.h"

JNIEXPORT jstring JNICALL Java_com_example_laizihan_startfornewlife_jniTest_JniTest_getStringFromNDK
        (JNIEnv *env, jobject obj) {




    return env->NewStringUTF("this is a NDK String From native code c++");
}