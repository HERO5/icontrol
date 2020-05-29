package com.mrl.icontrol;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mrl.ai.baidu.asr.business.RecogListener;
import com.mrl.ai.baidu.asr.mini.MiniRecog;
import com.mrl.icontrol.baiduDemo.mini.ActivityMyMiniRecog;
import com.mrl.icontrol.baiduDemo.mini.ActivityMyMiniUnit;
import com.mrl.icontrol.baiduDemo.mini.ActivityMyMiniWakeUp;
import com.mrl.icontrol.cmd.CmdParser;
import com.mrl.icontrol.service.ServerService;
import com.mrl.icontrol.util.JsonUtil;
import com.mrl.network.business.OnReceiveListener;
import com.mrl.network.business.OnServerConnectListener;
import com.mrl.network.echo.EchoClient;
import com.mrl.network.echo.EchoServer;
import com.mrl.network.model.Message;
import com.mrl.network.protobuf.Test;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private TextView etTitle;
    private TextView etContent;
    private TextView tvRes;

    Button connect;
    Button send;

    TextView activity1;
    TextView activity2;
    TextView activity3;

    Button startSpeech;
    Button stopSpeech;

    MiniRecog miniRecog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miniRecog = new MiniRecog(this, new RecogListener() {
            @Override
            public void onNluResult(String res) { }
            @Override
            public void onPartialResult(String res) { }
            @Override
            public void onFinalResult(String res) {
                tvRes.append(res+"\n");
                Map<String, Object> map = JsonUtil.jsonToMap(res);
                if(map.containsKey(MiniRecog.FinalResultMap.BEST_RESULT)){
                    String keyword = (String) map.get(MiniRecog.FinalResultMap.BEST_RESULT);
                    keyword = keyword.replace(String.valueOf(keyword.charAt(keyword.length()-1)), "");
                    etTitle.setText(keyword);
                    Integer cmd = CmdParser.parse(keyword);
                    etContent.setText(String.valueOf(cmd));
                }
            }
            @Override
            public void onUnExcept(String res) { }
        });
        miniRecog.onCreate();

        Intent intent = new Intent(this, ServerService.class);
        startService(intent);

        initView();
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.activity1:
                intent = new Intent(this, ActivityMyMiniRecog.class);
                break;
            case R.id.activity2:
                intent = new Intent(this, ActivityMyMiniUnit.class);
                break;
            case R.id.activity3:
                intent = new Intent(this, ActivityMyMiniWakeUp.class);
                break;
            case R.id.connect_server:
                connect();
            case R.id.send_to_server:
                send();
                break;
            case R.id.start_speech:
                miniRecog.start();
                break;
            case R.id.stop_speech:
                miniRecog.stop();
                break;
        }
        if(intent != null){
            startActivity(intent);
        }
    }

    private void initView(){
        etTitle = findViewById(R.id.etTitle);
        etContent = findViewById(R.id.etContent);
        tvRes = findViewById(R.id.tvRes);
        connect = findViewById(R.id.connect_server);
        send = findViewById(R.id.send_to_server);
        activity1 = findViewById(R.id.activity1);
        activity2 = findViewById(R.id.activity2);
        activity3 = findViewById(R.id.activity3);
        startSpeech = findViewById(R.id.start_speech);
        stopSpeech = findViewById(R.id.stop_speech);
        connect.setOnClickListener(this);
        send.setOnClickListener(this);
        activity1.setOnClickListener(this);
        activity2.setOnClickListener(this);
        activity3.setOnClickListener(this);
        startSpeech.setOnClickListener(this);
        stopSpeech.setOnClickListener(this);
    }

    public void connect() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                EchoClient
                        .getInstance(new OnReceiveListener() {
                            @Override
                            public void handleReceive(final Object msg) {
                                if (msg instanceof Test.ProtoTest) {
                                    Log.d(TAG, "handleReceive: " + ((Test.ProtoTest) msg).getContent());
                                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                                        @Override
                                        public void run() {
                                            tvRes.setText("");
                                            tvRes.setText(msg.toString());
                                        }
                                    });

                                }
                            }
                        })
                        .connect("192.168.43.115", 80, new OnServerConnectListener() {
                            @Override
                            public void onConnectSuccess() {
                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(MainActivity.this, "connect success!", Toast.LENGTH_SHORT).show();
                                    }
                                });

                            }
                            @Override
                            public void onConnectFailed() {
                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(MainActivity.this, "connect failed!", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        });
            }
        }).start();

    }

    public void send() {
        EchoClient.getInstance(null).send(new Message(etTitle.getText().toString(), etContent.getText().toString()));
    }

    @Override
    protected void onStop() {
        super.onStop();
        EchoServer.getInstance(0).shutDown();
    }

    //    public void connect() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                NettyClient
//                        .getInstance()
//                        .connect("192.168.1.3", 8080, new OnServerConnectListener() {
//                            @Override
//                            public void onConnectSuccess() {
//                                new Handler(Looper.getMainLooper()).post(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        Toast.makeText(MainActivity.this, "connect success!", Toast.LENGTH_SHORT).show();
//                                    }
//                                });
//
//                            }
//
//                            @Override
//                            public void onConnectFailed() {
//                                new Handler(Looper.getMainLooper()).post(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        Toast.makeText(MainActivity.this, "connect failed!", Toast.LENGTH_SHORT).show();
//                                    }
//                                });
//
//                            }
//                        });
//            }
//        }).start();
//
//    }
//
//    public void send() {
//        Test.ProtoTest protoTest = Test.ProtoTest
//                .newBuilder()
//                .setId(1)
//                .setTitle(etTitle.getText().toString())
//                .setContent(etContent.getText().toString())
//                .build();
//        NettyClient.getInstance().send(protoTest, new OnReceiveListener() {
//            @Override
//            public void handleReceive(final Object msg) {
//                if (msg instanceof Test.ProtoTest) {
//                    Log.d(TAG, "handleReceive: " + ((Test.ProtoTest) msg).getContent());
//                    new Handler(Looper.getMainLooper()).post(new Runnable() {
//                        @Override
//                        public void run() {
//                            tvRes.setText("");
//                            Test.ProtoTest test = (Test.ProtoTest) msg;
//                            tvRes.setText(test.getId() + "\n" +
//                                    test.getTitle() + "\n" +
//                                    test.getContent());
//                        }
//                    });
//
//                }
//            }
//        });
//    }
}
