package com.example.cognito_tutorial;

import android.content.Context;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amazonaws.regions.Regions;

/**
 * This class is to help set attributes for a user pool
 * and create an instance of CognitoUserPool
 */
public class AppHelper {

    private static AppHelper sharedInstance = null;

    private AppHelper() { }

    public static AppHelper getInstance() {
        if (sharedInstance == null)
            sharedInstance = new AppHelper();

        return sharedInstance;
    }

    private CognitoUserPool userPool;

    private final String userPoolId = "us-east-1_03oO0EspQ";

    private final String clientId = "37sgopkqdsj92r421n3bqenuop";

    private final String clientSecret = "1rk8bnnbrttv0outic6q81foags7933q93co7csbsgsekj8orrgm";


    private final Regions cognitoRegion = Regions.DEFAULT_REGION;


    public void init(Context context) {
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        userPool = new CognitoUserPool(context,userPoolId ,clientId ,clientSecret , clientConfiguration);
    }

    public CognitoUserPool getUserPool() {
        return userPool;
    }


}
