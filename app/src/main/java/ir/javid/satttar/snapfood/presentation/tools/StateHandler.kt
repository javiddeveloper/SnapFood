package ir.javid.satttar.snapfood.presentation.tools

import ir.javid.satttar.snapfood.presentation.viewModel.StarWarsState

/**
 * @author  : Javid
 * @summary : StateHandler
 */

data class ViewState<T>(
    val state: StarWarsState,
    val data: T? = null
)