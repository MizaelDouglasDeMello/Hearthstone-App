package br.com.mizaeldouglas.hearthstone_app.di

import br.com.mizaeldouglas.hearthstone_app.data.api.BaseInterceptor
import br.com.mizaeldouglas.hearthstone_app.data.api.HeathstoneService
import br.com.mizaeldouglas.hearthstone_app.data.repository.CardRepositoryImpl
import br.com.mizaeldouglas.hearthstone_app.data.repository.ICardRepository
import br.com.mizaeldouglas.hearthstone_app.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(BaseInterceptor())
            .connectTimeout(60, TimeUnit.SECONDS)  // Aumenta o tempo limite de conexão para 60 segundos
            .readTimeout(60, TimeUnit.SECONDS)     // Aumenta o tempo limite de leitura para 60 segundos
            .build()
    }

    @Provides
    fun provideHeathstoneService(retrofit: Retrofit): HeathstoneService {
        return retrofit.create(HeathstoneService::class.java)
    }

    @Provides
    fun provideICardRepository(heathstoneService: HeathstoneService): ICardRepository {
        return CardRepositoryImpl(heathstoneService)
    }

}