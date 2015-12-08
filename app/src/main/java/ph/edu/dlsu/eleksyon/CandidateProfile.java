package ph.edu.dlsu.eleksyon;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kevincepria on 12/8/2015.
 */
public class CandidateProfile extends CandidateList{
MyDatabase db;Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.candidate_profile);
        ImageView pic=(ImageView)findViewById(R.id.candidatepic) ;
        TextView name=(TextView)findViewById(R.id.Name);
        TextView position=(TextView)findViewById(R.id.Position);
        TextView party=(TextView)findViewById(R.id.Party);
        TextView education=(TextView)findViewById(R.id.edub);
        TextView politics=(TextView)findViewById(R.id.polb);
        Intent intent=getIntent();
        String x= intent.getStringExtra("choice");
        System.out.print(x);
        db= new MyDatabase(this);
        cursor=db.setSearchCursor(x);
        cursor.moveToFirst();

         int   REsid = getResources().getIdentifier(cursor.getString(2).toString(), "drawable", getPackageName());
        pic.setImageResource(REsid);
        name.setText(cursor.getString(1));
       position.setText(cursor.getString(3));
      party.setText(cursor.getString(4));
        String s= cursor.getString(5).replace("\\n"," \n");
       education.setText(s.replace("\\",""));
        String r=cursor.getString(6).replace("\\n","\n");
       politics.setText(r.replace("\\",""));

}


}