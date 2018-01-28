package com.zhongyu.dao

import com.zhongyu.bean.Example
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by ZhongYu on 06/08/2017.
 */
@Repository
interface ExampleRepository extends JpaRepository<Example, Long> {

}