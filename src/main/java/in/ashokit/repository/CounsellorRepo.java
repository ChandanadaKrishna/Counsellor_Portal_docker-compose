package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.Entity.Counsellor;

public interface CounsellorRepo extends JpaRepository<Counsellor, Integer> {
	
	public Counsellor findByEmail(String email);
	
	public Counsellor findByEmailAndPassword(String email,String password);

}
