package frent.nobos.rpncalc;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.ads.AdView;



/**
 * Main Class of the App
 * @author Noah Boyers
 * last edited: 2021-04-10
 */
public class RPNCalcActivity extends AppCompatActivity {
    private  GUIHelper mHelper;   // Helper to run calculation
    public AdsManager adsManager; // Runs Calculations
    private EditText mResult;     // Shows the number displays

    /**
     * on the app's creations runs this method
     * @param savedInstanceState - keeps the last state of the app
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initializes the Helper, Result and Ads
        mResult = new EditText(this);
        mHelper = new GUIHelper();
        adsManager = new AdsManager(this);

        mResult.setKeyListener(null);
        // Sets up the screen to say 0.0
        setContentView(R.layout.activity_main);
        mResult = findViewById(R.id.screen);
        mResult.setEnabled(false);
        mResult.setKeyListener(null);
        mResult.setText("0.0");

        //Creation of ads on the program
        AdView adView = findViewById(R.id.adMobBanner);
        adsManager.createAds(adView);
    }

    /**
     * Method that updates the view of the app
     * @param view - Input from the buttons
     */
    public void buttonClick(View view) {
            String numButton = ((Button) view).getText().toString();
            mResult.setText(mHelper.addKey(numButton));
    }
}

