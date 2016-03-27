package soumu.seed.android41;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

/**
 * ZXIngライブラリを使用するために、以下の作業が必要
 *   1.[build.gradle]に以下の記述を追加
 *      dependencies {
 *          ...
 *          compile 'com.journeyapps:zxing-android-embedded:3.1.0@aar'
 *          compile 'com.google.zxing:core:3.2.0'
 *      }
 *   2.buildすると、mavenの力で、ライブラリを引っ張ってきてくれる
 *
 */
public class BarcodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);

        Button btnScan = (Button)findViewById(R.id.btnBarcodeScan);
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(BarcodeActivity.this);
                integrator.setCaptureActivity(CaptureAnyOrientationActivity.class);
                integrator.setOrientationLocked(false);
                integrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (scanResult != null) {
            EditText edtBarcode = (EditText)findViewById(R.id.edtBarcodeCode);
            edtBarcode.setText(scanResult.getContents());
        }
    }

}
