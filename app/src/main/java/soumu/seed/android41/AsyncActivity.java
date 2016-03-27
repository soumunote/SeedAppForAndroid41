package soumu.seed.android41;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class AsyncActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        Button btnStart = (Button)findViewById(R.id.btnAsynStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // execute()は UI thread から呼ぶ必要がある
                new SimpleAsyncTask(AsyncActivity.this).execute("foo", "bar");
            }
        });

        Button btnDoNotPush = (Button)findViewById(R.id.btnAsyncDoNotPush);
        btnDoNotPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Thread.sleep(1000 * 10);
                }
                catch (InterruptedException exp) {
                    Log.d(AsyncActivity.class.getName(), exp.toString());
                }
            }
        });
    }
}
