package ir.javid.satttar.snapfood.data.repository.patterns

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * @author  : Javid
 * @summary : NetworkBoundResource
 */

abstract class NetworkBoundResource<ResultType, RequestType> {

    suspend fun asFlow(): Flow<ResultType> = flow {
        fetchFromLocal()?.let {
            emit(it)
        }

        val response = fetchFromNetwork()
        saveNetworkResult(response)

        fetchFromLocal()?.let {
            emit(it)
        }
    }

    protected abstract suspend fun fetchFromLocal(): ResultType?

    protected abstract suspend fun fetchFromNetwork(): RequestType

    protected abstract suspend fun saveNetworkResult(item: RequestType)
}
