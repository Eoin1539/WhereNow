package nci.wherenow;

import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;

public class messageAdapter extends FirebaseListAdapter<message> {

    public RestaurantChat activity;

    public messageAdapter(RestaurantChat activity, Class<message> modelClass, int modelLayout, DatabaseReference ref) {
        super(activity, modelClass, modelLayout, ref);
        this.activity = activity;
    }
    
    private BarChat objective;

    public messageAdapter(BarChat activity, Class<message> modelClass, int modelLayout, DatabaseReference ref) {
        super(activity, modelClass, modelLayout, ref);
        this.objective = objective;
    }

    @Override
    protected void populateView(View v, message model, int position) {
        TextView messageText = (TextView) v.findViewById(R.id.message_text);
        TextView messageUser = (TextView) v.findViewById(R.id.message_user);
        TextView messageTime = (TextView) v.findViewById(R.id.message_time);

        messageText.setText(model.getText());
        messageUser.setText(model.getUser());

        // Format the date before showing it
        messageTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)", model.getTime()));
    }

   /// @Override
  /*  public View getView(int position, View view, ViewGroup viewGroup) {
        message chatMessage = getItem(position);
        if (chatMessage.getUser().equals(activity.getLoggedInUser()))
            view = activity.getLayoutInflater().inflate(R.layout.messagein, viewGroup, false);
        else
            view = activity.getLayoutInflater().inflate(R.layout.messageout, viewGroup, false);


        populateView(view, chatMessage, position);

        return view;
    }  */

  /*  @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }*/
}

