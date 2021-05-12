package kotlinclass.leminh.kotlin_week2.movie

data class NowPlayingResp (
    val page: Long? = null,
    val dates: Dates? = null,
    val results: List<Movie>? = null,
    val totalPages: Long? = null,
    val totalResults: Long? = null
    )
    data class Dates (
        val maximum: String? = null,
        val minimum: String?
    )