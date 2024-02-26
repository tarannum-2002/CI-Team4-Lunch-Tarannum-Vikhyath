package repository

import entity.EmployeeAttendanceEntity
import entity.EmployeeAttendanceId
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import java.time.LocalDate

@Repository
interface AttendanceRepository : CrudRepository<EmployeeAttendanceEntity, Int> {

    fun findByEmployeeIdAndDate(employeeId:String,date: LocalDate):EmployeeAttendanceEntity
    fun existsByEmployeeIdAndDate(employeeId: String, date: LocalDate): Boolean
    fun countByDateAndStatus(date: LocalDate,status:String):Int
}