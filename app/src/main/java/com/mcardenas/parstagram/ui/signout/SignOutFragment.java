package com.mcardenas.parstagram.ui.signout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mcardenas.parstagram.LoginActivity;
import com.mcardenas.parstagram.MainActivity;
import com.mcardenas.parstagram.R;
import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class SignOutFragment extends Fragment {

    public static final String TAG= "SignOutFragment";
    private SignOutViewModel signOutViewModel;
    private Button btn_signOut;
    private Context context= getContext();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        signOutViewModel =
//                new ViewModelProvider(this).get(SignOutViewModel.class);
        View root = inflater.inflate(R.layout.fragment_signout, container, false);
        btn_signOut= root.findViewById(R.id.Sign_out);

        btn_signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOutInBackground(new LogOutCallback(){
                    @Override
                    public void done(ParseException e) {
                        if(e != null){
                            Log.e(TAG, "Issue with signout", e);
                            return;
                        }
                        Intent i= new Intent(getActivity(), LoginActivity.class);
                        Log.i("signout", TAG);
                        startActivity(i);
                    }
                });
            }
        });
        return root;
    }
}