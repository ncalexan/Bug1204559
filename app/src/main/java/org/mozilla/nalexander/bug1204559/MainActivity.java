package org.mozilla.nalexander.bug1204559;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.simple.parser.JSONParser;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
    }

    public void onClickParse(View view) {
        final String input = editText.getText().toString();
        boolean good = false;
        try {
            System.out.println("Starting new parse of input: '" + input + "'");
            new JSONParser().parse(input);
            good = true;
        } catch (Throwable e) {
            Log.w("Bug1204559", "Got throwable parsing input; ignoring.", e);
        }

        final String output = good ? "Good" : "Bad!";
        final int color = good ? Color.GREEN : Color.RED;

        final Snackbar snackbar = Snackbar.make(view, output, Snackbar.LENGTH_SHORT);
        View snackBarView = snackbar.getView();
        snackBarView.setBackgroundColor(color);

        snackbar.show();
    }
}
