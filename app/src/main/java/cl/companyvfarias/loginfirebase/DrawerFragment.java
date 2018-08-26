package cl.companyvfarias.loginfirebase;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


/**
 * A simple {@link Fragment} subclass.
 */
public class DrawerFragment extends Fragment {


    public DrawerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drawer, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView logout = view.findViewById(R.id.logoutTv);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AuthUI.getInstance()
                        .signOut(getContext())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            public void onComplete(@NonNull Task<Void> task) {
                                Intent intent= new Intent(getActivity(),LoginActivity.class);
                                startActivity(intent);
                                getActivity().finish();
                            }
                        });

            }
        });

        TextView userMail = view.findViewById(R.id.emailTv);
        userMail.setText((CharSequence) new CurrentUser().email());
    }
    
    
    private void requestSelfie()
    {
        new AlertDialog.Builder(getActivity())
                .setTitle("Selfie :´(")
                .setMessage("Para completar el registro debe teber una selfie actualizada")
                .setCancelable(false)
                .setPositiveButton("Selfie", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    
    }
}