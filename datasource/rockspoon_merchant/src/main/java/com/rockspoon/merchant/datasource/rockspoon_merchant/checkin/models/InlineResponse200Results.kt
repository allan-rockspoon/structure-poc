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

/**
 * @param id ID of the check-in
 * @param profileId Profile id of the checked in user
 * @param name Customer name
 * @param deletedAt Date time of the deletion of the check in. Returned
 *     only for deleted check-ins.
 * @param picture
 * @param devices
 */
data class InlineResponse200Results(
    /** ID of the check-in */
    val id: String? = null,
    /** Profile id of the checked in user */
    val profileId: String? = null,
    /** Customer name */
    val name: String? = null,
    /**
     * Date time of the deletion of the check in. Returned only for deleted
     * check-ins.
     */
    val deletedAt: String? = null,
    val picture: InlineResponse200Picture? = null,
    val devices: List<InlineResponse200Devices>? = null
)

