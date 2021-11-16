package com.mercadolivro.service

import com.mercadolivro.enums.CustomerStatus
import com.mercadolivro.enums.Role
import com.mercadolivro.exception.NotFoundException
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.util.*

@ExtendWith(MockKExtension::class)
class CustomerServiceTest {

    @MockK
    private lateinit var customerRepository: CustomerRepository

    @MockK
    private lateinit var bookService: BookService

    @MockK
    private lateinit var bCrypt: BCryptPasswordEncoder

    @InjectMockKs
    private lateinit var customerService: CustomerService

    @Test
    fun `should return all customers`() {
        val fakeCustomer = listOf(buildCustomer(), buildCustomer())
        every { customerRepository.findAll() } returns fakeCustomer
        val customers = customerService.getAll(null, null)

        assertEquals(fakeCustomer, customers)
        verify(exactly = 1) { customerRepository.findAll() }
        verify(exactly = 0) { customerRepository.findByEmailContaining(any()) }
        verify(exactly = 0) { customerRepository.findByNameContaining(any()) }
    }

    @Test
    fun `should return all customers when name is informat`() {
        val name = "TS-${Math.random().toString()}"
        val email = "${UUID.randomUUID()}@email.com"

        val fakeCustomer = listOf(buildCustomer(), buildCustomer())
        every { customerRepository.findByNameContaining(name) } returns fakeCustomer
        every { customerRepository.findByEmailContaining(email) } returns fakeCustomer

        val customers = customerService.getAll(name, email)

        assertEquals(fakeCustomer, customers)
        verify(exactly = 0) { customerRepository.findAll() }
        verify(exactly = 1) { customerRepository.findByNameContaining(name) }
        verify(exactly = 0) { customerRepository.findByEmailContaining(email) }
    }

    @Test
    fun `should create cusomter and encrypt password`() {
        val initialPassword = Random().nextInt().toString()
        val fakeCustomer = buildCustomer(password = initialPassword)
        val fakePassword = "${UUID.randomUUID().toString()}"
        val fakeCustomerEncrypt = fakeCustomer.copy(password = fakePassword)

        // mocks
        every { customerRepository.save(fakeCustomerEncrypt) } returns fakeCustomer
        every { bCrypt.encode(initialPassword) } returns fakePassword

        customerService.create(fakeCustomer)

        verify(exactly = 1) { customerRepository.save(fakeCustomerEncrypt) }
        verify(exactly = 1) { bCrypt.encode(initialPassword) }
    }

    @Test
    fun `should return customer by id`(){
        val id = Random().nextInt()
        val fakeCustomer = buildCustomer(id = id)

        // mock
        every { customerRepository.findById(id) } returns Optional.of(fakeCustomer)

        val customer  = customerService.findById(id)

        assertEquals(fakeCustomer, customer)
        verify(exactly = 1) {customerRepository.findById(id)}
    }

    @Test
    fun `should throw error when customer not found`(){
        val id = Random().nextInt()

        // mock
        every { customerRepository.findById(id) } returns Optional.empty()

        val error  = assertThrows<NotFoundException> {
            customerService.findById(id)
        }

        assertEquals("Customer [${id}] not exists", error.message)
        assertEquals("ML-201", error.errorCode)
        verify(exactly = 1) {customerRepository.findById(id)}
    }

    // generate fake customer
    fun buildCustomer(
        id: Int? = null,
        name: String = "customer name",
        email: String = "${UUID.randomUUID()}@email.com",
        password: String = "password"
    ) = CustomerModel(
        id = id,
        name = name,
        email = email,
        status = CustomerStatus.ATIVO,
        password = password,
        roles = setOf(Role.CUSTOMER)
    )
}