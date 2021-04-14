package cn.wzu.ccw.game.activity;

import android.content.Context;
import android.content.SharedPreferences;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class shared_prefference  {
    String name;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor edit;
    ArrayList<String> member_list;
    int member_size;

    public shared_prefference(Context context) {

        sharedPreferences =  context.getSharedPreferences("file_info",Context.MODE_PRIVATE);
        edit = sharedPreferences.edit();

    }

    public String getName() {
        name = sharedPreferences.getString("name","ccw");
        return name;
    }

    public void setName(String name) {
        this.name = name;
        edit.putString("name",name);
        edit.apply();
        edit.commit();
    }

    public void saveMember(ArrayList<String> list){
        this.member_size=list.size();
        this.member_list=list;
        edit.putInt("member_size",member_size);
        for (int i = 0; i < member_size; i++) {
            edit.remove("user_"+i);
            edit.putString("user_"+i,list.get(i));
        }
        edit.apply();
        edit.commit();
    }

    public ArrayList<String> getMember(){
        ArrayList<String> list=new ArrayList<>();
        int size=sharedPreferences.getInt("member_size",0);
        for (int i = 0; i < size; i++) {
            list.add(sharedPreferences.getString("user_"+i,null));
        }
        return list;
    }
}
