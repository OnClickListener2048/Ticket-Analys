package cn.watson.ticketsystem.base;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.Utils;
import com.lzy.okgo.OkGo;
import com.standards.library.app.AppContext;
import com.standards.library.app.ReturnCode;
import com.standards.library.app.ReturnCodeConfig;
import com.standards.library.cache.DataProvider;
import com.standards.library.network.NetworkConfig;
import com.standards.library.util.LogUtil;

import cn.jpush.android.api.JPushInterface;
import cn.watson.ticketsystem.BuildConfig;


/**
 * <请描述这个类是干什么的>
 *
 * @data: 16/9/19 下午2:40
 * @version: V1.0
 */
public class App extends Application {

    private static Context sContext;

    public static Context getContext() {
        return sContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        AppContext.getInstance().init(this);
        sContext = getContext();
        LogUtil.init(BuildConfig.DEBUG_LOG, "lucky");
        Utils.init(this);
        DataProvider.init(this);
        OkGo.getInstance().init(this);
        NetworkConfig.setBaseUrl(BuildConfig.HOST_URL);
        ReturnCodeConfig.getInstance().initReturnCode(ReturnCode.CODE_SUCCESS, ReturnCode.CODE_EMPTY);
    }

}
