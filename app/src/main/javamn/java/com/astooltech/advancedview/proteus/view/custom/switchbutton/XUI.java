package com.astooltech.advancedview.proteus.view.custom.switchbutton;

import android.app.Application;
import android.content.Context;


/**
 * UI全局设置
 *
 * @author xuexiang
 * @since 2018/11/14 上午11:40
 */
public class XUI {

    private static Application sContext;

    private static boolean sIsTabletChecked;

    private static int sScreenType;

    private static String sDefaultFontAssetPath;

    //=======================初始化设置===========================//

    /**
     * 初始化
     *
     * @param context 上下文
     */
    public static void init(Application context) {
        sContext = context;
    }

    /**
     * 设置默认字体
     */


    public static Context getContext() {
        testInitialize();
        return sContext;
    }

    private static void testInitialize() {
        if (sContext == null) {
            throw new ExceptionInInitializerError("请先在全局Application中调用 XUI.init() 初始化！");
        }
    }

    //=======================日志调试===========================//

    /**
     * 设置调试模式
     *
     * @param tag 标志
     */


    /**
     * 设置调试模式
     *
     * @param isDebug 是否是调试模式
     */


    //=======================字体===========================//

    /**
     * 设置控件的字体【用于遗漏的控件字体设置】
     *
     * @param views 控件集合
     */

    /**
     * @return 获取默认字体
     */

    /**
     * @return 默认字体的存储位置
     */
    public static String getDefaultFontAssetPath() {
        return sDefaultFontAssetPath;
    }

    /**
     * @param fontPath 字体路径
     * @return 获取默认字体
     */


    //=======================屏幕尺寸===========================//

    /**
     * 检验设备屏幕的尺寸
     *
     * @param context 上下文
     * @return 屏幕的尺寸类型
     */

    /**
     * 判断是否平板设备
     *
     * @return true:平板,false:手机
     */


    /**
     * 是否是平板
     *
     * @return
     */

    /**
     * 初始化主题
     *
     * @param activity
     */


    /**
     * 获取主题色
     *
     * @param context 上下文
     * @return 主题色
     */


}
