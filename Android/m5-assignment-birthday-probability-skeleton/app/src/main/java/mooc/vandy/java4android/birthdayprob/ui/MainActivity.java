package mooc.vandy.java4android.birthdayprob.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.diamonds.R;
import mooc.vandy.java4android.birthdayprob.logic.Logic;
import mooc.vandy.java4android.birthdayprob.logic.LogicInterface;

/**
 * Main UI for the App.
 */
public class MainActivity 
       extends AppCompatActivity 
       implements OutputInterface {
    /**
     * String for LOGGING.
     */
    public final static String LOG_TAG =
        MainActivity.class.getCanonicalName();

    /**
     * Logic Instance.
     */
    private LogicInterface mLogic;

    /**
     * EditText that stores the output.
     */
    private EditText mOutput;

    /**
     * EditText that stores the size.
     */
    private EditText mSize;

    /**
     * EditText that stores the count.
     */
    private EditText mCount;

    /**
     * Button the user presses to perform the computation.
     */
    private Button mProcessButton;

    /**
     * Called when the activity is starting.
     *
     * Similar to 'main' in C/C++/Standalone Java
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // required
        super.onCreate(savedInstanceState);

        // create a new 'Logic' instance.
        mLogic = new Logic(this);

        // setup the UI.
        initializeUI();
    }

    /**
     * This method sets up/gets reference to the UI components
     */
    private void initializeUI(){
        // Set the layout.
        setContentView(R.layout.activity_main);

        // Initialize the views.
        mOutput = (EditText) findViewById(R.id.outputET);
        mSize = (EditText) findViewById(R.id.editTextGroupSize);
        mCount = (EditText) findViewById(R.id.editTextCount);
        mProcessButton = (Button) findViewById(R.id.button);
    }

    /**
     * Called when Button is Pressed.
     *
     * @param buttonPress
     */
    public void buttonPressed(View buttonPress) {
        resetText();
        mLogic.process();
    }

    /**
     * Add @a string to the EditText.
     */
    private void addToEditText(String string) {
        mOutput.setText("" + mOutput.getText() + string);
    }

    /**
     * Get Size value from displayed UI.
     */
    public int getSize(){
        int value = 0; 
        final String strValue =
            mSize.getText().toString();

        if (strValue != null 
            && !strValue.isEmpty())
            value = Integer.valueOf(strValue);
        return value;
    }

    /**
     * Get Count value from displayed UI.
     */
    public int getCount(){
        int value = 0; 
        final String strValue = 
            mCount.getText().toString();

        if (strValue != null 
            && !strValue.isEmpty())
            value = Integer.valueOf(strValue);
        return value;
    }

    /**
     * This prints to the output a string
     * @param text
     */
    @Override
    public void print(String text) {
        Log.d(LOG_TAG, "print(String)");
        addToEditText(text);
    }

    /**
     * This prints to the output a char
     * @param _char
     */
    @Override
    public void print(char _char) {
        print("" + _char);
    }

    /**
     * This prints to the screen a string then a new line
     * @param text
     */
    @Override
    public void println(String text) {
        Log.d(LOG_TAG,"println(String)");
        addToEditText(text + "\n");
    }

    /**
     * This prints to the screen a char then a new line
     * @param _char
     */
    @Override
    public void println(char _char) {
		println("" + _char);
    }

    /**
     * Reset the on-screen output (EditText box)
     */
    @Override
    public void resetText() {
        mOutput.setText("");
    }

    /**
     * Make Log statements from Logic
     */
    @Override
    public void log(String logtext) {
        Log.d(Logic.TAG, logtext);
    }

    /**
     * Make a Toast from Logic
     */
    @Override
    public void makeAlertToast(String alertText) {
        Toast.makeText(this,alertText,Toast.LENGTH_LONG);
    }
}

