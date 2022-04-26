package com.mahmoud_darwish.mvvmexample.presentation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.mahmoud_darwish.mvvmexample.domain.model.Volume
import com.mahmoud_darwish.mvvmexample.domain.repository.IBooksRepo
import com.mahmoud_darwish.mvvmexample.presentation.theme.MVVMExampleTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMExampleTheme {
                Scaffold {
                    val books by viewModel.booksSearchResult.collectAsState(initial = listOf())
                    val query by viewModel.query.collectAsState(initial = "")
                    Column {
                        SearchBar(
                            query = query,
                            onQueryChange = viewModel::setQuery
                        )
                        BooksList(volumes = books)
                    }
                }
            }
        }
    }
}

@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit
) {
    OutlinedTextField(
        value = query, onValueChange = onQueryChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        maxLines = 1,
    )
}

@Composable
fun BooksList(volumes: List<Volume>) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = spacedBy(8.dp)
    ) {
        items(volumes) { volume ->
            Text(text = volume.title)
        }
    }
}


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val booksRepo: IBooksRepo
) : ViewModel() {
    val booksSearchResult: Flow<List<Volume>> = booksRepo.searchResult
    val query: StateFlow<String> = booksRepo.query

    fun setQuery(query: String) {
        booksRepo.setQueryString(query)
    }
}