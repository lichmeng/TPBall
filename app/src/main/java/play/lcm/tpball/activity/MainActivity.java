package play.lcm.tpball.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import play.lcm.tpball.R;

/**
 * Created by lichaomeng on 2018/5/8 0008.
 *
 * @Description:
 */

public class MainActivity extends AppCompatActivity  {

    private FrameLayout scale;
    private Button btnStart;
    private Button btnPause;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scale = findViewById(R.id.fl_scale);
        btnStart = findViewById(R.id.btn_start);
        btnPause = findViewById(R.id.btn_pause);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SensorTestActivity.class));
            }
        });


    }





    @Override
    protected void onResume() {
        super.onResume();

    }







}
