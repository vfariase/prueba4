package cl.companyvfarias.loginfirebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Nodes {

    private DatabaseReference root= FirebaseDatabase.getInstance().getReference();

    public DatabaseReference Cars() {
        return root.child("products");
    }
}
