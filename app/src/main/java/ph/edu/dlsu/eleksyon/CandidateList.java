package ph.edu.dlsu.eleksyon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by kevincepria on 11/24/2015.
 */
public class CandidateList extends Candidates {

    private ListView Options;
   // private CustomAdapter adapter;
    private ArrayAdapter<String> adapter;
    private String Presidentials[]={"Miriam Defensor Santiago","Jejomar Cabuatan Binay, Sr.","Rodrigo Roa Duterte","Manuel Araneta Roxas"};
    private int[] presImg={R.drawable.santiago,R.drawable.binay,R.drawable.duterte,R.drawable.roxas};
    private String VPresidentials[]={"Alan Peter Cayetano","Antonio Fuentes Trillanes IV","Ferdinand Romualdez Marcos, Jr.","Francis Joseph Guevara Escudero","Gregorio Ballesteros Honasan II","Maria Leonor Gerona Robredo"};
    private int [] vpresImg={R.drawable.cayetano,R.drawable.trillanes,R.drawable.marcos,R.drawable.escudero,R.drawable.honasan,R.drawable.robredo};
    private int index, z;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.candidate_list);
        Options = (ListView) findViewById(R.id.listView);
        Intent intent=getIntent();
        int x = intent.getIntExtra("choice",9);
        adapter=new ArrayAdapter<>(this,R.layout.list_text, Presidentials);
        switch (x){
            case 0:
                adapter=new ArrayAdapter<>(this,R.layout.list_text, Presidentials);
//                Options.setAdapter(new CustomAdapter(this, Presidentials,presImg));
//               Options.setOnItemClickListener(new
//
//            Options.setAdapter(new CustomAdapter(this, Presidentials,presImg));
//                Options.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        Intent intent = new Intent(getBaseContext(), CandidateProfile.class);;
//                        String temp = Presidentials[position];
//                        intent.putExtra("choice",Presidentials[position]);
//                        Toast.makeText(getBaseContext(), temp, Toast.LENGTH_LONG).show();
//
//                startActivity(intent);
//                    }
//                });
                break;
            case 1:
                adapter=new ArrayAdapter<>(this,R.layout.list_text, VPresidentials);
//                adapter = new CustomAdapter(this, VPresidentials,vpresImg);
//                Options.setAdapter();
//                Options.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        Intent intent = new Intent(getBaseContext(), CandidateProfile.class);;
//                        String temp = VPresidentials[position];
//                        intent.putExtra("choice",VPresidentials[position]);
//                        Toast.makeText(getApplicationContext(), temp, Toast.LENGTH_LONG).show();
//
//                        startActivity(intent);
//                    }
//                });
                break;
        }
        Options.setAdapter(adapter);
        Options.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(getBaseContext(), CandidateProfile.class);;
            String temp = (String) Options.getItemAtPosition(position);
            intent.putExtra("choice",temp);
            Toast.makeText(getApplicationContext(), temp, Toast.LENGTH_LONG).show();

          startActivity(intent);
        }
    });


    }
}
