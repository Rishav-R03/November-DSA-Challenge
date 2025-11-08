import java.util.Arrays;

public class ZombieGame {
    public static boolean endGame(int bobHealth, int numZom, int[] zombies) {
        Arrays.sort(zombies); 
        for (int i = 0; i < numZom; i++) {
            int damage = ((zombies[i]) % 2) + (zombies[i] / 2);
            bobHealth -= damage;
        }
        if (bobHealth < 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] zombies = { 5, 9, 6 };
        boolean isWon = endGame(35, 3, zombies);
        if (isWon) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
