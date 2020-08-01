import java.util.Scanner;

class Main {
  static boolean running = true;
  static card pileCard = new card();
  static Scanner brad = new Scanner(System.in);

  public static void main(String[] args) {
    do{
      running = true;
      mainMenu();
      newCard();
      player user = new player();
      System.out.print("How many cpus would you like -> ");
      int cpuCount = brad.nextInt();
      player[] cpus = new player[cpuCount];
      for(int i = 0; i < cpus.length; i++){
        cpus[i] = new player();
      }

      while(running){
        for(int i = 0; i < cpus.length; i++){
          clearScreen();
          dispInfo(cpus, user);
          System.out.println("CPU " + (i + 1)+ " picking a card...");
          cpuTurn(cpus[i]);
          if(cpus[i].cardCount() <= 0){
            running = false;
            clearScreen();
            System.out.print("CPU " + i + " has won!!");
            break;
          }
        }
        if(!running){
          break;
        }
        clearScreen();
        dispInfo(cpus, user);
        playerTurn(user);
        if(user.cardCount() <= 0){
          clearScreen();
          System.out.print("You have won!!");
          break;
        }
      }
      delay(3000);
    }while(again());
  }

  public static boolean again(){
    clearScreen();
    System.out.print("Would you like to play again? (y/n) -> ");
    char ui = brad.next().charAt(0);
    return ui == 'y' || ui == 'Y';
  }

  public static void dispInfo(player[] comps, player user){
    System.out.println("Card Counts:");
    System.out.println("Player: " + user.cardCount());
    for(int i = 0; i < comps.length; i++){
      System.out.println("CPU" + (i+1) + ": " + comps[i].cardCount());
    }

    System.out.print("\nCard on Pile: ");
    if(pileCard.isDrawCard()){
      System.out.println(pileCard.cardColor() + " Draw 2");
      return;
    }
    System.out.println(pileCard.cardColor() + " " + pileCard.cardNum());
  }

  public static void delay(int time_ms){
    try {
      Thread.sleep(time_ms);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void newCard(){
    card temp = new card();
    do{
      temp = new card();
    }while(temp.isDrawCard() || !temp.cardColor().equals(pileCard.cardColor()));
    pileCard = temp;
  }

  public static void cpuTurn(player p){
    if(pileCard.isDrawCard()){
      System.out.println("Drawing 2 cards...");
      delay(3000);
      p.addCard();
      p.addCard();
      newCard();
      return;
    }
    delay(3000);
    int cpuChoice = -1;
    for(int i = 0; i < p.cardCount(); i++){
      if(checkCard(p.getCard(i + 1))){
        cpuChoice = i + 1;
        break;
      }
    }
    if(cpuChoice == -1){
      p.addCard();
      return;
    }
    pileCard = p.getCard(cpuChoice);
    p.removeCard(cpuChoice);
  }

  public static void playerTurn(player p){
    if(pileCard.isDrawCard()){
      System.out.println("Drawing two cards...");
      delay(3000);
      p.addCard();
      p.addCard();
      newCard();
      return;
    }
    System.out.println("[0]\tDraw a card");
    p.getCards();
    int cardChoice = -1;
    do{
      cardChoice = brad.nextInt();
      if(cardChoice == 0){
        p.addCard();
        return;
      }
    }while((!checkCard(p.getCard(cardChoice))) || cardChoice > p.cardCount() || cardChoice <= 0);
    pileCard = p.getCard(cardChoice);
    p.removeCard(cardChoice);
    if(p.cardCount() <= 0){
      running = false;
    }
  }

  public static boolean checkCard(card c){
    if(c.cardColor().equals(pileCard.cardColor())){
      return true;
    }
    else if(c.cardNum() == pileCard.cardNum()){
      return true;
    }
    else{
      return false;
    }
  }

  public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
  }

  public static void mainMenu(){
    boolean playGame = false;
    while(!playGame){
      clearScreen();
      System.out.println("Welcome to Vrazy Eights!");
      System.out.println("[1]\tBegin");
      System.out.println("[2]\tInstrustions");
      int choice = brad.nextInt();
      switch(choice){
        case 1: playGame = true;
          break;
        case 2: dispInstr();
      }
    }
  }

  public static void dispInstr(){
    clearScreen();
    System.out.println("Objective of the game:");
    System.out.println("The goal of the game is to place down all of\nyour cards. There are special Draw2 cards that will cause\nthe next person to add two cards to their hand.");
    System.out.println("\n");
    System.out.println("Controls:");
    System.out.println("When it is your turn you will be prompted with\nthe cards in your hand and you will type the number next to the\ncard to make a choice.");
    delay(15000);
  }
}