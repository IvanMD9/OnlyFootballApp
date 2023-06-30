package com.example.footballapp.utils.base

class BaseState<Model>(
    val data: Model? = null,
    val isLoading : Boolean = false,
    val error : String = ""
)