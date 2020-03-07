import java.util.Scanner; //import scanner 
public class  phanNguyenQuan_HangMan
{
  public static void main(String []args)
  {
    Scanner scan = new Scanner(System.in); //create scanner 
    String magicword = "struggle"; //chosen word 
    int length = magicword.length();//length of the chosen word
    String [] character = magicword.split("");//split the word into a string array
    String [] visualize = new String[length];//declare another array to show the user that is the same size as the magicword
    visualize = assistedVisual(character,visualize,length);//uses a variety of methods to create the basis for the visual
    int hearts = 0;//a counter for each incorrect word

       
    while(hearts<6)//while the lives iare lower than 6, the user can continue to guess a letter.
    {
      printDisplay(visualize);//prints the current visual, at first, it will be empty.
      String chosen = scan.nextLine();//scans for the letter the user wants to guess
  
      
      
      if(magicword.contains(chosen))
      {// uses the user-guessed letter and compares it to the magic word
        for(int x=0;x<length;x++)
        {
          if(character[x].equals(chosen))
          { //if the user-guessed letter is the same as a letter in the magic word
            visualize[x] = chosen; //it will replace the spots
          }
        }
      }
      else{
        hearts++; //adds one count to the hearts counter which means one lost point
      }
      picture(hearts);//print out the hearts
    
    
    int count = 0; //creates another counter to compare if its a win or loss 
      
      for(int x =0; x < character.length; x++)
      {
        if( visualize[x].equals(character[x]))
        {
          count++; //each time the spot in the user-guessed array is equal to the magic word array it will add a point
        }
      }
      
      if(count == length) //if they are both the same then it will print out winner
      {
        printDisplay(visualize); 
        System.out.println("Great Job! You have won the Hangman game successfully!");
        break;
      }
    }
    
    if (hearts==6) //this compares it to the counter before which determines the hearts which when equal to 6 is 
                             //when the hearts are 0 which is therefore results in a loss.
    {
      System.out.println("Sorry, you have lost the game, the word was Struggle.");
    }
  }
  

  
  
  
  
  
    
  
  //code below are methods to make the program less messy and more simple.
  
    public static String[] assistedVisual(String [] character, String [] visualize,int length)
    {
    for(int x = 0; x < length; x++)
    {//set the visualize array to be filled with underscores and slashes to seperate each letter spot
      visualize[x] = "/_";
    }
    for(int x=0;x<length;x++){//if the letter of the user-guessed is equal to the magic word, then it replaces.
      if(character[x].equals(" "))
      {
        visualize[x] = " ";
      }
    }
    return visualize;//return the underscores and letters again
  }
  

public static void picture(int hearts)
{//method associated with each heart
    if(hearts == 1)
    {
      System.out.println(" <3 <3 <3 <3 <3 - 5 more lives!");    
    }
    else if(hearts == 2)
    {
      System.out.println(" <3 <3 <3 <3 - 4 more lives!");   
    }
    else if(hearts == 3)
    {
      System.out.println(" <3 <3 <3 - 3 more lives!");    
    }
    else if(hearts == 4)
    {
      System.out.println(" <3 <3 - 2 more lives!");
    }
    else if(hearts == 5)
    {
      System.out.println("  <3 - 1 more life!");

    }
    else if(hearts == 6)
    {
      System.out.println(" NO MORE LIVES ");
  
    }
  }

  
   public static void printDisplay(String [] visualize)
   {
    for(int x=0;x<visualize.length;x++)
    {
      System.out.print(visualize[x]); //prints out the blanks
    }
     System.out.println(" "); //creates a new line from the textbox and the blanks
   }
  
}
  