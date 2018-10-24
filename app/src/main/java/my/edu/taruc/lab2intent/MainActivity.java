package my.edu.taruc.lab2intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG_MESSAGE = "my.edu.taruc.lab2intent.MESSAGE";
    private static final int REQUEST_REPLYCODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        EditText editTextMessage;
        editTextMessage = findViewById(R.id.editTextReply);
        //Input validation here
        if(TextUtils.isEmpty(editTextMessage.getText())){
            editTextMessage.setError(getString(R.string.error_message));
            return;
        }

        //Explicit Intent
        Intent intent = new Intent(this, SecondActivity.class);
        String stringMessage;
        stringMessage = editTextMessage.getText().toString();
        intent.putExtra(TAG_MESSAGE, stringMessage);
        startActivityForResult(intent, REQUEST_REPLYCODE);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_REPLYCODE){
            if(resultCode == RESULT_OK){
                TextView textViewReply;
                textViewReply = findViewById(R.id.textViewReply);
                String stringReply = data.getStringExtra(SecondActivity.TAG_REPLY);
                textViewReply.setText(stringReply);
            }
        }
    }
}
