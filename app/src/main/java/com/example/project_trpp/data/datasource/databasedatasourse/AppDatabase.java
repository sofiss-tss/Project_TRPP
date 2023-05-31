package com.example.project_trpp.data.datasource.databasedatasourse;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {EventEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract EventDao eventDao();
    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "Database_eventssssss").build();
                }
            }
        }
        return INSTANCE;
    }


//
//    /**
//     * Override the onCreate method to populate the database.
//     * For this sample, we clear the database every time it is created.
//     */
//    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
//        @Override
//        public void onCreate(@NonNull SupportSQLiteDatabase db) {
//            super.onCreate(db);
//
//            databaseWriteExecutor.execute(() -> {
//
//                EventDao dao = INSTANCE.eventDao();
//                dao.deleteAll();
//                Log.d("mytag","del");
//
//            });
//        }
//    };
}