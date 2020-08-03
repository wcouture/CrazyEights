import java.util.ArrayList;

public class player{
  ArrayList<card> playerCards = new ArrayList<card>();

  /*
    Creates a player with a hand of six cards
   */
  public player(){
    for(int i = 0; i < 6; i++){
      card temp = new card();
      playerCards.add(temp);
    }
  }

  /*
    returns the amount of cards left in the player's hand
   */
  public int cardCount(){
    return playerCards.size();
  }

  /*
    prints out the player's hand
   */
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

  /*
    adds a new card to the player's hand
   */
  public void addCard(){
    card temp = new card();
    playerCards.add(temp);
  }

  /*
    returns the card at the given index of the players hand
    @return - the card object at the given index
   */
  public card getCard(int index){
    index--;
    return playerCards.get(index);
  }

  /*
    removes the card at a given index from the player's hand
    @return - whether it was successfully removed
   */
  public boolean removeCard(int index){
    index--;
    return playerCards.remove(playerCards.get(index));
  }
}