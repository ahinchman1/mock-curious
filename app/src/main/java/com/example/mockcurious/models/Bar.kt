package com.example.mockcurious.models

data class Bar(val name: String,
               val address: String,
               val image: String,
               val description: String,
               val barFilters: Filters)

data class Filters(val atmosphere: String,
                   val barServiceOptions: List<ServiceOption>,
                   val conversationFriendly: Boolean,
                   val petFriendly: Boolean,
                   val closingTime: String)

data class ServiceOption(
    val coffeeEspresso: Boolean,
    val nitroCoffee: Boolean,
    val mocktails: Boolean,
    val appetizers: Boolean,
    val arcadeGames: Boolean,
    val poolDarts: Boolean,
    val liveMusic: Boolean,
    val trivia: Boolean
)