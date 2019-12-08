package com.example.talkingkuang;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tiaozhuan_layout);
        Button button登陆跳转 = findViewById(R.id.button登陆对话框);
        button登陆跳转.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_layout);
                final EditText TextName = findViewById(R.id.textName);
                final EditText TextPwd = findViewById(R.id.textPwd);
                Button buttonOk = findViewById(R.id.buttonOk);
                Button buttonCancel = findViewById(R.id.buttonCancel);
                buttonOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (TextName.getText().toString().equals("abc") && TextPwd.getText().toString().equals("123"))
                            Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
                    }
                });
                buttonCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextName.setText("");
                        TextPwd.setText("");
                    }
                });
            }
        });
        final Button button提示对话框 = findViewById(R.id.button提示对话框);
        button提示对话框.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("这是对话框").setTitle("Talking kuang(*^▽^*)");
                builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "您点击了确定按钮！(✪ω✪)", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "您点击了取消按钮！(ಥ_ಥ) ", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNeutralButton("退出", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        android.os.Process.killProcess(android.os.Process.myPid());//退出进程
                    }
                });
                builder.show();
            }
        });
    }
}
