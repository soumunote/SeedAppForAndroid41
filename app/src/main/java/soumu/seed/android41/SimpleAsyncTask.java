package soumu.seed.android41;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by maeda on 2016/03/27.
 */
public class SimpleAsyncTask
    extends AsyncTask<String, Integer, Long> {

    final String TAG;
    ProgressDialog dialog;
    Context context;

    public SimpleAsyncTask(Context context) {
        TAG = this.getClass().getName();
        this.context = context;
    }

    /**
     * UI thread から呼ばれる
     */
    @Override
    protected void onPreExecute() {
        Log.d(TAG, "onPreExecute");
        dialog = new ProgressDialog(context);
        dialog.setTitle("Please wait");
        dialog.setMessage("Simple work progress...");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setCancelable(true);
        dialog.setMax(100);
        dialog.setProgress(0);
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                Log.d(TAG, "Dialog onCancel... calling cancel(true)");
                SimpleAsyncTask.this.cancel(true);
            }
        });
        dialog.show();
    }

    /**
     * Worker thread から呼ばれる
     */
    @Override
    protected Long doInBackground(String... params) {
        Log.d(TAG, "doInBackground - " + params[0]);

        try {
            for (int i = 0; i < 10; i ++) {
                // 定期的にキャンセル要求が無いかを確認する
                if (isCancelled()) {
                    Log.d(TAG, "Canceled!");
                    break;
                }
                Thread.sleep(1000);
                publishProgress((i + 1) * 10);
            }
        }
        catch (InterruptedException exp) {
            Log.d(TAG, "InterruptedException in doInBackground.");
        }
        return 123L; // この値はonPostExecute()の引数の値になる
    }

    /**
     * UI thread から呼ばれる
     */
    @Override
    protected void onProgressUpdate(Integer... values) {
        Log.d(TAG, "onProgressUpdate - " + values);
        dialog.setProgress(values[0]);
    }

    /**
     * UI thread から呼ばれる
     */
    @Override
    protected void onCancelled() {
        Log.d(TAG, "onCanceled");
        dialog.dismiss();
    }

    /**
     * UI thread から呼ばれる
     */
    @Override
    protected void onPostExecute(Long result) {
        Log.d(TAG, "onPostExecute - " + result);
        dialog.dismiss();
    }
}
