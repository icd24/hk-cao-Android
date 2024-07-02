package com.hk.cao.ui.details

import com.hk.cao.domain.Details
import com.hk.cao.util.formatDate

data class DetailsUiState(
    val detail: Details = Details(),
    val offline: Boolean = false
) {
    val formattedUserSince = formatDate(detail.userSince)
}