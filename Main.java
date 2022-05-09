//Chaya Tendler

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args)
  {
    ArrayList<iAnimal> animals = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    while(true)
    {
      System.out.println("Do you want to add a tiger? y/n");
      String choice = scanner.nextLine();

      if( choice.equalsIgnoreCase("y"))
      {
        Tiger tiger = new Tiger();
        System.out.println("What is animal ID? ");
        int id = scanner.nextInt();
        scanner.nextLine();
        tiger.setIdTag(id);
        boolean alreadyExist = false;
        for(iAnimal animal : animals)
        {
          if(animal instanceof Tiger)
          {
            Tiger aTiger = (Tiger)animal;
            if(aTiger.compareTo(tiger) == 0)
            {
              System.out.println("This animal already exists.");
              alreadyExist = true;
            }
          }
        }
        if(!alreadyExist)
        {
          animals.add(tiger);
          System.out.println("Tiger added to animal list.");
        }
      }

      System.out.println("Do you want to add a canary? y/n");
      choice = scanner.nextLine();

      if(choice.equalsIgnoreCase("y"))
      {
        Canary canary = new Canary();
        System.out.println("What is animal ID?");
        int id = scanner.nextInt();
        scanner.nextLine();
        canary.setIdTag(id);
        boolean alreadyExist = false;
        for(iAnimal animal : animals)
        {
          if(animal instanceof Canary)
          {
            Canary aCanary = (Canary)animal;
            if(aCanary.compareTo(canary) == 0)
            {
              System.out.println("This animal already exists.");
              alreadyExist = true;
            }
          }
        }
        if(!alreadyExist)
        {
          animals.add(canary);
          System.out.println("Canary added to animal list.");
        }
      }

      System.out.println("Do you want to continue? y/n");
      choice = scanner.nextLine();
      if(choice.equalsIgnoreCase("n"))
        break;
    }

    for(iAnimal animal : animals)
    {
      System.out.println(animal);
    }
  }

  
}

class Tiger implements iAnimal, Comparable<iAnimal>
{
  //declare member variables
  String animalType;
  int idTag, minTemperature, maxTemperature;

  //constructor
  Tiger()
  {
    minTemperature = 50;
    maxTemperature = 100;
    animalType = this.getClass().getName();
  }
  
  @Override
  public String getAnimalType()
  {
    //return type of animal
    return animalType;
  }

  @Override
  public int getIdTag()
  {
    //standard accessor to get animal's id number
    return idTag;
  }

  @Override
  public void setIdTag(int anIdTag)
  {
    //standard mutator to set animal's id number
    idTag = anIdTag;
  }

  @Override
  public int getMinTemperature()
  {
    //return min temp for animal's enclosure, not info from user
    return minTemperature;
  }

  @Override
  public int getMaxTemperature()
  {
    //return max temp for animal's enclosure
    return maxTemperature;
  }

  @Override
  public int compareTo(iAnimal iAnimal)
  {
    return animalType.compareTo(iAnimal.getAnimalType()) + idTag - iAnimal.getIdTag();
  }

  @Override
  public String toString()
  {
    return "Tiger: ID - " + getIdTag() + ", Max Temp: " + getMaxTemperature() + ", Min Temp: " + getMinTemperature();
  }

}

class Canary implements iAnimal, Comparable<iAnimal>
{
  //declare member variables
  String animalType;
  int IdTag;
  int minTemperature;
  int maxTemperature;

  //constructor
  Canary()
  {
    minTemperature = 17;
    maxTemperature = 108;
    animalType = this.getClass().getName();
  }

  @Override
  public String getAnimalType()
  {
    return animalType;
  }

  @Override
  public int getIdTag()
  {
    return IdTag;
  }

  @Override
  public void setIdTag(int anIdTag)
  {
    IdTag = anIdTag;
  }

  @Override
  public int getMinTemperature()
  {
    return minTemperature;
  }

  @Override
  public int getMaxTemperature()
  {
    return maxTemperature;
  }

  @Override
  public int compareTo(iAnimal iAnimal)
  {
    return animalType.compareTo(iAnimal.getAnimalType()) + IdTag - iAnimal.getIdTag();
  }

  @Override
  public String toString()
  {
    return "Canary:  ID - " + getIdTag() + ", Max Temp: " + getMaxTemperature() + ", Min Temp: " + getMinTemperature();
  }
}

