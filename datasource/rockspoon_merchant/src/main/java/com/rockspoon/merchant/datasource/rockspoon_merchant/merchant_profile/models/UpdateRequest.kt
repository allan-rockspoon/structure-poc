package com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.models

import kotlinx.serialization.Serializable

/** @param name category name */
@Serializable
data class UpdateRequest(
    /** category name */
    val name: String? = null
)

