package nci.wherenow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.*;


import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.GraphJSONObjectCallback;
import com.facebook.GraphResponse;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class Social extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);
        createDatabase();
        TextView view1 = (TextView) findViewById(R.id.text1);
        ///   String message = createDatabase().child[0]("Users");
        ///   view1.setText(accessToken);
        /// String message = myData;
        // view1.setText(message);
        ///   final public String token = accessToken.getToken();
        ///  view1.setText(token);
        apiRequest();
        ///view1.setText(token);

    }

    public DatabaseReference createDatabase() {
        DatabaseReference myData;
        FirebaseDatabase myDatabase = FirebaseDatabase.getInstance();
        myData = myDatabase.getReference();
        myData.child("Users").child("userID").setValue(666);
        myData.child("Users").child("Name").setValue("Mike Hunt");
        return myData;
    }


    public void apiRequest() {
        GraphRequest request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(),
                new GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(
                            JSONObject object,
                            GraphResponse response) {
                        JSONObject result = response.getJSONObject();
                ///        JSONArray array = result.getJSONArray("array");
                        try {
                            String cunt = result.getString("id");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        String result1 = result.toString();
                        TextView view1 = (TextView) findViewById(R.id.text1);
                        view1.setText(cunt);
                        // Application code
                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,link");
        request.setParameters(parameters);
        request.executeAsync();
}}
