package bafy.pharmacy.milkbank.other;

import bafy.pharmacy.milkbank.BuildConfig;

/**
 *    github : https://github.com/getActivity/AndroidProject
 *    time   : 2019/09/02
 *    desc   : App 配置管理类
 */
public final class AppConfig  {

    /**
     * 当前是否为 Debug 模式
     */
    public static boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    /**
     * 获取当前应用的包名
     */
    public static String getPackageName() {
        return BuildConfig.APPLICATION_ID;
    }

    /**
     * 获取当前应用的版本名
     */
    public static String getVersionName() {
        return BuildConfig.VERSION_NAME;
    }

    /**
     * 获取当前应用的版本码
     */
    public static int getVersionCode() {
        return BuildConfig.VERSION_CODE;
    }

    /**
     * 获取当前应用的渠道名
     */
    public static String getProductFlavors() {
        return BuildConfig.FLAVOR;
    }

    /**
     * 获取 BuglyId
     */
//    public static String getBuglyId() {
//        return BuildConfig.BUGLY_ID;
//    }
}
