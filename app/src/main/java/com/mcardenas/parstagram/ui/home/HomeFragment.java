package com.mcardenas.parstagram.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mcardenas.parstagram.Item_post;
import com.mcardenas.parstagram.PostAdapter;
import com.mcardenas.parstagram.R;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    List<Item_post> posts;
    private String TAG= "HomeFragment";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        Context context= getContext();


        RecyclerView rvPostView= root.findViewById(R.id.rvPostView);
        posts= new ArrayList<>();

        PostAdapter postAdapter= new PostAdapter(context,posts);
        rvPostView.setAdapter(postAdapter);
        rvPostView.setLayoutManager(new LinearLayoutManager(context));

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Post");

//        query.findInBackground((objects, e) -> {
//            if(e == null){
//                posts.addAll(Item_post.fromParseArray(objects));
//                postAdapter.notifyDataSetChanged();
//            }else{
//                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });

        return root;
    }
}