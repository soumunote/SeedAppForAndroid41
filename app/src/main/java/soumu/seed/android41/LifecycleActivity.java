package soumu.seed.android41;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
 *
 * ライフサイクルメソッドの動作を確認します
 * AndroidStudio の 「6.Android Monitor」の「logcat」タブで確認する
 *
 */
public class LifecycleActivity extends AppCompatActivity {

    private String TAG;

    {
        TAG = this.getClass().getName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        Log.d(TAG, "%m"+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onStart");
    }
}
