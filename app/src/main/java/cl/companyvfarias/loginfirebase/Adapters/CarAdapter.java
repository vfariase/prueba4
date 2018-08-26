package cl.companyvfarias.loginfirebase.Adapters;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import cl.companyvfarias.loginfirebase.R;
import cl.companyvfarias.loginfirebase.listeners.CarListener;
import cl.companyvfarias.loginfirebase.models.Car;

public class CarAdapter extends FirebaseRecyclerAdapter<Car,CarAdapter.CarViewHolder>{


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */


    private CarListener carListener;
    private boolean first = true;
    public CarAdapter(@NonNull FirebaseRecyclerOptions<Car> options, CarListener listener)
    {
        super(options);
        this.carListener=listener;
    }

    @Override
    protected void onBindViewHolder(@NonNull final CarViewHolder holder, int position, @NonNull Car car) {
             holder.model.setText(car.getName());
             holder.brand.setText(car.getDescription());
             holder.itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Car auxCar=getItem(holder.getAdapterPosition());
                     carListener.clicked(auxCar);
                 }
             });
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_car, parent, false);
        return new CarViewHolder(view);
    }

    public static class CarViewHolder extends RecyclerView.ViewHolder
    {
        private TextView model;
        private TextView brand;

        public CarViewHolder(View itemView) {
            super(itemView);

            model= itemView.findViewById(R.id.modeloTv);
            brand=itemView.findViewById(R.id.brandTv);
        }
    }


    @Override
    public void onDataChanged() {
        if(first)
        {
            first = false;
        }
    }
}