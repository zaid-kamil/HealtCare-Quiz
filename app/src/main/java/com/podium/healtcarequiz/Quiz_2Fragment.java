package com.podium.healtcarequiz;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.podium.healtcarequiz.databinding.FragmentQuiz2Binding;

public class Quiz_2Fragment extends Fragment {

    boolean isCorrect = false;
    private FragmentQuiz2Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentQuiz2Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btn2.setOnClickListener(view1 -> {
            new Handler().postDelayed(() -> {
                if (isCorrect) {
                    NavHostFragment.findNavController(this).navigate(R.id.action_quiz_2Fragment_to_scoreFragment);
                } else {
                    NavHostFragment.findNavController(this).navigate(R.id.action_quiz_2Fragment_to_gameOverFragment);
                }
            }, 2000);
        });
    }
}