package frent.nobos.rpncalc;

import android.content.Context;
import android.widget.Toast;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;

public class AdsManager {

    private final Context ctx;

    public AdsManager(Context context){
        this.ctx = context;
        MobileAds.initialize(ctx, initializationStatus -> {});

    }
    public void createAds(AdView adView) {
        AdRequest adRequest = new AdRequest.Builder().build();

        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                super.onAdLoaded();
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
                super.onAdFailedToLoad(adError);
                Toast.makeText(ctx,""+adError.getCode(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });
        adView.loadAd(adRequest);


    }
}
