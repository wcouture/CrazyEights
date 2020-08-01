import java.util.ArrayList;

public class player{
  ArrayList<card> playerCards = new ArrayList<card>();

  public player(){
    for(int i = 0; i < 6; i++){
      card temp = new card();
      playerCards.add(temp);
    }
  }

  public int cardCount(){
    return playerCards.size();
  }

  public void getCards(){
    for(int i = 0; i < playerCards.size(); i++){
      card temp = playerCards.get(i);
      System.out.print("[" + (i + 1) + "]\t");
      if(temp.isDrawCard()){
        System.out.println(temp.cardColor() + " Draw 2");
      }
      else
        System.out.println(temp.cardColor() + " " + temp.cardNum());
    }
  }

  public void addCard(){
    card temp = new card();
    playerCards.add(temp);
  }

  public card getCard(int index){
    index--;
    return playerCards.get(index);
  }

  public boolean removeCard(int index){
    index--;
    return playerCards.remove(playerCards.get(index));
  }
}