/**
 * checkin | Error | Code | |
 * ----------------------------------------------------------------------
 * | - | | checkInCodePrefix | 4155 | | invalidObjectID | 1 | |
 * invalidMiddlewareContext | 2 | | customDatabaseError | 3 | |
 * codeControllerError | 4 | | decodeBody | 5 | | invalidParameter
 * | 6 | | integrationError | 7 | | cannotSendSSE | 8 |
 *
 * OpenAPI spec version: v1
 *
 * NOTE: This class is auto generated by the swagger code generator
 * program. https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
package com.rockspoon.merchant.datasource.rockspoon_merchant.checkin.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param profileId
 * @param status
 */
data class UpdateStatus(
    val profileId: String,
    val status: Status
) {

    /** Values: active,inactive */
    @Serializable
    enum class Status(val value: String) {

        @SerialName("active")
        ACTIVE("active"),

        @SerialName("inactive")
        INACTIVE("inactive");
    }

}

