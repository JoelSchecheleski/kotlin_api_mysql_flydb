package com.mercadolivro.repository

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.model.BookModel
import com.mercadolivro.model.CustomerModel
import com.sun.source.tree.BinaryTree
import com.sun.source.tree.ExpressionTree
import com.sun.source.tree.Tree
import com.sun.source.tree.TreeVisitor
import org.aspectj.weaver.Position
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface BookRepository: JpaRepository<BookModel, Int> {
     fun findByStatus(status: BookStatus, pageable: Pageable): Page<BookModel>
     fun findByCustomer(customer: CustomerModel): List<BookModel>

//     fun findAll(pageable: Pageable): Page<BookModel>
}
