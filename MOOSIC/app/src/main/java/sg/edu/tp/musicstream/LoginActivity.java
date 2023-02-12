package sg.edu.tp.musicstream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import sg.edu.tp.musicstream.util.AppUtil;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void doLogin (View view)
    {
        TextView tvName = (TextView)findViewById(R.id.txtName); //find the username TextView component
        String username= tvName.getText().toString(); //get the text that the user entered at the TextView

        TextView tvPW = (TextView)findViewById(R.id.txtPW); //find the the password textview component
        String password = tvPW.getText().toString(); //get the text that the user entered at the textview

        if (username.equals("liquid") && password.equals("1234")) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else
        {
            AppUtil.popMessage(this, "Invalid username or password");
        }
    }
}
