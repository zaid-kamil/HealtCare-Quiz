package com.podium.healtcarequiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.podium.healtcarequiz.databinding.FragmentWelcomeBinding;


public class WelcomeFragment extends Fragment {

    private com.podium.healtcarequiz.databinding.FragmentWelcomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnStart.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_welcome_to_quiz_1Fragment);
        });
    }
}