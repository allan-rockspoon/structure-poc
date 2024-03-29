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

import com.example.poc.core.common.serialization.BigDecimalSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * Represents Item complete info model (you should expect this model to
 * always equal the `github.com/rockspoon/rs.cat.item-model/dto.Item` model
 *
 * @param alternativeNames
 * @param approvalStatus
 * @param availabilityPeriods
 * @param availableFor
 * @param barcode
 * @param bundleAttributes
 * @param createdAt
 * @param deletedAt
 * @param description
 * @param facets
 * @param foodAndBeverageAttributes
 * @param globalId
 * @param groceryAttributes
 * @param id
 * @param inventoryAttributes
 * @param meta
 * @param name
 * @param packing
 * @param photos
 * @param salesTax
 * @param sizes
 * @param status
 * @param subtype
 * @param tags
 * @param tempUnavailability
 * @param type
 * @param updatedAt
 * @param venueId
 * @param version
 * @param category
 * @param taxRule
 */
@Serializable
data class ItemAdminResponse(
    val alternativeNames: List<MLCollection>? = null,
    val approvalStatus: String? = null,
    val availabilityPeriods: List<AvailabilityDTO>? = null,
    val availableFor: List<String>? = null,
    val barcode: String? = null,
    val bundleAttributes: BundleAttributesDTO? = null,
    val createdAt: Instant? = null,
    val deletedAt: Instant? = null,
    val description: MLCollection? = null,
    val facets: List<String>? = null,
    val foodAndBeverageAttributes: FoodAndBeverageAttributesDTO? = null,
    val globalId: String? = null,
    val groceryAttributes: GroceryAttributesDTO? = null,
    val id: String? = null,
    val inventoryAttributes: InventoryAttributesDTO? = null,
    val meta: Map<String, String>? = null,
    val name: MLCollection? = null,
    val packing: String? = null,
    val photos: List<ProductImageDTO>? = null,
    val salesTax: ItemSalesTaxDTO? = null,
    val sizes: List<SizeDTO>? = null,
    val status: String? = null,
    val subtype: String? = null,
    val tags: List<ItemTagDTO>? = null,
    val tempUnavailability: TempUnavailabilityDTO? = null,
    val type: String? = null,
    val updatedAt: Instant? = null,
    val venueId: String? = null,
    @Serializable(with = BigDecimalSerializer::class)
    val version: java.math.BigDecimal? = null,
    val category: ItemCategory? = null,
    val taxRule: ItemTaxRule? = null
)

