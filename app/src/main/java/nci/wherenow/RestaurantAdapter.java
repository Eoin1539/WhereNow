package nci.wherenow;



import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


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
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RestaurantAdapter.RestaurantViewHolder holder, int position) {
        Restaurant restaurant = restaurantList.get(position);

        holder.title.setText(restaurant.getTitle());
        holder.address.setText(restaurant.getAddress());
        holder.cuisine.setText(restaurant.getCuisine());
        holder.duration.setText(restaurant.getDuration());
        holder.priceRange.setText(restaurant.getPriceRange());
        //holder.image.setImageURI(restaurant.getImage());


       // holder.imageView.setImageDrawable((mCtx.getResources().getDrawable(Restaurant.getImage())));

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "You clicked "+restaurant.getTitle(), Toast.LENGTH_LONG).show();
            }
        });
    }



    public class RestaurantViewHolder extends RecyclerView.ViewHolder{

        TextView title, address, cuisine, duration, priceRange;
        ImageView image;
        RelativeLayout relativeLayout;

        public RestaurantViewHolder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.textViewTitle);
            address = (TextView)itemView.findViewById(R.id.textViewAddress);
            cuisine = (TextView)itemView.findViewById(R.id.textViewCuisine);
            duration = (TextView)itemView.findViewById(R.id.textViewDuration);
            priceRange = (TextView)itemView.findViewById(R.id.textViewPriceRange);
            image = (ImageView)itemView.findViewById(R.id.imageView);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.realtiveLayout);

        }
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }



}
