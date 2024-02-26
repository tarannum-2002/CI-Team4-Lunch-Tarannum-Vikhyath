package service

import dto.Employee
import io.restassured.RestAssured.`when`
import jakarta.persistence.EntityManager
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import dto.Attendance
import entity.EmployeeAttendanceEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import repository.AttendanceRepository
import java.time.LocalDate

class AttendanceServiceTest {

    private val attendanceRepository = mock(AttendanceRepository::class.java)
    private val attendanceService = AttendanceService(attendanceRepository)

    @Test
    fun getCountByDateAndStatus() {
        // Mocking the behavior of attendanceRepository
        `when`(attendanceRepository.countByDateAndStatus(LocalDate.now(), "present")).thenReturn(5)

        val count = attendanceService.getCountByDateAndStatus(LocalDate.now(), "present")

        assertEquals(5, count)

    }

    @Test
    fun checkExistByIdAndDate() {
        `when`(attendanceRepository.existsByEmployeeIdAndDate("employeeId", LocalDate.now())).thenReturn(true)

        val exists = attendanceService.checkExistByIdAndDate("employeeId", LocalDate.now())

        assertTrue(exists)
    }

    @Test
    fun getRecordByIdAndDate() {
        val employeeId = "employeeId"
        val date = LocalDate.now()
        val expectedEntity = EmployeeAttendanceEntity(/* initialize with necessary data */)

        // Mocking the behavior of attendanceRepository
        `when`(attendanceRepository.findByEmployeeIdAndDate(employeeId, date)).thenReturn(expectedEntity)

        val actualEntity = attendanceService.getRecordByIdAndDate(employeeId, date)

        assertEquals(expectedEntity, actualEntity)
    }
}