/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.casoec2.repository;

import com.example.casoec2.entity.Libro;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 *
 * @author Juan
 */
@Mapper
public interface LibroMyBatisRepository {
    @Select("select l.idlibro, l.nombre, concat(a.apellido) as autor, e.nombre editorial from libro as l\n" +
    "inner join autor as a on l.idautor = a.idautor\n" +
    "inner join editorial as e on l.ideditorial = e.ideditorial")
    public List<Map<String,Object>> findAll();
    
    @Select("select * from libro where idlibro=#{id}")
    public Libro readLibro(int id);

    @Delete("DELETE FROM libro WHERE idlibro = #{id}")
    public int deleteById(int id);
    
    @Insert("INSERT INTO libro(nombre, idautor,ideditorial) VALUES (#{nombre}, #{idautor},#{ideditorial})")
    public int insert(Libro libro);
    //UPDATE `bdejemplo`.`producto` SET `nombre` = 'www', `precio` = '5', `idcategoria` = '2' WHERE (`idproducto` = '19');
    @Update("Update libro set nombre=#{nombre}, idautor=#{idautor}, ideditorial=#{ideditorial} where idlibro=#{idlibro}")
    public int update(Libro libro);
}