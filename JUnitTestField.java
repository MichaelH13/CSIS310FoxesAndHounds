import java.awt.Graphics;

import org.junit.Test;

public class JUnitTestField
{

   @Test
   public void testConstructor() // 1
   {
      Field thisField = new Field(3, 3);

      assert (thisField != null);
   }

   @Test
   public void testGetHeight() // 2
   {
      Field thisField = new Field(1, 3);

      assert (thisField.getHeight() == 3);
   }

   @Test
   public void testGetWidth() // 3
   {
      Field thisField = new Field(1, 3);

      assert (thisField.getWidth() == 1);
   }

   @Test
   public void testIsHound() // 4
   {
      Field thisField = new Field(3, 3);
      Hound hound = new Hound();

      thisField.setOccupantAt(1, 3, hound);

      assert (thisField.isHound(1, 3));
   }

   @Test
   public void testIsFox() // 5
   {
      Field thisField = new Field(2, 2);
      Fox fox = new Fox();

      thisField.setOccupantAt(1, 2, fox);
      assert (thisField.isFox(1, 2));
   }

   @Test
   public void testSetOccupantAt() // 6
   {
      Field thisField = new Field(3, 3);
      Hound hound = new Hound();

      thisField.setOccupantAt(2, 3, hound);

      assert (thisField.getOccupantAt(2, 3) != null);
      assert (thisField.isHound(2, 3));
   }

   @Test
   public void testGetOccupantAt() // 7
   {
      Field thisField = new Field(3, 3);

      Hound hound = new Hound();

      thisField.setOccupantAt(2, 3, hound);

      assert (thisField.getOccupantAt(2, 3) != null);
      assert (thisField.isHound(2, 3));
   }

   @Test
   public void testValidateXCoordinate() // 8
   {
      Field thisField = new Field(3, 4);

      int x = 3;

      x = thisField.validateXCoordinate(x);
      assert (x == 1);

      x = -1;

      x = thisField.validateXCoordinate(x);
      assert (x == 3);
   }

   @Test
   public void testValidateYCoordinate() // 9
   {
      Field thisField = new Field(4, 3);

      int y = 3;

      y = thisField.validateYCoordinate(y);
      assert (y == 1);

      y = -1;

      y = thisField.validateYCoordinate(y);
      assert (y == 3);
   }

   @Test
   public void testGetNeighbors() // 10
   {
      Field thisField = new Field(3, 3);
      FieldOccupant[] neighbors;
      Hound hound = new Hound();
      Fox fox = new Fox();
      Graphics graphicsContext = null;

      thisField.setOccupantAt(0, 0, fox); // top left
      thisField.setOccupantAt(1, 0, hound); // top middle
      thisField.setOccupantAt(2, 0, fox); // top right
      thisField.setOccupantAt(0, 1, hound); // middle left
      thisField.setOccupantAt(2, 1, hound); // middle right
      thisField.setOccupantAt(0, 2, fox); // bottom left
      thisField.setOccupantAt(1, 2, hound); // bottom middle
      thisField.setOccupantAt(2, 2, fox); // bottom right

      neighbors = thisField.getNeighbors(1, 1);

      drawField(graphicsContext, thisField);
   }

   @Test
   public void testCountOccupants() // 11
   {
      Field thisField = new Field(3, 3);
      assert (thisField.isFox(new Fox()));
   }

   @Test
   public void testUpdateOccupant() // 12
   {
      Field thisField = new Field(3, 3);
      assert (thisField.isFox(new Fox()));
   }

   @Test
   public void testUpdateField() // 13
   {
      Field thisField = new Field(3, 3);
      assert (thisField.isFox(new Fox()));
   }

}
