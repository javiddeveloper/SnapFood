package ir.javid.satttar.snapfood.domain.model

/**
 * @author  : Javid
 * @summary : CharacterWithVideoDetails
 */

data class CharacterWithDetails(
    val character: CharacterVideo,
    val videoDetails: CharacterVideoDetail?
)
