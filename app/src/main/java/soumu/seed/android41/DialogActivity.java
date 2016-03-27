package soumu.seed.android41;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    private String TAG;
    private Toast toast = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        TAG = this.getClass().getName();

        Button btnMultiSelect = (Button)findViewById(R.id.btnMultiSelect);
        btnMultiSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = {"Mario", "Link", "Luigi"};
                final boolean[] itemsChecked = new boolean[items.length];

                new AlertDialog.Builder(DialogActivity.this)
                        .setTitle("Hello, AlertDialog")
                        .setMultiChoiceItems(
                                items, itemsChecked,
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                        Log.d(TAG, items[which] + (isChecked ? " Checked" : " UnChecked"));
                                        if (toast != null) {
                                            toast.cancel();
                                            toast = null;
                                        }
                                        toast = Toast.makeText(
                                                DialogActivity.this,
                                                items[which] + (isChecked ? " Checked" : " UnChecked"),
                                                Toast.LENGTH_LONG);
                                        toast.show();
                                    }
                                }
                        )
                        .setPositiveButton(
                                "Close",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Log.d(TAG, "Dialog Canceled");
                                    }
                                }
                        )
                        .show();
            }
        });

    }
}
