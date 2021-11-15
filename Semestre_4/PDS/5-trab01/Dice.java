import java.util.Random;

public class Dice {
  public final int DICE_BOUND = 6;
	Random rand = new Random();

  public int roll(){
    return rand.nextInt(DICE_BOUND) + 1;
  }
}
