package com.example.footballapp.utils.base

import com.example.footballapp.utils.Resource
import kotlinx.coroutines.flow.Flow

interface BaseUseCase<T> {

    operator fun invoke(param : String) : Flow<Resource<T>>
}