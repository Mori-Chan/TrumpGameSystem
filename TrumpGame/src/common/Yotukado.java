package common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author 81906
 *
 */

public class Yotukado {
    public static void main(String[] args) {
    	// TrumpUtillクラスのgetTrumpListメソッドを使用してトランプ一覧を取得

		ArrayList<Trump> trumpList = TrumpUtill.getTrumpList();

		//TODO 以下をMethodとする
		System.out.println("----------四つ角　ルール説明----------");
		System.out.println();
		System.out.println("四つ角は、すでに場に出ている2枚のカードと自分の手番に引いた1枚のカードを照らし合わせて、");
		System.out.println("役(以下に記述)を作ったら罰ゲーム(SHOT!!!)となる新宿二丁目発祥の飲みゲームです。");
		System.out.println("各プレイヤーは、役を回避することに尽力してください。");
		System.out.println();
		System.out.println("3人以上のプレイヤーで行います。");
		System.out.println("3枚の禁止カードを決めます。");
		System.out.println("3枚の禁止カード・フラッシュ(3枚ともマークが同じ)・ストレート(階段状に数字が並ぶ)・スリーカード(3枚とも数字が同じ)");
		System.out.println("の時にカードを引いた人が罰ゲームを受けます。");
		System.out.println();
		System.out.println("また、ジョーカーを引いた場合は、");
		System.out.println("1つ前の人が罰ゲームを受けます。");
		System.out.println();
		System.out.println("--------------------------------------");
		System.out.println();

		Scanner scanner = new Scanner(System.in);

		ArrayList<Trump> usedTrumpList = new ArrayList<>();
		Collections.shuffle(trumpList);
		int count = 0;
		ArrayList<String> members = new ArrayList<String>();

		int memberCount = 0;
		String member = null;
		do {
			try {
				System.out.println((memberCount + 1) + "人目のプレイヤー名を入力してください。");
				if(memberCount > 2) {
					System.out.println("決定の場合は、何も入力せずにEnterを押してください。");
				}

				member = scanner.nextLine();
				if(memberCount < 2 && member.equals("")) {
					System.out.println("何も入力されてません。");
					System.out.println("もう一度入力してください。");
				} else if(memberCount >= 2 && member.equals("")) {
					System.out.println();
					System.out.println("--------------------------------------------------");
					System.out.println();
					System.out.print("プレイヤーは、\"");
					for(int x = 0; x < members.size(); x++) {
						if(x == (members.size() - 1)) {
							System.out.print(members.get(x));
						} else {
							System.out.print(members.get(x) + ", ");
						}
					}
					System.out.println("\"です。");
					System.out.println("ゲームを開始します。");
					System.out.println();
					System.out.println("--------------------------------------------------");
					System.out.println();
				}  else {
					members.add(member);
					memberCount++;
				}
		 	}catch (InputMismatchException e){
		      System.out.println("型が違います：");
		    }
		} while(memberCount < 2 || !(member.equals("")));

		memberCount = 0;

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int y = 1; y <= 3; y++) {
			do{
				try{
					System.out.println(y + "つ目の禁止カードの数字を入力してください。 例) 1,2,3,4,5,6,7,8,9,10,11,12,13");
					int num = scanner.nextInt();
					if(num >= 1 && num <= 13) {
						numbers.add(num);
					} else {
						System.out.println("1～13までの数字を入力してください。");
					}
				}catch (InputMismatchException e){
				    System.out.println("型が違います：");
				}
			}
			while(numbers.get(y - 1) == null) ;
		}

		System.out.println();
		System.out.println("--------------------------------------------------");
		System.out.println();
		System.out.print("禁止カードは、\"");
		for(int z = 0; z < numbers.size(); z++) {
			if(z == (numbers.size() - 1)) {
				System.out.print(numbers.get(z));
			} else {
				System.out.print(numbers.get(z) + ", ");
			}
		}

		System.out.println("\"の3つです。");
		System.out.println();
		System.out.println("--------------------------------------------------");
		System.out.println();

		for (int i = trumpList.size() - 1; i >= 0; i--) {
			if(count == 0) {
				if(trumpList.get(i).getMark().equals("ジョーカー")) {
					System.out.println("最初のカードは、\"" + trumpList.get(i).getMark() + "\"です。");
				} else if(trumpList.get(i).getNumber() == 1) {
					System.out.println("最初のカードは、\"" + trumpList.get(i).getMark() + "のA\"です。");
				} else if(trumpList.get(i).getNumber() == 11) {
					System.out.println("最初のカードは、\"" + trumpList.get(i).getMark() + "のJ\"です。");
				} else if(trumpList.get(i).getNumber() == 12) {
					System.out.println("最初のカードは、\"" + trumpList.get(i).getMark() + "のQ\"です。");
				} else if(trumpList.get(i).getNumber() == 13) {
					System.out.println("最初のカードは、\"" + trumpList.get(i).getMark() + "のK\"です。");
				} else {
					System.out.println("最初のカードは、\"" + trumpList.get(i).getMark() + "の" + trumpList.get(i).getNumber() + "\"です。");
				}
			} else if(count == 1) {
				if(trumpList.get(i).getMark().equals("ジョーカー")) {
					System.out.println("２番目のカードは、\"" + trumpList.get(i).getMark() + "\"です。");
				} else if(trumpList.get(i).getNumber() == 1) {
					System.out.println("２番目のカードは、\"" + trumpList.get(i).getMark() + "のA\"です。");
				} else if(trumpList.get(i).getNumber() == 11) {
					System.out.println("２番目のカードは、\"" + trumpList.get(i).getMark() + "のJ\"です。");
				} else if(trumpList.get(i).getNumber() == 12) {
					System.out.println("２番目のカードは、\"" + trumpList.get(i).getMark() + "のQ\"です。");
				} else if(trumpList.get(i).getNumber() == 13) {
					System.out.println("２番目のカードは、\"" + trumpList.get(i).getMark() + "のK\"です。");
				} else {
					System.out.println("２番目のカードは、\"" + trumpList.get(i).getMark() + "の" + trumpList.get(i).getNumber() + "\"です。");
				}
			}
			if(!(count == 0 || count == 1)) {
				//TODO クリックで処理を実行できるようにする（名前の入力でもいいかも）

				/*プレイヤー名をfor文前で入力してもらい、for文内(以下)では、
				 * System.out.println("Enterを押してください。");と、new java.util.Scanner(System.in).nextLine();の組み合わせも可。
				 * あらかじめ、参加可能なプレイヤーの数を限定しておいてもよい。
				 * そうでない場合、プレイヤーの数だけ、String name = new java.util.Scanner(System.in).nextLine();を繰り返す必要がある。
				 */

				System.out.println("\"" + members.get(memberCount) + "\"は、Enterキーを押してください。カードを引きます。");
				scanner.nextLine();
				if(count == 2) {
					scanner.nextLine();
				}

				if(usedTrumpList.get(count - 2).getMark().equals("ジョーカー")) {
					System.out.println("２つ前のカードは、\"" + usedTrumpList.get(count - 2).getMark() + "\"です。");
				} else if(usedTrumpList.get(count - 2).getNumber() == 1) {
					System.out.println("２つ前のカードは、\"" + usedTrumpList.get(count - 2).getMark() + "のA\"です。");
				} else if(usedTrumpList.get(count - 2).getNumber() == 11) {
					System.out.println("２つ前のカードは、\"" + usedTrumpList.get(count - 2).getMark() + "のJ\"です。");
				} else if(usedTrumpList.get(count - 2).getNumber() == 12) {
					System.out.println("２つ前のカードは、\"" + usedTrumpList.get(count - 2).getMark() + "のQ\"です。");
				} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
					System.out.println("２つ前のカードは、\"" + usedTrumpList.get(count - 2).getMark() + "のK\"です。");
				} else {
					System.out.println("２つ前のカードは、\"" + usedTrumpList.get(count - 2).getMark() + "の" + usedTrumpList.get(count - 2).getNumber() + "\"です。");
				}
				if(usedTrumpList.get(count - 1).getMark().equals("ジョーカー")) {
					System.out.println("１つ前のカードは、\"" + usedTrumpList.get(count - 1).getMark() + "\"です。");
				} else if(usedTrumpList.get(count - 1).getNumber() == 1) {
					System.out.println("１つ前のカードは、\"" + usedTrumpList.get(count - 1).getMark() + "のA\"です。");
				} else if(usedTrumpList.get(count - 1).getNumber() == 11) {
					System.out.println("１つ前のカードは、\"" + usedTrumpList.get(count - 1).getMark() + "のJ\"です。");
				} else if(usedTrumpList.get(count - 1).getNumber() == 12) {
					System.out.println("１つ前のカードは、\"" + usedTrumpList.get(count - 1).getMark() + "のQ\"です。");
				} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
					System.out.println("１つ前のカードは、\"" + usedTrumpList.get(count - 1).getMark() + "のK\"です。");
				} else {
					System.out.println("１つ前のカードは、\"" + usedTrumpList.get(count - 1).getMark() + "の" + usedTrumpList.get(count - 1).getNumber() + "\"です。");
				}

