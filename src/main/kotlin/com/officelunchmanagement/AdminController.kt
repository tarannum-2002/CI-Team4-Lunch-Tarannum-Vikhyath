package com.officelunchmanagement

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import jakarta.inject.Inject
import repository.AttendanceRepository
import service.AttendanceService
import java.time.LocalDate


@Controller("/admin")
class AdminController {

    @Inject
    lateinit var attendanceService: AttendanceService

    @Get("/count")
    fun getCountForDate(@QueryValue date: LocalDate, @QueryValue status: String): Int {
        return attendanceService.getCountByDateAndStatus(date,status)
    }
}