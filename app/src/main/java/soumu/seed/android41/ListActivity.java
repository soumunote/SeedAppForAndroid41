package soumu.seed.android41;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class ListActivity extends android.app.ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] listViewItem = getResources().getStringArray(R.array.list_activity_items);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, R.layout.activity_list_item,listViewItem);
        setListAdapter(adapter);
    }
}
