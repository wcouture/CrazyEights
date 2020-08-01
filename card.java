public class card{
  
  private String[] colors = {"red", "blue", "yellow", "green"};
  private String color;
  private int num;
  private boolean drawCard;

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

  public boolean isDrawCard(){
    return drawCard;
  }

  public int cardNum(){
    return this.num;
  }

  public String cardColor(){
    return this.color;
  }
}