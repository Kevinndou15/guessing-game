import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    private List<String> wordList;
    private String randomWord;
    private Random random;
    private Scanner scanner;

    public GuessGame() {
        wordList = new ArrayList<>();
        random = new Random();
        scanner = new Scanner(System.in);
    }

    public void initializeWordList() {
        wordList.add("Apple");
        wordList.add("Banana");
        wordList.add("Orange");
        wordList.add("Strawberry");
        wordList.add("Watermelon");
        wordList.add("Pineapple");
        wordList.add("Mango");
        wordList.add("Grapes");
        wordList.add("Kiwi");
        wordList.add("Peach");
    }

    public void displayWordList() {
        System.out.println("Word List:");
        System.out.println("-----------");
        for (int i = 0; i < wordList.size(); i++) {
            System.out.println((i + 1) + ". " + wordList.get(i));
        }
        System.out.println();
    }

    public void playGame() {
        System.out.println("Let's play a guessing game!");

        while (true) {
            initializeWordList();
            displayWordList();

            randomWord = getRandomWord();
            int chances = 3;

            while (chances > 0) {
                System.out.print("Guess the word: ");
                String guess = scanner.nextLine();

                if (guess.equalsIgnoreCase(randomWord)) {
                    System.out.println("Congratulations! You guessed the word correctly.");
                    wordList.remove(randomWord);
                    break;
                } else {
                    chances--;
                    System.out.println("Incorrect guess!");

                    if (chances == 2) {
                        System.out.println("Clue: The first letter of the word is '" + randomWord.charAt(0) + "'");
                    } else if (chances == 1) {
                        System.out.println("Clue: The word has " + randomWord.length() + " letters.");
                    }

                    if (chances > 0) {
                        System.out.println("You have " + chances + " chance(s) remaining.");
                    } else {
                        System.out.println("You have run out of chances. The correct word was: " + randomWord);
                    }
                }
            }

            System.out.println("Number of items remaining in the list: " + wordList.size());
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine();

            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }

            System.out.println();
        }

        System.out.println("Thank you for playing!");
    }

    public String getRandomWord() {
        int index = random.nextInt(wordList.size());
        return wordList.get(index);
    }

}
