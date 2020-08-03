public class card{
  
  private String[] colors = {"red", "blue", "yellow", "green"};
  private String color;
  private int num;
  private boolean drawCard;

  /*
    Sets the card number to a random number between 0 and 10 exclusive and the card color
    to one the four possible colors as well as setting the possiblity of it being a draw 2
    card.
   */
  public card(){
    if(Math.random() > .8){
      drawCard = true;
      this.num = -1;
    }
    else{
      drawCard = false;
      this.num = (int)(Math.random() * 10);
    }
    int max = colors.length;
    int min = 0;
    int range = max - min;
    int tempIndex = (int)(Math.random() * range) + min;
    this.color = colors[tempIndex];
  }

  /*
    returns whether the card is a draw 2 card or not.
   */
  public boolean isDrawCard(){
    return drawCard;
  }

  /*
    returns the card number
   */
  public int cardNum(){
    return this.num;
  }

  /*
    returns the card color
   */
  public String cardColor(){
    return this.color;
  }
}