package service

import dto.Attendance
import entity.EmployeeAttendanceEntity
import jakarta.inject.Inject
import jakarta.inject.Singleton
import repository.AttendanceRepository
import java.time.LocalDate


@Singleton
class AttendanceService(private val attendanceRepository: AttendanceRepository) {
    fun getCountByDateAndStatus(date: LocalDate,status:String): Int {
        val count = attendanceRepository.countByDateAndStatus(date,status)
        return count
    }

    fun checkExistByIdAndDate(id:String,date: LocalDate): Boolean {
        return attendanceRepository.existsByEmployeeIdAndDate(id,date)
    }

    fun createAttendance(attendance: Attendance){
        attendanceRepository.save(attendance.toEmployeeAttendanceEntity())
    }

    fun getRecordByIdAndDate(id: String,date: LocalDate): EmployeeAttendanceEntity {
        return attendanceRepository.findByEmployeeIdAndDate(id,date)
    }
}