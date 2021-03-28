package frent.nobos.rpncalc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.ads.AdView;



/**
 * Main Class of the App
 * @author Noah Boyers
 * last edited: 16-03-2021
 */
public class RPNCalcActivity extends AppCompatActivity {

    private final GUIHelper mHelper = new GUIHelper();  // Helper to run calculations
    private EditText mResult;                     // Edits the screen for user


    /**
     * on the app's creations runs this method
     * @param savedInstanceState - keeps the last state of the app
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_rpn_calc);
        mResult = findViewById(R.id.screen);
        mResult.setText("0.0");
        AdView adView = findViewById(R.id.adMobBanner);
        AdsManager adsManager = new AdsManager(this);
        adsManager.createAds(adView);
    }

    /**
     * Method that updates the view of the app
     * @param view - Input from the buttons
     */
    public void buttonClick(View view) {
        String numButton = ((Button)view).getText().toString();
        mResult.setText(mHelper.addKey(numButton));
    }
}
