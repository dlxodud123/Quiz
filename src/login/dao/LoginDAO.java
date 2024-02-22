package login.dao;

import java.util.ArrayList;

import login.dto.LoginDTO;

public class LoginDAO {
	public static ArrayList<LoginDTO> arr;
	static {
		arr = new ArrayList<>();
	}
	public boolean check(String id2, String pwd2) {
		for (LoginDTO d : arr) {
			if (id2.equals(d.getId()) && pwd2.equals(d.getPwd())) {
				return true;
			}
		}
		return false;
	}
	public boolean overlapCheck(String id) {
		for (LoginDTO d : arr) {
			if (id.equals(d.getId())) {
				return true;
			}
		}
		return false;
	}
	public void register(LoginDTO dto) {
		arr.add(dto);
	}
	public void list() {
		System.out.println("----목록 확인----");
		for (LoginDTO d : arr) {
			System.out.println("아이디 : " + d.getId());
			System.out.println("비밀번호 : " + d.getPwd());
			System.out.println("------------");
		}
	}
	public boolean noneExit() {
		if (arr.isEmpty()) {
			return true;
		}
		return false;
	}
	public boolean exit(String exitId) {
		for (LoginDTO d : arr) {
			if (exitId.equals(d.getId())) {
				arr.remove(d);
				return true;
			}
		}
		return false;
	}
	public boolean secret(int secret) {
		LoginDTO d = new LoginDTO();
		if (secret == d.getSecret()) {
			return true;
		}
		return false;
	}
}
