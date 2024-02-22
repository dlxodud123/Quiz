package login.service;

import java.util.Scanner;

import login.dao.LoginDAO;
import login.dto.LoginDTO;

public class LoginServicImpl implements LoginService{
	Scanner sc = new Scanner(System.in);
	LoginDAO dao = new LoginDAO();

	@Override
	public void display() {
		while (true) {
			System.out.print("1.로그인\n2.회원가입\n3.회원 목록\n4.탈퇴\n5.종료\n>>> : ");
			int func1 = sc.nextInt();
			switch (func1) {
			case 1:
				login();
				break;
			case 2:
				join();
				break;
			case 3:
				list();
				break;
			case 4:
				out();
				break;
			case 5:
				shutdown();
				return;
			default:
				System.out.println("다시입력해주세요");
				break;
			}
		}
	}

	@Override
	public void login() {
		System.out.print("아이디 입력 : ");
		String id2 = sc.next();
		System.out.print("비밀번호 입력 : ");
		String pwd2 = sc.next();

		if (dao.check(id2, pwd2)) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("회원가입 진행해주세요");
		}
	}

	@Override
	public void join() {
		LoginDTO dto = new LoginDTO();
		while (true) {
			System.out.println("----회원가입----");
			System.out.print("아이디 입력 : ");
			String id = sc.next();
			if (dao.overlapCheck(id)) {
				System.out.println("아이디가 중복되었습니다");
				continue;
			}else {
				dto.setId(id);
				System.out.println("아이디 사용이 가능합니다.");
				break;
			}
		}
		System.out.print("비밀번호 입력 : ");
		dto.setPwd(sc.next());
		dao.register(dto);
		System.out.println("회원가입 성공");
	}

	@Override
	public void list() {
		while (true) {
			System.out.print("목록에 들어가려면 압호를 입력하시오.(나가려면 1번 입력)\n>>> : ");
			int secret = sc.nextInt();
			if (dao.secret(secret)) {
				System.out.println("인증 통과 !!!");
				dao.list();
				break;
			}else if (secret == 1) {
				System.out.println("나가기");
				return;
			}
			else {
				System.out.println("암호가 틀렸습니다.");
				continue;
			}
		}
	}

	@Override
	public void out() {
		if (dao.noneExit()) {
			System.out.println("탈퇴할 아이디가 없습니다");
			return;
		}
		System.out.print("탈퇴할 아이디 입력 : ");
		String exitId = sc.next();
		if (dao.exit(exitId)) {
			System.out.println("탈퇴되었습니다.");
		}else {
			System.out.println("일치하는 아이디가 없습니다");
		}
	}

	@Override
	public void shutdown() {
		System.out.println("종료되었습니다.");
	}
}
