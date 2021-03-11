package com.mcardenas.parstagram.ui.signout;

import android.widget.Button;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mcardenas.parstagram.R;

public class SignOutViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private Button btn_signOut;

    public SignOutViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
        btn_signOut= btn_signOut.findViewById(R.id.Sign_out);
    }

    public LiveData<String> getText() {
        return mText;
    }
}