package sg.edu.tp.musicstream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    //go to login page
    public void doNextPage (View view)
    {
        Intent np = new Intent(this, LoginActivity.class);
        startActivity(np);
    }
}
