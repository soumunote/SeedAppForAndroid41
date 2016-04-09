package soumu.seed.android41;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    private final static int DIALOG_ID_1 = 1;

    private String TAG;
    private Toast toast = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        TAG = this.getClass().getName();

        Button btnMultiSelect = (Button)findViewById(R.id.btnMultiSelect);
        assert btnMultiSelect != null;
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

        Button btnBetterMethod = (Button)findViewById(R.id.btnBetterMethod);
        btnBetterMethod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID_1);
            }
        });

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DIALOG_ID_1:
                LayoutInflater factory = LayoutInflater.from(this);
                final View inputView = factory.inflate(R.layout.activity_dialog_custom_dialog_1, null);
                return new AlertDialog.Builder(DialogActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("BetterDialog")
                        .setView(inputView)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).create();

        }
        return null;
    }
}
