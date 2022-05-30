package com.example.mobilishop.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilishop.Model.RewardModel;
import com.example.mobilishop.Adapter.MyRewardsAdapter;
import com.example.mobilishop.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyRewardsFragment} factory method to
 * create an instance of this fragment.
 */
public class MyRewardsFragment extends Fragment {



    public MyRewardsFragment() {
        // Required empty public constructor
    }

private RecyclerView rewardsRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.fragment_my_rewards, container, false);

       rewardsRecyclerView = view.findViewById(R.id.my_rewards_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rewardsRecyclerView.setLayoutManager(layoutManager);

        List<RewardModel> rewardModelList = new ArrayList<>();
        rewardModelList.add(new RewardModel("remise en argent","Pour le 2 juin 2022","obtenez 20% de réduction sur tout produit supérieur à 500€ et inférieur à 1000€"));
        rewardModelList.add(new RewardModel("remise","Pour le 2 juin 2022","obtenez 20% de réduction sur tout produit supérieur à 500€ et inférieur à 1000€"));
        rewardModelList.add(new RewardModel("achetez 1 obtenez 1 gratuit","Pour le 2 juin 2022","obtenez 20% de réduction sur tout produit supérieur à 500€ et inférieur à 1000€"));
        rewardModelList.add(new RewardModel("remise en argent","Pour le 2 juin 2022","obtenez 20% de réduction sur tout produit supérieur à 500€ et inférieur à 1000€"));
        rewardModelList.add(new RewardModel("remise","Pour le 2 juin 2022","obtenez 20% de réduction sur tout produit supérieur à 500€ et inférieur à 1000€"));
        rewardModelList.add(new RewardModel("achetez 1 obtenez 1 gratuit","Pour le 2 juin 2022","obtenez 20% de réduction sur tout produit supérieur à 500€ et inférieur à 1000€"));
        rewardModelList.add(new RewardModel("remise en argent","Pour le 2 juin 2022","obtenez 20% de réduction sur tout produit supérieur à 500€ et inférieur à 1000€"));
        rewardModelList.add(new RewardModel("remise","Pour le 2 juin 2022","obtenez 20% de réduction sur tout produit supérieur à 500€ et inférieur à 1000€"));
        rewardModelList.add(new RewardModel("achetez 1 obtenez 1 gratuit","Pour le 2 juin 2022","obtenez 20% de réduction sur tout produit supérieur à 500€ et inférieur à 1000€"));

        MyRewardsAdapter myRewardsAdapter = new MyRewardsAdapter(rewardModelList);
        rewardsRecyclerView.setAdapter(myRewardsAdapter);
        myRewardsAdapter.notifyDataSetChanged();

        return view;
    }
}