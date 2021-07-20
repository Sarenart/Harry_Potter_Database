package com.example.harrypotterdatabase.network;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.util.Log;

import androidx.fragment.app.FragmentManager;

import com.example.harrypotterdatabase.fragments.NetworkDialogFragment;
import com.example.harrypotterdatabase.model.Constants;
import com.example.harrypotterdatabase.model.GlobalVariables;

public class CheckNetwork {

    Context context;
    FragmentManager fragmentManager;

    public CheckNetwork(Context context, FragmentManager fragmentManager) {
        this.context = context;
        this.fragmentManager = fragmentManager;
    }


    public void registerNetworkCallback()
    {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkRequest.Builder builder = new NetworkRequest.Builder();

            connectivityManager
                    .registerDefaultNetworkCallback(new ConnectivityManager.NetworkCallback(){
                       @Override
                       public void onAvailable(Network network) {
                           GlobalVariables.isNetworkConnected = true; // Global Static Variable
                           Log.d("NetworkState", "Network is available");
                       }
                       @Override
                       public void onLost(Network network) {
                           GlobalVariables.isNetworkConnected = false; // Global Static Variable
                           Log.d("NetworkState","Network is unavailable");
                           new NetworkDialogFragment().show(fragmentManager, Constants.NETWORK_TAG);
                       }
                   }
            );
            GlobalVariables.isNetworkConnected = false;
        }catch (Exception e){
            GlobalVariables.isNetworkConnected = false;
        }
    }
}
