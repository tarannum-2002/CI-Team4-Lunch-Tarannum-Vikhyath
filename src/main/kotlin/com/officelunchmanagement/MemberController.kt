package com.officelunchmanagement


import dto.Attendance
import dto.Employee
import entity.EmployeeAttendanceEntity
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import jakarta.inject.Inject
import repository.AttendanceRepository
import repository.EmployeeRepository
import service.AttendanceService
import service.EmployeeService
import java.time.LocalDate


@Controller("/member")
class MemberController {
    @Inject
    lateinit var employeeService: EmployeeService

    @Inject
    lateinit var attendanceService: AttendanceService

    @Post("/")
    fun createEmployee(@Body employee: Employee): HttpResponse<String>? {
        if (!employeeService.checkIfEmployeeExists(employee.id)) {
            employeeService.createEmployeeRecord(employee)
            return HttpResponse.ok("Employee Created");
        }
        return HttpResponse.badRequest("Already Exist!!!")
    }

    @Post("/addpreference")
    fun addPreference(@Body attendance: Attendance): HttpResponse<String>? {
        if (!attendanceService.checkExistByIdAndDate(attendance.id, attendance.date)) {
            attendanceService.createAttendance(attendance)
            return HttpResponse.ok("Preference Saved Successfully");
        }
        return HttpResponse.badRequest("Already Exist, Cannot add")
    }

    @Get("/check")
    fun checkAndReturnRecord(
        @QueryValue id: String,
        @QueryValue name: String,
        @QueryValue date: LocalDate,
    ): EmployeeAttendanceEntity {

        if (attendanceService.checkExistByIdAndDate(id, date)) {
            val record = attendanceService.getRecordByIdAndDate(id, date)
            return record
        } else {
            val attendance = Attendance(id, name, date, "Not Specified")
            val record = attendance.toEmployeeAttendanceEntity()
            return record
        }

    }

}