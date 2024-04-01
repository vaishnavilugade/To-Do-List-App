import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> itemList;
    private ArrayAdapter<String> adapter;
    private EditText itemEditText;
    private ListView itemListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);

        itemEditText = findViewById(R.id.itemEditText);
        itemListView = findViewById(R.id.itemListView);
        itemListView.setAdapter(adapter);
    }

    public void addItem(View view) {
        String newItem = itemEditText.getText().toString();
        if (!newItem.isEmpty()) {
            itemList.add(newItem);
            adapter.notifyDataSetChanged();
            itemEditText.setText("");
        }
    }

    public void clearList(View view) {
        itemList.clear();
        adapter.notifyDataSetChanged();
    }
}
