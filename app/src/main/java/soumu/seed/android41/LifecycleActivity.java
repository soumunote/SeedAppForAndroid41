package soumu.seed.android41;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * ライフサイクルメソッドの動作を確認します
 * AndroidStudio の 「6.Android Monitor」の「logcat」タブで確認する
 */
public class LifecycleActivity extends AppCompatActivity {

    private String TAG;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    {
        TAG = this.getClass().getName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        Log.d(TAG, getCurrentMethodName());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, getCurrentMethodName());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, getCurrentMethodName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, getCurrentMethodName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, getCurrentMethodName());
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, getCurrentMethodName());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, getCurrentMethodName());
    }

    private String getCurrentMethodName() {
        StackTraceElement[] s = Thread.currentThread().getStackTrace();
        return s[3].getMethodName();
    }
}
