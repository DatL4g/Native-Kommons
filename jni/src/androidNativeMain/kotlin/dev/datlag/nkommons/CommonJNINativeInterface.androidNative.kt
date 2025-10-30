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

@OptIn(ExperimentalForeignApi::class)
actual class CommonJNINativeInterface(
    actual val platform: JNINativeInterface
) {

    actual var NewLongArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jlongArray?>>?
        get() = platform.NewLongArray
        set(value) {
            platform.NewLongArray = value
        }

    actual var GetByteArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jbyteArray?, CPointer<jbooleanVar>?) -> CPointer<ByteVarOf<jbyte>>?>>?
        get() = platform.GetByteArrayElements
        set(value) {
            platform.GetByteArrayElements = value
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
            platform.SetStaticByteField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jfieldID?, jbyte) -> Unit>>?
        }

    actual var CallNonvirtualDoubleMethod: COpaquePointer?
        get() = platform.CallNonvirtualDoubleMethod
        set(value) {
            platform.CallNonvirtualDoubleMethod = value
        }

    actual var CallStaticFloatMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jfloat>>?
        get() = platform.CallStaticFloatMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jfloat>>?
        set(value) {
            platform.CallStaticFloatMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jmethodID?, CPointer<jvalue>?) -> jfloat>>?
        }

    actual var CallStaticLongMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jlong>>?
        get() = platform.CallStaticLongMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jlong>>?
        set(value) {
            platform.CallStaticLongMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jmethodID?, CPointer<jvalue>?) -> jlong>>?
        }

    actual var CallBooleanMethod: COpaquePointer?
        get() = platform.CallBooleanMethod
        set(value) {
            platform.CallBooleanMethod = value
        }

    actual var GetStringUTFLength: CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?) -> jsize>>?
        get() = platform.GetStringUTFLength
        set(value) {
            platform.GetStringUTFLength = value
        }

    actual var CallVoidMethod: COpaquePointer?
        get() = platform.CallVoidMethod
        set(value) {
            platform.CallVoidMethod = value
        }

    actual var Throw: CPointer<CFunction<(CPointer<JNIEnvVar>?, jthrowable?) -> jint>>?
        get() = platform.Throw
        set(value) {
            platform.Throw = value
        }

    actual var NewByteArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jbyteArray?>>?
        get() = platform.NewByteArray
        set(value) {
            platform.NewByteArray = value
        }

    actual var CallLongMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jlong>>?
        get() = platform.CallLongMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jlong>>?
        set(value) {
            platform.CallLongMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jmethodID?, CPointer<jvalue>?) -> jlong>>?
        }

    actual var FatalError: CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<ByteVarOf<Byte>>?) -> Unit>>?
        get() = platform.FatalError
        set(value) {
            platform.FatalError = value
        }

    actual var NewCharArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jcharArray?>>?
        get() = platform.NewCharArray
        set(value) {
            platform.NewCharArray = value
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
            platform.CallNonvirtualObjectMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, platform.android.jmethodID?, CPointer<jvalue>?) -> jobject?>>?
        }

    actual var AllocObject: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?) -> jobject?>>?
        get() = platform.AllocObject
        set(value) {
            platform.AllocObject = value
        }

    actual var ExceptionOccurred: CPointer<CFunction<(CPointer<JNIEnvVar>?) -> jthrowable?>>?
        get() = platform.ExceptionOccurred
        set(value) {
            platform.ExceptionOccurred = value
        }

    actual var GetObjectField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jobject?>>?
        get() = platform.GetObjectField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jobject?>>?
        set(value) {
            platform.GetObjectField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jfieldID?) -> jobject?>>?
        }

    actual var GetStaticBooleanField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jboolean>>?
        get() = platform.GetStaticBooleanField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jboolean>>?
        set(value) {
            platform.GetStaticBooleanField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jfieldID?) -> jboolean>>?
        }

    actual var SetIntField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jint) -> Unit>>?
        get() = platform.SetIntField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jint) -> Unit>>?
        set(value) {
            platform.SetIntField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jfieldID?, jint) -> Unit>>?
        }

    actual var ReleaseIntArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jintArray?, CPointer<jintVar>?, jint) -> Unit>>?
        get() = platform.ReleaseIntArrayElements
        set(value) {
            platform.ReleaseIntArrayElements = value
        }

    actual var CallStaticFloatMethod: COpaquePointer?
        get() = platform.CallStaticFloatMethod
        set(value) {
            platform.CallStaticFloatMethod = value
        }

    actual var GetStaticDoubleField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jdouble>>?
        get() = platform.GetStaticDoubleField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jdouble>>?
        set(value) {
            platform.GetStaticDoubleField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jfieldID?) -> jdouble>>?
        }

    actual var GetStaticIntField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jint>>?
        get() = platform.GetStaticIntField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jint>>?
        set(value) {
            platform.GetStaticIntField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jfieldID?) -> jint>>?
        }

    actual var GetJavaVM: CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<CPointerVarOf<CPointer<JavaVMVar>>>?) -> jint>>?
        get() = platform.GetJavaVM
        set(value) {
            platform.GetJavaVM = value
        }

    actual var GetFieldID: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<ByteVar>?, CPointer<ByteVar>?) -> jfieldID?>>?
        get() = platform.GetFieldID as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<ByteVar>?, CPointer<ByteVar>?) -> jfieldID?>>?
        set(value) {
            platform.GetFieldID = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<ByteVar>?, CPointer<ByteVar>?) -> platform.android.jfieldID?>>?
        }

    actual var GetLongArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jlongArray?, jsize, jsize, CPointer<jlongVar>?) -> Unit>>?
        get() = platform.GetLongArrayRegion
        set(value) {
            platform.GetLongArrayRegion = value
        }

    actual var SetStaticLongField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jlong) -> Unit>>?
        get() = platform.SetStaticLongField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jlong) -> Unit>>?
        set(value) {
            platform.SetStaticLongField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jfieldID?, jlong) -> Unit>>?
        }

    actual var ExceptionDescribe: CPointer<CFunction<(CPointer<JNIEnvVar>?) -> Unit>>?
        get() = platform.ExceptionDescribe
        set(value) {
            platform.ExceptionDescribe = value
        }

    actual var CallShortMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jshort>>?
        get() = platform.CallShortMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jshort>>?
        set(value) {
            platform.CallShortMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jmethodID?, CPointer<jvalue>?) -> jshort>>?
        }

    actual var CallStaticVoidMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> Unit>>?
        get() = platform.CallStaticVoidMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> Unit>>?
        set(value) {
            platform.CallStaticVoidMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jmethodID?, CPointer<jvalue>?) -> Unit>>?
        }

    actual var ReleaseStringUTFChars: CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?, CPointer<ByteVar>?) -> Unit>>?
        get() = platform.ReleaseStringUTFChars
        set(value) {
            platform.ReleaseStringUTFChars = value
        }

    actual var CallStaticCharMethod: COpaquePointer?
        get() = platform.CallStaticCharMethod
        set(value) {
            platform.CallStaticCharMethod = value
        }

    actual var NewGlobalRef: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jobject?>>?
        get() = platform.NewGlobalRef
        set(value) {
            platform.NewGlobalRef = value
        }

    actual var SetCharArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jcharArray?, jsize, jsize, CPointer<jcharVar>?) -> Unit>>?
        get() = platform.SetCharArrayRegion
        set(value) {
            platform.SetCharArrayRegion = value
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
            platform.CallCharMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jmethodID?, CPointer<jvalue>?) -> jchar>>?
        }

    actual var GetByteField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jbyte>>?
        get() = platform.GetByteField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jbyte>>?
        set(value) {
            platform.GetByteField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jfieldID?) -> jbyte>>?
        }

    actual var FindClass: CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<ByteVar>?) -> jclass?>>?
        get() = platform.FindClass
        set(value) {
            platform.FindClass = value
        }

    actual var SetByteField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jbyte) -> Unit>>?
        get() = platform.SetByteField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jbyte) -> Unit>>?
        set(value) {
            platform.SetByteField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jfieldID?, jbyte) -> Unit>>?
        }

    actual var SetStaticShortField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jshort) -> Unit>>?
        get() = platform.SetStaticShortField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jshort) -> Unit>>?
        set(value) {
            platform.SetStaticShortField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jfieldID?, jshort) -> Unit>>?
        }

    actual var CallLongMethod: COpaquePointer?
        get() = platform.CallLongMethod
        set(value) {
            platform.CallLongMethod = value
        }

    actual var PopLocalFrame: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jobject?>>?
        get() = platform.PopLocalFrame
        set(value) {
            platform.PopLocalFrame = value
        }

    actual var SetStaticDoubleField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jdouble) -> Unit>>?
        get() = platform.SetStaticDoubleField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jdouble) -> Unit>>?
        set(value) {
            platform.SetStaticDoubleField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jfieldID?, jdouble) -> Unit>>?
        }

    actual var CallIntMethod: COpaquePointer?
        get() = platform.CallIntMethod
        set(value) {
            platform.CallIntMethod = value
        }

    actual var GetBooleanField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jboolean>>?
        get() = platform.GetBooleanField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jboolean>>?
        set(value) {
            platform.GetBooleanField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jfieldID?) -> jboolean>>?
        }

    actual var GetStaticMethodID: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<ByteVar>?, CPointer<ByteVar>?) -> jmethodID?>>?
        get() = platform.GetStaticMethodID as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<ByteVar>?, CPointer<ByteVar>?) -> jmethodID?>>?
        set(value) {
            platform.GetStaticMethodID = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<ByteVar>?, CPointer<ByteVar>?) -> platform.android.jmethodID?>>?
        }

    actual var GetObjectArrayElement: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobjectArray?, jsize) -> jobject?>>?
        get() = platform.GetObjectArrayElement
        set(value) {
            platform.GetObjectArrayElement = value
        }

    actual var CallStaticDoubleMethod: COpaquePointer?
        get() = platform.CallStaticDoubleMethod
        set(value) {
            platform.CallStaticDoubleMethod = value
        }

    actual var CallVoidMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> Unit>>?
        get() = platform.CallVoidMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> Unit>>?
        set(value) {
            platform.CallVoidMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jmethodID?, CPointer<jvalue>?) -> Unit>>?
        }

    actual var reserved1: COpaquePointer?
        get() = platform.reserved1
        set(value) {
            platform.reserved1 = value
        }

    actual var NewShortArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jshortArray?>>?
        get() = platform.NewShortArray
        set(value) {
            platform.NewShortArray = value
        }

    actual var PushLocalFrame: CPointer<CFunction<(CPointer<JNIEnvVar>?, jint) -> jint>>?
        get() = platform.PushLocalFrame
        set(value) {
            platform.PushLocalFrame
        }

    actual var ReleaseByteArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jbyteArray?, CPointer<jbyteVar>?, jint) -> Unit>>?
        get() = platform.ReleaseByteArrayElements
        set(value) {
            platform.ReleaseByteArrayElements = value
        }

    actual var CallNonvirtualFloatMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jfloat>>?
        get() = platform.CallNonvirtualFloatMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jfloat>>?
        set(value) {
            platform.CallNonvirtualFloatMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, platform.android.jmethodID?, CPointer<jvalue>?) -> jfloat>>?
        }

    actual var CallNonvirtualByteMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jbyte>>?
        get() = platform.CallNonvirtualByteMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jbyte>>?
        set(value) {
            platform.CallNonvirtualByteMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, platform.android.jmethodID?, CPointer<jvalue>?) -> jbyte>>?
        }

    actual var GetPrimitiveArrayCritical: CPointer<CFunction<(CPointer<JNIEnvVar>?, jarray?, CPointer<jbooleanVar>?) -> COpaquePointer?>>?
        get() = platform.GetPrimitiveArrayCritical
        set(value) {
            platform.GetPrimitiveArrayCritical = value
        }

    actual var DeleteWeakGlobalRef: CPointer<CFunction<(CPointer<JNIEnvVar>?, jweak?) -> Unit>>?
        get() = platform.DeleteWeakGlobalRef
        set(value) {
            platform.DeleteWeakGlobalRef = value
        }

    actual var SetCharField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jchar) -> Unit>>?
        get() = platform.SetCharField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jchar) -> Unit>>?
        set(value) {
            platform.SetCharField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jfieldID?, jchar) -> Unit>>?
        }

    actual var GetCharArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jcharArray?, CPointer<jbooleanVar>?) -> CPointer<jcharVar>?>>?
        get() = platform.GetCharArrayElements
        set(value) {
            platform.GetCharArrayElements = value
        }

    actual var GetStringLength: CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?) -> jsize>>?
        get() = platform.GetStringLength
        set(value) {
            platform.GetStringLength = value
        }

    actual var CallNonvirtualShortMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jshort>>?
        get() = platform.CallNonvirtualShortMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jshort>>?
        set(value) {
            platform.CallNonvirtualShortMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, platform.android.jmethodID?, CPointer<jvalue>?) -> jshort>>?
        }

    actual var CallStaticShortMethod: COpaquePointer?
        get() = platform.CallStaticShortMethod
        set(value) {
            platform.CallStaticShortMethod = value
        }

    actual var GetBooleanArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jbooleanArray?, CPointer<jbooleanVar>?) -> CPointer<jbooleanVar>?>>?
        get() = platform.GetBooleanArrayElements
        set(value) {
            platform.GetBooleanArrayElements = value
        }

    actual var SetObjectField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jobject?) -> Unit>>?
        get() = platform.SetObjectField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jobject?) -> Unit>>?
        set(value) {
            platform.SetObjectField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jfieldID?, jobject?) -> Unit>>?
        }

    actual var GetSuperclass: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?) -> jclass?>>?
        get() = platform.GetSuperclass
        set(value) {
            platform.GetSuperclass = value
        }

    actual var GetStringUTFRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?, jsize, jsize, CPointer<ByteVar>?) -> Unit>>?
        get() = platform.GetStringUTFRegion
        set(value) {
            platform.GetStringUTFRegion = value
        }

    actual var SetLongArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jlongArray?, jsize, jsize, CPointer<jlongVar>?) -> Unit>>?
        get() = platform.SetLongArrayRegion
        set(value) {
            platform.SetLongArrayRegion = value
        }

    actual var RegisterNatives: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<JNINativeMethod>?, jint) -> jint>>?
        get() = platform.RegisterNatives
        set(value) {
            platform.RegisterNatives = value
        }

    actual var SetIntArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jintArray?, jsize, jsize, CPointer<jintVar>?) -> Unit>>?
        get() = platform.SetIntArrayRegion
        set(value) {
            platform.SetIntArrayRegion = value
        }

    actual var SetFloatField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jfloat) -> Unit>>?
        get() = platform.SetFloatField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jfloat) -> Unit>>?
        set(value) {
            platform.SetFloatField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jfieldID?, jfloat) -> Unit>>?
        }

    actual var NewBooleanArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jbooleanArray?>>?
        get() = platform.NewBooleanArray
        set(value) {
            platform.NewBooleanArray = value
        }

    actual var GetDoubleArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jdoubleArray?, CPointer<jbooleanVar>?) -> CPointer<jdoubleVar>?>>?
        get() = platform.GetDoubleArrayElements
        set(value) {
            platform.GetDoubleArrayElements = value
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
            platform.CallFloatMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jmethodID?, CPointer<jvalue>?) -> jfloat>>?
        }

    actual var SetByteArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jbyteArray?, jsize, jsize, CPointer<jbyteVar>?) -> Unit>>?
        get() = platform.SetByteArrayRegion
        set(value) {
            platform.SetByteArrayRegion = value
        }

    actual var GetStaticShortField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jshort>>?
        get() = platform.GetStaticShortField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jshort>>?
        set(value) {
            platform.GetStaticShortField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jfieldID?) -> jshort>>?
        }

    actual var CallStaticShortMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jshort>>?
        get() = platform.CallStaticShortMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jshort>>?
        set(value) {
            platform.CallStaticShortMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jmethodID?, CPointer<jvalue>?) -> jshort>>?
        }

    actual var ReleaseBooleanArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jbooleanArray?, CPointer<jbooleanVar>?, jint) -> Unit>>?
        get() = platform.ReleaseBooleanArrayElements
        set(value) {
            platform.ReleaseBooleanArrayElements = value
        }

    actual var GetStaticObjectField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jobject?>>?
        get() = platform.GetStaticObjectField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jobject?>>?
        set(value) {
            platform.GetStaticObjectField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jfieldID?) -> jobject?>>?
        }

    actual var MonitorEnter: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jint>>?
        get() = platform.MonitorEnter
        set(value) {
            platform.MonitorExit = value
        }

    actual var CallNonvirtualLongMethod: COpaquePointer?
        get() = platform.CallNonvirtualLongMethod
        set(value) {
            platform.CallNonvirtualLongMethod = value
        }

    actual var SetLongField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jlong) -> Unit>>?
        get() = platform.SetLongField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jlong) -> Unit>>?
        set(value) {
            platform.SetLongField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jfieldID?, jlong) -> Unit>>?
        }

    actual var ReleaseStringCritical: CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?, CPointer<jcharVar>?) -> Unit>>?
        get() = platform.ReleaseStringCritical
        set(value) {
            platform.ReleaseStringCritical = value
        }

    actual var GetFloatField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jfloat>>?
        get() = platform.GetFloatField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jfloat>>?
        set(value) {
            platform.GetFloatField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jfieldID?) -> jfloat>>?
        }

    actual var CallByteMethod: COpaquePointer?
        get() = platform.CallByteMethod
        set(value) {
            platform.CallByteMethod = value
        }

    actual var ReleasePrimitiveArrayCritical: CPointer<CFunction<(CPointer<JNIEnvVar>?, jarray?, COpaquePointer?, jint) -> Unit>>?
        get() = platform.ReleasePrimitiveArrayCritical
        set(value) {
            platform.ReleasePrimitiveArrayCritical = value
        }

    actual var GetIntField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jint>>?
        get() = platform.GetIntField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jint>>?
        set(value) {
            platform.GetIntField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jfieldID?) -> jint>>?
        }

    actual var GetObjectRefType: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jobjectRefType>>?
        get() = platform.GetObjectRefType
        set(value) {
            platform.GetObjectRefType = value
        }

    actual var GetFloatArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jfloatArray?, jsize, jsize, CPointer<jfloatVar>?) -> Unit>>?
        get() = platform.GetFloatArrayRegion
        set(value) {
            platform.GetFloatArrayRegion = value
        }

    actual var GetDoubleArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jdoubleArray?, jsize, jsize, CPointer<jdoubleVar>?) -> Unit>>?
        get() = platform.GetDoubleArrayRegion
        set(value) {
            platform.GetDoubleArrayRegion = value
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
            platform.SetDoubleField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jfieldID?, jdouble) -> Unit>>?
        }

    actual var CallBooleanMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jboolean>>?
        get() = platform.CallBooleanMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jboolean>>?
        set(value) {
            platform.CallBooleanMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jmethodID?, CPointer<jvalue>?) -> jboolean>>?
        }

    actual var GetShortArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jshortArray?, CPointer<jbooleanVar>?) -> CPointer<jshortVar>?>>?
        get() = platform.GetShortArrayElements
        set(value) {
            platform.GetShortArrayElements = value
        }

    actual var CallNonvirtualDoubleMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jdouble>>?
        get() = platform.CallNonvirtualDoubleMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jdouble>>?
        set(value) {
            platform.CallNonvirtualDoubleMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, platform.android.jmethodID?, CPointer<jvalue>?) -> jdouble>>?
        }

    actual var FromReflectedMethod: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jmethodID?>>?
        get() = platform.FromReflectedMethod as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jmethodID?>>?
        set(value) {
            platform.FromReflectedMethod = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> platform.android.jmethodID?>>?
        }

    actual var CallNonvirtualIntMethod: COpaquePointer?
        get() = platform.CallNonvirtualIntMethod
        set(value) {
            platform.CallNonvirtualIntMethod = value
        }

    actual var DeleteLocalRef: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> Unit>>?
        get() = platform.DeleteLocalRef
        set(value) {
            platform.DeleteLocalRef = value
        }

    actual var CallNonvirtualVoidMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> Unit>>?
        get() = platform.CallNonvirtualVoidMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> Unit>>?
        set(value) {
            platform.CallNonvirtualVoidMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, platform.android.jmethodID?, CPointer<jvalue>?) -> Unit>>?
        }

    actual var ReleaseShortArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jshortArray?, CPointer<jshortVar>?, jint) -> Unit>>?
        get() = platform.ReleaseShortArrayElements
        set(value) {
            platform.ReleaseShortArrayElements = value
        }

    actual var ToReflectedMethod: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, jboolean) -> jobject?>>?
        get() = platform.ToReflectedMethod as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, jboolean) -> jobject?>>?
        set(value) {
            platform.ToReflectedMethod = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jmethodID?, jboolean) -> jobject?>>?
        }

    actual var GetDirectBufferCapacity: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jlong>>?
        get() = platform.GetDirectBufferCapacity
        set(value) {
            platform.GetDirectBufferCapacity = value
        }

    actual var CallNonvirtualByteMethod: COpaquePointer?
        get() = platform.CallNonvirtualByteMethod
        set(value) {
            platform.CallNonvirtualByteMethod = value
        }

    actual var CallNonvirtualCharMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jchar>>?
        get() = platform.CallNonvirtualCharMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jchar>>?
        set(value) {
            platform.CallNonvirtualCharMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, platform.android.jmethodID?, CPointer<jvalue>?) -> jchar>>?
        }

    actual var GetStaticCharField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jchar>>?
        get() = platform.GetStaticCharField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jchar>>?
        set(value) {
            platform.GetStaticCharField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jfieldID?) -> jchar>>?
        }

    actual var NewDirectByteBuffer: CPointer<CFunction<(CPointer<JNIEnvVar>?, COpaquePointer?, jlong) -> jobject?>>?
        get() = platform.NewDirectByteBuffer
        set(value) {
            platform.NewDirectByteBuffer = value
        }

    actual var UnregisterNatives: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?) -> jint>>?
        get() = platform.UnregisterNatives
        set(value) {
            platform.UnregisterNatives = value
        }

    actual var GetDirectBufferAddress: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> COpaquePointer?>>?
        get() = platform.GetDirectBufferAddress
        set(value) {
            platform.GetDirectBufferAddress = value
        }

    actual var GetShortField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jshort>>?
        get() = platform.GetShortField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jshort>>?
        set(value) {
            platform.GetShortField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jfieldID?) -> jshort>>?
        }

    actual var NewFloatArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jfloatArray?>>?
        get() = platform.NewFloatArray
        set(value) {
            platform.NewFloatArray = value
        }

    actual var FromReflectedField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jfieldID?>>?
        get() = platform.FromReflectedField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jfieldID?>>?
        set(value) {
            platform.FromReflectedField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> platform.android.jfieldID?>>?
        }

    actual var GetStaticByteField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jbyte>>?
        get() = platform.GetStaticByteField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jbyte>>?
        set(value) {
            platform.GetStaticByteField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jfieldID?) -> jbyte>>?
        }

    actual var GetStaticLongField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jlong>>?
        get() = platform.GetStaticLongField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jlong>>?
        set(value) {
            platform.GetStaticLongField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jfieldID?) -> jlong>>?
        }

    actual var SetFloatArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jfloatArray?, jsize, jsize, CPointer<jfloatVar>?) -> Unit>>?
        get() = platform.SetFloatArrayRegion
        set(value) {
            platform.SetFloatArrayRegion = value
        }

    actual var CallNonvirtualIntMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jint>>?
        get() = platform.CallNonvirtualIntMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jint>>?
        set(value) {
            platform.CallNonvirtualIntMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, platform.android.jmethodID?, CPointer<jvalue>?) -> jint>>?
        }

    actual var GetStringUTFChars: CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?, CPointer<jbooleanVar>?) -> CPointer<ByteVar>?>>?
        get() = platform.GetStringUTFChars
        set(value) {
            platform.GetStringUTFChars = value
        }

    actual var ReleaseFloatArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jfloatArray?, CPointer<jfloatVar>?, jint) -> Unit>>?
        get() = platform.ReleaseFloatArrayElements
        set(value) {
            platform.ReleaseFloatArrayElements = value
        }

    actual var IsAssignableFrom: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jclass?) -> jboolean>>?
        get() = platform.IsAssignableFrom
        set(value) {
            platform.IsAssignableFrom = value
        }

    actual var SetShortField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jshort) -> Unit>>?
        get() = platform.SetShortField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jshort) -> Unit>>?
        set(value) {
            platform.SetShortField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jfieldID?, jshort) -> Unit>>?
        }

    actual var CallByteMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jbyte>>?
        get() = platform.CallByteMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jbyte>>?
        set(value) {
            platform.CallByteMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jmethodID?, CPointer<jvalue>?) -> jbyte>>?
        }

    actual var ReleaseCharArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jcharArray?, CPointer<jcharVar>?, jint) -> Unit>>?
        get() = platform.ReleaseCharArrayElements
        set(value) {
            platform.ReleaseCharArrayElements = value
        }

    actual var NewObjectArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize, jclass?, jobject?) -> jobjectArray?>>?
        get() = platform.NewObjectArray
        set(value) {
            platform.NewObjectArray = value
        }

    actual var CallStaticIntMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jint>>?
        get() = platform.CallStaticIntMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jint>>?
        set(value) {
            platform.CallStaticIntMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jmethodID?, CPointer<jvalue>?) -> jint>>?
        }

    actual var GetObjectClass: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jclass?>>?
        get() = platform.GetObjectClass
        set(value) {
            platform.GetObjectClass = value
        }

    actual var GetStringCritical: CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?, CPointer<jbooleanVar>?) -> CPointer<jcharVar>?>>?
        get() = platform.GetStringCritical
        set(value) {
            platform.GetStringCritical = value
        }

    actual var CallStaticByteMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jbyte>>?
        get() = platform.CallStaticByteMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jbyte>>?
        set(value) {
            platform.CallStaticByteMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jmethodID?, CPointer<jvalue>?) -> jbyte>>?
        }

    actual var ReleaseDoubleArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jdoubleArray?, CPointer<jdoubleVar>?, jint) -> Unit>>?
        get() = platform.ReleaseDoubleArrayElements
        set(value) {
            platform.ReleaseDoubleArrayElements = value
        }

    actual var GetStaticFieldID: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<ByteVar>?, CPointer<ByteVar>?) -> jfieldID?>>?
        get() = platform.GetStaticFieldID as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<ByteVar>?, CPointer<ByteVar>?) -> jfieldID?>>?
        set(value) {
            platform.GetStaticFieldID = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<ByteVar>?, CPointer<ByteVar>?) -> platform.android.jfieldID?>>?
        }

    actual var SetBooleanArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jbooleanArray?, jsize, jsize, CPointer<jbooleanVar>?) -> Unit>>?
        get() = platform.SetBooleanArrayRegion
        set(value) {
            platform.SetBooleanArrayRegion = value
        }

    actual var reserved2: COpaquePointer?
        get() = platform.reserved2
        set(value) {
            platform.reserved2 = value
        }

    actual var NewStringUTF: CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<ByteVar>?) -> jstring?>>?
        get() = platform.NewStringUTF
        set(value) {
            platform.NewStringUTF = value
        }

    actual var SetObjectArrayElement: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobjectArray?, jsize, jobject?) -> Unit>>?
        get() = platform.SetObjectArrayElement
        set(value) {
            platform.SetObjectArrayElement = value
        }

    actual var CallNonvirtualShortMethod: COpaquePointer?
        get() = platform.CallNonvirtualShortMethod
        set(value) {
            platform.CallNonvirtualShortMethod = value
        }

    actual var GetCharArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jcharArray?, jsize, jsize, CPointer<jcharVar>?) -> Unit>>?
        get() = platform.GetCharArrayRegion
        set(value) {
            platform.GetCharArrayRegion = value
        }

    actual var GetFloatArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jfloatArray?, CPointer<jbooleanVar>?) -> CPointer<jfloatVar>?>>?
        get() = platform.GetFloatArrayElements
        set(value) {
            platform.GetFloatArrayElements = value
        }

    actual var CallObjectMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jobject?>>?
        get() = platform.CallObjectMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jobject?>>?
        set(value) {
            platform.CallObjectMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jmethodID?, CPointer<jvalue>?) -> jobject?>>?
        }

    actual var NewWeakGlobalRef: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jweak?>>?
        get() = platform.NewWeakGlobalRef
        set(value) {
            platform.NewWeakGlobalRef = value
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
        get() = platform.NewDoubleArray
        set(value) {
            platform.NewDoubleArray = value
        }

    actual var CallNonvirtualBooleanMethod: COpaquePointer?
        get() = platform.CallNonvirtualBooleanMethod
        set(value) {
            platform.CallNonvirtualBooleanMethod = value
        }

    actual var SetStaticIntField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jint) -> Unit>>?
        get() = platform.SetStaticIntField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jint) -> Unit>>?
        set(value) {
            platform.SetStaticIntField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jfieldID?, jint) -> Unit>>?
        }

    actual var ToReflectedField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jboolean) -> jobject?>>?
        get() = platform.ToReflectedField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jboolean) -> jobject?>>?
        set(value) {
            platform.ToReflectedField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jfieldID?, jboolean) -> jobject?>>?
        }

    actual var GetStringRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?, jsize, jsize, CPointer<jcharVar>?) -> Unit>>?
        get() = platform.GetStringRegion
        set(value) {
            platform.GetStringRegion = value
        }

    actual var GetShortArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jshortArray?, jsize, jsize, CPointer<jshortVar>?) -> Unit>>?
        get() = platform.GetShortArrayRegion
        set(value) {
            platform.GetShortArrayRegion = value
        }

    actual var MonitorExit: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jint>>?
        get() = platform.MonitorExit
        set(value) {
            platform.MonitorExit = value
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
            platform.CallNonvirtualLongMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, platform.android.jmethodID?, CPointer<jvalue>?) -> jlong>>?
        }

    actual var GetMethodID: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<ByteVar>?, CPointer<ByteVar>?) -> jmethodID?>>?
        get() = platform.GetMethodID as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<ByteVar>?, CPointer<ByteVar>?) -> jmethodID?>>?
        set(value) {
            platform.GetMethodID = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<ByteVar>?, CPointer<ByteVar>?) -> platform.android.jmethodID?>>?
        }

    actual var CallIntMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jint>>?
        get() = platform.CallIntMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jint>>?
        set(value) {
            platform.CallIntMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jmethodID?, CPointer<jvalue>?) -> jint>>?
        }

    actual var DefineClass: CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<ByteVar>?, jobject?, CPointer<jbyteVar>?, jsize) -> jclass?>>?
        get() = platform.DefineClass
        set(value) {
            platform.DefineClass = value
        }

    actual var GetStringChars: CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?, CPointer<jbooleanVar>?) -> CPointer<jcharVar>?>>?
        get() = platform.GetStringChars
        set(value) {
            platform.GetStringChars = value
        }

    actual var GetIntArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jintArray?, jsize, jsize, CPointer<jintVar>?) -> Unit>>?
        get() = platform.GetIntArrayRegion
        set(value) {
            platform.GetIntArrayRegion = value
        }

    actual var CallDoubleMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jdouble>>?
        get() = platform.CallDoubleMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jmethodID?, CPointer<jvalue>?) -> jdouble>>?
        set(value) {
            platform.CallDoubleMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jmethodID?, CPointer<jvalue>?) -> jdouble>>?
        }

    actual var CallStaticObjectMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jobject?>>?
        get() = platform.CallStaticObjectMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jobject?>>?
        set(value) {
            platform.CallStaticObjectMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jmethodID?, CPointer<jvalue>?) -> jobject?>>?
        }

    actual var ReleaseStringChars: CPointer<CFunction<(CPointer<JNIEnvVar>?, jstring?, CPointer<jcharVar>?) -> Unit>>?
        get() = platform.ReleaseStringChars
        set(value) {
            platform.ReleaseStringChars = value
        }

    actual var GetStaticFloatField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jfloat>>?
        get() = platform.GetStaticFloatField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?) -> jfloat>>?
        set(value) {
            platform.GetStaticFloatField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jfieldID?) -> jfloat>>?
        }

    actual var GetIntArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jintArray?, CPointer<jbooleanVar>?) -> CPointer<jintVar>?>>?
        get() = platform.GetIntArrayElements
        set(value) {
            platform.GetIntArrayElements = value
        }

    actual var CallStaticBooleanMethod: COpaquePointer?
        get() = platform.CallStaticBooleanMethod
        set(value) {
            platform.CallStaticBooleanMethod = value
        }

    actual var GetBooleanArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jbooleanArray?, jsize, jsize, CPointer<jbooleanVar>?) -> Unit>>?
        get() = platform.GetBooleanArrayRegion
        set(value) {
            platform.GetBooleanArrayRegion = value
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
            platform.NewObjectA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jmethodID?, CPointer<jvalue>?) -> jobject?>>?
        }

    actual var SetStaticCharField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jchar) -> Unit>>?
        get() = platform.SetStaticCharField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jchar) -> Unit>>?
        set(value) {
            platform.SetStaticCharField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jfieldID?, jchar) -> Unit>>?
        }

    actual var IsSameObject: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jobject?) -> jboolean>>?
        get() = platform.IsSameObject
        set(value) {
            platform.IsSameObject = value
        }

    actual var reserved3: COpaquePointer?
        get() = platform.reserved3
        set(value) {
            platform.reserved3 = value
        }

    actual var SetStaticBooleanField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jboolean) -> Unit>>?
        get() = platform.SetStaticBooleanField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jboolean) -> Unit>>?
        set(value) {
            platform.SetStaticBooleanField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jfieldID?, jboolean) -> Unit>>?
        }

    actual var SetStaticObjectField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jobject?) -> Unit>>?
        get() = platform.SetStaticObjectField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jobject?) -> Unit>>?
        set(value) {
            platform.SetStaticObjectField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jfieldID?, jobject?) -> Unit>>?
        }

    actual var CallStaticBooleanMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jboolean>>?
        get() = platform.CallStaticBooleanMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jboolean>>?
        set(value) {
            platform.CallStaticBooleanMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jmethodID?, CPointer<jvalue>?) -> jboolean>>?
        }

    actual var SetStaticFloatField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jfloat) -> Unit>>?
        get() = platform.SetStaticFloatField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jfieldID?, jfloat) -> Unit>>?
        set(value) {
            platform.SetStaticFloatField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jfieldID?, jfloat) -> Unit>>?
        }

    actual var CallStaticVoidMethod: COpaquePointer?
        get() = platform.CallStaticVoidMethod
        set(value) {
            platform.CallStaticVoidMethod = value
        }

    actual var CallStaticCharMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jchar>>?
        get() = platform.CallStaticCharMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jchar>>?
        set(value) {
            platform.CallStaticCharMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jmethodID?, CPointer<jvalue>?) -> jchar>>?
        }

    actual var DeleteGlobalRef: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> Unit>>?
        get() = platform.DeleteGlobalRef
        set(value) {
            platform.DeleteGlobalRef = value
        }

    actual var IsInstanceOf: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?) -> jboolean>>?
        get() = platform.IsInstanceOf
        set(value) {
            platform.IsInstanceOf = value
        }

    actual var NewLocalRef: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?) -> jobject?>>?
        get() = platform.NewLocalRef
        set(value) {
            platform.NewLocalRef = value
        }

    actual var CallStaticDoubleMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jdouble>>?
        get() = platform.CallStaticDoubleMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, jmethodID?, CPointer<jvalue>?) -> jdouble>>?
        set(value) {
            platform.CallStaticDoubleMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, platform.android.jmethodID?, CPointer<jvalue>?) -> jdouble>>?
        }

    actual var GetArrayLength: CPointer<CFunction<(CPointer<JNIEnvVar>?, jarray?) -> jsize>>?
        get() = platform.GetArrayLength
        set(value) {
            platform.GetArrayLength = value
        }

    actual var GetLongArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jlongArray?, CPointer<jbooleanVar>?) -> CPointer<jlongVar>?>>?
        get() = platform.GetLongArrayElements
        set(value) {
            platform.GetLongArrayElements = value
        }

    actual var ThrowNew: CPointer<CFunction<(CPointer<JNIEnvVar>?, jclass?, CPointer<ByteVar>?) -> jint>>?
        get() = platform.ThrowNew
        set(value) {
            platform.ThrowNew = value
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
        get() = platform.SetShortArrayRegion
        set(value) {
            platform.SetShortArrayRegion = value
        }

    actual var NewIntArray: CPointer<CFunction<(CPointer<JNIEnvVar>?, jsize) -> jintArray?>>?
        get() = platform.NewIntArray
        set(value) {
            platform.NewIntArray = value
        }

    actual var GetCharField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jchar>>?
        get() = platform.GetCharField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jchar>>?
        set(value) {
            platform.GetCharField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jfieldID?) -> jchar>>?
        }

    actual var reserved0: COpaquePointer?
        get() = platform.reserved0
        set(value) {
            platform.reserved0 = value
        }

    actual var GetLongField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jlong>>?
        get() = platform.GetLongField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jlong>>?
        set(value) {
            platform.GetLongField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jfieldID?) -> jlong>>?
        }

    actual var SetBooleanField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jboolean) -> Unit>>?
        get() = platform.SetBooleanField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?, jboolean) -> Unit>>?
        set(value) {
            platform.SetBooleanField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jfieldID?, jboolean) -> Unit>>?
        }

    actual var SetDoubleArrayRegion: CPointer<CFunction<(CPointer<JNIEnvVar>?, jdoubleArray?, jsize, jsize, CPointer<jdoubleVar>?) -> Unit>>?
        get() = platform.SetDoubleArrayRegion
        set(value) {
            platform.SetDoubleArrayRegion = value
        }

    actual var GetDoubleField: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jdouble>>?
        get() = platform.GetDoubleField as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jfieldID?) -> jdouble>>?
        set(value) {
            platform.GetDoubleField = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, platform.android.jfieldID?) -> jdouble>>?
        }

    actual var ReleaseLongArrayElements: CPointer<CFunction<(CPointer<JNIEnvVar>?, jlongArray?, CPointer<jlongVar>?, jint) -> Unit>>?
        get() = platform.ReleaseLongArrayElements
        set(value) {
            platform.ReleaseLongArrayElements = value
        }

    actual var CallNonvirtualBooleanMethodA: CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jboolean>>?
        get() = platform.CallNonvirtualBooleanMethodA as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, jmethodID?, CPointer<jvalue>?) -> jboolean>>?
        set(value) {
            platform.CallNonvirtualBooleanMethodA = value as CPointer<CFunction<(CPointer<JNIEnvVar>?, jobject?, jclass?, platform.android.jmethodID?, CPointer<jvalue>?) -> jboolean>>?
        }

    actual var NewString: CPointer<CFunction<(CPointer<JNIEnvVar>?, CPointer<jcharVar>?, jsize) -> jstring?>>?
        get() = platform.NewString
        set(value) {
            platform.NewString = value
        }

    actual companion object {
        actual operator fun invoke(platform: JNINativeInterface) = CommonJNINativeInterface(platform)
    }
}