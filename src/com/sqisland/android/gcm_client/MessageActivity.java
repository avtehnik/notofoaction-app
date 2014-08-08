package com.sqisland.android.gcm_client;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.TextView;

public class MessageActivity extends Activity {
  private TextView mMessageView;

  private CheckBox komnata1;
  private CheckBox komnata2;
  private CheckBox balkon1;
  private CheckBox balkon2;
  private CheckBox dor1;
  
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_message);
    mMessageView = (TextView) findViewById(R.id.message);
    komnata1 = (CheckBox) findViewById(R.id.komnata_1);
    komnata2 = (CheckBox) findViewById(R.id.komnata_2);
    balkon1 = (CheckBox) findViewById(R.id.balkon_1);
    balkon2 = (CheckBox) findViewById(R.id.balkon_2);
    dor1 = (CheckBox) findViewById(R.id.dor1);
        
  }

  @Override
  public void onResume() {
    super.onResume();
    String msg = getIntent().getStringExtra(Constants.FIELD_MESSAGE);
    String data = getIntent().getStringExtra(Constants.FIELD_DATA);
    
    
    JSONObject jObject;
	try {
		jObject = new JSONObject(data);
		
		komnata1.setChecked(jObject.getBoolean("komnata1"));//13
		komnata2.setChecked(jObject.getBoolean("komnata2")); //14 
		balkon1.setChecked(jObject.getBoolean("balkon1"));//8
		balkon2.setChecked(jObject.getBoolean("balkon2"));//15
		dor1.setChecked(jObject.getBoolean("dor1"));//15
		
		
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    mMessageView.setText(msg);
  }
}