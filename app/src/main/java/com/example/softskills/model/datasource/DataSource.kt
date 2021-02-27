package com.example.softskills.model.datasource

interface DataSource<T> {
    fun getData(): T
}