package com.unquiler.beunquiler.services

import com.unquiler.beunquiler.repositories.entities.Cancha

interface CanchaService {
    fun getByClubName(clubName:String):Array<Cancha>
    fun getLastCanchas(qty: Int): Array<Cancha>
}