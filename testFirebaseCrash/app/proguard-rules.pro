## Add project specific ProGuard rules here.
## By default, the flags in this file are appended to flags specified
## in C:\Users\susyimes\AppData\Local\Android\Sdk/tools/proguard/proguard-android.txt
## You can edit the include path and order by changing the proguardFiles
## directive in build.gradle.
##
## For pgc_more details, see
##   http://developer.android.com/guide/developing/tools/proguard.html
#
## Add any project specific keep options here:
#
## If your project uses WebView with JS, uncomment the following
## and specify the fully qualified class name to the JavaScript interface
## class:
##-keepclassmembers class fqcn.of.javascript.interface.for.webview {
##   public *;
##}
##############################################
##
## 对于一些基本指令的添加
##
##############################################
#-optimizationpasses 7
#-dontusemixedcaseclassnames
#-dontskipnonpubliclibraryclasses
#-verbose
#-dontskipnonpubliclibraryclassmembers
#-dontpreverify
#-keepattributes *Annotation*,InnerClasses
#-keepattributes Signature
#-keepattributes SourceFile,LineNumberTable
#-optimizations !code/simplification/cast,!field/*,!class/merging/*
#
#
##############################################
##
## Android开发中一些需要保留的公共部分
##
##############################################
#-keep public class * extends android.app.Activity
#-keep public class * extends android.app.Fragment
#-keep public class * extends android.app.Service
#-keep public class * extends android.content.BroadcastReceiver
#-keep public class * extends android.content.ContentProvider
#-keep public class * extends android.app.backup.BackupAgentHelper
#-keep public class * extends android.preference.Preference
#-keep public class * extends android.view.View
#-keep class **.R$* {*;}
##
#-keep public interface **{*;}
#-keep public class Object {*;}
#-keepclasseswithmembernames class * {
#    native <methods>;
#}
#-keepclassmembers class * extends android.app.Activity{
#    public void *(android.view.View);
#}
#-keepclassmembers enum * {
#    public static **[] values();
#    public static ** valueOf(java.lang.String);
#}
#-keep public class * extends android.view.View{
#    *** get*();
#    void set*(***);
#    public <init>(android.content.Context);
#    public <init>(android.content.Context, android.util.AttributeSet);
#    public <init>(android.content.Context, android.util.AttributeSet, int);
#}
#-keep class * implements android.os.Parcelable {
#  public static final android.os.Parcelable$Creator *;
#}
#-keepclassmembers class * implements java.io.Serializable {
#    static final long serialVersionUID;
#    private static final java.io.ObjectStreamField[] serialPersistentFields;
#    private void writeObject(java.io.ObjectOutputStream);
#    private void readObject(java.io.ObjectInputStream);
#    java.lang.Object writeReplace();
#    java.lang.Object readResolve();
#}
#-keepclassmembers class * {
#    void *(**On*Event);
#}
#
##support libary
## The support library contains references to newer platform versions.
## Don't warn about those in case this app is linking against an older
## platform version.  We know about them, and they are safe.
#-dontwarn android.support.**
#
## Understand the @Keep support annotation.
#-keep class android.support.annotation.Keep
#
#-keep @android.support.annotation.Keep class * {*;}
#
#-keepclasseswithmembers class * {
#    @android.support.annotation.Keep <methods>;
#}
#
#-keepclasseswithmembers class * {
#    @android.support.annotation.Keep <fields>;
#}
#
#-keepclasseswithmembers class * {
#    @android.support.annotation.Keep <init>(...);
#}
#
#
#-dontwarn com.google.android.gms.**
#-keep class com.google.android.gms.** { *; }
#-keep class com.google.firebase.** { *; }
#
#
##webView处理，项目中没有使用到webView忽略即可
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
#-keepclassmembers class * extends android.webkit.webViewClient {
#    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
#    public boolean *(android.webkit.WebView, java.lang.String);
#}
#-keepclassmembers class * extends android.webkit.webViewClient {
#    public void *(android.webkit.webView, jav.lang.String);
#}
#
##############################################
##
## 项目中特殊处理部分
##
##############################################
#
##-----------处理反射类---------------
#
#
#
##-----------处理js交互---------------
#
#
#
##-----------处理实体类---------------
#
#
#
##-----------处理第三方依赖库---------
##google gcm混淆
#-dontwarn com.google.android.gms.**
#-keep class com.google.android.gms.** { *; }
#-keep class com.google.firebase.** { *; }
#
#
#
####greendao
#-keepclassmembers class * extends org.greenrobot.greendao.AbstractDao {
#public static java.lang.String TABLENAME;
#}
#-keep class **$Properties
#
## If you do not use SQLCipher:
#-dontwarn org.greenrobot.greendao.database.**
## If you do not use Rx:
#-dontwarn rx.**
#
####ButterKnife
#-keep class butterknife.** { *; }
#-dontwarn butterknife.internal.**
#-keep class **$$ViewBinder { *; }
#
#-keepclasseswithmembernames class * {
#    @butterknife.* <fields>;
#}
#
#-keepclasseswithmembernames class * {
#    @butterknife.* <methods>;
#}
#
#### Retrofit 2.X
### https://square.github.io/retrofit/ ##
#
#-dontwarn retrofit2.**
#-keep class retrofit2.** { *; }
#-keepattributes Signature
#-keepattributes Exceptions
#-dontwarn com.squareup.okhttp.**
#-keep class com.squareup.okhttp.** { *; }
#-keep interface com.squareup.okhttp.** { *; }
#
#-keepclasseswithmembers class * {
#    @retrofit2.http.* <methods>;
#}
#
####picasso OKHTTP
#
## Platform calls Class.forName on types which do not exist on Android to determine platform.
#-dontnote okhttp3.internal.Platform
#
#
#### OKIO
#
## java.nio.file.* usage which cannot be used at runtime. Animal sniffer annotation.
#-dontwarn okio.Okio
## JDK 7-only method which is @hide on Android. Animal sniffer annotation.
#-dontwarn okio.DeflaterSink
#
#### Facebook
#-keep class com.facebook.FacebookSdk {
#   boolean isInitialized();
#}
#-keep class com.facebook.appevents.AppEventsLogger {
#   com.facebook.appevents.AppEventsLogger newLogger(android.content.Context);
#   void logSdkEvent(java.lang.String, java.lang.Double, android.os.Bundle);
#}
#
####Jsoup
#-keep public class org.jsoup.** {
#public *;
#}
#
##-keep class **{*;}
#-keepclassmembers class * extends android.support.v4.app.FragmentActivity{
#    public void *(android.view.View);
#}
#-keepclassmembers class * extends  android.app.Application{
#    public void *(android.view.View);
#}
##-keep public class **{*;}
#-keep public class com.box.lib_keeplive.**{*;}
#-keep public class com.box.lib_apidata.**{*;}
#-keep public class com.box.lib_award.view.**{*;}
#-keep class assets.** {*; }
#
####Glide
#-keep public class * implements com.bumptech.glide.module.GlideModule
#-keep public class * extends com.bumptech.glide.AppGlideModule
#-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
#  **[] $VALUES;
#  public *;
#}
#-dontwarn com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool
#-dontwarn com.bumptech.glide.load.resource.bitmap.Downsampler
#-dontwarn com.bumptech.glide.load.resource.bitmap.HardwareConfigState
##Glide如果API级别<=Android API 27 则需要添加
#-dontwarn com.bumptech.glide.load.resource.bitmap.VideoDecoder
## for DexGuard only
##-keepresourcexmlelements manifest/application/meta-data@value=GlideModule
#
##dgsdk
#-keep class com.minhthqyx.r.** { *;}
#-keep class com.abus.** { *;}
#-keep class com.pad.** { *;}
#-keep class com.qaz.** { *;}
##obsdk
#-keep class com.vys.** { *;}
#-keep class com.inter.** { *;}
#-keep class com.nt.** { *;}
#
#-dontwarn com.vys.**
#-dontwarn com.inter.**
#-dontwarn com.bl.**
#
##android-gif-drawable
#-keep public class pl.droidsonroids.gif.GifIOException{<init>(int, java.lang.String);}
#
#-keep public class com.liulishuo.filedownloader.**{*;}
#
##Kochava: Ignore SDK warnings for missing dependencies. Typically only this line is required. Some non standard ProGuard configurations may require the second line.
#-dontwarn com.kochava.**
#
##Kochava: Do not run ProGuard on the SDK at all.
#-keep class com.kochava.** { *; }
#
#-keep class com.dianxinos.DXStatService.stat.TokenManager {
#public static java.lang.String getToken(android.content.Context);
#}
#-keep public class * extends android.content.BroadcastReceiver
#-keep public class * extends android.content.ContentProvider
#
#-dontwarn com.duapps.ad.**
#
##fastJson
#-dontwarn com.alibaba.fastjson.**
#-keep class com.alibaba.fastjson.** { *; }
#
##dg
#-keep class com.minhthqyx.r..** { *;}
#
##ob
#-keep class com.qcl.** { *;}
#-keep class com.inter.** { *;}
#-keep class com.pl.** { *;}
#
#-dontwarn com.qcl.**
#-dontwarn com.inter.**
#-dontwarn com.pl.**
#
#####baidu ad
#-dontwarn com.duapps.ad.**
#-keep class com.duapps.ad.**{*;}
#-keep class com.dianxinos.DXStatService.stat.TokenManager {
#public static java.lang.String getToken(android.content.Context);
#}
#-keep public class * extends android.content.BroadcastReceiver
#-keep public class * extends android.content.ContentProvider
#-keepnames @com.google.android.gms.common.annotation.KeepName class *
#-keepclassmembernames class * {
#@com.google.android.gms.common.annotation.KeepName *;}
#-keep class com.google.android.gms.common.GooglePlayServicesUtil {
#public <methods>;}
#-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient {
#public <methods>;}
#-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient$Info {
#public <methods>;}
#
#
#-keepclasseswithmembernames class ** {
#    native <methods>;
#}
#-keepattributes Signature
#-keep class sun.misc.Unsafe { *; }
#-keep class com.taobao.** {*;}
#-keep class com.alibaba.** {*;}
#-keep class com.alipay.** {*;}
#-keep class com.ut.** {*;}
#-keep class com.ta.** {*;}
#-keep class anet.**{*;}
#-keep class anetwork.**{*;}
#-keep class org.android.spdy.**{*;}
#-keep class org.android.agoo.**{*;}
#-keep class android.os.**{*;}
#-dontwarn com.taobao.**
#-dontwarn com.alibaba.**
#-dontwarn com.alipay.**
#-dontwarn anet.**
#-dontwarn org.android.spdy.**
#-dontwarn org.android.agoo.**
#-dontwarn anetwork.**
#-dontwarn com.ut.**
#-dontwarn com.ta.**
#
##millionaire
#-keep public class com.millionaire.bean.**{*;}
#-keep public class com.millionaire.api.**{*;}
#-keep public class com.millionaire.http.**{*;}
#
##arouter
#-keep public class com.alibaba.android.arouter.routes.**{*;}
#-keep class * implements com.alibaba.android.arouter.facade.template.ISyringe{*;}
#
## 如果使用了 byType 的方式获取 Service，需添加下面规则，保护接口
#-keep interface * implements com.alibaba.android.arouter.facade.template.IProvider
#
## 如果使用了 单类注入，即不定义接口实现 IProvider，需添加下面规则，保护实现
#-keep class * implements com.alibaba.android.arouter.facade.template.IProvider
#
## batmobi
#-keep class com.etap.**{*;}
##ijkplayer
#-keep class tv.danmaku.ijk.media.player.** {*;}
#-keep class tv.danmaku.ijk.media.player.IjkMediaPlayer{*;}
#-keep class tv.danmaku.ijk.media.player.ffmpeg.FFmpegApi{*;}
#-ignorewarnings
#
#-keep class com.umeng.** {*;}
#-keepclassmembers class * {
#   public <init> (org.json.JSONObject);
#}
#-keepclassmembers enum * {
#    public static **[] values();
#    public static ** valueOf(java.lang.String);
#}
#-keep class com.uc.** {*;}
#-keep class com.zui.** {*;}
#-keep class com.miui.** {*;}
#-keep class com.heytap.** {*;}
#-keep class a.** {*;}
#-keep class com.vivo.** {*;}
#
##InMobi
#-keepattributes SourceFile,LineNumberTable
#
#-keep class com.inmobi.** { *; }
#
#-keep public class com.google.android.gms.**
#-dontwarn com.google.android.gms.**
#-dontwarn com.squareup.picasso.**
#
#-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient{
#     public *;
#}
#-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient$Info{
#     public *;
#}
#
## skip the Picasso library classes
#-keep class com.squareup.picasso.** {*;}
#-dontwarn com.squareup.okhttp.**
#
## skip Moat classes
#-keep class com.moat.** {*;}
#-dontwarn com.moat.**
#
## skip AVID classes
#-keep class com.integralads.avid.library.* {*;}
#
### Vungle
##-keep class com.vungle.warren.** { *; }
##-keep class com.vungle.warren.downloader.DownloadRequest
##-dontwarn com.vungle.warren.error.VungleError$ErrorCode
##-dontwarn com.vungle.warren.downloader.DownloadRequest$Status
##-keepclassmembers enum com.vungle.warren.** { *; }
#
##
###Theorem Reach
##-keep class theoremreach.com.** { *; }
#
#
#-keep class com.ayetstudios.publishersdk.messages.** {*;}
#-keep public class com.ayetstudios.publishersdk.AyetSdk
#-keepclassmembers class com.ayetstudios.publishersdk.AyetSdk {
#   public *;
#}
#-keep public interface com.ayetstudios.publishersdk.interfaces.UserBalanceCallback { *; }
#-keep public interface com.ayetstudios.publishersdk.interfaces.DeductUserBalanceCallback { *; }
#
#-keep class com.ayetstudios.publishersdk.models.VastTagReqData { *; }
#
#
## keep classes for tapjoy ads
#-keep class com.tapjoy.** { *; }
#-keep class com.moat.** { *; }
#-keepattributes JavascriptInterface
#-keepattributes *Annotation*
#-keep class * extends java.util.ListResourceBundle {
#protected Object[][] getContents();
#}
#-keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
#public static final *** NULL;
#}
#-keepnames @com.google.android.gms.common.annotation.KeepName class *
#-keepclassmembernames class * {
#@com.google.android.gms.common.annotation.KeepName *;
#}
#-keepnames class * implements android.os.Parcelable {
#public static final ** CREATOR;
#}
#-keep class com.google.android.gms.ads.identifier.** { *; }
#-dontwarn com.tapjoy.**
#
## keep classes for mintegral ads
#-keepattributes Signature
#-keepattributes *Annotation*
#-keep class com.mbridge.** {*; }
#-keep interface com.mbridge.** {*; }
#-keep interface androidx.** { *; }
#-keep class androidx.** { *; }
#-keep public class * extends androidx.** { *; }
#-dontwarn com.mbridge.**
#-keep class **.R$* { public static final int mbridge*; }
#
#
## keep classes for Topon ads
#-keep public class com.anythink.network.**
#-keepclassmembers class com.anythink.network.** {
#   public *;
#}
#
#-dontwarn com.anythink.hb.**
#-keep class com.anythink.hb.**{ *;}
#
## applovin
#-dontwarn com.applovin.**
#-keep class com.applovin.** { *; }
#
## new in v5.6.6
#-keep class com.anythink.myoffer.ui.**{ *;}
#-keepclassmembers public class com.anythink.myoffer.ui.** {
#   public *;
#}
#
## For communication with AdColony's WebView
#-keepclassmembers class * {
#    @android.webkit.JavascriptInterface <methods>;
#}
#
##chartboost
#-keep class com.chartboost.** { *; }
##-keep class com.greedygame.commons.* {*;}
#
#-keep class com.greedygame.commons.** {*;}
#
##-keep class com.box.module_rozdhan.viewmodel.HomeViewModel
##-keep class com.box.module_rozdhan.view.RozDhanFragment
#
#
#
## Vungle
#-keep class com.vungle.warren.** { *; }
#-keep class com.vungle.warren.downloader.DownloadRequest
#-dontwarn com.vungle.warren.error.VungleError$ErrorCode
#-dontwarn com.vungle.warren.downloader.DownloadRequest$Status
#-keepclassmembers enum com.vungle.warren.** { *; }
#
## Moat SDK
#-keep class com.moat.** { *; }
#-dontwarn com.moat.**
#-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
#-keepattributes *Annotation*
#
## Retrofit
#-keepattributes Signature, InnerClasses
#-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
#-dontwarn javax.annotation.**
#-dontwarn kotlin.Unit
#-dontwarn retrofit2.-KotlinExtensions
#-keepclassmembers,allowshrinking,allowobfuscation interface * {
#    @retrofit2.http.* <methods>;
#}
#
## Okio+OkHttp
#-dontwarn okhttp3.**
#-dontwarn okio.**
#-dontwarn javax.annotation.**
#-dontwarn org.conscrypt.**
#-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase
#-keepclassmembers class * extends com.vungle.warren.persistence.Memorable {
#   public <init>(byte[]);
#}
#
##IronSource
#-keepclassmembers class com.ironsource.sdk.controller.IronSourceWebView$JSInterface {
#    public *;
#}
#-keepclassmembers class * implements android.os.Parcelable {
#    public static final android.os.Parcelable$Creator *;
#}
#-keep public class com.google.android.gms.ads.** {
#   public *;
#}
#-keep class com.ironsource.adapters.** { *;
#}
#-dontwarn com.ironsource.mediationsdk.**
#-dontwarn com.ironsource.adapters.**
#-keepattributes JavascriptInterface
#-keepclassmembers class * {
#    @android.webkit.JavascriptInterface <methods>;
#}
#
## appnext
#-keep class com.appnext.** { *; }
#-dontwarn com.appnext.**
#
## yeahMobi
#-keep public class com.growstarry.**{*;}
#-dontwarn com.growstarry.**
#
##for gaid
#-keep class **.AdvertisingIdClient$** { *; }
#
##for js and webview interface
#-keepclassmembers class * {
#    @android.webkit.JavascriptInterface <methods>;
#}
#
## ucrop
#
#-dontwarn com.yalantis.ucrop**
#-keep class com.yalantis.ucrop** { *; }
#-keep interface com.yalantis.ucrop** { *; }