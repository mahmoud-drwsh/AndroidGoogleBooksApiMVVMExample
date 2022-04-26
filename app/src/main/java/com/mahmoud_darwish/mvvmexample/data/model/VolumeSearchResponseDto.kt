package com.mahmoud_darwish.mvvmexample.data.model


import com.google.gson.annotations.SerializedName

data class VolumeSearchResponseDto(
    @SerializedName("items")
    val items: List<VolumeDto> = listOf(),
    @SerializedName("kind")
    val kind: String = "",
    @SerializedName("totalItems")
    val totalItems: Int = 0
) {
    data class VolumeDto(
        @SerializedName("accessInfo")
        val accessInfo: AccessInfo = AccessInfo(),
        @SerializedName("etag")
        val etag: String = "",
        @SerializedName("id")
        val id: String = "",
        @SerializedName("kind")
        val kind: String = "",
        @SerializedName("saleInfo")
        val saleInfo: SaleInfo = SaleInfo(),
        @SerializedName("searchInfo")
        val searchInfo: SearchInfo = SearchInfo(),
        @SerializedName("selfLink")
        val selfLink: String = "",
        @SerializedName("volumeInfo")
        val volumeInfo: VolumeInfo = VolumeInfo()
    ) {
        data class AccessInfo(
            @SerializedName("accessViewStatus")
            val accessViewStatus: String = "",
            @SerializedName("country")
            val country: String = "",
            @SerializedName("embeddable")
            val embeddable: Boolean = false,
            @SerializedName("epub")
            val epub: Epub = Epub(),
            @SerializedName("pdf")
            val pdf: Pdf = Pdf(),
            @SerializedName("publicDomain")
            val publicDomain: Boolean = false,
            @SerializedName("quoteSharingAllowed")
            val quoteSharingAllowed: Boolean = false,
            @SerializedName("textToSpeechPermission")
            val textToSpeechPermission: String = "",
            @SerializedName("viewability")
            val viewability: String = "",
            @SerializedName("webReaderLink")
            val webReaderLink: String = ""
        ) {
            data class Epub(
                @SerializedName("acsTokenLink")
                val acsTokenLink: String = "",
                @SerializedName("isAvailable")
                val isAvailable: Boolean = false
            )

            data class Pdf(
                @SerializedName("acsTokenLink")
                val acsTokenLink: String = "",
                @SerializedName("isAvailable")
                val isAvailable: Boolean = false
            )
        }

        data class SaleInfo(
            @SerializedName("buyLink")
            val buyLink: String = "",
            @SerializedName("country")
            val country: String = "",
            @SerializedName("isEbook")
            val isEbook: Boolean = false,
            @SerializedName("listPrice")
            val listPrice: ListPrice = ListPrice(),
            @SerializedName("offers")
            val offers: List<Offer> = listOf(),
            @SerializedName("retailPrice")
            val retailPrice: RetailPrice = RetailPrice(),
            @SerializedName("saleability")
            val saleability: String = ""
        ) {
            data class ListPrice(
                @SerializedName("amount")
                val amount: Int = 0,
                @SerializedName("currencyCode")
                val currencyCode: String = ""
            )

            data class Offer(
                @SerializedName("finskyOfferType")
                val finskyOfferType: Int = 0,
                @SerializedName("listPrice")
                val listPrice: ListPrice = ListPrice(),
                @SerializedName("retailPrice")
                val retailPrice: RetailPrice = RetailPrice()
            ) {
                data class ListPrice(
                    @SerializedName("amountInMicros")
                    val amountInMicros: Long = 0,
                    @SerializedName("currencyCode")
                    val currencyCode: String = ""
                )

                data class RetailPrice(
                    @SerializedName("amountInMicros")
                    val amountInMicros: Long = 0,
                    @SerializedName("currencyCode")
                    val currencyCode: String = ""
                )
            }

            data class RetailPrice(
                @SerializedName("amount")
                val amount: Int = 0,
                @SerializedName("currencyCode")
                val currencyCode: String = ""
            )
        }

        data class SearchInfo(
            @SerializedName("textSnippet")
            val textSnippet: String = ""
        )

        data class VolumeInfo(
            @SerializedName("allowAnonLogging")
            val allowAnonLogging: Boolean = false,
            @SerializedName("authors")
            val authors: List<String> = listOf(),
            @SerializedName("averageRating")
            val averageRating: Double = 0.0,
            @SerializedName("canonicalVolumeLink")
            val canonicalVolumeLink: String = "",
            @SerializedName("categories")
            val categories: List<String> = listOf(),
            @SerializedName("contentVersion")
            val contentVersion: String = "",
            @SerializedName("description")
            val description: String = "",
            @SerializedName("imageLinks")
            val imageLinks: ImageLinks = ImageLinks(),
            @SerializedName("industryIdentifiers")
            val industryIdentifiers: List<IndustryIdentifier> = listOf(),
            @SerializedName("infoLink")
            val infoLink: String = "",
            @SerializedName("language")
            val language: String = "",
            @SerializedName("maturityRating")
            val maturityRating: String = "",
            @SerializedName("pageCount")
            val pageCount: Int = 0,
            @SerializedName("panelizationSummary")
            val panelizationSummary: PanelizationSummary = PanelizationSummary(),
            @SerializedName("previewLink")
            val previewLink: String = "",
            @SerializedName("printType")
            val printType: String = "",
            @SerializedName("publishedDate")
            val publishedDate: String = "",
            @SerializedName("publisher")
            val publisher: String = "",
            @SerializedName("ratingsCount")
            val ratingsCount: Int = 0,
            @SerializedName("readingModes")
            val readingModes: ReadingModes = ReadingModes(),
            @SerializedName("subtitle")
            val subtitle: String = "",
            @SerializedName("title")
            val title: String = ""
        ) {
            data class ImageLinks(
                @SerializedName("smallThumbnail")
                val smallThumbnail: String = "",
                @SerializedName("thumbnail")
                val thumbnail: String = ""
            )

            data class IndustryIdentifier(
                @SerializedName("identifier")
                val identifier: String = "",
                @SerializedName("type")
                val type: String = ""
            )

            data class PanelizationSummary(
                @SerializedName("containsEpubBubbles")
                val containsEpubBubbles: Boolean = false,
                @SerializedName("containsImageBubbles")
                val containsImageBubbles: Boolean = false
            )

            data class ReadingModes(
                @SerializedName("image")
                val image: Boolean = false,
                @SerializedName("text")
                val text: Boolean = false
            )
        }
    }
}