package org.codeforcoffee.chicagorecommendations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    private TextView mTxtName;
    private TextView mTxtAddress;
    private TextView mTxtDescription;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mIntent = getIntent();

        mTxtName = (TextView) findViewById(R.id.txt_detail_name);
        mTxtAddress = (TextView) findViewById(R.id.txt_detail_address);
        mTxtDescription = (TextView) findViewById(R.id.txt_detail_name);

        mTxtName.setText(mIntent.getStringExtra("NAME"));
        mTxtAddress.setText(mIntent.getStringExtra("ADDRESS"));
        mTxtDescription.setText(mIntent.getStringExtra("DESCRIPTION"));
    }
}
