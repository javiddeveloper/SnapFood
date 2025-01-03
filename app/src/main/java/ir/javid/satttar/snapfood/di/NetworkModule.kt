package ir.javid.satttar.snapfood.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.URLProtocol
//import io.ktor.serialization.gson.gson
import ir.javid.satttar.snapfood.data.network.NetworkDataSource
import javax.inject.Singleton

/**
 * @author  : Javid
 * @summary : NetworkModule
 */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideKtorClient(): HttpClient {
        return HttpClient(CIO) {
//            install(ContentNegotiation) {
//                gson {
//                    setPrettyPrinting()
//                    disableHtmlEscaping()
//                    serializeNulls()
//                }
//            }

            install(HttpTimeout) {
                requestTimeoutMillis = 10000
                connectTimeoutMillis = 10000
                socketTimeoutMillis = 10000
            }

            defaultRequest {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "https://www.swapi.tech/api/" // Base URL
                }
            }
        }
    }

    @Provides
    @Singleton
    fun provideNetworkDataSource(httpClient: HttpClient): NetworkDataSource {
        return NetworkDataSource(httpClient)
    }
}
