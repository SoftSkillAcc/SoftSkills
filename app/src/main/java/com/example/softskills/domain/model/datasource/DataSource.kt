package com.example.softskills.domain.model.datasource

interface DataSource<T> {
    fun getData(): T
}