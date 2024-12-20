package kr.ac.kumoh.s20210084.web24TermProject.repository

import kr.ac.kumoh.s20210084.web24TermProject.model.Player
import org.springframework.data.mongodb.repository.MongoRepository

interface PlayerRepository : MongoRepository<Player, String> {

    fun findByName(name: String): Player
    fun findByNum(num: Int): List<Player>
    fun findByPosition(position: String): List<Player>
}