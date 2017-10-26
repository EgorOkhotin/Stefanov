package barBossHouse;

public class OrderManager {
    private Order[] orders;

    OrderManager(int countOfTables)
    {
        orders = new Order[countOfTables];
    }

    public void addOrder(int numberOfTable, Order newOrder)
    {
        if(newOrder != null & isValidNumber(numberOfTable))
        {
            orders[numberOfTable] = newOrder;
        }
    }

    public Order getOrderByTableNumber(int numberOfTable)
    {
        if(isValidNumber(numberOfTable))
        {
            return orders[numberOfTable];
        }
        else return null;
    }

    public void addDishToOrder(int numberOfTable, Dish dish)
    {
        try
        {
            if (dish != null) {
                if (isValidNumber(numberOfTable))
                {
                    orders[numberOfTable].addDish(dish);
                }
                else throw new NumberFormatException();
            }

        }
        finally
        {
            //System.out.print("Dish value is null!!!");
        }
        //TODO Exception
    }

    public void cleanTable(int numberOfTable)
    {
        if(isValidNumber(numberOfTable))
        {
            orders[numberOfTable] = null;
        }
    }

    public int getFirstFreeTableNumber()
    {
        for(int i=0; i<orders.length; i++)
        {
            if(orders[i] == null) return i;
        }

        return (-1);
    }

    public int[] getFreeTables()
    {
        int[] result = null;
        int cap = 0;
        for(int i=0; i<orders.length;i++)
        {
            if(orders == null) cap++;
        }
        if(cap != 0)
        {
            result = new int[cap];
            int j = 0;
            for (int i = 0; i<orders.length; i++)
            {
                if(orders == null) result[j] = i;
            }
        }
        return result;
    }

    public int[] getNonFreeTables()
    {
        int[] result = null;
        int cap = 0;
        for(int i=0; i<orders.length;i++)
        {
            if(orders != null) cap++;
        }
        if(cap != 0)
        {
            result = new int[cap];
            int j = 0;
            for (int i = 0; i<orders.length; i++)
            {
                if(orders != null) result[j] = i;
            }
        }
        return result;
    }

    public Order[] getOrders()
    {
        Order[] result = null;
        int cap = 0;
        for(int i=0; i<orders.length;i++)
        {
            if(orders != null) cap++;
        }
        if(cap != 0)
        {
            result = new Order[cap];
            int j = 0;
            for (int i = 0; i<orders.length; i++)
            {
                if(orders != null) result[j] = orders[i];
            }
        }
        return result;
    }

    public int ordersSumPrice()
    {
        int result = 0;
        Order[] ordersTempArray = getOrders();
        if(ordersTempArray != null)
        {
            for (int i = 0; i < ordersTempArray.length; i++)
            {
                result += ordersTempArray[i].getSumPrice();
            }
        }
        return result;
    }

    public int getDishCountInOrders(String nameOfDish)
    {
        int result = 0;
        Order[] ordersTempArray = getOrders();
        if(ordersTempArray != null)
        {
            for(int i=0; i<ordersTempArray.length; i++)
            {
                result += ordersTempArray[i].getDishCount(nameOfDish);
            }
        }
        return result;
    }

    private boolean isValidNumber(int number)
    {
        if(number > -1 & number<orders.length)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
