/**
 * The Field class defines an object that models a field full of foxes and
 * hounds. Descriptions of the methods you must implement appear below.
 */
public class Field
{
   /**
    * Creates an empty field of given width and height
    *
    * @param width
    *           of the field.
    * @param height
    *           of the field.
    */
   public Field(int width, int height)
   {
      _width = width;
      _height = height;
      _field = new FieldOccupant[_width][_height];
   } // Field

   /**
    * @return the width of the field.
    */
   public int getWidth()
   {
      // Replace the following line with your solution.
      return _width;
   } // getWidth

   /**
    * @return the height of the field.
    */
   public int getHeight()
   {
      // Replace the following line with your solution.
      return _height;
   } // getHeight

   /**
    * Place an occupant in cell (x, y).
    *
    * @param x
    *           is the x-coordinate of the cell to place a mammal in.
    * @param y
    *           is the y-coordinate of the cell to place a mammal in.
    * @param toAdd
    *           is the occupant to place.
    */
   public void setOccupantAt(int x, int y, FieldOccupant toAdd)
   {
      this._field[x][y] = toAdd;
   } // setOccupantAt

   /**
    * Returns a validated x-coordinate for the x-coordinate being tested For
    * instance, if the width is 3 and the user inputs a 4, it returns 1 Or, if
    * the user inputs a -4, it returns 1
    * 
    * @param x
    *           The x-value for the current Field
    * 
    * @return a valid x-coordinate for the current Field
    */
   public int validateXCoordinate(int x)
   {
      // if x is greater than 0 mod by the width to get the correct coordinate
      // else if x is less than 0 it automatically returns the width of the
      // field minus one because modding negative numbers is really unreliable
      if (x > 0)
      {
         x = x % this.getWidth();
      }
      else if (x < 0)
      {
         x = this.getWidth() - 1;
      }

      return x;
   } // validateXCoordinate

   /**
    * Returns a validated y-coordinate for the y-coordinate being tested For
    * instance, if the height is 3 and the user inputs a 4, it returns 1 Or, if
    * the user inputs a -4, it returns 1
    * 
    * @param y
    *           The y-value for the current Field
    * 
    * @return a valid y-coordinate for the current Field
    */
   public int validateYCoordinate(int y)
   {
      // if y is greater than 0 mod by the height to get the correct coordinate
      // else if y is less than 0 it automatically returns the height of the
      // field minus one because modding negative numbers is really unreliable
      if (y > 0)
      {
         y = y % this.getHeight();
      }
      else if (y < 0)
      {
         y = this.getHeight() - 1;
      }

      return y;
   } // validateYCoordinate

   /**
    * Gets the occupant in cell (x, y)
    * 
    * @param x
    *           is the x-coordinate of the cell whose contents are queried.
    * @param y
    *           is the y-coordinate of the cell whose contents are queried.
    *
    * @return occupant of the cell (or null if unoccupied)
    */
   public FieldOccupant getOccupantAt(int x, int y)
   {
      x = this.validateXCoordinate(x);
      y = this.validateYCoordinate(y);

      return this._field[x][y];
   } // getOccupantAt

   /**
    * Returns the 8 neighboring cells of the field specified by the x-y
    * coordinates passed as arguments
    * 
    * @param x
    *           The x-value for the field
    * @param y
    *           The y-value for the field
    * 
    * @return the 8 neighbors of the current FieldOccupant
    */
   public FieldOccupant[] getNeighbors(int x, int y)
   {
      FieldOccupant[] neighbors = new FieldOccupant[8];

      // the following operations get the neighbors in a clockwise cycle
      // starting with the neighbor at 10:30 o'clock
      neighbors[0] = getOccupantAt(validateXCoordinate(x - 1),
               validateYCoordinate(y + 1));

      neighbors[1] = getOccupantAt(x, validateYCoordinate(y + 1));

      neighbors[2] = getOccupantAt(validateXCoordinate(x + 1),
               validateYCoordinate(y + 1));

      neighbors[3] = getOccupantAt(validateXCoordinate(x + 1), y);

      neighbors[4] = getOccupantAt(validateXCoordinate(x + 1),
               validateYCoordinate(y - 1));

      neighbors[5] = getOccupantAt(x, validateYCoordinate(y - 1));

      neighbors[6] = getOccupantAt(validateXCoordinate(x - 1),
               validateYCoordinate(y - 1));

      neighbors[7] = getOccupantAt(validateXCoordinate(x - 1), y);

      return neighbors;
   } // getNeighbors

