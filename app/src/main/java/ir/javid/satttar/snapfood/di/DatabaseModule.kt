package ir.javid.satttar.snapfood.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.javid.satttar.snapfood.data.database.CharacterDao
import ir.javid.satttar.snapfood.data.database.AppDatabase
import ir.javid.satttar.snapfood.data.database.SearchHistoryDao
import javax.inject.Singleton

/**
 * @author  : Javid
 * @summary : DatabaseModule
 */

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "snap_food_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(database: AppDatabase): CharacterDao {
        return database.characterDao()
    }

    @Provides
    @Singleton
    fun provideSearchHistoryDao(database: AppDatabase): SearchHistoryDao {
        return database.searchHistoryDao()
    }
}