package com.example.habittracker;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class HabitViewModel extends AndroidViewModel {
    private HabitRepository repository;
    private LiveData<List<Habit>> allHabits;

    public HabitViewModel(@NonNull Application application) {
        super(application);
        repository = new HabitRepository(application);
        allHabits = repository.getAllHabits();
    }

    public void insert(Habit habit) {
        repository.insert(habit);
    }

    public void delete(Habit habit) {
        repository.delete(habit);
    }


    public LiveData<List<Habit>> getAllHabits() {
        return allHabits;
    }

    // This method now correctly calls the repository's resetAllHabits method
    public void resetAllHabits() {
        repository.resetAllHabits();
    }
}
