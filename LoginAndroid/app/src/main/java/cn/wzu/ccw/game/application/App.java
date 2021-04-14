package cn.wzu.ccw.game.application;

import android.app.Application;
import android.graphics.Bitmap;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.xuexiang.xhttp2.XHttpSDK;

import java.io.SyncFailedException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import cn.wzu.ccw.game.R;
import cn.wzu.ccw.game.constant.NetConstant;

/**
 * @ClassName App
 * @Author littlecurl
 * @Date 2020/11/8 13:08
 * @Version 1.0.0
 * @Description TODO
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        XHttpSDK.init(this);                                            //初始化网络请求框架，必须首先执行

        XHttpSDK.setBaseUrl(NetConstant.baseService);                               //设置网络请求的基础地址


    }
}
