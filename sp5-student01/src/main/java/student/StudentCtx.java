package student;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentCtx {

	@Bean
	public StudentDao studentDao() {
		return new StudentDao();
	}
	
	@Bean
	public StudentRegisterService regSvc() {
		return new StudentRegisterService(studentDao());
	}
	
	@Bean
	public ChangePasswordService pwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setStudentDao(studentDao());
		return pwdSvc;
	}
	
	@Bean
	public StudentPrinter printer() {
		return new StudentPrinter();
	}
	
	@Bean
	public StudentListPrinter list() {
		return new StudentListPrinter(studentDao(), printer());
	}
	
	@Bean
	public StudentInfoPrinter info() {
		StudentInfoPrinter info = new StudentInfoPrinter();
		info.setStudentDao(studentDao());
		info.setPrinter(printer());
		return info;
	}
	
	@Bean
	public VersionPrinter version() {
		VersionPrinter version = new VersionPrinter();
		version.setMajorVersion(5);
		version.setMinorVersion(0);
		return version;
	}
}
