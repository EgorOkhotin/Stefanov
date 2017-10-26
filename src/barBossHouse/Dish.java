package barBossHouse;

public class Dish {
    private String name;
    private byte price;
    private String description;

    Dish(String nameOfDish, String descriptionOfDish)
    {
        name = nameOfDish;
        description = descriptionOfDish;
        price = 0;
    }

    Dish(String nameOfDish, String descriptionOfDish, byte priceOfDish)
    {
        name = nameOfDish;
        description = descriptionOfDish;
        price = priceOfDish;
    }

    public byte getPrice()
    {
        return price;
    }

    public void setPrice(byte newPrice)
    {
        price = newPrice;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String newName)
    {
        name = newName;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String newDescription)
    {
        name = newDescription;
    }

}
