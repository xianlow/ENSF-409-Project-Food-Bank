
package edu.ucalgary.ensf409;

import java.util.Arrays;

public class Food {
    private final int ITEM_ID;
    private final String NAME;
    private final int GRAIN_CONTENT;
    private final int FV_CONTENT;
    private final int PRO_CONTENT;
    private final int OTHER_CONTENT;
    private final int CALORIES;
    // Xian Wei Additions start
    private AccessFoodInventory access = new AccessFoodInventory("jdbc:mysql://localhost/food_inventory", "student",
            "ensf");

    public Food(int ITEM_ID) {

        this.ITEM_ID = ITEM_ID;

        access.initializeConnection();

        String[] tmp = access.getSpecificFood(ITEM_ID).split("/");

        this.NAME = tmp[0];
        this.GRAIN_CONTENT = Integer.parseInt(tmp[1]);

        this.FV_CONTENT = Integer.parseInt(tmp[2]);

        this.PRO_CONTENT = Integer.parseInt(tmp[3]);

        this.OTHER_CONTENT = Integer.parseInt(tmp[4]);

        this.CALORIES = Integer.parseInt(tmp[5]);

        access.close();
    }

    // Xian Wei Additions end
    public int getItemID() {
        return this.ITEM_ID;
    }

    public String getName() {
        return this.NAME;
    }

    // convert contents from % to calories
    public int getGrainContent() {
        return (this.GRAIN_CONTENT / 100) * this.CALORIES;
    }

    public int getFVContent() {
        return (this.FV_CONTENT / 100) * this.CALORIES;
    }

    public int getProContent() {
        return (this.PRO_CONTENT / 100) * this.CALORIES;
    }

    public int getOtherContent() {
        return (this.OTHER_CONTENT / 100) * this.CALORIES;
    }

    public int getCalories() {
        return this.CALORIES;
    }

    // extra method added temporarily so availableFood ArrayList can be printed when
    // AvailableFood is called.
    @Override
    public String toString() {
        return (this.getItemID() + " "
                + this.getName() + " "
                + this.getFVContent() + " "
                + this.getProContent() + " "
                + this.getOtherContent() + " "
                + this.getCalories());
    }
}
