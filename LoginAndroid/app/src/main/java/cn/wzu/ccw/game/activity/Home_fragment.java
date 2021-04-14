package cn.wzu.ccw.game.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.xuexiang.xhttp2.XHttp;
import com.xuexiang.xhttp2.callback.SimpleCallBack;
import com.xuexiang.xhttp2.exception.ApiException;
import com.xuexiang.xhttp2.utils.Utils;

import java.util.ArrayList;

import cn.wzu.ccw.game.R;
import cn.wzu.ccw.game.constant.NetConstant;
import cn.wzu.ccw.game.entity.Question;
import cn.wzu.ccw.game.util.DBUtils;

public class Home_fragment extends Fragment {
    public Home_fragment() {

    }


    AlertDialog alertDialog;
    AlertDialog.Builder alertDialogBuilder;
    View promptsView;
    LayoutInflater li;
    Home baseActivity;
    TextView numberOfQuestions,topic;
    SeekBar seekBar;
    shared_prefference sharedPrefference;
    //    Spinner spinner;
    TimePicker timePicker;;
    int time_to_send = 120;
    int position=0,number=10;
    String[] choice = { "General Knowledge", "Entertainment: Books", "Entertainment: Film", "Entertainment: Music", "Entertainment: Musicals & Theatres","Entertainment: Television","Entertainment: Video Games","Entertainment: Board Games","Science & Nature","Science: Computers","Science: Mathematics","Mythology","Sports"
            ,"Geography"
            ,"History"
            ,"Politics"
            ,"Art"
            ,"Celebrities"
            ,"Animals"
            ,"Vehicles"
            ,"Entertainment: Comics"
            ,"Science: Gadgets"
            ,"Entertainment: Japanese Anime & Manga"
            ,"Entertainment: Cartoon & Animations"
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        baseActivity = (Home) getActivity();

//        spinner = getView().findViewById(R.id.spinner2);
//        spinner.setOnItemSelectedListener(this);
//        ArrayAdapter ad
//                = new ArrayAdapter(
//                getContext(),
//                android.R.layout.simple_spinner_item,
//                choice);
//        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        spinner.setAdapter(ad);
        li = LayoutInflater.from(baseActivity);
        promptsView = li.inflate(R.layout.quiz_cofig_dialog, null);
        alertDialogBuilder = new AlertDialog.Builder(
                baseActivity);
        alertDialogBuilder
                .setView(promptsView)
                .setCancelable(false)
        ;


        alertDialog = alertDialogBuilder.create();


        numberOfQuestions = promptsView.findViewById(R.id.textView24);
        timePicker = promptsView.findViewById(R.id.timepicker);
        timePicker.setIs24HourView(true);
        timePicker.setCurrentHour(0);
        timePicker.setCurrentMinute(2);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                time_to_send = hourOfDay*60*60 + minute*60;
            }
        });

        topic = promptsView.findViewById(R.id.topic);



        seekBar = promptsView.findViewById(R.id.seekBar2);


        getView().findViewById(R.id.nature).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 17;
                number = 10;
                startDialogBox();
            }
        });

        getView().findViewById(R.id.film).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 11;
                number = 10;
                startDialogBox();
            }
        });

        getView().findViewById(R.id.music).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 12;
                number = 10;
                startDialogBox();
            }
        });

        getView().findViewById(R.id.video_games).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 15;
                number = 10;
                startDialogBox();
            }
        });

        getView().findViewById(R.id.board_games).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 16;
                number = 10;
                startDialogBox();
            }
        });

        getView().findViewById(R.id.mythology).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 20;
                number = 10;
                startDialogBox();
            }
        });

        getView().findViewById(R.id.sports).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 21;
                number = 10;
                startDialogBox();
            }
        });

        getView().findViewById(R.id.geography).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 22;
                number = 10;
                startDialogBox();
            }
        });

        getView().findViewById(R.id.history).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 23;
                number = 10;
                startDialogBox();
            }
        });

        getView().findViewById(R.id.politics).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 24;
                number = 10;
                startDialogBox();
            }
        });

        getView().findViewById(R.id.arts).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 25;
                number = 10;
                startDialogBox();
            }
        });


        getView().findViewById(R.id.celebs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 26;
                number = 10;
                startDialogBox();
            }
        });
        getView().findViewById(R.id.animals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 27;
                number = 10;
                startDialogBox();
            }
        });

        getView().findViewById(R.id.vehicals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 28;
                number = 10;
                startDialogBox();
            }
        });

        getView().findViewById(R.id.books).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 10;
                number = 10;
                startDialogBox();
            }
        });

        getView().findViewById(R.id.theators).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 13;
                number = 10;
                startDialogBox();
            }
        });

        getView().findViewById(R.id.computer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 18;
                number = 10;
                startDialogBox();
            }
        });

        getView().findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 14;
                number = 10;
                startDialogBox();
            }
        });
        getView().findViewById(R.id.math).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 19;
                number = 10;
                startDialogBox();
            }
        });
        promptsView.findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//             asyncGetMemWithXHttp2();

                if(baseActivity.isocket.member_array.size()==0){
                    baseActivity.isocket.member_array.add("15988441234");
                    baseActivity.isocket.member_array.add("17365863531");

                }
                Intent in = new Intent(baseActivity.getBaseContext() , PlayQuiz.class);
                in.putExtra("roomname",baseActivity.isocket.roomNameOfCurrentRoom);

                in.putExtra("members",baseActivity.isocket.member_array);

//                for(String member:member_list){
//                    System.out.println(member);
//                }




                in.putExtra("is_admin",baseActivity.isocket.is_admin);
                in.putExtra("time",time_to_send);
                in.putExtra("myname",baseActivity.local_databse.getName());
                String temp = "https://opentdb.com/api.php?amount="+number+"&category="+position+"&type=multiple";
                in.putExtra("url",temp);



                ArrayList<Question> list= DBUtils.getQues(6,3);

                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i).toString());
                }





//                startActivity(in);
            }
        });
        promptsView.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.cancel();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                number = progress;
                numberOfQuestions.setText(""+number);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    private void startDialogBox() {

        alertDialog.show();
        topic.setText(choice[position-9]);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home_fragment, container, false);
    }


    private void asyncGetMemWithXHttp2(){
        XHttp.get(NetConstant.getGetQuesURL())
                .params("room","123")
                .syncRequest(false)
                .execute(new SimpleCallBack<Object>() {
                    @Override
                    public void onSuccess(Object response) throws Throwable {

                    String a= (String) response;
                    System.out.println("-----------成员"+a);
                    }

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(baseActivity,"请求成员失败",Toast.LENGTH_LONG).show();
                    }
                });
    }

}
