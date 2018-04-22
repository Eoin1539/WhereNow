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

public class BarAdapter extends RecyclerView.Adapter<BarAdapter.BarViewHolder>{

    List<Bar> barList;
    Context context;




    public BarAdapter(List<Bar> barList) {

        this.barList = barList;

    }

    @Override
    public BarAdapter.BarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
        context = parent.getContext();
        return new BarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BarAdapter.BarViewHolder holder, int position) {
        Bar bar = barList.get(position);

        holder.title.setText(bar.getTitle());
        holder.address.setText(bar.getAddress());
        holder.barStyle.setText(bar.getBarStyle());
        holder.duration.setText(bar.getDuration());
        holder.PriceRange.setText(bar.getPriceRange());
        // holder.Latitude.setText(bar.getlatitude());
        // holder.Longitude.setText(bar.getlongitude());
        Picasso.with(context).load(barList.get(position).getImage()).into(holder.image);


        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "You clicked "+bar.getTitle(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, BarGalleryActivity.class);
                intent.putExtra("barTitle", bar.getTitle());
                intent.putExtra("barLatitude", bar.getlatitude());
                intent.putExtra("barLongitude", bar.getlongitude());
                context.startActivity(intent);
            }
        });
    }



    public class BarViewHolder extends RecyclerView.ViewHolder{

        TextView title, address, barStyle, duration, PriceRange;
        ImageView image;
        RelativeLayout relativeLayout;

        public BarViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.textViewTitle);
            address = itemView.findViewById(R.id.textViewAddress);
            barStyle = itemView.findViewById(R.id.textViewCuisine);
            duration = itemView.findViewById(R.id.textViewDuration);
            PriceRange = itemView.findViewById(R.id.textViewPriceRange);
            image = itemView.findViewById(R.id.viewImage);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);

        }
    }

    @Override
    public int getItemCount() {
        return barList.size();
    }



}
