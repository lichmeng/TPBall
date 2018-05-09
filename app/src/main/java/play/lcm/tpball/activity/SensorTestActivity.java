package play.lcm.tpball.activity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.nineoldandroids.animation.ObjectAnimator;

import play.lcm.tpball.R;

/**
 * Created by lichaomeng on 2018/5/8 0008.
 *
 * @Description:
 */

public class SensorTestActivity extends AppCompatActivity  implements SensorEventListener{
    private ImageView viewById;
    private SensorManager mSensorManager;
    private TextView mTxtValue;
    private Sensor mSensor;
    private FrameLayout mBall;
    private int measuredWidth;
    private int measuredHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensortestactivity);
        mTxtValue = (TextView) findViewById(R.id.txt_value);
        mBall = (FrameLayout) findViewById(R.id.pg);
        viewById = findViewById(R.id.iv_ball);

                measuredWidth = viewById.getMeasuredWidth();
        measuredHeight = viewById.getMeasuredHeight();


        // 获取传感器管理对象
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        // 获取传感器的类型(TYPE_ACCELEROMETER:加速度传感器)
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 为加速度传感器注册监听器
        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 取消监听
        mSensorManager.unregisterListener(this);
    }

    float x =0;
    float y =0;

    // 当传感器的值改变的时候回调该方法
    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] values = event.values;
        StringBuilder sb = new StringBuilder();
        sb.append("方向1：");
        sb.append(values[1]);
        sb.append("\n方向2：");
        sb.append(values[2]);
        mTxtValue.setText(sb.toString());


        if (Math.abs(x-values[1])>0.1||Math.abs(y-values[2])>0.1){
            x=values[1];
            y=values[2];


        adjustPosiotion(values[1],values[2]);
        }


    }



    // 当传感器精度发生改变时回调该方法
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void adjustPosiotion(float x,float y){

//        viewById.setTranslationX(x);
//        viewById.setTranslationY(y);


        ObjectAnimator.ofFloat(viewById,"TranslationX" ,x).start();
        ObjectAnimator.ofFloat(viewById,"TranslationY" ,y).start();



    }

}