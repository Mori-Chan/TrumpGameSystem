
package common;

/**
 * @author 81906
 *
 */
public class Trump {

	// 名前
	String mark;

	// 値段
	int number;

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Trump(String mark, int number) {
		this.mark = mark;
		this.number = number;
	}
}
