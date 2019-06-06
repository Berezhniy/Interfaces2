package ru.startandroid.interfaces;

public interface MainContract {

    interface Listener{
        void openSecondActivities();
        //создал интерфейс листенер
    }

    interface Callback{
        void showMessage();
    }
}
