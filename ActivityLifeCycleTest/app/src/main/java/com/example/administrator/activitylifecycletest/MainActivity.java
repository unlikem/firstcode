package com.example.administrator.activitylifecycletest;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;
    private boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        Button button1 = (Button) findViewById(R.id.button_1);
        Button button2 = (Button) findViewById(R.id.button_2);
        Button button3 = (Button) findViewById(R.id.button_3);

        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                String inputText = editText.getText().toString();
                Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_1:
//               Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();
                if (flag) {
                    imageView.setImageResource(R.drawable.img_2);
                    flag = false;
                }
                else{
                    imageView.setImageResource(R.drawable.img_1);
                    flag = true;
                }
                break;
            case R.id.button_2:
//                Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
                int progress = progressBar.getProgress();
                progress = progress + 10;
                if (progress > 100) {
                    progress = 0;
                }
                progressBar.setProgress(progress);
                break;
            case R.id.button_3:
//                Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            default:
                break;
        }
    }
}
