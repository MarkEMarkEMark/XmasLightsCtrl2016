package uk.co.kicktechnic.xmaslightsctrl2016;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ControllerActivity extends AppCompatActivity {

    String photonFunction = "xmasControl";
    static final String deviceID_jetpack_monkey = "xxx"; // put your device IDs here e.g. '999930000b47343388883738'
    static final String deviceID_scraper_gerbil = "yyy";
    static final String deviceID_dozen_crazy = "zzz";
    String accessToken = "aaaa"; //put your access token here e.g. '999a3374b0adacec1063d485938887777e1cb4c3'
    String deviceIDCurrent = deviceID_jetpack_monkey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controller);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Settings (step through Particle Photon devices)
        final Button buttonSettings = (Button) findViewById(R.id.buttonSettings);
        View.OnClickListener bSettingsListener = new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                switch (deviceIDCurrent) {
                    case deviceID_jetpack_monkey:
                        deviceIDCurrent = deviceID_scraper_gerbil;
                        Toast.makeText(ControllerActivity.this, "scarper gerbil", Toast.LENGTH_SHORT).show(); //rename to your device names here
                        break;
                    case deviceID_scraper_gerbil:
                        deviceIDCurrent = deviceID_dozen_crazy;
                        Toast.makeText(ControllerActivity.this, "dozen crazy", Toast.LENGTH_SHORT).show();
                        break;
                    case deviceID_dozen_crazy:
                        deviceIDCurrent = deviceID_jetpack_monkey;
                        Toast.makeText(ControllerActivity.this, "jetpack monkey", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
        buttonSettings.setOnClickListener(bSettingsListener);

        //On
        final Button buttonOn = (Button) findViewById(R.id.buttonOn);
        View.OnClickListener bOnListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("ON");
            }
        };
        buttonOn.setOnClickListener(bOnListener);

        //Off
        final Button buttonOff = (Button) findViewById(R.id.buttonOff);
        View.OnClickListener bOffListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("OFF");
            }
        };
        buttonOff.setOnClickListener(bOffListener);

        //Random
        final Button buttonRand = (Button) findViewById(R.id.buttonRand);
        View.OnClickListener bRandListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("RAND");
            }
        };
        buttonRand.setOnClickListener(bRandListener);

        //Sequenced
        final Button buttonSeq = (Button) findViewById(R.id.buttonSeq);
        View.OnClickListener bSeqListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("SEQ");
            }
        };
        buttonSeq.setOnClickListener(bSeqListener);

        //Program Up
        final Button buttonProgUp = (Button) findViewById(R.id.buttonProgUp);
        View.OnClickListener bProgUpListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("Pp");
            }
        };
        buttonProgUp.setOnClickListener(bProgUpListener);

        //Program Down
        final Button buttonProgDown = (Button) findViewById(R.id.buttonProgDown);
        View.OnClickListener bProgDownListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("Pm");
            }
        };
        buttonProgDown.setOnClickListener(bProgDownListener);

        //Variation Up
        final Button buttonVarUp = (Button) findViewById(R.id.buttonPattUp);
        View.OnClickListener bVarUpListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("Vp");
            }
        };
        buttonVarUp.setOnClickListener(bVarUpListener);

        //Variation Down
        final Button buttonVarDown = (Button) findViewById(R.id.buttonPattDown);
        View.OnClickListener bVarDownListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("Vm");
            }
        };
        buttonVarDown.setOnClickListener(bVarDownListener);

        //Fade Up
        final Button buttonFadeUp = (Button) findViewById(R.id.buttonFadeUp);
        View.OnClickListener bFadeUpListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("Fp");
            }
        };
        buttonFadeUp.setOnClickListener(bFadeUpListener);

        //Fade Down
        final Button buttonFadeDown = (Button) findViewById(R.id.buttonFadeDown);
        View.OnClickListener bFadeDownListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("Fm");
            }
        };
        buttonFadeDown.setOnClickListener(bFadeDownListener);

        //Program 01
        final Button buttonP01 = (Button) findViewById(R.id.buttonP01);
        View.OnClickListener bP01Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P01");
            }
        };
        buttonP01.setOnClickListener(bP01Listener);

        //Program 02
        final Button buttonP02 = (Button) findViewById(R.id.buttonP02);
        View.OnClickListener bP02Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P02");
            }
        };
        buttonP02.setOnClickListener(bP02Listener);

        //Program 03
        final Button buttonP03 = (Button) findViewById(R.id.buttonP03);
        View.OnClickListener bP03Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P03");
            }
        };
        buttonP03.setOnClickListener(bP03Listener);

        //Program 04
        final Button buttonP04 = (Button) findViewById(R.id.buttonP04);
        View.OnClickListener bP04Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P04");
            }
        };
        buttonP04.setOnClickListener(bP04Listener);

        //Program 05
        final Button buttonP05 = (Button) findViewById(R.id.buttonP05);
        View.OnClickListener bP05Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P05");
            }
        };
        buttonP05.setOnClickListener(bP05Listener);

        //Program 06
        final Button buttonP06 = (Button) findViewById(R.id.buttonP06);
        View.OnClickListener bP06Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P06");
            }
        };
        buttonP06.setOnClickListener(bP06Listener);

        //Program 07
        final Button buttonP07 = (Button) findViewById(R.id.buttonP07);
        View.OnClickListener bP07Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P07");
            }
        };
        buttonP07.setOnClickListener(bP07Listener);

        //Program 08
        final Button buttonP08 = (Button) findViewById(R.id.buttonP08);
        View.OnClickListener bP08Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P08");
            }
        };
        buttonP08.setOnClickListener(bP08Listener);

        //Program 09
        final Button buttonP09 = (Button) findViewById(R.id.buttonP09);
        View.OnClickListener bP09Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P09");
            }
        };
        buttonP09.setOnClickListener(bP09Listener);

        //Program 10
        final Button buttonP10 = (Button) findViewById(R.id.buttonP10);
        View.OnClickListener bP10Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P10");
            }
        };
        buttonP10.setOnClickListener(bP10Listener);

        //Program 11
        final Button buttonP11 = (Button) findViewById(R.id.buttonP11);
        View.OnClickListener bP11Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P11");
            }
        };
        buttonP11.setOnClickListener(bP11Listener);

        //Program 12
        final Button buttonP12 = (Button) findViewById(R.id.buttonP12);
        View.OnClickListener bP12Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P12");
            }
        };
        buttonP12.setOnClickListener(bP12Listener);

        //Program 13
        final Button buttonP13 = (Button) findViewById(R.id.buttonP13);
        View.OnClickListener bP13Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P13");
            }
        };
        buttonP13.setOnClickListener(bP13Listener);

        //Program 14
        final Button buttonP14 = (Button) findViewById(R.id.buttonP14);
        View.OnClickListener bP14Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P14");
            }
        };
        buttonP14.setOnClickListener(bP14Listener);

        //Program 15
        final Button buttonP15 = (Button) findViewById(R.id.buttonP15);
        View.OnClickListener bP15Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P15");
            }
        };
        buttonP15.setOnClickListener(bP15Listener);

        //Program 16
        final Button buttonP16 = (Button) findViewById(R.id.buttonP16);
        View.OnClickListener bP16Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P16");
            }
        };
        buttonP16.setOnClickListener(bP16Listener);

        //Program 17
        final Button buttonP17 = (Button) findViewById(R.id.buttonP17);
        View.OnClickListener bP17Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P17");
            }
        };
        buttonP17.setOnClickListener(bP17Listener);

        //Program 18
        final Button buttonP18 = (Button) findViewById(R.id.buttonP18);
        View.OnClickListener bP18Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P18");
            }
        };
        buttonP18.setOnClickListener(bP18Listener);

        //Program 19
        final Button buttonP19 = (Button) findViewById(R.id.buttonP19);
        View.OnClickListener bP19Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P19");
            }
        };
        buttonP19.setOnClickListener(bP19Listener);

        //Program 20
        final Button buttonP20 = (Button) findViewById(R.id.buttonP20);
        View.OnClickListener bP20Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P20");
            }
        };
        buttonP20.setOnClickListener(bP20Listener);

        //Program 21
        final Button buttonP21 = (Button) findViewById(R.id.buttonP21);
        View.OnClickListener bP21Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P21");
            }
        };
        buttonP21.setOnClickListener(bP21Listener);

        //Program 22
        final Button buttonP22 = (Button) findViewById(R.id.buttonP22);
        View.OnClickListener bP22Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P22");
            }
        };
        buttonP22.setOnClickListener(bP22Listener);

        //Program 23
        final Button buttonP23 = (Button) findViewById(R.id.buttonP23);
        View.OnClickListener bP23Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P23");
            }
        };
        buttonP23.setOnClickListener(bP23Listener);

        //Program 24
        final Button buttonP24 = (Button) findViewById(R.id.buttonP24);
        View.OnClickListener bP24Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P24");
            }
        };
        buttonP24.setOnClickListener(bP24Listener);

        //Program 25
        final Button buttonP25 = (Button) findViewById(R.id.buttonP25);
        View.OnClickListener bP25Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P25");
            }
        };
        buttonP25.setOnClickListener(bP25Listener);

        //Program 26
        final Button buttonP26 = (Button) findViewById(R.id.buttonP26);
        View.OnClickListener bP26Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P26");
            }
        };
        buttonP26.setOnClickListener(bP26Listener);

        //Program 27
        final Button buttonP27 = (Button) findViewById(R.id.buttonP27);
        View.OnClickListener bP27Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P27");
            }
        };
        buttonP27.setOnClickListener(bP27Listener);

        //Program 28
        final Button buttonP28 = (Button) findViewById(R.id.buttonP28);
        View.OnClickListener bP28Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P28");
            }
        };
        buttonP28.setOnClickListener(bP28Listener);

        //Program 29
        final Button buttonP29 = (Button) findViewById(R.id.buttonP29);
        View.OnClickListener bP29Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P29");
            }
        };
        buttonP29.setOnClickListener(bP29Listener);

        //Program 30
        final Button buttonP30 = (Button) findViewById(R.id.buttonP30);
        View.OnClickListener bP30Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("P30");
            }
        };
        buttonP30.setOnClickListener(bP30Listener);

        //Crossfade 01
        final Button buttonF01 = (Button) findViewById(R.id.buttonF01);
        View.OnClickListener bF01Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("F01");
            }
        };
        buttonF01.setOnClickListener(bF01Listener);

        //Crossfade 02
        final Button buttonF02 = (Button) findViewById(R.id.buttonF02);
        View.OnClickListener bF02Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("F02");
            }
        };
        buttonF02.setOnClickListener(bF02Listener);

        //Crossfade 03
        final Button buttonF03 = (Button) findViewById(R.id.buttonF03);
        View.OnClickListener bF03Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("F03");
            }
        };
        buttonF03.setOnClickListener(bF03Listener);

        //Crossfade 04
        final Button buttonF04 = (Button) findViewById(R.id.buttonF04);
        View.OnClickListener bF04Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("F04");
            }
        };
        buttonF04.setOnClickListener(bF04Listener);

        //Crossfade 05
        final Button buttonF05 = (Button) findViewById(R.id.buttonF05);
        View.OnClickListener bF05Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("F05");
            }
        };
        buttonF05.setOnClickListener(bF05Listener);

        //Crossfade 06
        final Button buttonF06 = (Button) findViewById(R.id.buttonF06);
        View.OnClickListener bF06Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostClient().execute("F06");
            }
        };
        buttonF06.setOnClickListener(bF06Listener);

        //Brightness
        final SeekBar seekBar01 = (SeekBar) findViewById(R.id.seekBar1);
        seekBar01.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int sb01progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar01, int progress01Value, boolean fromUser) {
                sb01progress = progress01Value;
                //Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar01) {
                //Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar01) {
                new PostClient().execute("SBA" + sb01progress);
                Toast.makeText(getApplicationContext(), "01: " + sb01progress + " / " + seekBar01.getMax(), Toast.LENGTH_SHORT).show();
            }
        });

        //Speed
        final SeekBar seekBar02 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar02.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int sb02progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar02, int progress02Value, boolean fromUser) {
                sb02progress = progress02Value;
                //Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar02) {
                //Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar02) {
                new PostClient().execute("SBB" + sb02progress);
                Toast.makeText(getApplicationContext(), "02: " + sb02progress + " / " + seekBar02.getMax(), Toast.LENGTH_SHORT).show();
            }
        });

        //Pattern change time?
        final SeekBar seekBar03 = (SeekBar) findViewById(R.id.seekBar3);
        seekBar03.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int sb03progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar03, int progress03Value, boolean fromUser) {
                sb03progress = progress03Value;
                //Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar03) {
                //Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar03) {
                new PostClient().execute("SBC" + sb03progress);
                Toast.makeText(getApplicationContext(), "03: " + sb03progress + " / " + seekBar03.getMax(), Toast.LENGTH_SHORT).show();
            }
        });

        //Fade change time?
        final SeekBar seekBar04 = (SeekBar) findViewById(R.id.seekBar4);
        seekBar04.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int sb04progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar04, int progress04Value, boolean fromUser) {
                sb04progress = progress04Value;
                //Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar04) {
                //Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar04) {
                new PostClient().execute("SBD" + sb04progress);
                Toast.makeText(getApplicationContext(), "04: " + sb04progress + " / " + seekBar04.getMax(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_controller, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




    // We must do this as a background task, elsewhere our app crashes
    class PostClient extends AsyncTask<String, Void, String> {
        public String doInBackground(String... IO) {

            // Predefine variables
            String io = new String(IO[0]);
            URL url;

            try {
                // Stuff variables
                url = new URL("https://api.spark.io/v1/devices/"+ deviceIDCurrent + "/" + photonFunction + "/");
                String param = "access_token=" + accessToken + "&params="+io;
                Log.d("TAG", "param:" + param);

                // Open a connection using HttpURLConnection
                HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

                con.setReadTimeout(7000);
                con.setConnectTimeout(7000);
                con.setDoOutput(true);
                con.setDoInput(true);
                con.setInstanceFollowRedirects(false);
                con.setRequestMethod("POST");
                con.setFixedLengthStreamingMode(param.getBytes().length);
                con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

                // Send
                PrintWriter out = new PrintWriter(con.getOutputStream());
                out.print(param);
                out.close();

                con.connect();

                BufferedReader in = null;
                if (con.getResponseCode() != 200) {
                    in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                    Log.d("TAG", "!=200: " + in);
                } else {
                    in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    Log.d("TAG", "POST request send successful: " + in);
                };


            } catch (Exception e) {
                Log.d("TAG", "Exception");
                e.printStackTrace();
                return null;
            }
            // Set null and we're good to go
            return null;
        }
    }
}
