package com.example.poc.core.data.order

import com.example.poc.datasource.remoteclientapi.RemoteClientApiClient
import com.example.poc.datasource.remoteclientapi.order.OrderResource

// TODO Should I only have one interface for local and remote?
internal class OrderRemoteServerDataSourceImpl(
    private val apiClient: RemoteClientApiClient
) : OrderRemoteServerDataSource {

    // Probably put a try and catch here and convert the remote exception to an app exception
    override suspend fun getOrder(id: Long): Order? {
        return apiClient.order.get(id).execute()
            .body()
            ?.toModel()
    }

    override suspend fun insertOrder(order: Order): Order {
        return apiClient.order.insert(order.toResource()).execute()
            .body()
            .toModel()
    }

    private fun OrderResource.toModel() =
        Order(
            id = id
        )

    private fun Order.toResource() =
        OrderResource(
            id = id
        )
}