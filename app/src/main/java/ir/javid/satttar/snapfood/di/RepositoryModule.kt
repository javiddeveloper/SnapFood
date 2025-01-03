package ir.javid.satttar.snapfood.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ir.javid.satttar.snapfood.data.database.AppDao
import ir.javid.satttar.snapfood.data.network.NetworkDataSource
import ir.javid.satttar.snapfood.data.repository.VideoRepositoryImpl
import ir.javid.satttar.snapfood.domain.repository.VideoRepository

/**
 * @author  : Javid
 * @summary : RepositoryModule
 */

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    fun providePersonRepository(
        dao: AppDao,
        networkDataSource: NetworkDataSource
    ): VideoRepository {
        return VideoRepositoryImpl(
            dao = dao,
            remote = networkDataSource
        )
    }

}