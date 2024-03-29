/**
 * catalog | Error | Code | |
 * ----------------------------------------------------------------------
 * | - | | itemCodePrefix | 4050 | | codeRequiredParameter |
 * 1 | | codeNotEmptyList | 2 | | codeInvalidParameter | 3 |
 * | codeNotfoundSection | 4 | | codeNotfoundModifier | 5 | |
 * codeInactiveItemModifier | 6 | | codeTenantNotAllowed | 7 | |
 * codeNilContext | 8 | | codeDatabaseError | 9 | | codeControllerError
 * | 10 | | codeInvalidHex | 11 | | codeTransformerError | 12 | |
 * codeTranslationError | 13 | | codeAlreadyPublishedError | 14 | |
 * codeAlreadyUnpublishedError | 15 | | codeInvalidContext | 16 | |
 * codeTranslationNotFound | 17 | | oneOrMoreImagesFailedToUpload
 * | 18 | | invalidMicroserviceResponse | 19 | | invalidFacet | 20
 * | | errorCountingItemsFacet | 21 | | errorListingItemsFacet |
 * 22 | | errListingModifiers | 23 | | errorCountingModifiers | 24
 * | | errorCreatingRecipe | 25 | | errorUpdatingRecipe | 26 | |
 * codeNotfoundRecipes | 27 | | itemDoesntHaveInventoryAttributes
 * | 28 | | invalidTag | 29 | | errorListingTags | 30 | |
 * couldNotDeleteItemRecipe | 31 | | couldNotCountItemProperties
 * | 32 | | couldNotGetItemProperties | 33 | | databaseNotFound
 * | 34 | | couldNotRemoveSizes | 35 | | cannotSendSSE | 36 | |
 * actionIsNotAllowedForObjectType | 37 | | actionIsAllowedOnlyFor | 38
 * | | couldNotFindBundleSection | 39 | | couldNotFindBundleItem | 40 |
 * | sizeDoesNotBelongToItem | 41 | | errorListingItemsApprovalStatus |
 * 42 | | errorCountingItemsApprovalStatus | 43 | | errorVisibilityChange
 * | 44 | | errorInvalidRequest | 45 | | menuVersionIsNil | 46
 * | | eCommerceItemAlreadyExists | 47 | | wrongSliceLength |
 * 48 | | deviceMarketplaceVenue | 49 | | decodeBody | 50 | |
 * errorVisibilityStatus | 51 | | couldNotGetExternalMenu | 52 | |
 * couldNotFindVenue | 53 |
 *
 * OpenAPI spec version: v1
 *
 * NOTE: This class is auto generated by the swagger code generator
 * program. https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
package com.rockspoon.merchant.datasource.rockspoon_merchant.catalog.models

import kotlinx.serialization.Serializable

/**
 * ItemConsumerResponse is the response for item types
 *
 * @param tags
 * @param alcoholicAttributes
 * @param beverageAttributes
 * @param groceryAttributes
 * @param bundleAttributes
 * @param applyTaxDeliveryTakeout
 * @param availability
 * @param availableFor
 * @param category
 * @param createdAt
 * @param description
 * @param id
 * @param venueId
 * @param includeCountdown
 * @param origin
 * @param photos
 * @param routing
 * @param sizesAndPrices
 * @param subcategory
 * @param title
 * @param type
 * @param updatedAt
 * @param measure
 * @param quantityStep
 * @param course
 * @param isAvailable
 * @param unavailabilityReason
 * @param meta
 * @param itemCategory
 * @param taxRule
 */
@Serializable
data class ItemConsumerResponse(
    val tags: List<ItemTagDTO>,
    val applyTaxDeliveryTakeout: Boolean,
    val availability: List<AvailabilityResponse>,
    val availableFor: List<String>,
    val category: ItemType,
    val createdAt: kotlinx.datetime.Instant,
    val description: String,
    val id: String,
    val photos: List<ImageDto>,
    val routing: List<String>,
    val sizesAndPrices: List<SizeResponse>,
    val subcategory: ItemSubtype,
    val title: String,
    val type: List<Facet>,
    val isAvailable: Boolean,
    val itemCategory: ItemCategory,
    val taxRule: ItemTaxRule,
    val alcoholicAttributes: AlcoholicAttributesResponse? = null,
    val beverageAttributes: BeverageAttributesResponse? = null,
    val groceryAttributes: GroceryAttributesResponse? = null,
    val bundleAttributes: BundleAttributesResponse? = null,
    val venueId: String? = null,
    val includeCountdown: Boolean? = null,
    val origin: ItemOriginResponse? = null,
    val updatedAt: kotlinx.datetime.Instant? = null,
    val measure: String? = null,
    val quantityStep: QuantityStep? = null,
    val course: Long? = null,
    val unavailabilityReason: String? = null,
    val meta: DeviceMeta? = null
)

