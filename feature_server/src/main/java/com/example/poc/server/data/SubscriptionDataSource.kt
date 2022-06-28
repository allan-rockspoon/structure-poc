package com.example.poc.server.data

import kotlinx.coroutines.flow.Flow

interface SubscriptionDataSource {

    suspend fun insertSubscription(subscription: Subscription)

    suspend fun deleteSubscription(id: Long)

    fun listSubscriptions(entityId: Long, entityType: Subscription.Type): Flow<Subscription>
}