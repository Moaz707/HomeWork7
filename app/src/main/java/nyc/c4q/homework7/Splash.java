package nyc.c4q.homework7;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.waynell.library.DropAnimationView;

public class Splash extends AppCompatActivity {


    private TextView tv;
    private ImageView iv;
    private Animation myanim;
    private Button goPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tv = (TextView) findViewById(R.id.tv);
        iv = (ImageView) findViewById(R.id.iv);
        goPlay = (Button) findViewById(R.id.goPlay);
        myanim = AnimationUtils.loadAnimation(this, R.anim.mytranstion);
        DropAnimationView view = (DropAnimationView) findViewById(R.id.drop_animation_view);
        view.setDrawables(R.drawable.star1,
                R.drawable.star2,
                R.drawable.whitesnow1,
                R.drawable.whitesnow2,
                R.drawable.greenstar1);
        view.startAnimation();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                iv.startAnimation(myanim);
            }
        }, 600);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tv.setText("Welcom to My Simon's Game");
                tv.startAnimation(myanim);
                goPlay.setVisibility(View.VISIBLE);
            }
        }, 1200);


        final Intent intent = new Intent(this, MainActivity.class);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    goPlay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(intent);

                        }
                    });

                }
            }
        };
        timer.start();
    }
}
