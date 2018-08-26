package cl.companyvfarias.loginfirebase.views;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import cl.companyvfarias.loginfirebase.Adapters.CarAdapter;
import cl.companyvfarias.loginfirebase.CurrentUser;
import cl.companyvfarias.loginfirebase.Nodes;
import cl.companyvfarias.loginfirebase.R;
import cl.companyvfarias.loginfirebase.listeners.CarListener;
import cl.companyvfarias.loginfirebase.models.Car;

public class ResultActivity extends AppCompatActivity implements CarListener {

    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        RecyclerView recyclerView=findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        FirebaseRecyclerOptions<Car> options= new FirebaseRecyclerOptions.Builder<Car>()
              .setQuery(new Nodes().Cars(),Car.class)
                .setLifecycleOwner(this)
                .build();





        CarAdapter carAdapter = new CarAdapter(options,this);
        recyclerView.setAdapter(carAdapter);
    }

    @Override
    public void clicked(Car car) {
        Toast.makeText(this, car.getDescription(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void dataChanged() {
      progressDialog.dismiss();
    }
}
