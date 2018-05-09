package play.lcm.tpball.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by lichaomeng on 2018/5/6 0006.
 *
 * @Description:
 */

public class App extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
