package dto

import entity.EmployeeAttendanceEntity
import io.micronaut.serde.annotation.Serdeable
import java.time.LocalDate

@Serdeable
data class Attendance(
    val id: String,
    val name: String,
    val date: LocalDate,
    val status: String
) {
    fun toEmployeeAttendanceEntity(): EmployeeAttendanceEntity {
        val attendanceEntity = EmployeeAttendanceEntity()
        attendanceEntity.employeeId = this.id
        attendanceEntity.status = this.status
        attendanceEntity.date = this.date
        attendanceEntity.name = this.name
        return attendanceEntity
    }
}
