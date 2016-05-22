package br.com.application.data;

public enum GenderData {

	FEMALE('F'), MALE('M');
	
	private char gender;

	private GenderData(char gender) {
		this.gender = gender;
	}
	public char getGender() {
		return gender;
	}
}
