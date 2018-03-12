package cn.customs.h2018.example.business1;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Bussiness1 {
	private int id;
	private String title;
	private String body;

	public Bussiness1() {
	}

	public Bussiness1(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}

}
