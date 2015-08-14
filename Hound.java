import java.awt.Color;

/**
 * Hounds can display themsevles
 */
public class Hound extends FieldOccupant
{

   /**
    * Creates a new instance of a Hound
    */
   public Hound()
   {
      _starveTime = DEFAULT_STARVE_TIME;
   }

   /**
    * @return a String representation of a Hound
    */
   @Override
   public String toString()
   {
      return "H";
   } // toString

   /**
    * @param hound
    *           the Hound to decrement the starve time
    * 
    * @return the updated hound
    */
   public Hound updateStarveTime()
   {
      Hound hound = new Hound();

      this.setStarveTime(this.getStarveTime() - 1);

      if (this.getStarveTime() == 0)
      {
         hound = null;
      }
      else
      {
         hound.setStarveTime(this.getStarveTime());
      }

      return hound;
   } // updateStarveTime

   /**
    * Returns true if a FieldOccupant is a Hound, otherwise false
    * 
    * @param occupant
    *           the occupant to check
    * 
    * @return whether or not the FieldOccupant is a Hound
    */
   public static boolean isHound(FieldOccupant occupant)
   {
      boolean isHound = false;
      Hound hound = new Hound();

      if (occupant.toString().equals(hound.toString()))
      {
         isHound = true;
      }

      return isHound;
   } // isHound

   /**
    * @return the starve time of a hound
    */
   public int getStarveTime()
   {
      return this._starveTime;
   } // getStarveTime

   /**
    * @param newStarveTime
    *           the new starve time of a hound
    */
   public void setStarveTime(int newStarveTime)
   {
      this._starveTime = newStarveTime;
   } // setStarveTime

   /**
    * @return the color to use for a cell occupied by a Hound
    */
   @Override
   public Color getDisplayColor()
   {
      return Color.red;
   } // getDisplayColor

   // The default starve time for Hounds
   public static final int DEFAULT_STARVE_TIME = 3;

   // instance variables
   private int             _starveTime;
}
