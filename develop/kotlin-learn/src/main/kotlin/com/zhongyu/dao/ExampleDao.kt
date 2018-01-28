package com.zhongyu.dao

import com.zhongyu.bean.Example
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ExampleDao : JpaRepository<Example, Int>