				if(trumpList.get(i).getMark().equals("ジョーカー")) {
					System.out.println("\"" + members.get(memberCount) + "\"が引いたカードは、\"" + trumpList.get(i).getMark() + "\"です。");
					if(memberCount == 0) {
						System.out.println("\"" + members.get(members.size() - 1) + "\"は、１杯飲んでください。");
					} else {
						System.out.println("\"" + members.get(memberCount - 1) + "は、１杯飲んでください。");
					}
					System.out.println("\"" + members.get(memberCount) + "は、もう一度カードを引いてください。");
				} else if(trumpList.get(i).getNumber() == 1) {
					System.out.println("\"" + members.get(memberCount) + "\"が引いたカードは、\"" + trumpList.get(i).getMark() + "のA\"です。");
				} else if(trumpList.get(i).getNumber() == 11) {
					System.out.println("\"" + members.get(memberCount) + "\"が引いたカードは、\"" + trumpList.get(i).getMark() + "のJ\"です。");
				} else if(trumpList.get(i).getNumber() == 12) {
					System.out.println("\"" + members.get(memberCount) + "\"が引いたカードは、\"" + trumpList.get(i).getMark() + "のQ\"です。");
				} else if(trumpList.get(i).getNumber() == 13) {
					System.out.println("\"" + members.get(memberCount) + "\"が引いたカードは、\"" + trumpList.get(i).getMark() + "のK\"です。");
				} else {
					System.out.println("\"" + members.get(memberCount) + "\"が引いたカードは、\"" + trumpList.get(i).getMark() + "の" + trumpList.get(i).getNumber() + "\"です。");
				}

				//TODO 罰ゲームの組み合わせを分岐で記述
				int selfDrinkCount = 0;

				// 入力された数値
				if(numbers.get(0) == trumpList.get(i).getNumber() || numbers.get(1) == trumpList.get(i).getNumber() || numbers.get(2) == trumpList.get(i).getNumber()) {
					if(trumpList.get(i).getNumber() == 1) {
						System.out.println("\"A\"は禁止カードです。");
						selfDrinkCount += 1;
					} else if(trumpList.get(i).getNumber() == 11) {
						System.out.println("\"J\"は禁止カードです。");
						selfDrinkCount += 1;
					} else if(trumpList.get(i).getNumber() == 12) {
						System.out.println("\"Q\"は禁止カードです。");
						selfDrinkCount += 1;
					} else if(trumpList.get(i).getNumber() == 13) {
						System.out.println("\"K\"は禁止カードです。");
						selfDrinkCount += 1;
					} else {
						System.out.println("\"" + trumpList.get(i).getNumber() + "\"は禁止カードです。");
						selfDrinkCount += 1;
					}
				}

				// フラッシュ
				if(trumpList.get(i).getMark().equals(usedTrumpList.get(count - 1).getMark()) && trumpList.get(i).getMark().equals(usedTrumpList.get(count - 2).getMark())) { // クローバー, クローバー, クローバー
					System.out.println("\"" + trumpList.get(i).getMark() + "\"のフラッシュです。");
					selfDrinkCount ++;
				} else if(usedTrumpList.get(count - 1).getMark().equals("joker") && trumpList.get(i).getMark().equals(usedTrumpList.get(count - 2).getMark())) { // クローバー, joker, クローバー
					System.out.println("\"" + trumpList.get(i).getMark() + "\"のフラッシュです。");
					selfDrinkCount += 1;
				} else if(trumpList.get(i).getMark().equals(usedTrumpList.get(count - 1).getMark()) && usedTrumpList.get(count - 2).getMark().equals("ジョーカー")) { // クローバー, クローバー, joker
					System.out.println("\"" + trumpList.get(i).getMark() + "\"のフラッシュです。");
					selfDrinkCount += 1;
				} else if(usedTrumpList.get(count - 1).getMark().equals("ジョーカー") && usedTrumpList.get(count - 2).getMark().equals("ジョーカー")) { // クローバー, joker, joker
					System.out.println("\"" + trumpList.get(i).getMark() + "\"のフラッシュです。");
					selfDrinkCount += 1;
				} else if(trumpList.get(i).getMark().equals("ジョーカー") && usedTrumpList.get(count - 1).getMark().equals(usedTrumpList.get(count - 2).getMark())) { // joker, クローバー, クローバー
					System.out.println("\"" + usedTrumpList.get(count - 1).getMark() + "\"のフラッシュです。");
					selfDrinkCount += 1;
				} else if(trumpList.get(i).getMark().equals("ジョーカー") && usedTrumpList.get(count - 2).getMark().equals("ジョーカー")) { // joker, クローバー, joker
					System.out.println("\"" + usedTrumpList.get(count - 1).getMark() + "\"のフラッシュです。");
					selfDrinkCount += 1;
				} else if(trumpList.get(i).getMark().equals("ジョーカー") && usedTrumpList.get(count - 1).getMark().equals("ジョーカー")) { // joker, joker, クローバー
					System.out.println("\"" + usedTrumpList.get(count - 2).getMark() + "\"のフラッシュです。");
					selfDrinkCount += 1;
				}


				// ストレート(階段)の判定

