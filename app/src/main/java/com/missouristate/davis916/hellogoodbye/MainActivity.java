/*
Laura Davis CIS 262-902
2 February 2018
This simple app says "hello" when it is opened
then says "goodbye" when the button is tapped.
*/

package com.missouristate.davis916.hellogoodbye;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declare text reference to the interface layout component
    private TextView greetingTextView;

    //Indicates hello is currently displayed
    private boolean isHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Inflate the main screen layout used by the app
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Establish references to the TextView and the Button
        greetingTextView = (TextView) findViewById(R.id.textView);

        //Initialize greetings
        initializeGreeting();

        //Register the listener event for the button
        Button exclaimBtn = (Button) findViewById(R.id.button);
        exclaimBtn.setOnClickListener(toggleGreeting);
    }//end onCreate

    private final View.OnClickListener toggleGreeting = new View.OnClickListener(){

        //Creates onClick toggle with if-else statement
        public void onClick (View btn){
            //Construct the toggle greeting
            if (isHello){
                isHello = false;
                greetingTextView.setText(R.string.goodbye);
            } else{
                isHello = true;
                greetingTextView.setText(R.string.hello);
            }
        }//end onClick
    }; //end View.OnClickListener

    //initializes the greeting as "true"
    private void initializeGreeting(){
        isHello = true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        /*
        inflate the menu
        this adds items to the action bar if it is present
        menu_main.xml must be created, even if it is "empty"
        */
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }//end onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        /*Handle action bar item clicks here. The action bar
        will automatically handle clicks on the Home/Up button
        as long as a parent activity is specified in the
        AndroidManifest.xml
         */
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }//end onOptionsItemSelected

}//end of MainActivity
