package barBossHouse;
import java.util.HashSet;

public class Order {
    private Dish[] dishes;
    //private byte countOfDishes;
    private byte size;
    private static final byte DEFAULT_LENGTH = 16;

    Order()
    {
        dishes = new Dish[DEFAULT_LENGTH];
        //countOfDishes = 0;
        size = 0;
    }

    Order(byte countOfArray)
    {
        dishes = new Dish[countOfArray];
        //countOfDishes = 0;
        size =0;
    }

    Order(Dish[] arrayOfDishes)
    {
        dishes = arrayOfDishes;
        //countOfDishes = (byte)dishes.length;
        size = getSize();
    }

    public boolean addDish(Dish dish)
    {
        if(size < dishes.length)
        {
            dishes[size+1] = dish;
            size++;
            return true;
        }
        else
        {
            Dish[] newDish = new Dish[size*2];
            byte[] newCount = new byte[size*2];
            System.arraycopy(dishes,0,newDish,0,size);
            //System.arraycopy(countOfDishes,0,newCount,0,size);
            dishes = newDish;
            //countOfDishes = newCount;
            //countOfDishes[size] = 1;
            dishes[size] = dish;
            size++;
            return true;
        }
    }

    public boolean deleteDish(String nameOfDish)
    {
        for(int i=0; i<size+1; i++)
        {
            if(dishes[i].getName().equalsIgnoreCase(nameOfDish))
            {
                for(int j=i; j<dishes.length; j++) dishes[j] = dishes[j+1];
            }
        }
        //shiftRowDishes(indx);
        return true;
    }

    public int deleteAllDish(String nameOfDish)
    {
        int countOfDeletedDish =0;
        for(int i=0; i<size; i++)
        {
            if(dishes[i].getName().equalsIgnoreCase(nameOfDish))
            {
                dishes[i] = null;
                countOfDeletedDish++;
            }
        }
        for(int i=0; i<size; i++)
        {
            if(dishes[i]==null) dishes[i] = dishes[i+1];
        }
        size -= countOfDeletedDish;
        return countOfDeletedDish;
    }

    public int getCountOfDishes()
    {
        return size;
    }

    public Dish[] getDishes()
    {
        Dish[] result = new Dish[size];
        System.arraycopy(dishes,0,result,0,size);
        return result;
    }

    public int getSumPrice()
    {
        int result = 0;
        for(int i=0; i<size; i++)
        {
            result+=dishes[i].getPrice();
        }
        return result;
    }

    public int getDishCount(String name)
    {
        int result =0;
        for(int i=0; i<size; i++)
        {
            if(dishes[i].getName().equalsIgnoreCase(name)) result += dishes[i].getPrice();
        }
        return result;
    }

    public String[] orderDishesNames()
    {
        if(size != 0)
        {
            HashSet<String> names = new HashSet<>();
            for(int i=0; i< size; i++)
            {
                names.add(dishes[i].getName());
            }
            String[] result = new String[names.size()];
            return names.toArray(result);
        }
        return null;
    }
    public Dish[] getDishesSortedToLow()
    {
        if(size !=0)
        {
            Dish[] result = new Dish[size];
            System.arraycopy(dishes,0,result,0,size);
            qSortDishes(result,0,size-1);
            return result;
        }
        return null;
    }

    private byte getSize()
    {
        for(byte i=0; i<dishes.length; i++)
        {
            if(dishes[i] == null) return i;
        }
        return -1;
    }

    private void qSortDishes(Dish[] array,int a, int b)
    {
          int i = a, r=b;
          Dish p = array[(a+b)/2];
          int pPrise = p.getPrice();

          while(i<=r)
          {
              while(array[i].getPrice()>pPrise) i++;
              while(array[r].getPrice()<pPrise) r--;
              if(i<=r)
              {
                  Dish tmpDish = array[r];
                  array[r] = array[i];
                  array[i] = tmpDish;
                  i++;r--;
              }
              if(i<b) qSortDishes(array,i,b);
              if(r>a) qSortDishes(array,a,r);
          }
    }

}