				// a, b(a+1), c(a+2)
				if (usedTrumpList.get(count - 1).getNumber() == (trumpList.get(i).getNumber() + 1) && usedTrumpList.get(count - 2).getNumber() == (trumpList.get(i).getNumber() + 2)){
					if(trumpList.get(i).getNumber() == 1) {
						 if(usedTrumpList.get(count - 1).getNumber() == 12) {
							 if(usedTrumpList.get(count - 2).getNumber() == 13) {
								System.out.println("\"A, Q, K\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"A, Q, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
							if(usedTrumpList.get(count - 2).getNumber() == 12) {
								System.out.println("\"A, K, Q\"のストレートです");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"A, K, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else {
							System.out.println("\"A, " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 11) {
						if(usedTrumpList.get(count - 1).getNumber() == 12) {
							if(usedTrumpList.get(count - 2).getNumber() == 13) {
								System.out.println("\"J, Q, K\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"J, Q, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
							if(usedTrumpList.get(count - 2).getNumber() == 12) {
								System.out.println("\"J, K, Q\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"J, K, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else {
							System.out.println("\"J, " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 12) {
						if(usedTrumpList.get(count - 1).getNumber() == 1) {
							if(usedTrumpList.get(count - 2).getNumber() == 13) {
								System.out.println("\"Q, A, K\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("Q, A, " + usedTrumpList.get(count - 2).getNumber() + "のストレートです。");
								selfDrinkCount += 1;
							}
						} else if(usedTrumpList.get(count - 1).getNumber() == 11) {
							if(usedTrumpList.get(count - 2).getNumber() == 13) {
								System.out.println("\"Q, J, K\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"Q, J, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです");
								selfDrinkCount += 1;
							}
						} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
							if(usedTrumpList.get(count - 2).getNumber() == 1) {
								System.out.println("\"Q, K, A\"のストレートです。");
								selfDrinkCount += 1;
							} else if(usedTrumpList.get(count - 1).getNumber() == 11) {
								System.out.println("\"Q, K, J\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"Q, K, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else {
							System.out.println("\"Q, " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 13) {
						if(usedTrumpList.get(count - 1).getNumber() == 1) {
							if(usedTrumpList.get(count - 2).getNumber() == 12) {
								System.out.println("\"K, A, Q\"のストレートです");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"K, A, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if(usedTrumpList.get(count - 1).getNumber() == 11) {
							if(usedTrumpList.get(count - 2).getNumber() == 12) {
								System.out.println("\"K, J, Q\"のストレートです");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"K, J, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if(usedTrumpList.get(count - 1).getNumber() == 12) {
							if(usedTrumpList.get(count - 2).getNumber() == 1) {
								System.out.println("\"K, Q, A\"のストレートです。");
								selfDrinkCount += 1;
							} else if(usedTrumpList.get(count - 1).getNumber() == 11) {
								System.out.println("\"K, Q, J\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"K, Q, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else {
						System.out.println("\"" + trumpList.get(i).getNumber() + ", " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
						selfDrinkCount += 1;
					}
				}

				// a, b(a+2), c(a+1)
				 else if (usedTrumpList.get(count - 1).getNumber() == (trumpList.get(i).getNumber() + 2) && usedTrumpList.get(count - 2).getNumber() == (trumpList.get(i).getNumber() + 1)){
					 if(trumpList.get(i).getNumber() == 1) {
						 if(usedTrumpList.get(count - 1).getNumber() == 12) {
							 if(usedTrumpList.get(count - 2).getNumber() == 13) {
								System.out.println("\"A, Q, K\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"A, Q, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
							if(usedTrumpList.get(count - 2).getNumber() == 12) {
								System.out.println("\"A, K, Q\"のストレートです");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"A, K, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else {
							System.out.println("\"A, " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 11) {
						if(usedTrumpList.get(count - 1).getNumber() == 12) {
							if(usedTrumpList.get(count - 2).getNumber() == 13) {
								System.out.println("\"J, Q, K\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"J, Q, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
							if(usedTrumpList.get(count - 2).getNumber() == 12) {
								System.out.println("\"J, K, Q\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"J, K, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else {
							System.out.println("\"J, " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 12) {
						if(usedTrumpList.get(count - 1).getNumber() == 1) {
							if(usedTrumpList.get(count - 2).getNumber() == 13) {
								System.out.println("\"Q, A, K\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"Q, A, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if(usedTrumpList.get(count - 1).getNumber() == 11) {
							if(usedTrumpList.get(count - 2).getNumber() == 13) {
								System.out.println("\"Q, J, K\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"Q, J, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです");
								selfDrinkCount += 1;
							}
						} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
							if(usedTrumpList.get(count - 2).getNumber() == 1) {
								System.out.println("\"Q, K, A\"のストレートです。");
								selfDrinkCount += 1;
							} else if(usedTrumpList.get(count - 1).getNumber() == 11) {
								System.out.println("\"Q, K, J\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"Q, K, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else {
							System.out.println("\"Q, " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 13) {
						if(usedTrumpList.get(count - 1).getNumber() == 1) {
							if(usedTrumpList.get(count - 2).getNumber() == 12) {
								System.out.println("\"K, A, Q\"のストレートです");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"K, A, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if(usedTrumpList.get(count - 1).getNumber() == 11) {
							if(usedTrumpList.get(count - 2).getNumber() == 12) {
								System.out.println("\"K, J, Q\"のストレートです");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"K, J, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if(usedTrumpList.get(count - 1).getNumber() == 12) {
							if(usedTrumpList.get(count - 2).getNumber() == 1) {
								System.out.println("\"K, Q, A\"のストレートです。");
								selfDrinkCount += 1;
							} else if(usedTrumpList.get(count - 1).getNumber() == 11) {
								System.out.println("\"K, Q, J\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"K, Q, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else {
						System.out.println("\"" + trumpList.get(i).getNumber() + ", " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
						selfDrinkCount += 1;
					}
				}

				// a(b+1), b, c(b+2)
				else if (trumpList.get(i).getNumber() == (usedTrumpList.get(count - 1).getNumber() + 1) && usedTrumpList.get(count - 2).getNumber() == (usedTrumpList.get(count - 1).getNumber() + 2)){
					if (trumpList.get(i).getNumber() == 1) {
						if (usedTrumpList.get(count - 1).getNumber() == 12) {
							if (usedTrumpList.get(count - 2).getNumber() == 13) {
								System.out.println("\"A, Q, K\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"A, Q, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if (usedTrumpList.get(count - 1).getNumber() == 13) {
							if (usedTrumpList.get(count - 2).getNumber() == 12) {
								System.out.println("\"A, K, Q\"のストレートです");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"A, K, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else {
							System.out.println("\"A, " + usedTrumpList.get(count - 1).getNumber() + ", "
									+ usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if (trumpList.get(i).getNumber() == 11) {
						if (usedTrumpList.get(count - 1).getNumber() == 12) {
							if (usedTrumpList.get(count - 2).getNumber() == 13) {
								System.out.println("\"J, Q, K\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"J, Q, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if (usedTrumpList.get(count - 1).getNumber() == 13) {
							if (usedTrumpList.get(count - 2).getNumber() == 12) {
								System.out.println("\"J, K, Q\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"J, K, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else {
							System.out.println("\"J, " + usedTrumpList.get(count - 1).getNumber() + ", "
									+ usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if (trumpList.get(i).getNumber() == 12) {
						if (usedTrumpList.get(count - 1).getNumber() == 1) {
							if (usedTrumpList.get(count - 2).getNumber() == 13) {
								System.out.println("\"Q, A, K\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"Q, A, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if (usedTrumpList.get(count - 1).getNumber() == 11) {
							if (usedTrumpList.get(count - 2).getNumber() == 13) {
								System.out.println("\"Q, J, K\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"Q, J, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです");
								selfDrinkCount += 1;
							}
						} else if (usedTrumpList.get(count - 1).getNumber() == 13) {
							if (usedTrumpList.get(count - 2).getNumber() == 1) {
								System.out.println("\"Q, K, A\"のストレートです。");
								selfDrinkCount += 1;
							} else if (usedTrumpList.get(count - 1).getNumber() == 11) {
								System.out.println("\"Q, K, J\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"Q, K, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else {
							System.out.println("\"Q, " + usedTrumpList.get(count - 1).getNumber() + ", "
									+ usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if (trumpList.get(i).getNumber() == 13) {
						if (usedTrumpList.get(count - 1).getNumber() == 1) {
							if (usedTrumpList.get(count - 2).getNumber() == 12) {
								System.out.println("\"K, A, Q\"のストレートです");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"K, A, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if (usedTrumpList.get(count - 1).getNumber() == 11) {
							if (usedTrumpList.get(count - 2).getNumber() == 12) {
								System.out.println("\"K, J, Q\"のストレートです");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"K, J, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if (usedTrumpList.get(count - 1).getNumber() == 12) {
							if (usedTrumpList.get(count - 2).getNumber() == 1) {
								System.out.println("\"K, Q, A\"のストレートです。");
								selfDrinkCount += 1;
							} else if (usedTrumpList.get(count - 1).getNumber() == 11) {
								System.out.println("\"K, Q, J\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"K, Q, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getNumber() + ", "
									+ usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else {
						System.out.println("\"" + trumpList.get(i).getNumber() + ", " + usedTrumpList.get(count - 1).getNumber()
								+ ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
						selfDrinkCount += 1;
					}
				}

				// a(b+2), b, c(b+1)
				 else if (trumpList.get(i).getNumber() == (usedTrumpList.get(count - 1).getNumber() + 2) && usedTrumpList.get(count - 2).getNumber() == (usedTrumpList.get(count - 1).getNumber() + 1)){
					if (trumpList.get(i).getNumber() == 1) {
						if (usedTrumpList.get(count - 1).getNumber() == 12) {
							if (usedTrumpList.get(count - 2).getNumber() == 13) {
								System.out.println("\"A, Q, K\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"A, Q, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if (usedTrumpList.get(count - 1).getNumber() == 13) {
							if (usedTrumpList.get(count - 2).getNumber() == 12) {
								System.out.println("\"A, K, Q\"のストレートです");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"A, K, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else {
							System.out.println("\"A, " + usedTrumpList.get(count - 1).getNumber() + ", "
									+ usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if (trumpList.get(i).getNumber() == 11) {
						if (usedTrumpList.get(count - 1).getNumber() == 12) {
							if (usedTrumpList.get(count - 2).getNumber() == 13) {
								System.out.println("\"J, Q, K\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"J, Q, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if (usedTrumpList.get(count - 1).getNumber() == 13) {
							if (usedTrumpList.get(count - 2).getNumber() == 12) {
								System.out.println("\"J, K, Q\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"J, K, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else {
							System.out.println("\"J, " + usedTrumpList.get(count - 1).getNumber() + ", "
									+ usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if (trumpList.get(i).getNumber() == 12) {
						if (usedTrumpList.get(count - 1).getNumber() == 1) {
							if (usedTrumpList.get(count - 2).getNumber() == 13) {
								System.out.println("\"Q, A, K\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"Q, A, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if (usedTrumpList.get(count - 1).getNumber() == 11) {
							if (usedTrumpList.get(count - 2).getNumber() == 13) {
								System.out.println("\"Q, J, K\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"Q, J, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです");
								selfDrinkCount += 1;
							}
						} else if (usedTrumpList.get(count - 1).getNumber() == 13) {
							if (usedTrumpList.get(count - 2).getNumber() == 1) {
								System.out.println("\"Q, K, A\"のストレートです。");
								selfDrinkCount += 1;
							} else if (usedTrumpList.get(count - 1).getNumber() == 11) {
								System.out.println("\"Q, K, J\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"Q, K, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else {
							System.out.println("\"Q, " + usedTrumpList.get(count - 1).getNumber() + ", "
									+ usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if (trumpList.get(i).getNumber() == 13) {
						if (usedTrumpList.get(count - 1).getNumber() == 1) {
							if (usedTrumpList.get(count - 2).getNumber() == 12) {
								System.out.println("\"K, A, Q\"のストレートです");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"K, A, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if (usedTrumpList.get(count - 1).getNumber() == 11) {
							if (usedTrumpList.get(count - 2).getNumber() == 12) {
								System.out.println("\"K, J, Q\"のストレートです");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"K, J, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if (usedTrumpList.get(count - 1).getNumber() == 12) {
							if (usedTrumpList.get(count - 2).getNumber() == 1) {
								System.out.println("\"K, Q, A\"のストレートです。");
								selfDrinkCount += 1;
							} else if (usedTrumpList.get(count - 1).getNumber() == 11) {
								System.out.println("\"K, Q, J\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"K, Q, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getNumber() + ", "
									+ usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else {
						System.out.println("\"" + trumpList.get(i).getNumber() + ", " + usedTrumpList.get(count - 1).getNumber()
								+ ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
						selfDrinkCount += 1;
					}
				}

				// a(c+1), b(c+2), c
				 else if (trumpList.get(i).getNumber() == (usedTrumpList.get(count - 2).getNumber() + 1) && usedTrumpList.get(count - 1).getNumber() == (usedTrumpList.get(count - 2).getNumber() + 2)){
					 	if (trumpList.get(i).getNumber() == 1) {
							if (usedTrumpList.get(count - 1).getNumber() == 12) {
								if (usedTrumpList.get(count - 2).getNumber() == 13) {
									System.out.println("\"A, Q, K\"のストレートです。");
									selfDrinkCount += 1;
								} else {
									System.out.println("\"A, Q, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
									selfDrinkCount += 1;
								}
							} else if (usedTrumpList.get(count - 1).getNumber() == 13) {
								if (usedTrumpList.get(count - 2).getNumber() == 12) {
									System.out.println("\"A, K, Q\"のストレートです");
									selfDrinkCount += 1;
								} else {
									System.out.println("\"A, K, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
									selfDrinkCount += 1;
								}
							} else {
								System.out.println("\"A, " + usedTrumpList.get(count - 1).getNumber() + ", "
										+ usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if (trumpList.get(i).getNumber() == 11) {
							if (usedTrumpList.get(count - 1).getNumber() == 12) {
								if (usedTrumpList.get(count - 2).getNumber() == 13) {
									System.out.println("\"J, Q, K\"のストレートです。");
									selfDrinkCount += 1;
								} else {
									System.out.println("\"J, Q, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
									selfDrinkCount += 1;
								}
							} else if (usedTrumpList.get(count - 1).getNumber() == 13) {
								if (usedTrumpList.get(count - 2).getNumber() == 12) {
									System.out.println("\"J, K, Q\"のストレートです。");
									selfDrinkCount += 1;
								} else {
									System.out.println("\"J, K, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
									selfDrinkCount += 1;
								}
							} else {
								System.out.println("\"J, " + usedTrumpList.get(count - 1).getNumber() + ", "
										+ usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if (trumpList.get(i).getNumber() == 12) {
							if (usedTrumpList.get(count - 1).getNumber() == 1) {
								if (usedTrumpList.get(count - 2).getNumber() == 13) {
									System.out.println("\"Q, A, K\"のストレートです。");
									selfDrinkCount += 1;
								} else {
									System.out.println("\"Q, A, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
									selfDrinkCount += 1;
								}
							} else if (usedTrumpList.get(count - 1).getNumber() == 11) {
								if (usedTrumpList.get(count - 2).getNumber() == 13) {
									System.out.println("\"Q, J, K\"のストレートです。");
									selfDrinkCount += 1;
								} else {
									System.out.println("\"Q, J, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです");
									selfDrinkCount += 1;
								}
							} else if (usedTrumpList.get(count - 1).getNumber() == 13) {
								if (usedTrumpList.get(count - 2).getNumber() == 1) {
									System.out.println("\"Q, K, A\"のストレートです。");
									selfDrinkCount += 1;
								} else if (usedTrumpList.get(count - 1).getNumber() == 11) {
									System.out.println("\"Q, K, J\"のストレートです。");
									selfDrinkCount += 1;
								} else {
									System.out.println("\"Q, K, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
									selfDrinkCount += 1;
								}
							} else {
								System.out.println("\"Q, " + usedTrumpList.get(count - 1).getNumber() + ", "
										+ usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if (trumpList.get(i).getNumber() == 13) {
							if (usedTrumpList.get(count - 1).getNumber() == 1) {
								if (usedTrumpList.get(count - 2).getNumber() == 12) {
									System.out.println("\"K, A, Q\"のストレートです");
									selfDrinkCount += 1;
								} else {
									System.out.println("\"K, A, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
									selfDrinkCount += 1;
								}
							} else if (usedTrumpList.get(count - 1).getNumber() == 11) {
								if (usedTrumpList.get(count - 2).getNumber() == 12) {
									System.out.println("\"K, J, Q\"のストレートです");
									selfDrinkCount += 1;
								} else {
									System.out.println("\"K, J, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
									selfDrinkCount += 1;
								}
							} else if (usedTrumpList.get(count - 1).getNumber() == 12) {
								if (usedTrumpList.get(count - 2).getNumber() == 1) {
									System.out.println("\"K, Q, A\"のストレートです。");
									selfDrinkCount += 1;
								} else if (usedTrumpList.get(count - 1).getNumber() == 11) {
									System.out.println("\"K, Q, J\"のストレートです。");
									selfDrinkCount += 1;
								} else {
									System.out.println("\"K, Q, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
									selfDrinkCount += 1;
								}
							} else {
								System.out.println("\"K, " + usedTrumpList.get(count - 1).getNumber() + ", "
										+ usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else {
							System.out.println("\"" + trumpList.get(i).getNumber() + ", " + usedTrumpList.get(count - 1).getNumber()
									+ ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
				}

				// a(c+2), b(c+1), c
				else if (trumpList.get(i).getNumber() == (usedTrumpList.get(count - 2).getNumber() + 2) && usedTrumpList.get(count - 1).getNumber() == (usedTrumpList.get(count - 2).getNumber() + 1)){
					if (trumpList.get(i).getNumber() == 1) {
						if (usedTrumpList.get(count - 1).getNumber() == 12) {
							if (usedTrumpList.get(count - 2).getNumber() == 13) {
								System.out.println("\"A, Q, K\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"A, Q, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if (usedTrumpList.get(count - 1).getNumber() == 13) {
							if (usedTrumpList.get(count - 2).getNumber() == 12) {
								System.out.println("\"A, K, Q\"のストレートです");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"A, K, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else {
							System.out.println("\"A, " + usedTrumpList.get(count - 1).getNumber() + ", "
									+ usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if (trumpList.get(i).getNumber() == 11) {
						if (usedTrumpList.get(count - 1).getNumber() == 12) {
							if (usedTrumpList.get(count - 2).getNumber() == 13) {
								System.out.println("\"J, Q, K\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"J, Q, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if (usedTrumpList.get(count - 1).getNumber() == 13) {
							if (usedTrumpList.get(count - 2).getNumber() == 12) {
								System.out.println("\"J, K, Q\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"J, K, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else {
							System.out.println("\"J, " + usedTrumpList.get(count - 1).getNumber() + ", "
									+ usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if (trumpList.get(i).getNumber() == 12) {
						if (usedTrumpList.get(count - 1).getNumber() == 1) {
							if (usedTrumpList.get(count - 2).getNumber() == 13) {
								System.out.println("\"Q, A, K\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"Q, A, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if (usedTrumpList.get(count - 1).getNumber() == 11) {
							if (usedTrumpList.get(count - 2).getNumber() == 13) {
								System.out.println("\"Q, J, K\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"Q, J, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです");
								selfDrinkCount += 1;
							}
						} else if (usedTrumpList.get(count - 1).getNumber() == 13) {
							if (usedTrumpList.get(count - 2).getNumber() == 1) {
								System.out.println("\"Q, K, A\"のストレートです。");
								selfDrinkCount += 1;
							} else if (usedTrumpList.get(count - 1).getNumber() == 11) {
								System.out.println("\"Q, K, J\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"Q, K, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else {
							System.out.println("\"Q, " + usedTrumpList.get(count - 1).getNumber() + ", "
									+ usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if (trumpList.get(i).getNumber() == 13) {
						if (usedTrumpList.get(count - 1).getNumber() == 1) {
							if (usedTrumpList.get(count - 2).getNumber() == 12) {
								System.out.println("\"K, A, Q\"のストレートです");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"K, A, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if (usedTrumpList.get(count - 1).getNumber() == 11) {
							if (usedTrumpList.get(count - 2).getNumber() == 12) {
								System.out.println("\"K, J, Q\"のストレートです");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"K, J, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else if (usedTrumpList.get(count - 1).getNumber() == 12) {
							if (usedTrumpList.get(count - 2).getNumber() == 1) {
								System.out.println("\"K, Q, A\"のストレートです。");
								selfDrinkCount += 1;
							} else if (usedTrumpList.get(count - 1).getNumber() == 11) {
								System.out.println("\"K, Q, J\"のストレートです。");
								selfDrinkCount += 1;
							} else {
								System.out.println("\"K, Q, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
								selfDrinkCount += 1;
							}
						} else {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getNumber() + ", "
									+ usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else {
						System.out.println("\"" + trumpList.get(i).getNumber() + ", " + usedTrumpList.get(count - 1).getNumber()
								+ ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
						selfDrinkCount += 1;
					}
				}

				// jokerパターン

				// a, b(joker), c(a+1)
				 else if (usedTrumpList.get(count - 1).getMark().equals("ジョーカー") && usedTrumpList.get(count - 2).getNumber() == (trumpList.get(i).getNumber() + 1)){
					 if(trumpList.get(i).getNumber() == 1) {
						 if(usedTrumpList.get(count - 2).getNumber() == 12) {
							System.out.println("\"A, " + usedTrumpList.get(count - 1).getMark() + ", Q\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
							System.out.println("\"A, " + usedTrumpList.get(count - 1).getMark() + ", K\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"A, " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 11) {
						if(usedTrumpList.get(count - 2).getNumber() == 12) {
							System.out.println("\"J, " + usedTrumpList.get(count - 1).getMark() + ", Q\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
							System.out.println("\"J, " + usedTrumpList.get(count - 1).getMark() + ", K\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"J, " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getNumber() + "のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 12) {
						if(usedTrumpList.get(count - 2).getNumber() == 1) {
						 System.out.println("\"Q, " + usedTrumpList.get(count - 1).getMark() + ", A\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 11) {
							System.out.println("\"Q, " + usedTrumpList.get(count - 1).getMark() + ", J\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
							System.out.println("\"Q, " + usedTrumpList.get(count - 1).getMark() + ", K\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"Q, " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 13) {
						if(usedTrumpList.get(count - 2).getNumber() == 1) {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getMark() + ", A\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 11) {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getMark() + ", J\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 12) {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getMark() + ", Q\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else {
						System.out.println("\"" + trumpList.get(i).getNumber() + ", " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
						selfDrinkCount += 1;
					}
				}

				// a, b(joker), c(a+2)
				 else if (usedTrumpList.get(count - 1).getMark().equals("ジョーカー") && usedTrumpList.get(count - 2).getNumber() == (trumpList.get(i).getNumber() + 1)){
					 if(trumpList.get(i).getNumber() == 1) {
						 if(usedTrumpList.get(count - 2).getNumber() == 12) {
							System.out.println("\"A, " + usedTrumpList.get(count - 1).getMark() + ", Q\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
							System.out.println("\"A, " + usedTrumpList.get(count - 1).getMark() + ", K\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"A, " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 11) {
						if(usedTrumpList.get(count - 2).getNumber() == 12) {
							System.out.println("\"J, " + usedTrumpList.get(count - 1).getMark() + ", Q\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
							System.out.println("\"J, " + usedTrumpList.get(count - 1).getMark() + ", K\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"J, " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 12) {
						if(usedTrumpList.get(count - 2).getNumber() == 1) {
						 System.out.println("\"Q, " + usedTrumpList.get(count - 1).getMark() + ", A\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 11) {
							System.out.println("\"Q, " + usedTrumpList.get(count - 1).getMark() + ", J\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
							System.out.println("\"Q, " + usedTrumpList.get(count - 1).getMark() + ", K\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"Q, " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 13) {
						if(usedTrumpList.get(count - 2).getNumber() == 1) {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getMark() + ", A\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 11) {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getMark() + ", J\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 12) {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getMark() + ", Q\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else {
						System.out.println("\"" + trumpList.get(i).getNumber() + ", " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
						selfDrinkCount += 1;
					}
				}

				// a, b(a+1), c(joker)
				 else if (usedTrumpList.get(count - 1).getNumber() == (trumpList.get(i).getNumber() + 1) && usedTrumpList.get(count - 2).getMark().equals("ジョーカー")){
					 if(trumpList.get(i).getNumber() == 1) {
						 if(usedTrumpList.get(count - 1).getNumber() == 12) {
							System.out.println("\"A, Q, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
							System.out.println("\"A, K, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"A, " + usedTrumpList.get(count - 1).getNumber() + usedTrumpList.get(count - 2).getMark() + "のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 11) {
						if(usedTrumpList.get(count - 1).getNumber() == 12) {
							System.out.println("\"J, Q, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
							System.out.println("\"J, K, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"J, " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 12) {
						if(usedTrumpList.get(count - 1).getNumber() == 1) {
						 System.out.println("\"Q, A, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 1).getNumber() == 11) {
							System.out.println("\"Q, J, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
							System.out.println("\"Q, K, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"Q" + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 13) {
						if(usedTrumpList.get(count - 1).getNumber() == 1) {
							System.out.println("\"K, A, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 1).getNumber() == 11) {
							System.out.println("\"K, J, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 1).getNumber() == 12) {
							System.out.println("\"K, Q, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else {
						System.out.println("\"" + trumpList.get(i).getNumber() + ", " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
						selfDrinkCount += 1;
					}
				}

				// a, b(a+2), c(joker)
				 else if (usedTrumpList.get(count - 1).getNumber() == (trumpList.get(i).getNumber() + 2) && usedTrumpList.get(count - 2).getMark().equals("ジョーカー")){
					 if(trumpList.get(i).getNumber() == 1) {
						 if(usedTrumpList.get(count - 1).getNumber() == 12) {
							System.out.println("\"A, Q, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
							System.out.println("\"A, K, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"A, " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 11) {
						if(usedTrumpList.get(count - 1).getNumber() == 12) {
							System.out.println("\"J, Q, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
							System.out.println("\"J, K, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"J, " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 12) {
						if(usedTrumpList.get(count - 1).getNumber() == 1) {
						 System.out.println("\"Q, A, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 1).getNumber() == 11) {
							System.out.println("\"Q, J, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
							System.out.println("\"Q, K, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"Q, " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 13) {
						if(usedTrumpList.get(count - 1).getNumber() == 1) {
							System.out.println("\"K, A, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 1).getNumber() == 11) {
							System.out.println("\"K, J, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 1).getNumber() == 12) {
							System.out.println("\"K, Q, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else {
						System.out.println(trumpList.get(i).getNumber() + ", " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getMark() + "のストレートです。");
						selfDrinkCount += 1;
					}
				}

				// a, b(joker), c(joker)
				 else if (usedTrumpList.get(count - 1).getMark().equals("ジョーカー") && usedTrumpList.get(count - 2).getMark().equals("ジョーカー")){
					 if(trumpList.get(i).getNumber() == 1) {
							System.out.println("\"A, " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
					} else if(trumpList.get(i).getNumber() == 11) {
							System.out.println("\"J, " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
					} else if(trumpList.get(i).getNumber() == 12) {
							System.out.println("\"Q, " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
					} else if(trumpList.get(i).getNumber() == 13) {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
					} else {
						System.out.println("\"" + trumpList.get(i).getNumber() + ", " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
						selfDrinkCount += 1;
					}
				}

				// a(joker), b, c(b+1)
				 else if (trumpList.get(i).getMark().equals("ジョーカー") && usedTrumpList.get(count - 2).getNumber() == (usedTrumpList.get(count - 1).getNumber() + 1)){
					 if(usedTrumpList.get(count - 1).getNumber() == 1) {
						 if(usedTrumpList.get(count - 2).getNumber() == 12) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", A, Q\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", A, K\"のストレートです。");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"" + trumpList.get(i).getMark() + ", A, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(usedTrumpList.get(count - 1).getNumber() == 11) {
						if(usedTrumpList.get(count - 2).getNumber() == 12) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", J, Q\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", J, K\"のストレートです。");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"" + trumpList.get(i).getMark() + ", J, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(usedTrumpList.get(count - 1).getNumber() == 12) {
						if(usedTrumpList.get(count - 2).getNumber() == 1) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", Q, A\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 11) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", Q, J\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", Q, K\"のストレートです。");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"" + trumpList.get(i).getMark() + ", Q, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
						if(usedTrumpList.get(count - 2).getNumber() == 1) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", K, A\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 11) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", K, J\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 12) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", K, Q\"のストレートです。");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"" + trumpList.get(i).getMark() + ", K, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else {
						System.out.println("\"" + trumpList.get(i).getMark() + ", " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getNumber() + "のストレートです。");
						selfDrinkCount += 1;
					}
				}

				// a(joker), b, c(b+2)
				 else if (trumpList.get(i).getMark().equals("ジョーカー") && usedTrumpList.get(count - 2).getNumber() == (usedTrumpList.get(count - 1).getNumber() + 2)){
					 if(usedTrumpList.get(count - 1).getNumber() == 1) {
						 if(usedTrumpList.get(count - 2).getNumber() == 12) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", A, Q\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", A, K\"のストレートです。");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"" + trumpList.get(i).getMark() + ", A, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(usedTrumpList.get(count - 1).getNumber() == 11) {
						if(usedTrumpList.get(count - 2).getNumber() == 12) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", J, Q\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", J, K\"のストレートです。");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"" + trumpList.get(i).getMark() + ", J, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(usedTrumpList.get(count - 1).getNumber() == 12) {
						if(usedTrumpList.get(count - 2).getNumber() == 1) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", Q, A\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 11) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", Q, J\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", Q, K\"のストレートです。");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"" + trumpList.get(i).getMark() + ", Q, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
						if(usedTrumpList.get(count - 2).getNumber() == 1) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", K, A\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 11) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", K, J\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 12) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", K, Q\"のストレートです。");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"" + trumpList.get(i).getMark() + ", K, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else {
						System.out.println("\"" + trumpList.get(i).getMark() + ", " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
						selfDrinkCount += 1;
					}
				}

				// a(b+1), b, c(joker)
				 else if (trumpList.get(i).getNumber() == (usedTrumpList.get(count - 1).getNumber() + 1) && usedTrumpList.get(count - 2).getMark().equals("ジョーカー")){
					 if(trumpList.get(i).getNumber() == 1) {
						 if(usedTrumpList.get(count - 1).getNumber() == 12) {
							System.out.println("\"A, Q, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
							System.out.println("\"A, K, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"A, " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 11) {
						if(usedTrumpList.get(count - 1).getNumber() == 12) {
							System.out.println("\"J, Q, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
							System.out.println("\"J, K, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"J, " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 12) {
						if(usedTrumpList.get(count - 1).getNumber() == 1) {
						 System.out.println("\"Q, A, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 1).getNumber() == 11) {
							System.out.println("\"Q, J, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
							System.out.println("\"Q, K, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"Q, " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 13) {
						if(usedTrumpList.get(count - 1).getNumber() == 1) {
							System.out.println("\"K, A, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 1).getNumber() == 11) {
							System.out.println("\"K, J, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 1).getNumber() == 12) {
							System.out.println("\"K, Q, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else {
						System.out.println("\"" + trumpList.get(i).getNumber() + ", " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
						selfDrinkCount += 1;
					}
				}

				// a(b+2), b, c(joker)
				 else if (trumpList.get(i).getNumber() == (usedTrumpList.get(count - 1).getNumber() + 2) && usedTrumpList.get(count - 2).getMark().equals("ジョーカー")){
					 if(trumpList.get(i).getNumber() == 1) {
						 if(usedTrumpList.get(count - 1).getNumber() == 12) {
							System.out.println("\"A, Q, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
							System.out.println("\"A, K, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"A, " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 11) {
						if(usedTrumpList.get(count - 1).getNumber() == 12) {
							System.out.println("\"J, Q, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
							System.out.println("\"J, K, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"J, " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 12) {
						if(usedTrumpList.get(count - 1).getNumber() == 1) {
						 System.out.println("\"Q, A, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 1).getNumber() == 11) {
							System.out.println("\"Q, J, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
							System.out.println("\"Q, K, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"Q, " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 13) {
						if(usedTrumpList.get(count - 1).getNumber() == 1) {
							System.out.println("\"K, A, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 1).getNumber() == 11) {
							System.out.println("\"K, J, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 1).getNumber() == 12) {
							System.out.println("\"K, Q, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else {
						System.out.println("\"" + trumpList.get(i).getNumber() + ", " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
						selfDrinkCount += 1;
					}
				}

				// a(joker), b, c(joker)
				 else if (trumpList.get(i).getMark().equals("ジョーカー") && usedTrumpList.get(count - 2).getMark().equals("ジョーカー")){
					 if(usedTrumpList.get(count - 1).getNumber() == 1) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", A, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
					} else if(usedTrumpList.get(count - 1).getNumber() == 11) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", J, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
					} else if(usedTrumpList.get(count - 1).getNumber() == 12) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", Q, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
					} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", K, " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
							selfDrinkCount += 1;
					} else {
						System.out.println("\"" + trumpList.get(i).getMark() + ", " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getMark() + "\"のストレートです。");
						selfDrinkCount += 1;
					}
				}

				// a(joker), b(c+1), c
				 else if (trumpList.get(i).getMark().equals("ジョーカー") && usedTrumpList.get(count - 1).getNumber() == (usedTrumpList.get(count - 2).getNumber() + 1)){
					 if(usedTrumpList.get(count - 1).getNumber() == 1) {
						 if(usedTrumpList.get(count - 2).getNumber() == 12) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", A, Q\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", A, K\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"" + trumpList.get(i).getMark() + ", A, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(usedTrumpList.get(count - 1).getNumber() == 11) {
						if(usedTrumpList.get(count - 2).getNumber() == 12) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", J, Q\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", J, K\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"" + trumpList.get(i).getMark() + ", J, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(usedTrumpList.get(count - 1).getNumber() == 12) {
						if(usedTrumpList.get(count - 2).getNumber() == 1) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", Q, A\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 11) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", Q, J\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", Q, K\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"" + trumpList.get(i).getMark() + ", Q, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
						if(usedTrumpList.get(count - 2).getNumber() == 1) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", K, A\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 11) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", K, J\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 12) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", K, Q\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"" + trumpList.get(i).getMark() + ", K, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else {
						System.out.println("\"" + trumpList.get(i).getMark() + ", " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
						selfDrinkCount += 1;
					}
				}

				// a(joker), b(c+2), c
				 else if (trumpList.get(i).getMark().equals("ジョーカー") && usedTrumpList.get(count - 1).getNumber() == (usedTrumpList.get(count - 2).getNumber() + 2)){
					 if(usedTrumpList.get(count - 1).getNumber() == 1) {
						 if(usedTrumpList.get(count - 2).getNumber() == 12) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", A, Q\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", A, K\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"" + trumpList.get(i).getMark() + ", A, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(usedTrumpList.get(count - 1).getNumber() == 11) {
						if(usedTrumpList.get(count - 2).getNumber() == 12) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", J, Q\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", J, K\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"" + trumpList.get(i).getMark() + ", J, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(usedTrumpList.get(count - 1).getNumber() == 12) {
						if(usedTrumpList.get(count - 2).getNumber() == 1) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", Q, A\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 11) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", Q, J\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", Q, K\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"" + trumpList.get(i).getMark() + ", Q, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
						if(usedTrumpList.get(count - 2).getNumber() == 1) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", K, A\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 11) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", K, J\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 12) {
							System.out.println("\"" + trumpList.get(i).getMark() + ", K, Q\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"" + trumpList.get(i).getMark() + ", K, " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else {
						System.out.println("\"" + trumpList.get(i).getMark() + ", " + usedTrumpList.get(count - 1).getNumber() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
						selfDrinkCount += 1;
					}
				}

				// a(c+1), b (joker), c
				 else if (trumpList.get(i).getNumber() == (usedTrumpList.get(count - 2).getNumber() + 1) && usedTrumpList.get(count - 1).getMark().equals("ジョーカー")){
					 if(trumpList.get(i).getNumber() == 1) {
						 if(usedTrumpList.get(count - 2).getNumber() == 12) {
							System.out.println("A, " + usedTrumpList.get(count - 1).getMark() + ", Q\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
							System.out.println("A, " + usedTrumpList.get(count - 1).getMark() + ", K\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("A, " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 11) {
						if(usedTrumpList.get(count - 2).getNumber() == 12) {
							System.out.println("\"J, " + usedTrumpList.get(count - 1).getMark() + ", Q\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
							System.out.println("\"J, " + usedTrumpList.get(count - 1).getMark() + ", K\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"J, " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 12) {
						if(usedTrumpList.get(count - 2).getNumber() == 1) {
						 System.out.println("\"Q, " + usedTrumpList.get(count - 1).getMark() + ", A\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 11) {
							System.out.println("\"Q, " + usedTrumpList.get(count - 1).getMark() + ", J\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
							System.out.println("\"Q, " + usedTrumpList.get(count - 1).getMark() + ", K\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"Q, " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 13) {
						if(usedTrumpList.get(count - 2).getNumber() == 1) {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getMark() + ", A\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 11) {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getMark() + ", J\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 12) {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getMark() + ", Q\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else {
						System.out.println("\"" + trumpList.get(i).getNumber() + ", " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
						selfDrinkCount += 1;
					}
				}

				// a(c+2), b (joker), c
				 else if (trumpList.get(i).getNumber() == (usedTrumpList.get(count - 2).getNumber() + 2) && usedTrumpList.get(count - 1).getMark().equals("ジョーカー")){
					 if(trumpList.get(i).getNumber() == 1) {
						 if(usedTrumpList.get(count - 2).getNumber() == 12) {
							System.out.println("\"A, " + usedTrumpList.get(count - 1).getMark() + ", Q\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
							System.out.println("\"A, " + usedTrumpList.get(count - 1).getMark() + ", K\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"A, " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 11) {
						if(usedTrumpList.get(count - 2).getNumber() == 12) {
							System.out.println("\"J, " + usedTrumpList.get(count - 1).getMark() + ", Q\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
							System.out.println("\"J, " + usedTrumpList.get(count - 1).getMark() + ", K\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"J, " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 12) {
						if(usedTrumpList.get(count - 2).getNumber() == 1) {
						 System.out.println("\"Q, " + usedTrumpList.get(count - 1).getMark() + ", A\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 11) {
							System.out.println("\"Q, " + usedTrumpList.get(count - 1).getMark() + ", J\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
							System.out.println("\"Q, " + usedTrumpList.get(count - 1).getMark() + ", K\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"Q, " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else if(trumpList.get(i).getNumber() == 13) {
						if(usedTrumpList.get(count - 2).getNumber() == 1) {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getMark() + ", A\"のストレートです。");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 11) {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getMark() + ", J\"のストレートです");
							selfDrinkCount += 1;
						} else if(usedTrumpList.get(count - 2).getNumber() == 12) {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getMark() + ", Q\"のストレートです");
							selfDrinkCount += 1;
						} else {
							System.out.println("\"K, " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
							selfDrinkCount += 1;
						}
					} else {
						System.out.println("\"" + trumpList.get(i).getNumber() + ", " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
						selfDrinkCount += 1;
					}
				}

				// a(joker), b(joker), c
				 else if (trumpList.get(i).getMark().equals("ジョーカー") && usedTrumpList.get(count - 1).getMark().equals("ジョーカー")){
					 if(usedTrumpList.get(count - 2).getNumber() == 1) {
						System.out.println("\"" + trumpList.get(i).getMark() + ", " + usedTrumpList.get(count - 1).getMark() + ", A\"のストレートです。");
						selfDrinkCount += 1;
					} else if(usedTrumpList.get(count - 2).getNumber() == 11) {
						System.out.println("\"" + trumpList.get(i).getMark() + ", " + usedTrumpList.get(count - 1).getMark() + ", J\"のストレートです");
						selfDrinkCount += 1;
					} else if(usedTrumpList.get(count - 2).getNumber() == 12) {
						System.out.println("\"" + trumpList.get(i).getMark() + ", " + usedTrumpList.get(count - 1).getMark() + ", Q\"のストレートです");
						selfDrinkCount += 1;
					} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
						System.out.println("\"" + trumpList.get(i).getMark() + ", " + usedTrumpList.get(count - 1).getMark() + ", K\"のストレートです");
						selfDrinkCount += 1;
					} else {
						System.out.println("\"" + trumpList.get(i).getMark() + ", " + usedTrumpList.get(count - 1).getMark() + ", " + usedTrumpList.get(count - 2).getNumber() + "\"のストレートです。");
						selfDrinkCount += 1;
					}
				}


				// スリーカード

				// 1, 1, 1
				if(trumpList.get(i).getNumber() == usedTrumpList.get(count - 1).getNumber() && trumpList.get(i).getNumber() == usedTrumpList.get(count - 2).getNumber()) {
					if(trumpList.get(i).getNumber() == 1) {
						System.out.println("\"A\"のスリーカードです。");
						selfDrinkCount += 1;
					} else if(trumpList.get(i).getNumber() == 11) {
						System.out.println("\"J\"のスリーカードです。");
						selfDrinkCount += 1;
					} else if(trumpList.get(i).getNumber() == 12) {
						System.out.println("\"Q\"のスリーカードです。");
						selfDrinkCount += 1;
					} else if(trumpList.get(i).getNumber() == 13) {
						System.out.println("\"K\"のスリーカードです。");
						selfDrinkCount += 1;
					} else {
						System.out.println("\"" + trumpList.get(i).getNumber() + "\"のスリーカードです。");
						selfDrinkCount += 1;
					}
				// 1, joker, 1
				} else if(trumpList.get(i).getNumber() == usedTrumpList.get(count - 2).getNumber() && usedTrumpList.get(count - 1).getMark().equals("ジョーカー")) {
					if(trumpList.get(i).getNumber() == 1) {
						System.out.println("\"A\"のスリーカードです。");
						selfDrinkCount += 1;
					} else if(trumpList.get(i).getNumber() == 11) {
						System.out.println("\"J\"のスリーカードです。");
						selfDrinkCount += 1;
					} else if(trumpList.get(i).getNumber() == 12) {
						System.out.println("\"Q\"のスリーカードです。");
						selfDrinkCount += 1;
					} else if(trumpList.get(i).getNumber() == 13) {
						System.out.println("\"K\"のスリーカードです。");
						selfDrinkCount += 1;
					} else {
						System.out.println("\"" + trumpList.get(i).getNumber() + "\"のスリーカードです。");
						selfDrinkCount += 1;
					}
				// 1, 1, joker
				} else if(trumpList.get(i).getNumber() == usedTrumpList.get(count - 1).getNumber() && usedTrumpList.get(count - 2).getMark().equals("ジョーカー")) {
					if(trumpList.get(i).getNumber() == 1) {
						System.out.println("\"A\"のスリーカードです。");
						selfDrinkCount += 1;
					} else if(trumpList.get(i).getNumber() == 11) {
						System.out.println("\"J\"のスリーカードです。");
						selfDrinkCount += 1;
					} else if(trumpList.get(i).getNumber() == 12) {
						System.out.println("\"Q\"のスリーカードです。");
						selfDrinkCount += 1;
					} else if(trumpList.get(i).getNumber() == 13) {
						System.out.println("\"K\"のスリーカードです。");
						selfDrinkCount += 1;
					} else {
						System.out.println("\"" + trumpList.get(i).getNumber() + "\"のスリーカードです。");
						selfDrinkCount += 1;
					}
				// 1, joker, joker
				} else if(usedTrumpList.get(count - 1).getMark().equals("ジョーカー") && usedTrumpList.get(count - 2).getMark().equals("ジョーカー")) {
					if(trumpList.get(i).getNumber() == 1) {
						System.out.println("\"A\"のスリーカードです。");
						selfDrinkCount += 1;
					} else if(trumpList.get(i).getNumber() == 11) {
						System.out.println("\"J\"のスリーカードです。");
						selfDrinkCount += 1;
					} else if(trumpList.get(i).getNumber() == 12) {
						System.out.println("\"Q\"のスリーカードです。");
						selfDrinkCount += 1;
					} else if(trumpList.get(i).getNumber() == 13) {
						System.out.println("\"K\"のスリーカードです。");
						selfDrinkCount += 1;
					} else {
						System.out.println("\"" + trumpList.get(i).getNumber() + "\"のスリーカードです。");
						selfDrinkCount += 1;
					}
				// joker, joker, 1
				} else if(trumpList.get(i).getMark().equals("ジョーカー") && usedTrumpList.get(count - 1).getMark().equals("ジョーカー")) {
					if(usedTrumpList.get(count - 2).getNumber() == 1) {
						System.out.println("\"A\"のスリーカードです。");
						selfDrinkCount += 1;
					} else if(usedTrumpList.get(count - 2).getNumber() == 11) {
						System.out.println("\"J\"のスリーカードです。");
						selfDrinkCount += 1;
					} else if(usedTrumpList.get(count - 2).getNumber() == 12) {
						System.out.println("\"Q\"のスリーカードです。");
						selfDrinkCount += 1;
					} else if(usedTrumpList.get(count - 2).getNumber() == 13) {
						System.out.println("\"K\"のスリーカードです。");
						selfDrinkCount += 1;
					} else {
						System.out.println("\"" + usedTrumpList.get(count - 2).getNumber() + "\"のスリーカードです。");
						selfDrinkCount += 1;
					}
				// joker, 1, joker
				} else if(trumpList.get(i).getMark().equals("ジョーカー") && usedTrumpList.get(count - 2).getMark().equals("ジョーカー")) {
					if(usedTrumpList.get(count - 1).getNumber() == 1) {
						System.out.println("\"A\"のスリーカードです。");
						selfDrinkCount += 1;
					} else if(usedTrumpList.get(count - 1).getNumber() == 11) {
						System.out.println("\"J\"のスリーカードです。");
						selfDrinkCount += 1;
					} else if(usedTrumpList.get(count - 1).getNumber() == 12) {
						System.out.println("\"Q\"のスリーカードです。");
						selfDrinkCount += 1;
					} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
						System.out.println("\"K\"のスリーカードです。");
						selfDrinkCount += 1;
					} else {
						System.out.println("\"" + usedTrumpList.get(count - 1).getNumber() + "\"のスリーカードです。");
						selfDrinkCount += 1;
					}
				// joker, 1, 1
				} else if(trumpList.get(i).getMark().equals("ジョーカー") && usedTrumpList.get(count - 1).getNumber() == usedTrumpList.get(count - 2).getNumber()) {
					if(usedTrumpList.get(count - 1).getNumber() == 1) {
						System.out.println("\"A\"のスリーカードです。");
						selfDrinkCount += 1;
					} else if(usedTrumpList.get(count - 1).getNumber() == 11) {
						System.out.println("\"J\"のスリーカードです。");
						selfDrinkCount += 1;
					} else if(usedTrumpList.get(count - 1).getNumber() == 12) {
						System.out.println("\"Q\"のスリーカードです。");
						selfDrinkCount += 1;
					} else if(usedTrumpList.get(count - 1).getNumber() == 13) {
						System.out.println("\"K\"のスリーカードです。");
						selfDrinkCount += 1;
					} else {
						System.out.println("\"" + usedTrumpList.get(count - 1).getNumber() + "\"のスリーカードです。");
						selfDrinkCount += 1;
					}
				}

				// 合計杯数を出力
				if(selfDrinkCount > 0) {
					System.out.println(members.get(memberCount) + "は、" + selfDrinkCount + "杯飲んでください。");
				}
				if(trumpList.get(i).getMark().equals("ジョーカー")) {
					if(memberCount == 0) {
						memberCount = (members.size() - 1);
					} else {
						memberCount--;
					}
				}
				memberCount++;
				if(memberCount >= members.size()) {
					memberCount = 0;
				}
			}

			if(!(count == 0)) {
				System.out.println();
				System.out.println("--------------------------------------------------");
				System.out.println();
			}

			Trump trump = new Trump(trumpList.get(i).getMark(),trumpList.get(i).getNumber());
			usedTrumpList.add(trump);
			trumpList.remove(i);
			count++;

			if(i == 0) {
				System.out.println("カードがなくなりました。これでゲームは終了です。");
			}
		}
    }
}
