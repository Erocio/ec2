/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.casoec2.repository;

import com.example.casoec2.entity.Editorial;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


/**
 *
 * @author Juan
 */
@Mapper
public interface EditorialMyBatisRepository {
    @Select("select * from editorial")
    public List<Editorial> findAll();
}