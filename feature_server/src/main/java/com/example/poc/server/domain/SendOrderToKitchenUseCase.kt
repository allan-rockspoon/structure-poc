package com.example.poc.server.domain

import com.example.poc.server.data.Order
import com.example.poc.server.data.OrderRepository

class SendOrderToKitchenUseCase(
    private val orderRepository: OrderRepository,
    private val publishDataChangeUseCase: PublishDataChangeUseCase
) {

    suspend operator fun invoke(orderId: Long): Order {
        val order = orderRepository.getOrder(orderId)

        // Some checking and business logic
        if (order.status != Order.Status.OPEN) {
            throw NonOpenOrderSentToKitchenException(order.status)
        }

        val orderUpdated = orderRepository.updateOrderStatus(orderId, Order.Status.PREPARING)

        // Publish message to eventually notify subscribers about data change
        publishDataChangeUseCase(orderId)

        return orderUpdated
    }

    class NonOpenOrderSentToKitchenException(orderStatus: Order.Status) :
        IllegalArgumentException("Attempt to send to kitchen order with status $orderStatus. Only orders with status ${Order.Status.OPEN} can be sent to the kitchen.")
}