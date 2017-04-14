package com.ourproject.ui.book.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ourproject.R;
import com.ourproject.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QR_codeActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R2.id.qr_back)
    ImageView mBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
        ButterKnife.bind(this);

        mBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.qr_back:
                this.finish();
                break;
        }
    }
}
