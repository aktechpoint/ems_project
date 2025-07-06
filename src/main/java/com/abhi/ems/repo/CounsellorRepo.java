package com.abhi.ems.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.ems.entity.Counsellor;

public interface CounsellorRepo extends JpaRepository<Counsellor, Integer> {
	//select * from counsellor_tbl where email=:email and pwd=:pwd
	public Counsellor findByEmailAndPwd(String email, String pwd);


	//select * from counsellor_tbl where email=:email
	public Counsellor findByEmail(String email);
}
