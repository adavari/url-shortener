package com.adavari.shortener.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "url", indexes = [
    Index(name = "url_idx", columnList = "url", unique = false)
])
data class Url(
    @Id val id: String,
    @Column(name = "url", nullable = false) val url: String,
    @Column(name = "created_at", nullable = false) val createdAt: LocalDateTime
)
