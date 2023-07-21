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
    private GUIHelper mHelper;    // Helper to run calculation
    private EditText mResult;     // Shows the number displays

    /**
     * Called when the app is created
     * @param savedInstanceState - keeps the last state of the app
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializes the Helper, Result and Ads
        mResult = findViewById(R.id.screen);
        mHelper = new GUIHelper();
        // Manages ads in the app
        AdsManager adsManager = new AdsManager(this);

        mResult.setEnabled(false);
        mResult.setKeyListener(null);
        mResult.setText("0.0");

        // Creation of ads on the program
        AdView adView = findViewById(R.id.adMobBanner);
        adsManager.createAds(adView);
    }

    /**
     * Updates the view of the app based on button input
     * @param view - Input from the buttons
     */
   public void buttonClick(View view) {
        String numButton = ((Button) view).getText().toString();
        mResult.setText(mHelper.addKey(numButton));
    }
}
