package soumu.seed.android41;

import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HardwareActivity extends AppCompatActivity {

    private class Feature {
        private String category;
        private String feature;
        private String summary;
        private boolean available;

        public Feature(String category, String feature, String summary) {
            this.category  = category;
            this.feature   = feature;
            this.summary   = summary;
            this.available = false;
        }

        public String getCategory() {
            return category;
        }
        public void setCategory(String category) {
            this.category = category;
        }

        public String getFeature() {
            return feature;
        }
        public void setFeature(String feature) {
            this.feature = feature;
        }

        public String getSummary() {
            return summary;
        }
        public void setSummary(String summary) {
            this.summary = summary;
        }

        public boolean getAvailable() {
            return available;
        }
        public void setAvailable(boolean available) {
            this.available = available;
        }
    }

    List<Feature> features = new ArrayList<Feature>(Arrays.asList(new Feature[] {
        new Feature("Audio",      PackageManager.FEATURE_AUDIO_LOW_LATENCY, "低レイテンシAudio入出力"),
        new Feature("Bluetooth",  PackageManager.FEATURE_BLUETOOTH, "Bluetooth機能"),
        new Feature("Camera",     PackageManager.FEATURE_CAMERA, "カメラ機能"),
        new Feature("Camera",     PackageManager.FEATURE_CAMERA_AUTOFOCUS, "カメラのオートフォーカス機能"),
        new Feature("Camera",     PackageManager.FEATURE_CAMERA_FLASH, "カメラのフラッシュ機能"),
        new Feature("Camera",     PackageManager.FEATURE_CAMERA_FRONT, "フロントカメラ機能"),
        new Feature("Camera",     PackageManager.FEATURE_CAMERA_ANY, "フロントかリアカメラ機能"),
        new Feature("Location",   PackageManager.FEATURE_LOCATION, "GPSかネットワークから位置情報取得"),
        new Feature("Location",   PackageManager.FEATURE_LOCATION_NETWORK, "ネットワークから位置情報取得"),
        new Feature("Location",   PackageManager.FEATURE_LOCATION_GPS, "GPSから位置情報取得"),
        new Feature("Microphone", PackageManager.FEATURE_MICROPHONE, "マイク機能"),
        new Feature("NFC",        PackageManager.FEATURE_NFC, "NFC機能"),
        new Feature("Sensors",    PackageManager.FEATURE_SENSOR_ACCELEROMETER, "加速度センサー"),
        new Feature("Sensors",    PackageManager.FEATURE_SENSOR_BAROMETER, "気圧センサー"),
        new Feature("Sensors",    PackageManager.FEATURE_SENSOR_COMPASS, "方位センサー"),
        new Feature("Sensors",    PackageManager.FEATURE_SENSOR_GYROSCOPE, "ジャイロスコープ・センサー"),
        new Feature("Sensors",    PackageManager.FEATURE_SENSOR_LIGHT, "光センサー"),
        new Feature("Sensors",    PackageManager.FEATURE_SENSOR_PROXIMITY, "近接センサー"),
        new Feature("Screen",     PackageManager.FEATURE_SCREEN_LANDSCAPE, "横向き"),
        new Feature("Screen",     PackageManager.FEATURE_SCREEN_PORTRAIT, "縦向き"),
        new Feature("Telephony",  PackageManager.FEATURE_TELEPHONY, "通話・通信機能"),
        new Feature("Telephony",  PackageManager.FEATURE_TELEPHONY_CDMA, "CDMAによる通話・通信機能"),
        new Feature("Telephony",  PackageManager.FEATURE_TELEPHONY_GSM, "GSMによる通話・通信機能"),
        new Feature("Television", PackageManager.FEATURE_TELEVISION, "TV用機能"),
        new Feature("USB",        PackageManager.FEATURE_USB_HOST, "USBホスト接続機能"),
        new Feature("USB",        PackageManager.FEATURE_USB_ACCESSORY, "USBアクセサリー機能"),
        new Feature("Wifi",       PackageManager.FEATURE_WIFI, "Wi-Fi機能")
    }));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware);



        //PackageManager.FEATURE_CAMERA_CAPABILITY_MANUAL_POST_PROCESSING
    }
}
