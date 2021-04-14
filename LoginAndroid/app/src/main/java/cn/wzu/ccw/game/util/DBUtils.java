package cn.wzu.ccw.game.util;



import android.util.Log;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Queue;

import cn.wzu.ccw.game.entity.Question;

public class DBUtils {
    private static String driver = "com.mysql.jdbc.Driver";// MySql驱动
    private static String url = "jdbc:mysql://localhost:3306/competition_pk_sys";

    private static String user = "root";// 用户名

    private static String password = "root";// 密码

    private static Connection getConn(){
        String dbName="competition_pk_sys";
        Connection connection = null;
        try{
            Class.forName(driver);// 动态加载类
            String ip = "192.168.3.61";// 写成本机地址，不能写成localhost，同时手机和电脑连接的网络必须是同一个

            // 尝试建立到给定数据库URL的连接
            connection = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + dbName,
                    user, password);

        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }

    public static ArrayList<Question> getQues(int category,int num){
        ArrayList<Question> list=new ArrayList<>();
        Connection connection = getConn();
        String sql="SELECT * FROM competition_pk_sys.choice_question where category=? order by rand() limit ?;";
        if(connection!=null){
            try {
                PreparedStatement ps = connection.prepareStatement(sql);
                if (ps != null) {
                    ps.setString(1, String.valueOf(category));
                    ps.setString(2, String.valueOf(num));

                    ResultSet rs = ps.executeQuery();
                    while (rs.next()){
                        list.add(new Question(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(7),rs.getString(8),rs.getString(8),category));
                    }
                    connection.close();
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                Log.e("DBUtils","异常：" + e.getMessage());
            }
        }
        return  list;
    }


}
