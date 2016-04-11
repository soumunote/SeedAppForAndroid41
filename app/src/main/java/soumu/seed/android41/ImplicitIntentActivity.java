package soumu.seed.android41;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ImplicitIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        Button btnSendTo = (Button)findViewById(R.id.btnTouch);
        btnSendTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtExtraText = (EditText)findViewById(R.id.editExtraText);
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_TEXT, edtExtraText.getText());

                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendIntent);
                }
            }
        });

        Button btnSendToChoose = (Button)findViewById(R.id.btnSendToChoose);
        btnSendToChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtExtraText = (EditText)findViewById(R.id.editExtraText);
                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_TEXT, edtExtraText.getText());
                String title = getResources().getString(R.string.implicit_intent_activity_chooser_title);
                Intent chooser = Intent.createChooser(sendIntent, title);
                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                }
            }
        });
    }
}
