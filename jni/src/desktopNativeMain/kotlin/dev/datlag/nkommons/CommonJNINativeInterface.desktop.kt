package dev.datlag.kommons

import dev.datlag.kommons.binding.jarray
import dev.datlag.kommons.binding.jboolean
import dev.datlag.kommons.binding.jbooleanArray
import dev.datlag.kommons.binding.jbooleanVar
import dev.datlag.kommons.binding.jbyte
import dev.datlag.kommons.binding.jbyteArray
import dev.datlag.kommons.binding.jbyteVar
import dev.datlag.kommons.binding.jchar
import dev.datlag.kommons.binding.jcharArray
import dev.datlag.kommons.binding.jcharVar
import dev.datlag.kommons.binding.jclass
import dev.datlag.kommons.binding.jdouble
import dev.datlag.kommons.binding.jdoubleArray
import dev.datlag.kommons.binding.jdoubleVar
import dev.datlag.kommons.binding.jfieldID
import dev.datlag.kommons.binding.jfloat
import dev.datlag.kommons.binding.jfloatArray
import dev.datlag.kommons.binding.jfloatVar
import dev.datlag.kommons.binding.jint
import dev.datlag.kommons.binding.jintArray
import dev.datlag.kommons.binding.jintVar
import dev.datlag.kommons.binding.jlong
import dev.datlag.kommons.binding.jlongArray
import dev.datlag.kommons.binding.jlongVar
import dev.datlag.kommons.binding.jmethodID
import dev.datlag.kommons.binding.jobject
import dev.datlag.kommons.binding.jobjectArray
import dev.datlag.kommons.binding.jobjectRefType
import dev.datlag.kommons.binding.jshort
import dev.datlag.kommons.binding.jshortArray
import dev.datlag.kommons.binding.jshortVar
import dev.datlag.kommons.binding.jsize
import dev.datlag.kommons.binding.jstring
import dev.datlag.kommons.binding.jthrowable
import dev.datlag.kommons.binding.jweak
import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CPointerVarOf
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(markerClass = [ExperimentalForeignApi::class])
actual class CommonJNINativeInterface(
    actual val platform: JNINativeInterface
) {

    actual var NewLongArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jlongArray?>>?
        get() = platform.NewLongArray as CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jlongArray?>>?
        set(value) {
            platform.NewLongArray = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jni.jlongArray?>>?
        }

    actual var GetByteArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jbyteArray?, CPointer<jbooleanVar>?) -> CPointer<ByteVarOf<jbyte>>?>>?
        get() = platform.GetByteArrayElements as CPointer<CFunction<(CPointer<JNIEnvVar>?, jbyteArray?, CPointer<jbooleanVar>?) -> CPointer<ByteVarOf<jbyte>>?>>?
        set(value) {
            platform.GetByteArrayElements = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jbyteArray?, CPointer<jbooleanVar>?) -> CPointer<jbyteVar>?>>?
        }

    actual var ExceptionClear: CPointer<CFunction<(CPointer<JNIEnvVar>?) -> Unit>>?
        get() = platform.ExceptionClear
        set(value) {
            platform.ExceptionClear = value
        }

    actual var CallNonvirtualCharMethod: COpaquePointer?
        get() = platform.CallNonvirtualCharMethod
        set(value) {
            platform.CallNonvirtualCharMethod = value
        }

    actual var SetStaticByteField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jbyte) -> Unit>>?
        get() = platform.SetStaticByteField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jbyte) -> Unit>>?
        set(value) {
            platform.SetStaticByteField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jfieldID?, jbyte) -> Unit>>?
        }

    actual var CallNonvirtualDoubleMethod: COpaquePointer?
        get() = platform.CallNonvirtualDoubleMethod
        set(value) {
            platform.CallNonvirtualDoubleMethod = value
        }

    actual var CallStaticFloatMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jfloat>>?
        get() = platform.CallStaticFloatMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jfloat>>?
        set(value) {
            platform.CallStaticFloatMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jmethodID?, CPointer<jvalue>?) -> jfloat>>?
        }

    actual var CallStaticLongMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jlong>>?
        get() = platform.CallStaticLongMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jlong>>?
        set(value) {
            platform.CallStaticLongMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jmethodID?, CPointer<jvalue>?) -> jlong>>?
        }

    actual var CallBooleanMethod: COpaquePointer?
        get() = platform.CallBooleanMethod
        set(value) {
            platform.CallBooleanMethod = value
        }

    actual var GetStringUTFLength: CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?) -> jsize>>?
        get() = platform.GetStringUTFLength as CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?) -> jsize>>?
        set(value) {
            platform.GetStringUTFLength = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jstring?) -> jsize>>?
        }

    actual var CallVoidMethod: COpaquePointer?
        get() = platform.CallVoidMethod
        set(value) {
            platform.CallVoidMethod = value
        }

    actual var Throw: CPointer<CFunction<(CPointer<JNIEnvVar>?, jthrowable?) -> jint>>?
        get() = platform.Throw as CPointer<CFunction<(CPointer<JNIEnvVar>?, jthrowable?) -> jint>>?
        set(value) {
            platform.Throw = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jthrowable?) -> jint>>?
        }

    actual var NewByteArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jbyteArray?>>?
        get() = platform.NewByteArray as CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jbyteArray?>>?
        set(value) {
            platform.NewByteArray = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jni.jbyteArray?>>?
        }

    actual var CallLongMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jlong>>?
        get() = platform.CallLongMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jlong>>?
        set(value) {
            platform.CallLongMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jmethodID?, CPointer<jvalue>?) -> jlong>>?
        }

    actual var FatalError: CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<ByteVarOf<Byte>>?) -> Unit>>?
        get() = platform.FatalError
        set(value) {
            platform.FatalError = value
        }

    actual var NewCharArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jcharArray?>>?
        get() = platform.NewCharArray as CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jcharArray?>>?
        set(value) {
            platform.NewCharArray = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jni.jcharArray?>>?
        }

    actual var CallFloatMethod: COpaquePointer?
        get() = platform.CallFloatMethod
        set(value) {
            platform.CallFloatMethod = value
        }

    actual var EnsureLocalCapacity: CPointer<CFunction<(CPointer<JNIEnvVar>?, jint) -> jint>>?
        get() = platform.EnsureLocalCapacity
        set(value) {
            platform.EnsureLocalCapacity = value
        }

    actual var CallNonvirtualObjectMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jobject?>>?
        get() = platform.CallNonvirtualObjectMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jobject?>>?
        set(value) {
            platform.CallNonvirtualObjectMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jclass?, jni.jmethodID?, CPointer<jvalue>?) -> jni.jobject?>>?
        }

    actual var AllocObject: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?) -> jobject?>>?
        get() = platform.AllocObject as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?) -> jobject?>>?
        set(value) {
            platform.AllocObject = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?) -> jni.jobject?>>?
        }

    actual var ExceptionOccurred: CPointer<CFunction<(CPointer<JNIEnvVar>?) -> jthrowable?>>?
        get() = platform.ExceptionOccurred as CPointer<CFunction<(CPointer<JNIEnvVar>?) -> jthrowable?>>?
        set(value) {
            platform.ExceptionOccurred = value as CPointer<CFunction<(CPointer<JNIEnvVar>?) -> jni.jthrowable?>>?
        }

    actual var GetObjectField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jobject?>>?
        get() = platform.GetObjectField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jobject?>>?
        set(value) {
            platform.GetObjectField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jfieldID?) -> jni.jobject?>>?
        }

    actual var GetStaticBooleanField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jboolean>>?
        get() = platform.GetStaticBooleanField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jboolean>>?
        set(value) {
            platform.GetStaticBooleanField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jfieldID?) -> jboolean>>?
        }

    actual var SetIntField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jint) -> Unit>>?
        get() = platform.SetIntField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jint) -> Unit>>?
        set(value) {
            platform.SetIntField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jfieldID?, jint) -> Unit>>?
        }

    actual var ReleaseIntArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jintArray?, CPointer<jintVar>?, jint) -> Unit>>?
        get() = platform.ReleaseIntArrayElements as CPointer<CFunction<(CPointer<JNIEnvVar>?, jintArray?, CPointer<jintVar>?, jint) -> Unit>>?
        set(value) {
            platform.ReleaseIntArrayElements = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jintArray?, CPointer<jintVar>?, jint) -> Unit>>?
        }

    actual var CallStaticFloatMethod: COpaquePointer?
        get() = platform.CallStaticFloatMethod
        set(value) {
            platform.CallStaticFloatMethod = value
        }

    actual var GetStaticDoubleField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jdouble>>?
        get() = platform.GetStaticDoubleField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jdouble>>?
        set(value) {
            platform.GetStaticDoubleField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jfieldID?) -> jdouble>>?
        }

    actual var GetStaticIntField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jint>>?
        get() = platform.GetStaticIntField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jint>>?
        set(value) {
            platform.GetStaticIntField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jfieldID?) -> jint>>?
        }

    actual var GetJavaVM: CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<CPointerVarOf<CPointer<JavaVMVar>>>?) -> jint>>?
        get() = platform.GetJavaVM
        set(value) {
            platform.GetJavaVM = value
        }

    actual var GetFieldID: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<ByteVar>?, CPointer<ByteVar>?) -> jfieldID?>>?
        get() = platform.GetFieldID as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<ByteVar>?, CPointer<ByteVar>?) -> jfieldID?>>?
        set(value) {
            platform.GetFieldID = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, CPointer<ByteVar>?, CPointer<ByteVar>?) -> jni.jfieldID?>>?
        }

    actual var GetLongArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jlongArray?, jsize, jsize, CPointer<jlongVar>?) -> Unit>>?
        get() = platform.GetLongArrayRegion as CPointer<CFunction<(CPointer<JNIEnvVar>?, jlongArray?, jsize, jsize, CPointer<jlongVar>?) -> Unit>>?
        set(value) {
            platform.GetLongArrayRegion = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jlongArray?, jsize, jsize, CPointer<jlongVar>?) -> Unit>>?
        }

    actual var SetStaticLongField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jlong) -> Unit>>?
        get() = platform.SetStaticLongField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jlong) -> Unit>>?
        set(value) {
            platform.SetStaticLongField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jfieldID?, jlong) -> Unit>>?
        }

    actual var ExceptionDescribe: CPointer<CFunction<(CPointer<JNIEnvVar>?) -> Unit>>?
        get() = platform.ExceptionDescribe
        set(value) {
            platform.ExceptionDescribe = value
        }

    actual var CallShortMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jshort>>?
        get() = platform.CallShortMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jshort>>?
        set(value) {
            platform.CallShortMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jmethodID?, CPointer<jvalue>?) -> jshort>>?
        }

    actual var CallStaticVoidMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> Unit>>?
        get() = platform.CallStaticVoidMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> Unit>>?
        set(value) {
            platform.CallStaticVoidMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jmethodID?, CPointer<jvalue>?) -> Unit>>?
        }

    actual var ReleaseStringUTFChars: CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?, CPointer<ByteVar>?) -> Unit>>?
        get() = platform.ReleaseStringUTFChars as CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?, CPointer<ByteVar>?) -> Unit>>?
        set(value) {
            platform.ReleaseStringUTFChars = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jstring?, CPointer<ByteVar>?) -> Unit>>?
        }

    actual var CallStaticCharMethod: COpaquePointer?
        get() = platform.CallStaticCharMethod
        set(value) {
            platform.CallStaticCharMethod = value
        }

    actual var NewGlobalRef: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jobject?>>?
        get() = platform.NewGlobalRef as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jobject?>>?
        set(value) {
            platform.NewGlobalRef = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?) -> jni.jobject?>>?
        }

    actual var SetCharArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jcharArray?, jsize, jsize, CPointer<jcharVar>?) -> Unit>>?
        get() = platform.SetCharArrayRegion as CPointer<CFunction<(CPointer<JNIEnvVar>?, jcharArray?, jsize, jsize, CPointer<jcharVar>?) -> Unit>>?
        set(value) {
            platform.SetCharArrayRegion = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jcharArray?, jsize, jsize, CPointer<jcharVar>?) -> Unit>>?
        }

    actual var CallNonvirtualVoidMethod: COpaquePointer?
        get() = platform.CallNonvirtualVoidMethod
        set(value) {
            platform.CallNonvirtualVoidMethod = value
        }

    actual var ExceptionCheck: CPointer<CFunction<(CPointer<JNIEnvVar>?) -> jboolean>>?
        get() = platform.ExceptionCheck
        set(value) {
            platform.ExceptionCheck = value
        }

    actual var CallCharMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jchar>>?
        get() = platform.CallCharMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jchar>>?
        set(value) {
            platform.CallCharMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jmethodID?, CPointer<jvalue>?) -> jchar>>?
        }

    actual var GetByteField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jbyte>>?
        get() = platform.GetByteField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jbyte>>?
        set(value) {
            platform.GetByteField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jfieldID?) -> jbyte>>?
        }

    actual var FindClass: CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<ByteVar>?) -> jclass?>>?
        get() = platform.FindClass as CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<ByteVar>?) -> jclass?>>?
        set(value) {
            platform.FindClass = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<ByteVar>?) -> jni.jclass?>>?
        }

    actual var SetByteField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jbyte) -> Unit>>?
        get() = platform.SetByteField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jbyte) -> Unit>>?
        set(value) {
            platform.SetByteField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jfieldID?, jbyte) -> Unit>>?
        }

    actual var SetStaticShortField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jshort) -> Unit>>?
        get() = platform.SetStaticShortField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jshort) -> Unit>>?
        set(value) {
            platform.SetStaticShortField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jfieldID?, jshort) -> Unit>>?
        }

    actual var CallLongMethod: COpaquePointer?
        get() = platform.CallLongMethod
        set(value) {
            platform.CallLongMethod = value
        }

    actual var PopLocalFrame: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jobject?>>?
        get() = platform.PopLocalFrame as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jobject?>>?
        set(value) {
            platform.PopLocalFrame = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?) -> jni.jobject?>>?
        }

    actual var SetStaticDoubleField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jdouble) -> Unit>>?
        get() = platform.SetStaticDoubleField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jdouble) -> Unit>>?
        set(value) {
            platform.SetStaticDoubleField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jfieldID?, jdouble) -> Unit>>?
        }

    actual var CallIntMethod: COpaquePointer?
        get() = platform.CallIntMethod
        set(value) {
            platform.CallIntMethod = value
        }

    actual var GetBooleanField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jboolean>>?
        get() = platform.GetBooleanField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jboolean>>?
        set(value) {
            platform.GetBooleanField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jfieldID?) -> jboolean>>?
        }

    actual var GetStaticMethodID: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<ByteVar>?, CPointer<ByteVar>?) -> jmethodID?>>?
        get() = platform.GetStaticMethodID as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<ByteVar>?, CPointer<ByteVar>?) -> jmethodID?>>?
        set(value) {
            platform.GetStaticMethodID = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, CPointer<ByteVar>?, CPointer<ByteVar>?) -> jni.jmethodID?>>?
        }

    actual var GetObjectArrayElement: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobjectArray?, jsize) -> jobject?>>?
        get() = platform.GetObjectArrayElement as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobjectArray?, jsize) -> jobject?>>?
        set(value) {
            platform.GetObjectArrayElement = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobjectArray?, jsize) -> jni.jobject?>>?
        }

    actual var CallStaticDoubleMethod: COpaquePointer?
        get() = platform.CallStaticDoubleMethod
        set(value) {
            platform.CallStaticDoubleMethod = value
        }

    actual var CallVoidMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> Unit>>?
        get() = platform.CallVoidMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> Unit>>?
        set(value) {
            platform.CallVoidMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jmethodID?, CPointer<jvalue>?) -> Unit>>?
        }

    actual var reserved1: COpaquePointer?
        get() = platform.reserved1
        set(value) {
            platform.reserved1 = value
        }

    actual var NewShortArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jshortArray?>>?
        get() = platform.NewShortArray as CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jshortArray?>>?
        set(value) {
            platform.NewShortArray = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jni.jshortArray?>>?
        }

    actual var PushLocalFrame: CPointer<CFunction<(CPointer<JNIEnvVar>?, jint) -> jint>>?
        get() = platform.PushLocalFrame
        set(value) {
            platform.PushLocalFrame
        }

    actual var ReleaseByteArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jbyteArray?, CPointer<jbyteVar>?, jint) -> Unit>>?
        get() = platform.ReleaseByteArrayElements as CPointer<CFunction<(CPointer<JNIEnvVar>?, jbyteArray?, CPointer<jbyteVar>?, jint) -> Unit>>?
        set(value) {
            platform.ReleaseByteArrayElements = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jbyteArray?, CPointer<jbyteVar>?, jint) -> Unit>>?
        }

    actual var CallNonvirtualFloatMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jfloat>>?
        get() = platform.CallNonvirtualFloatMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jfloat>>?
        set(value) {
            platform.CallNonvirtualFloatMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jclass?, jni.jmethodID?, CPointer<jvalue>?) -> jfloat>>?
        }

    actual var CallNonvirtualByteMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jbyte>>?
        get() = platform.CallNonvirtualByteMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jbyte>>?
        set(value) {
            platform.CallNonvirtualByteMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jclass?, jni.jmethodID?, CPointer<jvalue>?) -> jbyte>>?
        }

    actual var GetPrimitiveArrayCritical: CPointer<CFunction<(CPointer<JNIEnvVar>?, jarray?, CPointer<jbooleanVar>?) -> COpaquePointer?>>?
        get() = platform.GetPrimitiveArrayCritical as CPointer<CFunction<(CPointer<JNIEnvVar>?, jarray?, CPointer<jbooleanVar>?) -> COpaquePointer?>>?
        set(value) {
            platform.GetPrimitiveArrayCritical = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jarray?, CPointer<jbooleanVar>?) -> COpaquePointer?>>?
        }

    actual var DeleteWeakGlobalRef: CPointer<CFunction<(CPointer<JNIEnvVar>?, jweak?) -> Unit>>?
        get() = platform.DeleteWeakGlobalRef as CPointer<CFunction<(CPointer<JNIEnvVar>?, jweak?) -> Unit>>?
        set(value) {
            platform.DeleteWeakGlobalRef = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jweak?) -> Unit>>?
        }

    actual var SetCharField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jchar) -> Unit>>?
        get() = platform.SetCharField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jchar) -> Unit>>?
        set(value) {
            platform.SetCharField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jfieldID?, jchar) -> Unit>>?
        }

    actual var GetCharArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jcharArray?, CPointer<jbooleanVar>?) -> CPointer<jcharVar>?>>?
        get() = platform.GetCharArrayElements as CPointer<CFunction<(CPointer<JNIEnvVar>?, jcharArray?, CPointer<jbooleanVar>?) -> CPointer<jcharVar>?>>?
        set(value) {
            platform.GetCharArrayElements = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jcharArray?, CPointer<jbooleanVar>?) -> CPointer<jcharVar>?>>?
        }

    actual var GetStringLength: CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?) -> jsize>>?
        get() = platform.GetStringLength as CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?) -> jsize>>?
        set(value) {
            platform.GetStringLength = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jstring?) -> jsize>>?
        }

    actual var CallNonvirtualShortMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jshort>>?
        get() = platform.CallNonvirtualShortMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jshort>>?
        set(value) {
            platform.CallNonvirtualShortMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jclass?, jni.jmethodID?, CPointer<jvalue>?) -> jshort>>?
        }

    actual var CallStaticShortMethod: COpaquePointer?
        get() = platform.CallStaticShortMethod
        set(value) {
            platform.CallStaticShortMethod = value
        }

    actual var GetBooleanArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jbooleanArray?, CPointer<jbooleanVar>?) -> CPointer<jbooleanVar>?>>?
        get() = platform.GetBooleanArrayElements as CPointer<CFunction<(CPointer<JNIEnvVar>?, jbooleanArray?, CPointer<jbooleanVar>?) -> CPointer<jbooleanVar>?>>?
        set(value) {
            platform.GetBooleanArrayElements = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jbooleanArray?, CPointer<jbooleanVar>?) -> CPointer<jbooleanVar>?>>?
        }

    actual var SetObjectField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jobject?) -> Unit>>?
        get() = platform.SetObjectField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jobject?) -> Unit>>?
        set(value) {
            platform.SetObjectField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jfieldID?, jni.jobject?) -> Unit>>?
        }

    actual var GetSuperclass: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?) -> jclass?>>?
        get() = platform.GetSuperclass as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?) -> jclass?>>?
        set(value) {
            platform.GetSuperclass = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?) -> jni.jclass?>>?
        }

    actual var GetStringUTFRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?, jsize, jsize, CPointer<ByteVar>?) -> Unit>>?
        get() = platform.GetStringUTFRegion as CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?, jsize, jsize, CPointer<ByteVar>?) -> Unit>>?
        set(value) {
            platform.GetStringUTFRegion = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jstring?, jsize, jsize, CPointer<ByteVar>?) -> Unit>>?
        }

    actual var SetLongArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jlongArray?, jsize, jsize, CPointer<jlongVar>?) -> Unit>>?
        get() = platform.SetLongArrayRegion as CPointer<CFunction<(CPointer<JNIEnvVar>?, jlongArray?, jsize, jsize, CPointer<jlongVar>?) -> Unit>>?
        set(value) {
            platform.SetLongArrayRegion = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jlongArray?, jsize, jsize, CPointer<jlongVar>?) -> Unit>>?
        }

    actual var RegisterNatives: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<JNINativeMethod>?, jint) -> jint>>?
        get() = platform.RegisterNatives as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<JNINativeMethod>?, jint) -> jint>>?
        set(value) {
            platform.RegisterNatives = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, CPointer<JNINativeMethod>?, jint) -> jint>>?
        }

    actual var SetIntArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jintArray?, jsize, jsize, CPointer<jintVar>?) -> Unit>>?
        get() = platform.SetIntArrayRegion as CPointer<CFunction<(CPointer<JNIEnvVar>?, jintArray?, jsize, jsize, CPointer<jintVar>?) -> Unit>>?
        set(value) {
            platform.SetIntArrayRegion = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jintArray?, jsize, jsize, CPointer<jintVar>?) -> Unit>>?
        }

    actual var SetFloatField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jfloat) -> Unit>>?
        get() = platform.SetFloatField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jfloat) -> Unit>>?
        set(value) {
            platform.SetFloatField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jfieldID?, jfloat) -> Unit>>?
        }

    actual var NewBooleanArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jbooleanArray?>>?
        get() = platform.NewBooleanArray as CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jbooleanArray?>>?
        set(value) {
            platform.NewBooleanArray = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jni.jbooleanArray?>>?
        }

    actual var GetDoubleArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jdoubleArray?, CPointer<jbooleanVar>?) -> CPointer<jdoubleVar>?>>?
        get() = platform.GetDoubleArrayElements as CPointer<CFunction<(CPointer<JNIEnvVar>?, jdoubleArray?, CPointer<jbooleanVar>?) -> CPointer<jdoubleVar>?>>?
        set(value) {
            platform.GetDoubleArrayElements = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jdoubleArray?, CPointer<jbooleanVar>?) -> CPointer<jdoubleVar>?>>?
        }

    actual var CallStaticIntMethod: COpaquePointer?
        get() = platform.CallStaticIntMethod
        set(value) {
            platform.CallStaticIntMethod = value
        }

    actual var CallStaticByteMethod: COpaquePointer?
        get() = platform.CallStaticByteMethod
        set(value) {
            platform.CallStaticByteMethod = value
        }

    actual var CallFloatMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jfloat>>?
        get() = platform.CallFloatMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jfloat>>?
        set(value) {
            platform.CallFloatMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jmethodID?, CPointer<jvalue>?) -> jfloat>>?
        }

    actual var SetByteArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jbyteArray?, jsize, jsize, CPointer<jbyteVar>?) -> Unit>>?
        get() = platform.SetByteArrayRegion as CPointer<CFunction<(CPointer<JNIEnvVar>?, jbyteArray?, jsize, jsize, CPointer<jbyteVar>?) -> Unit>>?
        set(value) {
            platform.SetByteArrayRegion = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jbyteArray?, jsize, jsize, CPointer<jbyteVar>?) -> Unit>>?
        }

    actual var GetStaticShortField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jshort>>?
        get() = platform.GetStaticShortField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jshort>>?
        set(value) {
            platform.GetStaticShortField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jfieldID?) -> jshort>>?
        }

    actual var CallStaticShortMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jshort>>?
        get() = platform.CallStaticShortMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jshort>>?
        set(value) {
            platform.CallStaticShortMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jmethodID?, CPointer<jvalue>?) -> jshort>>?
        }

    actual var ReleaseBooleanArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jbooleanArray?, CPointer<jbooleanVar>?, jint) -> Unit>>?
        get() = platform.ReleaseBooleanArrayElements as CPointer<CFunction<(CPointer<JNIEnvVar>?, jbooleanArray?, CPointer<jbooleanVar>?, jint) -> Unit>>?
        set(value) {
            platform.ReleaseBooleanArrayElements = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jbooleanArray?, CPointer<jbooleanVar>?, jint) -> Unit>>?
        }

    actual var GetStaticObjectField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jobject?>>?
        get() = platform.GetStaticObjectField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jobject?>>?
        set(value) {
            platform.GetStaticObjectField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jfieldID?) -> jni.jobject?>>?
        }

    actual var MonitorEnter: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jint>>?
        get() = platform.MonitorEnter as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jint>>?
        set(value) {
            platform.MonitorExit = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?) -> jint>>?
        }

    actual var CallNonvirtualLongMethod: COpaquePointer?
        get() = platform.CallNonvirtualLongMethod
        set(value) {
            platform.CallNonvirtualLongMethod = value
        }

    actual var SetLongField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jlong) -> Unit>>?
        get() = platform.SetLongField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jlong) -> Unit>>?
        set(value) {
            platform.SetLongField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jfieldID?, jlong) -> Unit>>?
        }

    actual var ReleaseStringCritical: CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?, CPointer<jcharVar>?) -> Unit>>?
        get() = platform.ReleaseStringCritical as CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?, CPointer<jcharVar>?) -> Unit>>?
        set(value) {
            platform.ReleaseStringCritical = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jstring?, CPointer<jcharVar>?) -> Unit>>?
        }

    actual var GetFloatField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jfloat>>?
        get() = platform.GetFloatField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jfloat>>?
        set(value) {
            platform.GetFloatField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jfieldID?) -> jfloat>>?
        }

    actual var CallByteMethod: COpaquePointer?
        get() = platform.CallByteMethod
        set(value) {
            platform.CallByteMethod = value
        }

    actual var ReleasePrimitiveArrayCritical: CPointer<CFunction<(CPointer<JNIEnvVar>?, jarray?, COpaquePointer?, jint) -> Unit>>?
        get() = platform.ReleasePrimitiveArrayCritical as CPointer<CFunction<(CPointer<JNIEnvVar>?, jarray?, COpaquePointer?, jint) -> Unit>>?
        set(value) {
            platform.ReleasePrimitiveArrayCritical = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jarray?, COpaquePointer?, jint) -> Unit>>?
        }

    actual var GetIntField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jint>>?
        get() = platform.GetIntField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jint>>?
        set(value) {
            platform.GetIntField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jfieldID?) -> jint>>?
        }

    actual var GetObjectRefType: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jobjectRefType>>?
        get() = platform.GetObjectRefType as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jobjectRefType>>?
        set(value) {
            platform.GetObjectRefType = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?) -> jobjectRefType>>?
        }

    actual var GetFloatArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jfloatArray?, jsize, jsize, CPointer<jfloatVar>?) -> Unit>>?
        get() = platform.GetFloatArrayRegion as CPointer<CFunction<(CPointer<JNIEnvVar>?, jfloatArray?, jsize, jsize, CPointer<jfloatVar>?) -> Unit>>?
        set(value) {
            platform.GetFloatArrayRegion = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jfloatArray?, jsize, jsize, CPointer<jfloatVar>?) -> Unit>>?
        }

    actual var GetDoubleArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jdoubleArray?, jsize, jsize, CPointer<jdoubleVar>?) -> Unit>>?
        get() = platform.GetDoubleArrayRegion as CPointer<CFunction<(CPointer<JNIEnvVar>?, jdoubleArray?, jsize, jsize, CPointer<jdoubleVar>?) -> Unit>>?
        set(value) {
            platform.GetDoubleArrayRegion = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jdoubleArray?, jsize, jsize, CPointer<jdoubleVar>?) -> Unit>>?
        }

    actual var NewObject: COpaquePointer?
        get() = platform.NewObject
        set(value) {
            platform.NewObject = value
        }

    actual var CallObjectMethod: COpaquePointer?
        get() = platform.CallObjectMethod
        set(value) {
            platform.CallObjectMethod = value
        }

    actual var SetDoubleField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jdouble) -> Unit>>?
        get() = platform.SetDoubleField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jdouble) -> Unit>>?
        set(value) {
            platform.SetDoubleField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jfieldID?, jdouble) -> Unit>>?
        }

    actual var CallBooleanMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jboolean>>?
        get() = platform.CallBooleanMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jboolean>>?
        set(value) {
            platform.CallBooleanMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jmethodID?, CPointer<jvalue>?) -> jboolean>>?
        }

    actual var GetShortArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jshortArray?, CPointer<jbooleanVar>?) -> CPointer<jshortVar>?>>?
        get() = platform.GetShortArrayElements as CPointer<CFunction<(CPointer<JNIEnvVar>?, jshortArray?, CPointer<jbooleanVar>?) -> CPointer<jshortVar>?>>?
        set(value) {
            platform.GetShortArrayElements = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jshortArray?, CPointer<jbooleanVar>?) -> CPointer<jshortVar>?>>?
        }

    actual var CallNonvirtualDoubleMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jdouble>>?
        get() = platform.CallNonvirtualDoubleMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jdouble>>?
        set(value) {
            platform.CallNonvirtualDoubleMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jclass?, jni.jmethodID?, CPointer<jvalue>?) -> jdouble>>?
        }

    actual var FromReflectedMethod: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jmethodID?>>?
        get() = platform.FromReflectedMethod as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jmethodID?>>?
        set(value) {
            platform.FromReflectedMethod = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?) -> jni.jmethodID?>>?
        }

    actual var CallNonvirtualIntMethod: COpaquePointer?
        get() = platform.CallNonvirtualIntMethod
        set(value) {
            platform.CallNonvirtualIntMethod = value
        }

    actual var DeleteLocalRef: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> Unit>>?
        get() = platform.DeleteLocalRef as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> Unit>>?
        set(value) {
            platform.DeleteLocalRef = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?) -> Unit>>?
        }

    actual var CallNonvirtualVoidMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> Unit>>?
        get() = platform.CallNonvirtualVoidMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> Unit>>?
        set(value) {
            platform.CallNonvirtualVoidMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jclass?, jni.jmethodID?, CPointer<jvalue>?) -> Unit>>?
        }

    actual var ReleaseShortArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jshortArray?, CPointer<jshortVar>?, jint) -> Unit>>?
        get() = platform.ReleaseShortArrayElements as CPointer<CFunction<(CPointer<JNIEnvVar>?, jshortArray?, CPointer<jshortVar>?, jint) -> Unit>>?
        set(value) {
            platform.ReleaseShortArrayElements = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jshortArray?, CPointer<jshortVar>?, jint) -> Unit>>?
        }

    actual var ToReflectedMethod: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, jboolean) -> jobject?>>?
        get() = platform.ToReflectedMethod as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, jboolean) -> jobject?>>?
        set(value) {
            platform.ToReflectedMethod = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jmethodID?, jboolean) -> jni.jobject?>>?
        }

    actual var GetDirectBufferCapacity: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jlong>>?
        get() = platform.GetDirectBufferCapacity as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jlong>>?
        set(value) {
            platform.GetDirectBufferCapacity = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?) -> jlong>>?
        }

    actual var CallNonvirtualByteMethod: COpaquePointer?
        get() = platform.CallNonvirtualByteMethod
        set(value) {
            platform.CallNonvirtualByteMethod = value
        }

    actual var CallNonvirtualCharMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jchar>>?
        get() = platform.CallNonvirtualCharMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jchar>>?
        set(value) {
            platform.CallNonvirtualCharMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jclass?, jni.jmethodID?, CPointer<jvalue>?) -> jchar>>?
        }

    actual var GetStaticCharField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jchar>>?
        get() = platform.GetStaticCharField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jchar>>?
        set(value) {
            platform.GetStaticCharField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jfieldID?) -> jchar>>?
        }

    actual var NewDirectByteBuffer: CPointer<CFunction<(CPointer<JNIEnvVar>?, COpaquePointer?, jlong) -> jobject?>>?
        get() = platform.NewDirectByteBuffer as CPointer<CFunction<(CPointer<JNIEnvVar>?, COpaquePointer?, jlong) -> jobject?>>?
        set(value) {
            platform.NewDirectByteBuffer = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, COpaquePointer?, jlong) -> jni.jobject?>>?
        }

    actual var UnregisterNatives: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?) -> jint>>?
        get() = platform.UnregisterNatives as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?) -> jint>>?
        set(value) {
            platform.UnregisterNatives = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?) -> jint>>?
        }

    actual var GetDirectBufferAddress: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> COpaquePointer?>>?
        get() = platform.GetDirectBufferAddress as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> COpaquePointer?>>?
        set(value) {
            platform.GetDirectBufferAddress = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?) -> COpaquePointer?>>?
        }

    actual var GetShortField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jshort>>?
        get() = platform.GetShortField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jshort>>?
        set(value) {
            platform.GetShortField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jfieldID?) -> jshort>>?
        }

    actual var NewFloatArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jfloatArray?>>?
        get() = platform.NewFloatArray as CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jfloatArray?>>?
        set(value) {
            platform.NewFloatArray = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jni.jfloatArray?>>?
        }

    actual var FromReflectedField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jfieldID?>>?
        get() = platform.FromReflectedField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jfieldID?>>?
        set(value) {
            platform.FromReflectedField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?) -> jni.jfieldID?>>?
        }

    actual var GetStaticByteField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jbyte>>?
        get() = platform.GetStaticByteField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jbyte>>?
        set(value) {
            platform.GetStaticByteField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jfieldID?) -> jbyte>>?
        }

    actual var GetStaticLongField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jlong>>?
        get() = platform.GetStaticLongField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jlong>>?
        set(value) {
            platform.GetStaticLongField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jfieldID?) -> jlong>>?
        }

    actual var SetFloatArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jfloatArray?, jsize, jsize, CPointer<jfloatVar>?) -> Unit>>?
        get() = platform.SetFloatArrayRegion as CPointer<CFunction<(CPointer<JNIEnvVar>?, jfloatArray?, jsize, jsize, CPointer<jfloatVar>?) -> Unit>>?
        set(value) {
            platform.SetFloatArrayRegion = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jfloatArray?, jsize, jsize, CPointer<jfloatVar>?) -> Unit>>?
        }

    actual var CallNonvirtualIntMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jint>>?
        get() = platform.CallNonvirtualIntMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jint>>?
        set(value) {
            platform.CallNonvirtualIntMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jclass?, jni.jmethodID?, CPointer<jvalue>?) -> jint>>?
        }

    actual var GetStringUTFChars: CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?, CPointer<jbooleanVar>?) -> CPointer<ByteVar>?>>?
        get() = platform.GetStringUTFChars as CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?, CPointer<jbooleanVar>?) -> CPointer<ByteVar>?>>?
        set(value) {
            platform.GetStringUTFChars = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jstring?, CPointer<jbooleanVar>?) -> CPointer<ByteVar>?>>?
        }

    actual var ReleaseFloatArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jfloatArray?, CPointer<jfloatVar>?, jint) -> Unit>>?
        get() = platform.ReleaseFloatArrayElements as CPointer<CFunction<(CPointer<JNIEnvVar>?, jfloatArray?, CPointer<jfloatVar>?, jint) -> Unit>>?
        set(value) {
            platform.ReleaseFloatArrayElements = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jfloatArray?, CPointer<jfloatVar>?, jint) -> Unit>>?
        }

    actual var IsAssignableFrom: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jclass?) -> jboolean>>?
        get() = platform.IsAssignableFrom as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jclass?) -> jboolean>>?
        set(value) {
            platform.IsAssignableFrom = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jclass?) -> jboolean>>?
        }

    actual var SetShortField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jshort) -> Unit>>?
        get() = platform.SetShortField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jshort) -> Unit>>?
        set(value) {
            platform.SetShortField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jfieldID?, jshort) -> Unit>>?
        }

    actual var CallByteMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jbyte>>?
        get() = platform.CallByteMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jbyte>>?
        set(value) {
            platform.CallByteMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jmethodID?, CPointer<jvalue>?) -> jbyte>>?
        }

    actual var ReleaseCharArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jcharArray?, CPointer<jcharVar>?, jint) -> Unit>>?
        get() = platform.ReleaseCharArrayElements as CPointer<CFunction<(CPointer<JNIEnvVar>?, jcharArray?, CPointer<jcharVar>?, jint) -> Unit>>?
        set(value) {
            platform.ReleaseCharArrayElements = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jcharArray?, CPointer<jcharVar>?, jint) -> Unit>>?
        }

    actual var NewObjectArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize, jclass?, jobject?) -> jobjectArray?>>?
        get() = platform.NewObjectArray as CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize, jclass?, jobject?) -> jobjectArray?>>?
        set(value) {
            platform.NewObjectArray = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize, jni.jclass?, jni.jobject?) -> jni.jobjectArray?>>?
        }

    actual var CallStaticIntMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jint>>?
        get() = platform.CallStaticIntMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jint>>?
        set(value) {
            platform.CallStaticIntMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jmethodID?, CPointer<jvalue>?) -> jint>>?
        }

    actual var GetObjectClass: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jclass?>>?
        get() = platform.GetObjectClass as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jclass?>>?
        set(value) {
            platform.GetObjectClass = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?) -> jni.jclass?>>?
        }

    actual var GetStringCritical: CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?, CPointer<jbooleanVar>?) -> CPointer<jcharVar>?>>?
        get() = platform.GetStringCritical as CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?, CPointer<jbooleanVar>?) -> CPointer<jcharVar>?>>?
        set(value) {
            platform.GetStringCritical = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jstring?, CPointer<jbooleanVar>?) -> CPointer<jcharVar>?>>?
        }

    actual var CallStaticByteMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jbyte>>?
        get() = platform.CallStaticByteMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jbyte>>?
        set(value) {
            platform.CallStaticByteMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jmethodID?, CPointer<jvalue>?) -> jbyte>>?
        }

    actual var ReleaseDoubleArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jdoubleArray?, CPointer<jdoubleVar>?, jint) -> Unit>>?
        get() = platform.ReleaseDoubleArrayElements as CPointer<CFunction<(CPointer<JNIEnvVar>?, jdoubleArray?, CPointer<jdoubleVar>?, jint) -> Unit>>?
        set(value) {
            platform.ReleaseDoubleArrayElements =
                value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jdoubleArray?, CPointer<jdoubleVar>?, jint) -> Unit>>?
        }

    actual var GetStaticFieldID: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<ByteVar>?, CPointer<ByteVar>?) -> jfieldID?>>?
        get() = platform.GetStaticFieldID as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<ByteVar>?, CPointer<ByteVar>?) -> jfieldID?>>?
        set(value) {
            platform.GetStaticFieldID = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, CPointer<ByteVar>?, CPointer<ByteVar>?) -> jni.jfieldID?>>?
        }

    actual var SetBooleanArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jbooleanArray?, jsize, jsize, CPointer<jbooleanVar>?) -> Unit>>?
        get() = platform.SetBooleanArrayRegion as CPointer<CFunction<(CPointer<JNIEnvVar>?, jbooleanArray?, jsize, jsize, CPointer<jbooleanVar>?) -> Unit>>?
        set(value) {
            platform.SetBooleanArrayRegion = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jbooleanArray?, jsize, jsize, CPointer<jbooleanVar>?) -> Unit>>?
        }

    actual var reserved2: COpaquePointer?
        get() = platform.reserved2
        set(value) {
            platform.reserved2 = value
        }

    actual var NewStringUTF: CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<ByteVar>?) -> jstring?>>?
        get() = platform.NewStringUTF as CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<ByteVar>?) -> jstring?>>?
        set(value) {
            platform.NewStringUTF = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<ByteVar>?) -> jni.jstring?>>?
        }

    actual var SetObjectArrayElement: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobjectArray?, jsize, jobject?) -> Unit>>?
        get() = platform.SetObjectArrayElement as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobjectArray?, jsize, jobject?) -> Unit>>?
        set(value) {
            platform.SetObjectArrayElement = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobjectArray?, jsize, jni.jobject?) -> Unit>>?
        }

    actual var CallNonvirtualShortMethod: COpaquePointer?
        get() = platform.CallNonvirtualShortMethod
        set(value) {
            platform.CallNonvirtualShortMethod = value
        }

    actual var GetCharArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jcharArray?, jsize, jsize, CPointer<jcharVar>?) -> Unit>>?
        get() = platform.GetCharArrayRegion as CPointer<CFunction<(CPointer<JNIEnvVar>?, jcharArray?, jsize, jsize, CPointer<jcharVar>?) -> Unit>>?
        set(value) {
            platform.GetCharArrayRegion =
                value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jcharArray?, jsize, jsize, CPointer<jcharVar>?) -> Unit>>?
        }

    actual var GetFloatArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jfloatArray?, CPointer<jbooleanVar>?) -> CPointer<jfloatVar>?>>?
        get() = platform.GetFloatArrayElements as CPointer<CFunction<(CPointer<JNIEnvVar>?, jfloatArray?, CPointer<jbooleanVar>?) -> CPointer<jfloatVar>?>>?
        set(value) {
            platform.GetFloatArrayElements = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jfloatArray?, CPointer<jbooleanVar>?) -> CPointer<jfloatVar>?>>?
        }

    actual var CallObjectMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jobject?>>?
        get() = platform.CallObjectMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jobject?>>?
        set(value) {
            platform.CallObjectMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jmethodID?, CPointer<jvalue>?) -> jni.jobject?>>?
        }

    actual var NewWeakGlobalRef: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jweak?>>?
        get() = platform.NewWeakGlobalRef as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jweak?>>?
        set(value) {
            platform.NewWeakGlobalRef = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?) -> jni.jweak?>>?
        }

    actual var CallCharMethod: COpaquePointer?
        get() = platform.CallCharMethod
        set(value) {
            platform.CallCharMethod = value
        }

    actual var CallNonvirtualFloatMethod: COpaquePointer?
        get() = platform.CallNonvirtualFloatMethod
        set(value) {
            platform.CallNonvirtualFloatMethod = value
        }

    actual var NewDoubleArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jdoubleArray?>>?
        get() = platform.NewDoubleArray as CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jdoubleArray?>>?
        set(value) {
            platform.NewDoubleArray = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jni.jdoubleArray?>>?
        }

    actual var CallNonvirtualBooleanMethod: COpaquePointer?
        get() = platform.CallNonvirtualBooleanMethod
        set(value) {
            platform.CallNonvirtualBooleanMethod = value
        }

    actual var SetStaticIntField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jint) -> Unit>>?
        get() = platform.SetStaticIntField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jint) -> Unit>>?
        set(value) {
            platform.SetStaticIntField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jfieldID?, jint) -> Unit>>?
        }

    actual var ToReflectedField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jboolean) -> jobject?>>?
        get() = platform.ToReflectedField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jboolean) -> jobject?>>?
        set(value) {
            platform.ToReflectedField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jfieldID?, jboolean) -> jni.jobject?>>?
        }

    actual var GetStringRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?, jsize, jsize, CPointer<jcharVar>?) -> Unit>>?
        get() = platform.GetStringRegion as CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?, jsize, jsize, CPointer<jcharVar>?) -> Unit>>?
        set(value) {
            platform.GetStringRegion = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jstring?, jsize, jsize, CPointer<jcharVar>?) -> Unit>>?
        }

    actual var GetShortArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jshortArray?, jsize, jsize, CPointer<jshortVar>?) -> Unit>>?
        get() = platform.GetShortArrayRegion as CPointer<CFunction<(CPointer<JNIEnvVar>?, jshortArray?, jsize, jsize, CPointer<jshortVar>?) -> Unit>>?
        set(value) {
            platform.GetShortArrayRegion = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jshortArray?, jsize, jsize, CPointer<jshortVar>?) -> Unit>>?
        }

    actual var MonitorExit: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jint>>?
        get() = platform.MonitorExit as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jint>>?
        set(value) {
            platform.MonitorExit = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?) -> jint>>?
        }

    actual var CallStaticLongMethod: COpaquePointer?
        get() = platform.CallStaticLongMethod
        set(value) {
            platform.CallStaticLongMethod = value
        }

    actual var CallShortMethod: COpaquePointer?
        get() = platform.CallShortMethod
        set(value) {
            platform.CallShortMethod = value
        }

    actual var CallNonvirtualLongMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jlong>>?
        get() = platform.CallNonvirtualLongMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jlong>>?
        set(value) {
            platform.CallNonvirtualLongMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jclass?, jni.jmethodID?, CPointer<jvalue>?) -> jlong>>?
        }

    actual var GetMethodID: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<ByteVar>?, CPointer<ByteVar>?) -> jmethodID?>>?
        get() = platform.GetMethodID as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<ByteVar>?, CPointer<ByteVar>?) -> jmethodID?>>?
        set(value) {
            platform.GetMethodID = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, CPointer<ByteVar>?, CPointer<ByteVar>?) -> jni.jmethodID?>>?
        }

    actual var CallIntMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jint>>?
        get() = platform.CallIntMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jint>>?
        set(value) {
            platform.CallIntMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jmethodID?, CPointer<jvalue>?) -> jint>>?
        }

    actual var DefineClass: CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<ByteVar>?, jobject?, CPointer<jbyteVar>?, jsize) -> jclass?>>?
        get() = platform.DefineClass as CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<ByteVar>?, jobject?, CPointer<jbyteVar>?, jsize) -> jclass?>>?
        set(value) {
            platform.DefineClass = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<ByteVar>?, jni.jobject?, CPointer<jbyteVar>?, jsize) -> jni.jclass?>>?
        }

    actual var GetStringChars: CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?, CPointer<jbooleanVar>?) -> CPointer<jcharVar>?>>?
        get() = platform.GetStringChars as CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?, CPointer<jbooleanVar>?) -> CPointer<jcharVar>?>>?
        set(value) {
            platform.GetStringChars = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jstring?, CPointer<jbooleanVar>?) -> CPointer<jcharVar>?>>?
        }

    actual var GetIntArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jintArray?, jsize, jsize, CPointer<jintVar>?) -> Unit>>?
        get() = platform.GetIntArrayRegion as CPointer<CFunction<(CPointer<JNIEnvVar>?, jintArray?, jsize, jsize, CPointer<jintVar>?) -> Unit>>?
        set(value) {
            platform.GetIntArrayRegion = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jintArray?, jsize, jsize, CPointer<jintVar>?) -> Unit>>?
        }

    actual var CallDoubleMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jdouble>>?
        get() = platform.CallDoubleMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jdouble>>?
        set(value) {
            platform.CallDoubleMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jmethodID?, CPointer<jvalue>?) -> jdouble>>?
        }

    actual var CallStaticObjectMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jobject?>>?
        get() = platform.CallStaticObjectMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jobject?>>?
        set(value) {
            platform.CallStaticObjectMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jmethodID?, CPointer<jvalue>?) -> jni.jobject?>>?
        }

    actual var ReleaseStringChars: CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?, CPointer<jcharVar>?) -> Unit>>?
        get() = platform.ReleaseStringChars as CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?, CPointer<jcharVar>?) -> Unit>>?
        set(value) {
            platform.ReleaseStringChars = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jstring?, CPointer<jcharVar>?) -> Unit>>?
        }

    actual var GetStaticFloatField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jfloat>>?
        get() = platform.GetStaticFloatField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jfloat>>?
        set(value) {
            platform.GetStaticFloatField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jfieldID?) -> jfloat>>?
        }

    actual var GetIntArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jintArray?, CPointer<jbooleanVar>?) -> CPointer<jintVar>?>>?
        get() = platform.GetIntArrayElements as CPointer<CFunction<(CPointer<JNIEnvVar>?, jintArray?, CPointer<jbooleanVar>?) -> CPointer<jintVar>?>>?
        set(value) {
            platform.GetIntArrayElements = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jintArray?, CPointer<jbooleanVar>?) -> CPointer<jintVar>?>>?
        }

    actual var CallStaticBooleanMethod: COpaquePointer?
        get() = platform.CallStaticBooleanMethod
        set(value) {
            platform.CallStaticBooleanMethod = value
        }

    actual var GetBooleanArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jbooleanArray?, jsize, jsize, CPointer<jbooleanVar>?) -> Unit>>?
        get() = platform.GetBooleanArrayRegion as CPointer<CFunction<(CPointer<JNIEnvVar>?, jbooleanArray?, jsize, jsize, CPointer<jbooleanVar>?) -> Unit>>?
        set(value) {
            platform.GetBooleanArrayRegion = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jbooleanArray?, jsize, jsize, CPointer<jbooleanVar>?) -> Unit>>?
        }

    actual var GetVersion: CPointer<CFunction<(CPointer<JNIEnvVar>?) -> jint>>?
        get() = platform.GetVersion
        set(value) {
            platform.GetVersion = value
        }

    actual var CallStaticObjectMethod: COpaquePointer?
        get() = platform.CallStaticObjectMethod
        set(value) {
            platform.CallStaticObjectMethod = value
        }

    actual var NewObjectA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jobject?>>?
        get() = platform.NewObjectA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jobject?>>?
        set(value) {
            platform.NewObjectA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jmethodID?, CPointer<jvalue>?) -> jni.jobject?>>?
        }

    actual var SetStaticCharField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jchar) -> Unit>>?
        get() = platform.SetStaticCharField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jchar) -> Unit>>?
        set(value) {
            platform.SetStaticCharField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jfieldID?, jchar) -> Unit>>?
        }

    actual var IsSameObject: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jobject?) -> jboolean>>?
        get() = platform.IsSameObject as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jobject?) -> jboolean>>?
        set(value) {
            platform.IsSameObject = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jobject?) -> jboolean>>?
        }

    actual var reserved3: COpaquePointer?
        get() = platform.reserved3
        set(value) {
            platform.reserved3 = value
        }

    actual var SetStaticBooleanField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jboolean) -> Unit>>?
        get() = platform.SetStaticBooleanField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jboolean) -> Unit>>?
        set(value) {
            platform.SetStaticBooleanField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jfieldID?, jboolean) -> Unit>>?
        }

    actual var SetStaticObjectField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jobject?) -> Unit>>?
        get() = platform.SetStaticObjectField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jobject?) -> Unit>>?
        set(value) {
            platform.SetStaticObjectField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jfieldID?, jni.jobject?) -> Unit>>?
        }

    actual var CallStaticBooleanMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jboolean>>?
        get() = platform.CallStaticBooleanMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jboolean>>?
        set(value) {
            platform.CallStaticBooleanMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jmethodID?, CPointer<jvalue>?) -> jboolean>>?
        }

    actual var SetStaticFloatField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jfloat) -> Unit>>?
        get() = platform.SetStaticFloatField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jfloat) -> Unit>>?
        set(value) {
            platform.SetStaticFloatField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jfieldID?, jfloat) -> Unit>>?
        }

    actual var CallStaticVoidMethod: COpaquePointer?
        get() = platform.CallStaticVoidMethod
        set(value) {
            platform.CallStaticVoidMethod = value
        }

    actual var CallStaticCharMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jchar>>?
        get() = platform.CallStaticCharMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jchar>>?
        set(value) {
            platform.CallStaticCharMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jmethodID?, CPointer<jvalue>?) -> jchar>>?
        }

    actual var DeleteGlobalRef: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> Unit>>?
        get() = platform.DeleteGlobalRef as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> Unit>>?
        set(value) {
            platform.DeleteGlobalRef = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?) -> Unit>>?
        }

    actual var IsInstanceOf: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?) -> jboolean>>?
        get() = platform.IsInstanceOf as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?) -> jboolean>>?
        set(value) {
            platform.IsInstanceOf = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jclass?) -> jboolean>>?
        }

    actual var NewLocalRef: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jobject?>>?
        get() = platform.NewLocalRef as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jobject?>>?
        set(value) {
            platform.NewLocalRef = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?) -> jni.jobject?>>?
        }

    actual var CallStaticDoubleMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jdouble>>?
        get() = platform.CallStaticDoubleMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jdouble>>?
        set(value) {
            platform.CallStaticDoubleMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, jni.jmethodID?, CPointer<jvalue>?) -> jdouble>>?
        }

    actual var GetArrayLength: CPointer<CFunction<(CPointer<JNIEnvVar>?, jarray?) -> jsize>>?
        get() = platform.GetArrayLength as CPointer<CFunction<(CPointer<JNIEnvVar>?, jarray?) -> jsize>>?
        set(value) {
            platform.GetArrayLength = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jarray?) -> jsize>>?
        }

    actual var GetLongArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jlongArray?, CPointer<jbooleanVar>?) -> CPointer<jlongVar>?>>?
        get() = platform.GetLongArrayElements as CPointer<CFunction<(CPointer<JNIEnvVar>?, jlongArray?, CPointer<jbooleanVar>?) -> CPointer<jlongVar>?>>?
        set(value) {
            platform.GetLongArrayElements = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jlongArray?, CPointer<jbooleanVar>?) -> CPointer<jlongVar>?>>?
        }

    actual var ThrowNew: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<ByteVar>?) -> jint>>?
        get() = platform.ThrowNew as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<ByteVar>?) -> jint>>?
        set(value) {
            platform.ThrowNew = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jclass?, CPointer<ByteVar>?) -> jint>>?
        }

    actual var CallDoubleMethod: COpaquePointer?
        get() = platform.CallDoubleMethod
        set(value) {
            platform.CallDoubleMethod = value
        }

    actual var CallNonvirtualObjectMethod: COpaquePointer?
        get() = platform.CallNonvirtualObjectMethod
        set(value) {
            platform.CallNonvirtualObjectMethod = value
        }

    actual var SetShortArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jshortArray?, jsize, jsize, CPointer<jshortVar>?) -> Unit>>?
        get() = platform.SetShortArrayRegion as CPointer<CFunction<(CPointer<JNIEnvVar>?, jshortArray?, jsize, jsize, CPointer<jshortVar>?) -> Unit>>?
        set(value) {
            platform.SetShortArrayRegion = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jshortArray?, jsize, jsize, CPointer<jshortVar>?) -> Unit>>?
        }

    actual var NewIntArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jintArray?>>?
        get() = platform.NewIntArray as CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jintArray?>>?
        set(value) {
            platform.NewIntArray = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jni.jintArray?>>?
        }

    actual var GetCharField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jchar>>?
        get() = platform.GetCharField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jchar>>?
        set(value) {
            platform.GetCharField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jfieldID?) -> jchar>>?
        }

    actual var reserved0: COpaquePointer?
        get() = platform.reserved0
        set(value) {
            platform.reserved0 = value
        }

    actual var GetLongField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jlong>>?
        get() = platform.GetLongField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jlong>>?
        set(value) {
            platform.GetLongField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jfieldID?) -> jlong>>?
        }

    actual var SetBooleanField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jboolean) -> Unit>>?
        get() = platform.SetBooleanField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jboolean) -> Unit>>?
        set(value) {
            platform.SetBooleanField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jfieldID?, jboolean) -> Unit>>?
        }

    actual var SetDoubleArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jdoubleArray?, jsize, jsize, CPointer<jdoubleVar>?) -> Unit>>?
        get() = platform.SetDoubleArrayRegion as CPointer<CFunction<(CPointer<JNIEnvVar>?, jdoubleArray?, jsize, jsize, CPointer<jdoubleVar>?) -> Unit>>?
        set(value) {
            platform.SetDoubleArrayRegion = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jdoubleArray?, jsize, jsize, CPointer<jdoubleVar>?) -> Unit>>?
        }

    actual var GetDoubleField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jdouble>>?
        get() = platform.GetDoubleField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jdouble>>?
        set(value) {
            platform.GetDoubleField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jfieldID?) -> jdouble>>?
        }

    actual var ReleaseLongArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jlongArray?, CPointer<jlongVar>?, jint) -> Unit>>?
        get() = platform.ReleaseLongArrayElements as CPointer<CFunction<(CPointer<JNIEnvVar>?, jlongArray?, CPointer<jlongVar>?, jint) -> Unit>>?
        set(value) {
            platform.ReleaseLongArrayElements = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jlongArray?, CPointer<jlongVar>?, jint) -> Unit>>?
        }

    actual var CallNonvirtualBooleanMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jboolean>>?
        get() = platform.CallNonvirtualBooleanMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jboolean>>?
        set(value) {
            platform.CallNonvirtualBooleanMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jni.jobject?, jni.jclass?, jni.jmethodID?, CPointer<jvalue>?) -> jboolean>>?
        }

    actual var NewString: CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<jcharVar>?, jsize) -> jstring?>>?
        get() = platform.NewString as CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<jcharVar>?, jsize) -> jstring?>>?
        set(value) {
            platform.NewString = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<jcharVar>?, jsize) -> jni.jstring?>>?
        }

    actual companion object {
        actual operator fun invoke(platform: JNINativeInterface) = CommonJNINativeInterface(platform)
    }
}