package com.example.nnayyar1_expbook;

import android.icu.util.CurrencyAmount;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nnayyar1_expbook.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.Date;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private RecyclerView recyclerView;
    private ExpenseAdapter adapter;
    private ArrayList<ExpenseRecord> expenseRecords;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = binding.recyclerView;

        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        expenseRecords = new ArrayList<>();
        expenseRecords.add(new ExpenseRecord("test", new Date(),123.0, "test"));
        adapter = new ExpenseAdapter(expenseRecords);
        recyclerView.setAdapter(adapter);

        binding.addExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.expenseListToAddExpense);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}