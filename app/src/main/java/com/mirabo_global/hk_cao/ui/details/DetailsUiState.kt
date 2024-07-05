package com.mirabo_global.hk_cao.ui.details

import com.mirabo_global.hk_cao.domain.Details
import com.mirabo_global.hk_cao.util.formatDate

data class DetailsUiState(
    val detail: Details = Details(),
    val offline: Boolean = false
) {
    val formattedUserSince = formatDate(detail.userSince)
}