package com.unquiler.beunquiler.services.impl

import com.unquiler.beunquiler.repositories.dao.ClubRepository
import com.unquiler.beunquiler.repositories.entities.Club
import com.unquiler.beunquiler.services.ClubService
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ClubServiceImpl : ClubService {
    @Autowired
    lateinit var clubRepository: ClubRepository

    override fun register(club: Club): Club {
        val isClubTaken = clubRepository.existsClubByEmail(club.getEmail()!!)
        if (isClubTaken) {
            throw RuntimeException("El club ya existe")
        }
        return clubRepository.save(club)
    }
}