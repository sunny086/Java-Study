#include <stdio.h>
#include "jni.h"
#include "work_jni_Hello.h"

JNIEXPORT void Java_work_jni_Hello_sayHello(JNIEnv *env,jobject obj){
    printf("Hello, World from C!\n");
}
