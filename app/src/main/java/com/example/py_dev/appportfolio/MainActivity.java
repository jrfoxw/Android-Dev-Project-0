package com.example.py_dev.appportfolio;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.content.Context;
import android.widget.Button;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {


    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set Button id //
        Button spotifyApp = (Button) findViewById(R.id.spotifyApp);
        Button scoresApp = (Button) findViewById(R.id.scoresApp);
        Button libraryApp = (Button) findViewById(R.id.libraryApp);
        Button biggerApp = (Button) findViewById(R.id.biggerApp);
        Button readerApp = (Button) findViewById(R.id.readerApp);
        Button capstoneApp = (Button) findViewById(R.id.capstoneApp);


        final String[] buttonsToast = {
                "Spotify Streamer",
                "Scores App",
                "Library App",
                "Build it Bigger App",
                "XYZ Reader",
                "Capstone App"
        };
        final Button[] Buttons = {
                spotifyApp,
                scoresApp,
                libraryApp,
                biggerApp,
                readerApp,
                capstoneApp
        };

        for (int items = 0; items < Buttons.length; items++) {

            final int fItems = items;
            Buttons[items].setOnClickListener
            (new Button.OnClickListener() {
                        public void onClick(View v) {

                            Context context = getApplicationContext();
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context,
                                    "This button will launch my " + buttonsToast[fItems] + "!",
                                    duration);
                            toast.show();
                        }
                    }

            );
        }

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.py_dev.appportfolio/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.py_dev.appportfolio/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}



