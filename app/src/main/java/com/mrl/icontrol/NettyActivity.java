package com.mrl.icontrol;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mrl.network.protobuf.NettyClient;
import com.mrl.network.protobuf.NettyServer;
import com.mrl.network.protobuf.Test;
import com.mrl.network.business.OnReceiveListener;
import com.mrl.network.business.OnServerConnectListener;
import com.mrl.icontrol.service.ServerService;

import java.net.InetSocketAddress;

public class NettyActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private EditText etTitle;
    private EditText etContent;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netty_demo);

        etTitle = (EditText) findViewById(R.id.etTitle);
        etContent = (EditText) findViewById(R.id.etContent);
        tvRes = (TextView) findViewById(R.id.tvRes);
        Intent intent = new Intent(this, ServerService.class);
        startService(intent);

    }

    public void connect(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                NettyClient.getInstance()
                        .connect("127.0.0.1", NettyServer.PORT_NUMBER, new OnServerConnectListener() {
                            @Override
                            public void onConnectSuccess() {
                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(NettyActivity.this, "connect success!", Toast.LENGTH_SHORT).show();
                                    }
                                });

                            }

                            @Override
                            public void onConnectFailed() {
                                new Handler(Looper.getMainLooper()).post(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(NettyActivity.this, "connect failed!", Toast.LENGTH_SHORT).show();
                                    }
                                });

                            }
                        });
            }
        }).start();

    }

    public void send(View view) {
        Test.ProtoTest protoTest = Test.ProtoTest
                .newBuilder()
                .setId(1)
                .setTitle(etTitle.getText().toString())
                .setContent(etContent.getText().toString())
                .build();
        NettyClient.getInstance().send(protoTest, new OnReceiveListener() {
            @Override
            public void handleReceive(final Object msg) {
                if (msg instanceof Test.ProtoTest) {
                    Log.d(TAG, "handleReceive: " + ((Test.ProtoTest) msg).getContent());
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            tvRes.setText("");
                            Test.ProtoTest test = (Test.ProtoTest) msg;
                            tvRes.setText(test.getId() + "\n" +
                                    test.getTitle() + "\n" +
                                    test.getContent());
                        }
                    });

                }
            }
        });
    }
}
