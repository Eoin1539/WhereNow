package nci.wherenow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;



public class Social extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_social);
        super.onCreate(savedInstanceState);
        /*
        AccessToken accessToken = AccessToken.getCurrentAccessToken();


        createDatabase();
        TextView view1 = (TextView) findViewById(R.id.text1);
        ///   String messagein = createDatabase().child[0]("Users");
        ///   view1.setText(accessToken);
        /// String messagein = myData;
        // view1.setText(messagein);
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


    public void apiRequest1(String id) {
        GraphRequest request = GraphRequest.newGraphPathRequest(
                AccessToken.getCurrentAccessToken(),
                "/100025266171180/friends",
                new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse response) {
                        JSONObject object = response.getJSONObject();
                      ///  Log.d("Cunt", String.valueOf(object));
                        TextView view1 = (TextView) findViewById(R.id.text1);
                        view1.setText(String.valueOf(object));
                    }
                });

        request.executeAsync();

}

public void apiRequest(){
    GraphRequest request = GraphRequest.newMeRequest(
            AccessToken.getCurrentAccessToken(),
            new GraphJSONObjectCallback() {
                @Override
                public void onCompleted(
                        JSONObject object,
                        GraphResponse response) {
                    JSONObject result = response.getJSONObject();
                    ///        JSONArray array = result.getJSONArray("array");
                    String id = null;
                    try {
                        id = result.getString("id");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    ///String result1 = result.toString();
               ///     TextView view1 = (TextView) findViewById(R.id.text1);
                  ///  view1.setText(id);
                    apiRequest1(id);

                }
            });
    Bundle parameters = new Bundle();
    parameters.putString("fields", "id,name,link");
    request.setParameters(parameters);
    request.executeAsync();
    */

}

    public void Socialbtn(View v) {
        Intent startNewActivity = new Intent(this, RestaurantChat.class);
        startActivity(startNewActivity);
    }


}