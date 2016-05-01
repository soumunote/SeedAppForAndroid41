package soumu.seed.android41;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

/**
 *
 * 本Activityは android.support.v7.app.AppCompatActivity を継承しているので、ActionBarを取得する際は
 * getActionBar()ではなく、getSupportedActionBar()を使う必要がある。
 * また、戻り値の型も android.app.ActionBar ではなく、android.support.v7.app.ActionBar である。
 * getActionBar()をsuper.onCreate()の前に呼ぶとActionBarを取得できるが、それはまやかし。
 *
 */
public class ActionBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);

        final ActionBar actionBar = getSupportActionBar();
        Switch swtShowActionBar = (Switch)findViewById(R.id.swtShowActionBar);

        swtShowActionBar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    actionBar.show();
                }
                else {
                    actionBar.hide();
                }
            }
        });

    }
}
