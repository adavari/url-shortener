package com.adavari.shortener.repository

import com.adavari.shortener.entity.Url
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UrlRepository : JpaRepository<Url, String>