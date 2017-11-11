package example.com.apptesisv1;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.os.RecoverySystem;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOExceptionWithCause;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class SplashScreen extends Activity {

    private GifImageView gifImageView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        gifImageView = (GifImageView) findViewById(R.id.gifimageView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(progressBar.VISIBLE);

        try{
            InputStream inputStream = getAssets().open("diente.gif");
            byte[] bytes= IOUtils.toByteArray(inputStream);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();
        }
        catch (IOException EX)
        {

        }


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SplashScreen.this.startActivity(new Intent(SplashScreen.this,MainActivity.class));
                SplashScreen.this.finish();
                //Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                //startActivity(intent);
            }
        },4000);
    }
}
