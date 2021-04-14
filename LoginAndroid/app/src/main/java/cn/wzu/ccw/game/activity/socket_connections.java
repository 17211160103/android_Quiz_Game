package cn.wzu.ccw.game.activity;

import android.app.Application;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.xuexiang.xhttp2.XHttpSDK;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

import cn.wzu.ccw.game.constant.NetConstant;

public class socket_connections extends Application {

    private HashMap<String, Object> map = new HashMap<String, Object>();

    private Socket iSocket;
//    private Socket socket;


    Boolean is_admin = false,is_joined = false;
    ArrayList<String> member_array;
    String roomNameOfCurrentRoom="";


    private static final String URL ="https://game-server-abhi-am.herokuapp.com/";
    //    private static final String URL ="http://192.168.43.206:5000/";
    @Override
    public void onCreate() {
        super.onCreate();
        XHttpSDK.init(this);                                            //初始化网络请求框架，必须首先执行

        XHttpSDK.setBaseUrl(NetConstant.baseService);

        try {


            IO.Options opts = new IO.Options();

            iSocket = IO.socket(URL, opts);

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        member_array = new ArrayList<String>();
    }
    public com.github.nkzawa.socketio.client.Socket getSocketInstance(){

        return iSocket;
    }

    public void connect_to_room(String room_name,String name,int code){
        iSocket.connect();
        iSocket.emit("joinroom",room_name,name,code);
    }

//    @Override
//    public void onTerminate() {
//        disconnect_room();
//        super.onTerminate();
//
//    }

    public void disconnect_room() {
        iSocket.disconnect();
    }


    public void put(String key,Object object){
        map.put(key, object);
    }

    public Object get(String key){
        return map.get(key);
    }
}
