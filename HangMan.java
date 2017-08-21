package hangMan;

import java.util.Scanner;

public class HangMan {

	private static String s = "meringue albumen foulard eudaemonic narcolepsy elucubrate"
			+ " vivisepulture pococurante cymotrichous malfeasance";
	private static Scanner scanString = new Scanner(s);
	private static StringBuffer sbr = new StringBuffer();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String word = wordsPosition();

		for (int i = 0; i < word.length(); i++) {

			sbr.append("-");

		}

		System.out.printf("Spell this %d letter word in 5 tries.\n", word.length());
		System.out.println(sbr);

		int count = 0;

		while (count != 5) {

			String str;
			do {
				System.out.println("Guess a letter: ");
				str = sc.next();
			} while (!checkLength(str));

			boolean b1 = checkWord(str, word, sbr);
			System.out.println(sbr);

			if (!b1) {
				count++;

			} else {
				String ans = "";
				while (!ans.equals("y") && !ans.equals("n")) {
					System.out.println("Do you want spell the word now? (y/n): ");
					ans = sc.next();
					if (!ans.equals("y") && !ans.equals("n")) {
						System.out.println("Try again");
					}
				}
				if (ans.equals("y")) {
					count = 5;
				}

			}

		}
		System.out.println("Spell the complete word: ");
		String a = sc.next();
		if (a.equals(word)) {
			System.out.println("You are correct!");
		} else {
			System.out.println("You are incorrect");
		}
		System.out.println("The correct word is: " + word);
	}

	public static String wordsPosition() {

		int num = (int) (Math.random() * 9);

		int count = 0;

		while (count != num) {
			scanString.next();
			count++;
		}
		String word = scanString.next();

		return word;
	}

	public static boolean checkLength(String str) {

		if (str.length() == 1) {
			return true;
		}else{
			System.out.println("1 letter only");
		}

		return false;

	}

	public static boolean checkWord(String str, String word, StringBuffer sbr) {

		char c = str.charAt(0);
		boolean wd = false;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == c) {
				sbr.setCharAt(i, c);
				wd = true;
			}
		}
		return wd;

	}

}
