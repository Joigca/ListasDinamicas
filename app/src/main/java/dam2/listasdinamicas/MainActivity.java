package dam2.listasdinamicas;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {

    Spinner spPaises, spCiudades;
    final static String TAG = "Jose";
    ArrayAdapter<String> adap_paises, adap_ciudades;
    ArrayList<String> ac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spPaises = (Spinner) findViewById(R.id.spPaises);
        String array_paises[] = getResources().getStringArray(R.array.paises);

        //ArrayList para añadir mas elementos si se necesitase
        ArrayList<String> ap = new ArrayList<String>(Arrays.asList(array_paises));
        adap_paises = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,ap);
        spPaises.setAdapter(adap_paises);

        adap_ciudades = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        ac = new ArrayList<String>();

        spPaises.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0: //España

                        ac = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.ciudades_espanya)));
                        break;

                    case 1: //Francia

                        ac = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.ciudades_francia)));
                        break;

                    case 2: //Alemania

                        ac = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.ciudades_alemania)));
                        break;

                    case 3: //Italia

                        ac = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.ciudades_italia)));
                        break;

                }
                adap_ciudades.clear();
                adap_ciudades.addAll(ac);
                spCiudades.setAdapter(adap_ciudades);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

       /* spPaises.setOnItemListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0: //España

                        ac = (ArrayList<String>) Arrays.asList(getResources().getStringArray(R.array.ciudades_espanya));
                        break;

                    case 1: //Francia

                        ac = (ArrayList<String>) Arrays.asList(getResources().getStringArray(R.array.ciudades_francia));
                        break;

                    case 2: //Alemania

                        ac = (ArrayList<String>) Arrays.asList(getResources().getStringArray(R.array.ciudades_alemania));
                        break;

                    case 3: //Italia

                        ac = (ArrayList<String>) Arrays.asList(getResources().getStringArray(R.array.ciudades_italia));
                        break;

                }

                adap_ciudades.addAll(ac);
                spCiudades.setAdapter(adap_ciudades);

            }
        });
    */
        adap_paises.add("Portugal");
        adap_paises.notifyDataSetChanged();//Aunque ya lo ejecute el método add, es aconsejable actualizar.

        spCiudades = (Spinner) findViewById(R.id.spCiudades);

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
