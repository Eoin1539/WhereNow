package nci.wherenow;



import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>{

    List<Restaurant> restaurantList;
    Context context;




    public RestaurantAdapter(List<Restaurant> restaurantList) {

        this.restaurantList = restaurantList;

    }

    @Override
    public RestaurantAdapter.RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
        context = parent.getContext();
        return new RestaurantViewHolder(view);
    }


    //To get the location of the restaurant when pressed and begin a seperate activity. This is done via a fragment, so the fragment variables change,
    //Depending on the restaurant picked.
    @Override
    public void onBindViewHolder(RestaurantAdapter.RestaurantViewHolder holder, int position) {
        Restaurant restaurant = restaurantList.get(position);

        holder.title.setText(restaurant.getTitle());
        holder.address.setText(restaurant.getAddress());
        holder.cuisine.setText(restaurant.getCuisine());
        holder.duration.setText(restaurant.getDuration());
        holder.PriceRange.setText(restaurant.getPriceRange());
        //holder.latitude.setText(restaurant.getlatitude());
        //holder.longitude.setText(restaurant.getlongitude());
        Picasso.with(context).load(restaurantList.get(position).getImage()).into(holder.image);


        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //converting string to double for lat and long

                double latitude = Double.parseDouble(restaurant.getlatitude());
                double longitude = Double.parseDouble(restaurant.getlongitude());

                Toast.makeText(context, "You clicked "+restaurant.getTitle(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, GalleryActivity.class);
                intent.putExtra("restaurantTitle", restaurant.getTitle());
                intent.putExtra("restaurantLatitude", restaurant.getlatitude());
                intent.putExtra("restaurantLongitude", restaurant.getlongitude());

                //intent.putExtra("lat", latitude);
                //intent.putExtra("lon", longitude);


                context.startActivity(intent);
            }
        });
    }



    public class RestaurantViewHolder extends RecyclerView.ViewHolder{

        TextView title, address, cuisine, duration, PriceRange, latitude, longitude;
        ImageView image;
        RelativeLayout relativeLayout;

        public RestaurantViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.textViewTitle);
            address = itemView.findViewById(R.id.textViewAddress);
            cuisine = itemView.findViewById(R.id.textViewCuisine);
            duration = itemView.findViewById(R.id.textViewDuration);
            PriceRange = itemView.findViewById(R.id.textViewPriceRange);
            image = itemView.findViewById(R.id.viewImage);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);

        }
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }



}
