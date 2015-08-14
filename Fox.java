import java.awt.Color;

/**
 * Foxes can display themselves
 */
public class Fox extends FieldOccupant
{
   /**
    * @return a String representation of the Fox
    */
   @Override
   public String toString()
   {
      return "F";
   } // toString

   /**
    * Returns true if a FieldOccupant is a Fox, otherwise false
    * 
    * @param occupant
    *           the occupant to check
    * 
    * @return whether or not the FieldOccupant is a Fox
    */
   public static boolean isFox(FieldOccupant occupant)
   {
      boolean isFox = false;
      Fox fox = new Fox();

      if (occupant.toString().equals(fox.toString()))
      {
         isFox = true;
      }

      return isFox;
   } // isFox

   /**
    * @return the color to use for a cell occupied by a Fox
    */
   @Override
   public Color getDisplayColor()
   {
      return Color.green;
   } // getDisplayColor

}
