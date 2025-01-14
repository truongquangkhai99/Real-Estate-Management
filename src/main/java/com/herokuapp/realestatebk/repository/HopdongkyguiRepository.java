package com.herokuapp.realestatebk.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.herokuapp.realestatebk.entity.Hopdongkygui;

@Repository
public interface HopdongkyguiRepository extends CrudRepository<Hopdongkygui, Integer> {

	@Query("select count(kg) from hopdongkygui kg where khachhang.khid = :khid")
	int countHopdongkyguiByKhID(@Param("khid") int khid);
}
