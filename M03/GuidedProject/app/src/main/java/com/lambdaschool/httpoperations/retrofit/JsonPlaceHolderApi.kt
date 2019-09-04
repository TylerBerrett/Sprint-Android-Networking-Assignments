package com.lambdaschool.httpoperations.retrofit

import com.lambdaschool.httpoperations.model.Employee
import retrofit2.Call
import retrofit2.http.*

interface JsonPlaceHolderApi {
    // TODO: Create API for different endpoints


    @GET("employees")
    fun getEmployees(): Call<List<Employee>>

    @GET("emloyees/{id}")
    fun getEmployeesById(@Path("id") employeeId: String): Call<List<Employee>>

    @GET("employees")
    fun getEmployeesByAge(@Query("age")employeeAge: String): Call<List<Employee>>

    @POST("employees")
    fun addNewEmployee(@Body employee: Employee): Call<Employee>

    @PUT("employees")
    fun updateEmployee(@Body employee: Employee): Call<Employee>

    @DELETE("emloyees/{id}")
    fun deleteEmployeeById(@Path("id") id: String): Call<Void>


    class Factory {
        companion object{
            val BASE_URL = "https://demo8143297.mockable.io"
        }
        //have to do somthing like this in the assignment
        fun getUrl() {
            Factory.BASE_URL
        }
    }
}