   /**
    * Returns a number representing the number of occupants that match the type
    * being searched for
    * 
    * @param occupants
    *           The list to search through
    * @param type
    *           The type to look for in occupants
    * 
    * @return the number of occupants that match the type of occupant requested
    */
   public int countOccupants(FieldOccupant[] occupants, FieldOccupant type)
   {
      int typeCount = 0;

      // loop through the occupants list, counting the ones that have the
      // same class as the type you are searching for
      for (int i = 0; i < occupants.length; i++)
      {
         if (occupants[i] != null
                  && occupants[i].toString().equals(type.toString()))
         {
            typeCount++;
         }
      }

      return typeCount;
   } // countOccupants

   /**
    * Returns a new FieldOccupant to replace the old one
    * 
    * @param x
    *           the x-coordinate of the cell to update
    * @param y
    *           the y-coordinate of the cell to update
    * 
    * @return the updated FieldOccupant
    */
   public FieldOccupant updateOccupant(int x, int y)
   {
      Hound hound = new Hound();
      Fox fox = new Fox();
      FieldOccupant oldOccupant = this.getOccupantAt(x, y); // the old occupant
      FieldOccupant[] neighbors = this.getNeighbors(x, y); // adjacent fields
      FieldOccupant updatedOccupant = null; // this will be returned

      // cell that is EMPTY
      if (oldOccupant == null)
      {
         // if the cell has 2 or more hounds adjacent, replace it with a hound
         if (this.countOccupants(neighbors, hound) >= 2
                  && this.countOccupants(neighbors, fox) >= 2)
         {
            updatedOccupant = hound;
         }
         // if the cell has 2 or more foxes adjacent, replace it with a fox
         else if (this.countOccupants(neighbors, fox) >= 2)
         {
            updatedOccupant = fox;
         }
      }
      // cell with FOX
      else if (Fox.isFox(oldOccupant))
      {
         // if the fox has 2 or more hounds adjacent, replace it with a hound
         if (this.countOccupants(neighbors, hound) >= 2)
         {
            updatedOccupant = hound;
         }
         // if the fox has 1 hound adjacent, replace it with nothing
         else if (this.countOccupants(neighbors, hound) >= 1)
         {
            updatedOccupant = null;
         }
         // just foxes or empty cells
         else
         {
            updatedOccupant = fox;
         }
      }
      // cell with HOUND
      else if (Hound.isHound(oldOccupant))
      {
         // if the hound has 1 or more fox adjacent, then place a fed hound
         if (this.countOccupants(neighbors, fox) >= 1)
         {
            updatedOccupant = hound;
         }
         else
         // leave the hound where it is
         {
            hound = (Hound) oldOccupant;

            updatedOccupant = hound.updateStarveTime();
         }
      }

      return updatedOccupant;
   } // updateOccupant

   /**
    * Takes the current field and updates it to the next state
    * 
    * @return the updated field
    */
   public Field updateField()
   {
      int x = this.getWidth();
      int y = this.getHeight();
      Field newField = new Field(x, y);

      // iterate over each cell and update its occupant according to what it
      // should be with respect to the old field
      // then set the occupant at j, i to the updated occupant
      for (int i = 0; i < y; i++)
      {
         for (int j = 0; j < x; j++)
         {
            newField.setOccupantAt(j, i, this.updateOccupant(j, i));
         }
      }

      return newField;
   } // updateField

   /**
    * Define any variables associated with a Field object here. These variables
    * MUST be private.
    * 
    */
   private int               _width;
   private int               _height;
   private FieldOccupant[][] _field;
}