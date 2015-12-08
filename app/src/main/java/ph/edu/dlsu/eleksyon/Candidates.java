package ph.edu.dlsu.eleksyon;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by kevincepria on 11/24/2015.
 */
public class Candidates extends AppCompatActivity {
   private final String presidents[]={"santiago","binay","duterte","roxas"};
   private final String vpresidents[]={"marcos","escudero","robredo","trillanes","honasan","cayetano"};
    private int i=0;
   private  int j=0;
   private int REsid;
    private int REsid2;
    private int choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.candidates_layout);
        final Animation fadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        final Animation fadeOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadeout);
        final ImageView pres=(ImageView)findViewById(R.id.President);
        final ImageView vpres=(ImageView)findViewById(R.id.imageView3);

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(i==4){
                    i=0;
                }
                if(j==6){
                    j=0;
                }

                REsid = getResources().getIdentifier(presidents[i], "drawable", getPackageName());
                REsid2=getResources().getIdentifier(vpresidents[j], "drawable", getPackageName());

                fadeIn.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                        pres.setVisibility(View.VISIBLE);
                        vpres.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        pres.startAnimation(fadeOut);
                        vpres.startAnimation(fadeOut);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                fadeOut.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
//                        pres.setVisibility(View.INVISIBLE);
                        pres.setImageResource(REsid);
                        vpres.setImageResource(REsid2);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                pres.startAnimation(fadeIn);
                vpres.startAnimation(fadeIn);


                i=i+1;
                j=j+1;
                handler.postDelayed(this, 4050);

            }
        });
        ImageButton a= (ImageButton) findViewById(R.id.PresCands);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), CandidateList.class);
                choice=0;
                intent.putExtra("choice", choice);
                startActivity(intent);



            }
        });

        ImageButton b= (ImageButton) findViewById(R.id.imageButton3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), CandidateList.class);
                choice=1;
                intent.putExtra("choice", choice);
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            startActivity(new Intent(this,
                    About.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public int getChoice(){
        return choice;
    }
}
