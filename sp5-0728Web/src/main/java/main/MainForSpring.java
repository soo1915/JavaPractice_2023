package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import dao.BoardDto;
import service.BoardService;

public class MainForSpring {

	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws IOException {
		ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		BufferedReader reader = 
				new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("명령어를 입력하세요:");
			String command = reader.readLine();
			if (command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			if (command.startsWith("new ")) {
				String[] aaa = command.split(" ");
				for (String ss : aaa) {
					System.out.println(ss);
				}
				processNewCommand(command.split(" "));
				continue;
			} else if (command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
				continue;
			} else if (command.equals("list")) {
				processListCommand();
				continue;
			}
			printHelp();
		}
	}

	private static void processNewCommand(String[] arg) {
		if (arg.length != 4) {
			printHelp();
			return;
		}
		BoardService boardService = ctx.getBean("boardService", BoardService.class);
		BoardDto dto = new BoardDto();
		dto.setWriter(arg[1]);
		dto.setTitle(arg[2]);
		dto.setContent(arg[3]);
		boardService.saveOne(dto);
		System.out.println("글을 등록했습니다.");

	}

	private static void processChangeCommand(String[] arg) {
		if (arg.length != 5) {
			printHelp();
			return;
		}
		BoardService boardService = ctx.getBean("boardService", BoardService.class);
		Long num = (arg[1].length() > 0) ? Long.parseLong(arg[1])
                : 0;
		if (num != 0 && boardService.hasArticle(num)) {
			BoardDto dto = new BoardDto(num, arg[2], arg[3], arg[4], null, 0);
			boardService.modifyOne(dto);
			System.out.println("글을 수정했습니다.");
		} else {
			System.out.println("글 번호가 오류입니다.");
		}
	}

	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("명령어 사용법:");
		System.out.println("new 저자명 글제목 글내용");
		System.out.println("change 번호 저자명 글제목 글내용");
		System.out.println();
	}

	private static void processListCommand() {
		BoardService boardService = ctx.getBean("boardService", BoardService.class);
		ArrayList<BoardDto> list = boardService.findAll();
		for (BoardDto dto : list) {
			System.out.println(dto);
		}
		
	}

}