package dev.vincenzocostagliola.coinswatch

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.vincenzocostagliola.data.net.repository.Repository
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel  @Inject constructor(
    private val repository: Repository
) : ViewModel() {
}