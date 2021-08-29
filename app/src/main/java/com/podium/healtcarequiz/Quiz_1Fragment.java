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

import com.podium.healtcarequiz.databinding.FragmentQuiz1Binding;

public class Quiz_1Fragment extends Fragment {


    boolean isCorrect = false;
    private com.podium.healtcarequiz.databinding.FragmentQuiz1Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentQuiz1Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.image1.setOnClickListener(v -> {
            isCorrect = true;
            binding.image1.setSelected(true);
            binding.image2.setSelected(false);
        });
        binding.image2.setOnClickListener(v -> {
            isCorrect = false;
            binding.image1.setSelected(false);
            binding.image2.setSelected(true);
        });
        binding.btn1.setOnClickListener(v -> {
            binding.answer.setVisibility(View.VISIBLE);
            if (isCorrect) {
                binding.score.setText("Score: 1");
            }
            new Handler().postDelayed(() -> {
                if(isCorrect) {
                    NavHostFragment.findNavController(this).navigate(R.id.action_quiz_1Fragment_to_quiz_2Fragment);
                }else {
                    NavHostFragment.findNavController(this).navigate(R.id.action_quiz_1Fragment_to_gameOverFragment);
                }
            }, 3000);

        });
    }
}