package com.colin.colorprogressbar;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.colin.colorprogressbar.customview.AnimDownloadProgressButton;

public class MainActivity extends AppCompatActivity {
    private AnimDownloadProgressButton mAnimDownloadProgressButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAnimDownloadProgressButton2 = (AnimDownloadProgressButton) findViewById(R.id.anim_btn);
        mAnimDownloadProgressButton2.setCurrentText("安装");
        mAnimDownloadProgressButton2.setTextSize(60f);
        mAnimDownloadProgressButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
            }
        });
    }

    private void download() {
        if (mAnimDownloadProgressButton2.getProgress() >= 100) {
            mAnimDownloadProgressButton2.setState(AnimDownloadProgressButton.NORMAL);
            mAnimDownloadProgressButton2.setCurrentText("打开");
        } else {
            mAnimDownloadProgressButton2.setState(AnimDownloadProgressButton.DOWNLOADING);
            mAnimDownloadProgressButton2.setProgressText("下载中", mAnimDownloadProgressButton2.getProgress() + 1);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    download();
                }
            }, 50);
        }
    }
}
