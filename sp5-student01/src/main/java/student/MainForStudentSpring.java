package student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForStudentSpring {

	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws IOException{
		ctx = new AnnotationConfigApplicationContext(StudentCtx.class);
		//BufferedReader는 왕창 가지고 올 수 있음
		// reader로 붙으면 2바이트로 가져옴(표준 입력 장치로부터 읽어옴)
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("명령어를 입력하세요:");
			String command = reader.readLine();
			//equalsIgnoreCase : 대소문자 상관없이 비교
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다");
				break;
			}
			// 요청 받아서 분기 시키기
			if(command.startsWith("new ")) { 
				processNewCommand(command.split(" ")); // 1칸짜리 공백으로 자르기
				continue;
			} else if(command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
				continue;
			} else if(command.equals("list")) {
				processListCommand();
				continue;
			} else if(command.startsWith("info")) {
				processInfoCommand(command.split(" " ));
				continue;
			} else if(command.equals("version")) {
				processVersionCommand();
				continue;
			}
			printHelp();
		}
	}
	
	private static void processNewCommand(String[] arg) {
		if(arg.length != 5) {
			printHelp();
			return;
		}
		StudentRegisterService regSvc = ctx.getBean("regSvc", StudentRegisterService.class);
		StudentRequest req = new StudentRequest();;
		req.setPhone(arg[1]);
		req.setName(arg[2]);
		req.setPasswd(arg[3]);
		req.setConfirmPasswd(arg[4]);
		
		if(!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호와 확인이 일치하지 않습니다.\n");
			return;
		}
		try {
			regSvc.regist(req);
			System.out.println("등록했습니다.\n");
		} catch (DuplicationStudentException e) {
			System.out.println("이미 존재하는 전화번호입니다. \n");
		}
	}
	
	private static void processChangeCommand(String[] arg) {
		if(arg.length != 4) {
			printHelp();
			return;
		}
		ChangePasswordService changePwdSvc = ctx.getBean("pwdSvc", ChangePasswordService.class);
		try {
			changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호를 변경했습니다. \n");
		} catch (StudentNotFoundException e) {
			System.out.println("존재하지 않는 전화번호입니다. \n");
		} catch (WrongIdPasswordException e) {
			System.out.println("전화번호과 암호가 일치하지 않습니다. \n");
		}
	}
	
	private static void processListCommand() {
		StudentListPrinter listPrinter = ctx.getBean("list", StudentListPrinter.class);
		listPrinter.printAll();
	}
	
	private static void processInfoCommand(String[] arg) {
		if(arg.length != 2) {
			printHelp();
			return;
		}
		StudentInfoPrinter infoPrinter = ctx.getBean("info", StudentInfoPrinter.class);
		infoPrinter.printStudentInfo(arg[1]);
	}

	private static void processVersionCommand() {
		VersionPrinter versionPrinter = ctx.getBean("version", VersionPrinter.class);
		versionPrinter.print();
	}
	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("명령어 사용법");
		System.out.println("new 전화번호 이름 암호 암호확인");
		System.out.println("change 전화번호 현재비번 변경비번");
		System.out.println();
	}
}
