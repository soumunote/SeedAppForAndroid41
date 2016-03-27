package soumu.seed.android41;

import com.journeyapps.barcodescanner.CaptureActivity;

/**
 * BarcodeActivityから起動されるカメラ画面のためのActivity
 * Activityの条件として以下が挙げられる
 *   1.AndroidManifest.xml に記述されている
 *   2.public なクラスである
 *   ここで、BarcodeActivityのインナークラスでも良いかと思い試したが駄目であったため
 *   残念ながら1つの独立したクラスとした
 */
public class CaptureAnyOrientationActivity extends CaptureActivity {
}
