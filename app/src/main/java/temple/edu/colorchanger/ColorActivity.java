package temple.edu.colorchanger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {

    ArrayList<String> colors;
    Spinner spinner;
    TextView greetingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.colorSpinner);
        colors = new ArrayList<>();
        colors.add("Blue");
        colors.add("Green");
        colors.add("Red");
        colors.add("Yellow");

        final BaseAdapter adapter = new ColorAdapter(this, colors);
        spinner.setAdapter(adapter);

        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                greetingTextView.setText(parent.getItemAtPosition(position).toString());
            }
        });
    }
}