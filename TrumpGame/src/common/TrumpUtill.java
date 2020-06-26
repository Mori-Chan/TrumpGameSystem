package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 81906
 *
 */
public class TrumpUtill {

	/**
	 * fileの中のTrump.csvを読み込んで、
	 * ArrayList<Trump>の形に変換して返す
	 * @return 料理一覧
	 */
	public static ArrayList<Trump> getTrumpList() {
		ArrayList<Trump> trumpList = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File("file/Trump.csv"))) {
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] input = line.split(",");
				Trump trump = new Trump(input[0],Integer.parseInt(input[1]));
				trumpList.add(trump);
			}
		} catch (FileNotFoundException e) {
			System.out.println("ファイルが見つかりません");
		}
		return trumpList;
	}

}
