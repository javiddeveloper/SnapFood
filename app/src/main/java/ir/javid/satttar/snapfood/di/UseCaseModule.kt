package ir.javid.satttar.snapfood.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ir.javid.satttar.snapfood.domain.repository.VideoRepository
import ir.javid.satttar.snapfood.domain.useCase.ManageVideosUseCase

/**
 * @author  : Javid
 * @summary : UseCaseModule
 */

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideManageVideosUseCase(
        videoRepository: VideoRepository
    ): ManageVideosUseCase {
        return ManageVideosUseCase(videoRepository)
    }
}