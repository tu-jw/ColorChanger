package temple.edu.colorchanger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {

    ArrayList<String> colors;
    Spinner spinner;
    TextView greetingTextView;
    ConstraintLayout cLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.colorSpinner);
        colors = new ArrayList<>();
        cLayout = (ConstraintLayout)findViewById(R.id.constraintLayout);

        // red, blue, green, black, white, gray, cyan, magenta, yellow, lightgray, darkgray, grey, lightgrey, darkgrey, aqua, fuchsia, lime, maroon, navy, olive, purple, silver, and teal
        colors.add("WHITE");
        colors.add("GREY");
        colors.add("FUCHSIA");
        colors.add("RED");
        colors.add("YELLOW");
        colors.add("LIME");
        colors.add("GREEN");
        colors.add("CYAN");
        colors.add("BLUE");
        colors.add("NAVY");
        colors.add("MAROON");
        colors.add("PURPLE");
        colors.add("BLACK");

        final BaseAdapter adapter = new ColorAdapter(this, colors);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object selectedView;
                if(parent.getItemAtPosition(position) == null){
                    selectedView = parent.getItemAtPosition(0);
                }
                else{
                    selectedView = parent.getItemAtPosition(position);
                    view.setBackgroundColor(Color.parseColor("white"));
                    cLayout.setBackgroundColor(Color.parseColor(selectedView.toString().toLowerCase()));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ColorActivity.this, "Make a selection for the background.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}