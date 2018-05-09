package play.lcm.tpball.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import play.lcm.tpball.R;

/**
 * Created by lichaomeng on 2018/5/9 0009.
 *
 * @Description: 自定义 控件 球场
 */

public class Playground extends ViewGroup {

    private ImageView viewById;
    private int measuredWidth;
    private int measuredHeight;

    public Playground(Context context) {
        this(context,null);
    }

    public Playground(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Playground(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater.from(context).inflate(R.layout.layout_playground,this);
//        viewById = findViewById(R.id.iv_ball);
//
//        measuredWidth = viewById.getMeasuredWidth();
//        measuredHeight = viewById.getMeasuredHeight();

    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        viewById.layout(l, t, r, b);
    }



    public void adjustPosiotion(float x,float y){

      int l = (int) (viewById.getX()+x);
       int t = (int) (viewById.getY()+y);
       int r = l+measuredWidth;
       int b = t+measuredHeight;


        layout(l,t,r,b);

    }

}
