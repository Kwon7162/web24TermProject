package kr.ac.kumoh.s20210084.web24TermProject.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "players")
data class Player(
    @Id
    var id: String? = null,
    var name: String,
    var position: String,
    var num: Int,
    var des: String,
    var url: String,
)
